package pe.rmlabs.amana.loader;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import pe.rmlabs.amana.domain.AirMechPlayer;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
import pe.rmlabs.amana.domain.Color;
import pe.rmlabs.amana.domain.ColorConst;
import pe.rmlabs.amana.domain.ColorNew;
import pe.rmlabs.amana.domain.Flair;
import pe.rmlabs.amana.domain.FlairConst;
import pe.rmlabs.amana.domain.FlairNew;
import pe.rmlabs.amana.domain.GameMap;
import pe.rmlabs.amana.domain.GameMapConst;
import pe.rmlabs.amana.domain.GameMapNew;
import pe.rmlabs.amana.domain.GameMode;
import pe.rmlabs.amana.domain.GameModeConst;
import pe.rmlabs.amana.domain.GameModeNew;
import pe.rmlabs.amana.domain.Item;
import pe.rmlabs.amana.domain.ItemConst;
import pe.rmlabs.amana.domain.ItemNew;
import pe.rmlabs.amana.domain.Mech;
import pe.rmlabs.amana.domain.MechConst;
import pe.rmlabs.amana.domain.MechNew;
import pe.rmlabs.amana.domain.Pilot;
import pe.rmlabs.amana.domain.PilotConst;
import pe.rmlabs.amana.domain.PilotNew;
import pe.rmlabs.amana.domain.Unit;
import pe.rmlabs.amana.domain.UnitConst;
import pe.rmlabs.amana.domain.UnitNew;

public abstract class ReplayInfoReader2 {

