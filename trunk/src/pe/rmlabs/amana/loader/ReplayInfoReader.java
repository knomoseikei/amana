package pe.rmlabs.amana.loader;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import pe.rmlabs.amana.domain.AirMechPlayer;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
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

public abstract class ReplayInfoReader {

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
		String[] sa = fileString.split("\\s+");
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(sa));
		int index = 0;

		// NAME
		amri.setName(FilenameUtils.getBaseName(replayInfoFile.getName()));

		// VERSION
		index = al.indexOf("version");
		System.out.println("version:" + index);
		amri.setBuild(al.get(++index));

		if (Integer.parseInt(amri.getBuild()) < ConfigManager.BUILD_THRESHOLD) {
			return null;
		}
		// DATE
		index = al.indexOf("localtime");
		StringBuilder sb = new StringBuilder();
		// System.out.println("localtime:" + index);
		sb.append(al.get(++index));
		sb.append(" ");
		sb.append(al.get(++index));
		sb.append(" ");
		sb.append(al.get(++index));
		sb.append(" ");
		sb.append(al.get(++index));
		sb.append(" ");
		sb.append(al.get(++index));

		// Wed Oct 31 21:42:04 2012
		DateFormat dfin = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);

		@SuppressWarnings("unused")
		DateFormat dfout = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);

		Calendar date = Calendar.getInstance();
		try {
			date.setTime(dfin.parse(sb.toString()));
		} catch (ParseException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		amri.setDate(date);

		// // MAP
		index = al.indexOf("map");
		amri.setMap(getMap(al.get(++index)));

		// // ONLINE_GAME
		index = al.indexOf("onlineGame");
		if (al.get(++index).equals("yes")) {
			amri.setOnlineGame(true);
		} else {
			amri.setOnlineGame(false);
		}

		// // AI_MASK
		index = al.indexOf("aiMask");
		if (index != -1)
			amri.setAiMask(al.get(++index));

		// // MAX_PLAYERS
		index = al.indexOf("maxPlayers");
		amri.setMaxPlayers(Short.parseShort(al.get(++index)));

		// // NET_PLAYER
		index = al.indexOf("netPlayers");
		amri.setNetPlayers(Short.parseShort(al.get(++index)));

		// // playerCfg
		index = al.indexOf("playerCfg");
		amri.setPlayerCfg(al.get(++index));

		// // GAME_MODE
		index = al.indexOf("gameMode");
		amri.setGameMode(getGameMode(amri.getMaxPlayers(), amri.getNetPlayers(), amri.getPlayerCfg(), al.get(++index), amri.isOnlineGame()));

		// // PLAYER_1

		index = al.indexOf("name");
		al.remove(index);
		amp1.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp1.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp1.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp1.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp1.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp1.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp1.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		al.remove(index);
		amp1.setUnit1(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army2");
		al.remove(index);
		amp1.setUnit2(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army3");
		al.remove(index);
		amp1.setUnit3(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army4");
		al.remove(index);
		amp1.setUnit4(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army5");
		al.remove(index);
		amp1.setUnit5(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army6");
		al.remove(index);
		amp1.setUnit6(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army7");
		al.remove(index);
		amp1.setUnit7(getUnit(al.get(index), al.get(index+1)));

		index = al.indexOf("army8");
		al.remove(index);
		amp1.setUnit8(getUnit(al.get(index), al.get(index+1)));

		// PLAYER_2

		index = al.indexOf("name");
		al.remove(index);
		amp2.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp2.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp2.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp2.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp2.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp2.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp2.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit1(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army2");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit2(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army3");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit3(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army4");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit4(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army5");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit5(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army6");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit6(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army7");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit7(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army8");
		if (index != -1) {
			al.remove(index);
			amp2.setUnit8(getUnit(al.get(index), al.get(index+1)));
		}

		// PLAYER_3
		index = al.indexOf("name");
		al.remove(index);
		amp3.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp3.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp3.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp3.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp3.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp3.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp3.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit1(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army2");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit2(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army3");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit3(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army4");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit4(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army5");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit5(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army6");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit6(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army7");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit7(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army8");
		if (index != -1) {
			al.remove(index);
			amp3.setUnit8(getUnit(al.get(index), al.get(index+1)));
		}

		// PLAYER_4
		index = al.indexOf("name");
		al.remove(index);
		amp4.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp4.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp4.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp4.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp4.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp4.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp4.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit1(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army2");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit2(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army3");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit3(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army4");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit4(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army5");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit5(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army6");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit6(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army7");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit7(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army8");
		if (index != -1) {
			al.remove(index);
			amp4.setUnit8(getUnit(al.get(index), al.get(index+1)));
		}

		// PLAYER_5
		index = al.indexOf("name");
		al.remove(index);
		amp5.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp5.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp5.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp5.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp5.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp5.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp5.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit1(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army2");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit2(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army3");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit3(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army4");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit4(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army5");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit5(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army6");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit6(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army7");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit7(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army8");
		if (index != -1) {
			al.remove(index);
			amp5.setUnit8(getUnit(al.get(index), al.get(index+1)));
		}

		// PLAYER_6
		index = al.indexOf("name");
		al.remove(index);
		amp6.setPlayer(al.get(index));

		index = al.indexOf("airmech");
		al.remove(index);
		amp6.setAirmech(getMech(al.get(index)));

		index = al.indexOf("pilot");
		al.remove(index);
		amp6.setPilot(getPilot(al.get(index)));

		index = al.indexOf("item");
		al.remove(index);
		amp6.setItem(getItem(al.get(index)));

		index = al.indexOf("flair1");
		al.remove(index);
		amp6.setFlair1(getFlair(al.get(index)));

		index = al.indexOf("flair2");
		al.remove(index);
		amp6.setFlair2(getFlair(al.get(index)));

		index = al.indexOf("flair3");
		al.remove(index);
		amp6.setFlair3(getFlair(al.get(index)));

		index = al.indexOf("army1");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit1(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army2");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit2(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army3");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit3(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army4");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit4(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army5");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit5(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army6");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit6(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army7");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit7(getUnit(al.get(index), al.get(index+1)));
		}

		index = al.indexOf("army8");
		if (index != -1) {
			al.remove(index);
			amp6.setUnit8(getUnit(al.get(index), al.get(index+1)));
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
				throw new Exception("WRONG READ 3 "+ amri.getName()+" - " + amri.getPlayerCfg());
			}
		} else if (amri.getGameMode().equals(GameModeConst.COOP)) {
			if (amri.getNetPlayers() == 1) {
				amri.setPlayer1(amp1);
			} else if (amri.getNetPlayers() == 2) {
				amri.setPlayer1(amp1);
				amri.setPlayer2(amp2);
			} else if (amri.getNetPlayers() == 3) {
				amri.setPlayer1(amp1);
				amri.setPlayer3(amp2);
				//TODO FIX THIS, IT MUST BE 1, 3 and 5, but needs TOTAL rework of AMANA PARSER
				amri.setPlayer5(amp3);
			} else {
				throw new Exception("WRONG READ 2 "+ amri.getName()+" - "+amri.getNetPlayers());
			}
		} else if (amri.getGameMode().equals(GameModeConst.PVP)) {
			if (amri.getNetPlayers() == 1) {
				amri.setPlayer1(amp1);
			} else if (amri.getNetPlayers() == 2) {
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
				throw new Exception("WRONG READ 1:"+amri.getNetPlayers());
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
	
	private static Unit getUnit(String codeName, String next) {
		if(codeName.equals("Ultimate")){
			codeName = codeName+" "+next;
		}else if(codeName.equals("Minecraft")){
			codeName = codeName+" "+next;
		}else if(codeName.equals("Heavy")){
			codeName = codeName+" "+next;
		}else if(codeName.equals("Light")){
			codeName = codeName+" "+next;
		}
		
		for (Unit i : UnitConst.values()) {
			if (codeName.equals(i.getCodeName())) {
				return i;
			}
		}
		return new UnitNew(codeName, "", "new-thumb.png", codeName);
	}

	private static GameMode getGameMode(Short maxPlayers, Short netPlayers, String playerCfg, String gameMode, boolean isOnline) {
		System.out.println("GameMode ? "+maxPlayers == 1+" / "+netPlayers+" / "+playerCfg+ " / "+gameMode);
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