	public static AirMechReplayInfo readReplayInfoFile(File replayInfoFile) throws Exception {
		AirMechReplayInfo amri = new AirMechReplayInfo();
		AirMechPlayer amp1 = new AirMechPlayer();
		AirMechPlayer amp2 = new AirMechPlayer();
		AirMechPlayer amp3 = new AirMechPlayer();
		AirMechPlayer amp4 = new AirMechPlayer();
		AirMechPlayer amp5 = new AirMechPlayer();
		AirMechPlayer amp6 = new AirMechPlayer();

		// parse file
		String fileString = FileUtils.readFileToString(replayInfoFile);

		amri.setName(FilenameUtils.getBaseName(replayInfoFile.getName()));
		// String[] sa = fileString.split("\\s+");
		String[] sa = fileString.split("\\n");
		System.out.println((replayInfoFile.getName()));
		for (int i = 0; i < sa.length; i++) {
			System.out.println("sa[" + i + "]:" + sa[i].trim());
			// String[] line = sa[i].trim().split("\\s");
			String[] line = sa[i].trim().split(" ", 2);
			if (line[0].equals("version")) {
				amri.setBuild(line[1]);
				if (Integer.parseInt(amri.getBuild()) < 14400) {
					return null;
				}
			} else if (line[0].equals("localtime")) {
				DateFormat dfin = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
				Calendar date = Calendar.getInstance();
				date.setTime(dfin.parse(line[1]));
				amri.setDate(date);
			} else if (line[0].equals("map")) {
				amri.setMap(getMap(line[1]));
			} else if (line[0].equals("onlineGame")) {
				if (line[1].equals("yes")) {
					amri.setOnlineGame(true);
				} else {
					amri.setOnlineGame(false);
				}
			} else if (line[0].equals("aiMask")) {
				amri.setAiMask(line[1]);
			} else if (line[0].equals("maxPlayers")) {
				amri.setMaxPlayers(Short.parseShort(line[1]));
			} else if (line[0].equals("netPlayers")) {
				amri.setNetPlayers(Short.parseShort(line[1]));
			} else if (line[0].equals("playerCfg")) {
				amri.setPlayerCfg(line[1]);
			} else if (line[0].equals("gameMode")) {
				amri.setGameMode(getGameMode(amri.getMaxPlayers(), amri.getNetPlayers(), amri.getPlayerCfg(), line[1], amri.isOnlineGame()));
			} else if (line[0].equals("player")) {
				// System.out.println("player..." + line[1].substring(0, 1));
				AirMechPlayer amp = null;
				switch (Integer.parseInt(line[1].substring(0, 1))) {
				case 1:
					amp = amp1;
					break;
				case 2:
					amp = amp2;
					break;
				case 3:
					amp = amp3;
					break;
				case 4:
					amp = amp4;
					break;
				case 5:
					amp = amp5;
					break;
				case 6:
					amp = amp6;
					break;
				}
				i++;
				try{
				while (!sa[i].trim().equals("}")) {
					// System.out.println(sa[i].trim());
					String[] playerArg = sa[i++].trim().split(" ", 2);
					if (playerArg[0].equals("name")) {
						amp.setPlayer(playerArg.length > 1 ? playerArg[1] : "");
					} else if (playerArg[0].equals("airmech")) {
						amp.setAirmech(getMech(playerArg[1]));
					} else if (playerArg[0].equals("pilot")) {
						amp.setPilot(getPilot(playerArg[1]));
					} else if (playerArg[0].equals("item")) {
						amp.setItem(getItem(playerArg[1]));
					} else if (playerArg[0].equals("flair1")) {
						amp.setFlair1(getFlair(playerArg[1]));
					} else if (playerArg[0].equals("flair2")) {
						amp.setFlair2(getFlair(playerArg[1]));
					} else if (playerArg[0].equals("flair3")) {
						amp.setFlair3(getFlair(playerArg[1]));
					} else if (playerArg[0].equals("color")) {
						amp.setColor(getColor(playerArg[1]));
					} else if (playerArg[0].equals("army1")) {
						amp.setUnit1(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army2")) {
						amp.setUnit2(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army3")) {
						amp.setUnit3(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army4")) {
						amp.setUnit4(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army5")) {
						amp.setUnit5(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army6")) {
						amp.setUnit6(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army7")) {
						amp.setUnit7(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else if (playerArg[0].equals("army8")) {
						amp.setUnit8(getUnit(playerArg.length == 2 ? playerArg[1] : ""));
					} else {
						System.out.println(amp);
						throw new Exception("PLAYER OFF!!! " + playerArg[0] + ":" + playerArg[1]);
					}
				}
				} catch(Exception ex){
					ex.printStackTrace();
				}
			} else {
				System.out.println(amri);
				throw new Exception("REPLAY OFF!!! " + line[0]);
			}
		}

		if (amri.getGameMode().equals(GameModeConst.CHALLENGE) || amri.getGameMode().equals(GameModeConst.SOLO)) {
			amri.setPlayer1(amp1);
		} else if (amri.getGameMode().equals(GameModeConst.SURVIVAL)) {
			if (amri.getPlayerCfg().equals("1P") || amri.getMaxPlayers() == 1) {
				amri.setPlayer1(amp1);
			} else if (amri.getPlayerCfg().equals("2P")) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
			} else if (amri.getPlayerCfg().equals("3P")) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
			} else if (amri.getPlayerCfg().equals("4P")) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
			} else {
				throw new Exception("WRONG READ 3 " + amri.getName() + " - " + amri.getPlayerCfg());
			}
		} else if (amri.getGameMode().equals(GameModeConst.COOP)) {
			if (amri.getNetPlayers() == 1) {
				amri.setPlayer1(amp1);
			} else if (amri.getNetPlayers() == 2) {
				amri.setPlayer1(amp1);
				amri.setPlayer3(amp3);
			} else if (amri.getNetPlayers() == 3) {
				amri.setPlayer1(amp1);
				amri.setPlayer3(amp3);
				amri.setPlayer5(amp5);
			} else {
				throw new Exception("WRONG READ 2 " + amri.getName() + " - " + amri.getNetPlayers());
			}
		} else if (amri.getGameMode().equals(GameModeConst.PVP)) {
			if (amri.getNetPlayers() == 1) {
				amri.setPlayer1(amp1);
			} else if (amri.getNetPlayers() == 2) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
			} else if (amri.getNetPlayers() == 3) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
			} else if (amri.getNetPlayers() == 4) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
			} else if (amri.getNetPlayers() == 5) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
				amri.setPlayer5(amp5);
			} else if (amri.getNetPlayers() == 6) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
				amri.setPlayer5(amp5);
				amri.setPlayer6(amp6);
			} else {
				throw new Exception("WRONG READ 1:" + amri.getNetPlayers());
			}
		} else if (amri.getGameMode().equals(GameModeConst.CTF)) {
			if (amri.getNetPlayers() == 2) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
			} else if (amri.getNetPlayers() == 4) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
			} else if (amri.getNetPlayers() == 6) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
				amri.setPlayer3(amp3);
				amri.setPlayer4(amp4);
				amri.setPlayer5(amp5);
				amri.setPlayer6(amp6);
			} else {
				throw new Exception("WRONG READ CTF");
			}
		}

		// System.out.println(amri);
		return amri;
	}

	private static Item getItem(String codeName) {
		for (Item i : ItemConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new ItemNew(codeName, "", "new-thumb.png", codeName);
	}

	private static Flair getFlair(String codeName) {
		for (Flair i : FlairConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new FlairNew(codeName, "", "new-thumb.png", codeName);
	}

	private static Color getColor(String codeName) {
		for (Color i : ColorConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new ColorNew(codeName, "", "new-thumb.png", codeName);
	}

	private static GameMap getMap(String codeName) {
		for (GameMap i : GameMapConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new GameMapNew(codeName, "", "new-tag.png", codeName);
	}

	private static Mech getMech(String codeName) {
		for (Mech i : MechConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new MechNew(codeName, "", "new-thumb.png", codeName);
	}

	private static Pilot getPilot(String codeName) {
		for (Pilot i : PilotConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new PilotNew(codeName, "", "new-thumb.png", codeName);
	}

	private static Unit getUnit(String codeName) {
		for (Unit i : UnitConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new UnitNew(codeName, "", "new-thumb.png", codeName);
	}

	private static GameMode getGameMode(Short maxPlayers, Short netPlayers, String playerCfg, String gameMode, boolean isOnline) {
		System.out.println("GameMode ? " + maxPlayers == 1 + " / " + netPlayers + " / " + playerCfg + " / " + gameMode);
		if (gameMode.equals("CTF")) {
			return GameModeConst.CTF;
		} else if (gameMode.equals("Coop")) {
			return GameModeConst.COOP;
		} else if (gameMode.equals("PvP")) {
			return GameModeConst.PVP;
		} else if (playerCfg.equals("1v1") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (playerCfg.equals("1v1C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (playerCfg.equals("1v2C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (maxPlayers == 1 && netPlayers == 0 && playerCfg.equals("1v3C") && gameMode.equals("PVP")) {
			return GameModeConst.SURVIVAL;
		} else if (playerCfg.equals("1v3C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (playerCfg.equals("2v2C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (playerCfg.equals("2v3C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (playerCfg.equals("3v3C") && gameMode.equals("PVP")) {
			return GameModeConst.SOLO;
		} else if (maxPlayers == 2 && playerCfg.equals("1P") && gameMode.equals("PVP")) {
			return GameModeConst.CHALLENGE;
		} else if (maxPlayers == 1 && playerCfg.equals("1P") && gameMode.equals("PVP")) {
			return GameModeConst.SURVIVAL;
		} else if (gameMode.equals("PvE")) {
			return GameModeConst.SURVIVAL;
		}
		return new GameModeNew("", "new-tag.png", "\"" + playerCfg + "\"+\"" + gameMode + "\"");
	}
}