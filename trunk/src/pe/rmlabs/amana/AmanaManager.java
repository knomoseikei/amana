package pe.rmlabs.amana;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;

import pe.rmlabs.amana.domain.AirMechPlayer;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
import pe.rmlabs.amana.domain.ColorConst;
import pe.rmlabs.amana.domain.GameMap;
import pe.rmlabs.amana.domain.GameMode;
import pe.rmlabs.amana.gui.AirMechReplayLabelGroup;
import pe.rmlabs.amana.gui.PlayerLoadoutPanel;
import pe.rmlabs.amana.loader.ConfigManager;
import pe.rmlabs.amana.loader.ReplayInfoReader;
import pe.rmlabs.amana.loader.SpriteStore;

public abstract class AmanaManager {

	public static final String STEAM_AIRMECH_ID = "-applaunch 206500";
	public static final int AIRMECH_PC = 0;
	public static final int AIRMECH_STEAM = 1;
	public static final String REPLAY_FLAG = " /replay";
	public static final String REPLAY_EXTENSION = ".replay";

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:ss");

	public static final Object[] listReplayInfoDir(int version) throws Exception {
		File replaysDir = null;
		if (version == AIRMECH_PC) {
			replaysDir = new File(ConfigManager.get().getProperty("REPLAYS_PC_PATH"));
		} else if (version == AIRMECH_STEAM) {
			replaysDir = new File(ConfigManager.get().getProperty("REPLAYS_STEAM_PATH"));
		}
		if (replaysDir == null) {
			return null;
		}
		LinkedList<AirMechReplayInfo> llAmr = new LinkedList<AirMechReplayInfo>();
		for (File f : replaysDir.listFiles()) {
			// System.out.println("procesando: " + f.getName() + " if:" +
			// FilenameUtils.getExtension(f.getName()).equals("replay"));
			if (FilenameUtils.getExtension(f.getName()).equals("replayInfo")) {
				if (f.getName().equals("replay999_p9.replayInfo") || f.getName().equals("dnd1324.replayInfo")) {
					f.delete();
				} else {
					AirMechReplayInfo amri = ReplayInfoReader.readReplayInfoFile(f);
					if (amri != null) {
						llAmr.add(amri);
					}
				}
			}
		}
		return llAmr.toArray(new AirMechReplayInfo[0]);
	}

	public static void openPcReplaysFolder() {
		try {
			// Runtime.getRuntime().exec("explorer " +
			// ConfigManager.get().getAppDataPath() +
			// "\\Carbon\\.debug\\replay\\");
			if (ConfigManager.get().validReplaysPcPath()) {
				Runtime.getRuntime().exec("explorer " + ConfigManager.get().getProperty("REPLAYS_PC_PATH"));
			} else {
				JOptionPane.showMessageDialog(null, "Looks like your Steam Replays Folder must be wrong, go fix it in Settings tab.", "Whoops!",
						JOptionPane.INFORMATION_MESSAGE, SpriteStore.get().getSprite("ratchet.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void openSteamReplaysFolder() {
		try {
			// Runtime.getRuntime().exec("explorer " +
			// ConfigManager.get().getAppDataPath() +
			// "\\Carbon\\AirMechSteam\\.debug\\replay\\");
			if (ConfigManager.get().validReplaysSteamPath()) {
				Runtime.getRuntime().exec("explorer " + ConfigManager.get().getProperty("REPLAYS_STEAM_PATH"));
			} else {
				JOptionPane.showMessageDialog(null, "Looks like your Steam Replays Folder must be wrong, go fix it in Settings tab.", "Whoops!",
						JOptionPane.INFORMATION_MESSAGE, SpriteStore.get().getSprite("ratchet.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createReplayFolders() {
		try {
			String APPDATA_PATH = System.getenv("APPDATA");

			String REPLAYS_STEAM_PATH = APPDATA_PATH + "\\Carbon\\AirMechSteam\\.debug\\replay\\";
			String REPLAYS_PC_PATH = APPDATA_PATH + "\\Carbon\\.debug\\replay\\";
			
			File replays_steam_folder = new File(REPLAYS_STEAM_PATH);
			File replays_pc_folder = new File(REPLAYS_PC_PATH);
			
			replays_steam_folder.mkdirs();
			replays_pc_folder.mkdirs();
			
			//Runtime.getRuntime().exec("rsc\\replayfolders.bat");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AirMechReplayLabelGroup obtainAirMechReplayLabelGroup(Object o) throws Exception {
		AirMechReplayInfo amri = (AirMechReplayInfo) o;
		AirMechReplayLabelGroup arlg = new AirMechReplayLabelGroup();

		JLabel lblName = new JLabel(FilenameUtils.getBaseName(amri.getName()));
		JLabel lblBuild = new JLabel("Build " + amri.getBuild());
		JLabel lblDate = new JLabel(sdf.format(amri.getDate().getTime()));

		GameMode gm = amri.getGameMode();
		JLabel lblGameMode;
		if (gm != null) {
			lblGameMode = new JLabel(SpriteStore.get().getSprite(amri.getGameMode().getImage()));
		} else {
			lblGameMode = new JLabel(SpriteStore.get().getSprite("new-tag.png"));
		}

		GameMap m = amri.getMap();
		JLabel lblMap;
		if (m != null) {
			lblMap = new JLabel(SpriteStore.get().getSprite(amri.getMap().getImage()));
		} else {
			lblMap = new JLabel(SpriteStore.get().getSprite("new-tag.png"));
		}

		arlg.setLblName(lblName);
		arlg.setLblBuild(lblBuild);
		arlg.setLblDate(lblDate);
		arlg.setLblGameMode(lblGameMode);
		arlg.setLblMap(lblMap);

		if (amri.getPlayer1() != null) {
			JLabel lblPlayer1Name = new JLabel(amri.getPlayer1().getPlayer());
			JLabel lblPlayer1AirMech = getAirMechLabel(amri.getPlayer1());
			JLabel lblPlayer1Pilot = getPilotLabel(amri.getPlayer1());
			JLabel lblPlayer1Item = getItemLabel(amri.getPlayer1());
			arlg.setLblPlayer1Name(lblPlayer1Name);
			arlg.setLblPlayer1Airmech(lblPlayer1AirMech);
			arlg.setLblPlayer1Pilot(lblPlayer1Pilot);
			arlg.setLblPlayer1Item(lblPlayer1Item);
		} else {
			arlg.setLblPlayer1Airmech(new JLabel());
			arlg.setLblPlayer1Name(new JLabel());
			arlg.setLblPlayer1Pilot(new JLabel());
			arlg.setLblPlayer1Item(new JLabel());
		}

		if (amri.getPlayer2() != null) {
			JLabel lblPlayer2Name = new JLabel(amri.getPlayer2().getPlayer());
			JLabel lblPlayer2AirMech = getAirMechLabel(amri.getPlayer2());
			JLabel lblPlayer2Pilot = getPilotLabel(amri.getPlayer2());
			JLabel lblPlayer2Item = getItemLabel(amri.getPlayer2());
			arlg.setLblPlayer2Name(lblPlayer2Name);
			arlg.setLblPlayer2Airmech(lblPlayer2AirMech);
			arlg.setLblPlayer2Pilot(lblPlayer2Pilot);
			arlg.setLblPlayer2Item(lblPlayer2Item);
		} else {
			arlg.setLblPlayer2Airmech(new JLabel());
			arlg.setLblPlayer2Name(new JLabel());
			arlg.setLblPlayer2Pilot(new JLabel());
			arlg.setLblPlayer2Item(new JLabel());
		}

		if (amri.getPlayer3() != null) {
			JLabel lblPlayer3Name = new JLabel(amri.getPlayer3().getPlayer());
			JLabel lblPlayer3AirMech = getAirMechLabel(amri.getPlayer3());
			JLabel lblPlayer3Pilot = getPilotLabel(amri.getPlayer3());
			JLabel lblPlayer3Item = getItemLabel(amri.getPlayer3());
			arlg.setLblPlayer3Name(lblPlayer3Name);
			arlg.setLblPlayer3Airmech(lblPlayer3AirMech);
			arlg.setLblPlayer3Pilot(lblPlayer3Pilot);
			arlg.setLblPlayer3Item(lblPlayer3Item);
		} else {
			arlg.setLblPlayer3Airmech(new JLabel());
			arlg.setLblPlayer3Name(new JLabel());
			arlg.setLblPlayer3Pilot(new JLabel());
			arlg.setLblPlayer3Item(new JLabel());
		}

		if (amri.getPlayer4() != null) {
			JLabel lblPlayer4Name = new JLabel(amri.getPlayer4().getPlayer());
			JLabel lblPlayer4AirMech = getAirMechLabel(amri.getPlayer4());
			JLabel lblPlayer4Pilot = getPilotLabel(amri.getPlayer4());
			JLabel lblPlayer4Item = getItemLabel(amri.getPlayer4());
			arlg.setLblPlayer4Name(lblPlayer4Name);
			arlg.setLblPlayer4Airmech(lblPlayer4AirMech);
			arlg.setLblPlayer4Pilot(lblPlayer4Pilot);
			arlg.setLblPlayer4Item(lblPlayer4Item);
		} else {
			arlg.setLblPlayer4Airmech(new JLabel());
			arlg.setLblPlayer4Name(new JLabel());
			arlg.setLblPlayer4Pilot(new JLabel());
			arlg.setLblPlayer4Item(new JLabel());
		}

		if (amri.getPlayer5() != null) {
			JLabel lblPlayer5Name = new JLabel(amri.getPlayer5().getPlayer());
			JLabel lblPlayer5AirMech = getAirMechLabel(amri.getPlayer5());
			JLabel lblPlayer5Pilot = getPilotLabel(amri.getPlayer5());
			JLabel lblPlayer5Item = getItemLabel(amri.getPlayer5());
			arlg.setLblPlayer5Airmech(lblPlayer5AirMech);
			arlg.setLblPlayer5Name(lblPlayer5Name);
			arlg.setLblPlayer5Pilot(lblPlayer5Pilot);
			arlg.setLblPlayer5Item(lblPlayer5Item);
		} else {
			arlg.setLblPlayer5Airmech(new JLabel());
			arlg.setLblPlayer5Name(new JLabel());
			arlg.setLblPlayer5Pilot(new JLabel());
			arlg.setLblPlayer5Item(new JLabel());
		}

		if (amri.getPlayer6() != null) {
			JLabel lblPlayer6Name = new JLabel(amri.getPlayer6().getPlayer());
			JLabel lblPlayer6AirMech = getAirMechLabel(amri.getPlayer6());
			JLabel lblPlayer6Pilot = getPilotLabel(amri.getPlayer6());
			JLabel lblPlayer6Item = getItemLabel(amri.getPlayer6());
			arlg.setLblPlayer6Airmech(lblPlayer6AirMech);
			arlg.setLblPlayer6Name(lblPlayer6Name);
			arlg.setLblPlayer6Pilot(lblPlayer6Pilot);
			arlg.setLblPlayer6Item(lblPlayer6Item);
		} else {
			arlg.setLblPlayer6Airmech(new JLabel());
			arlg.setLblPlayer6Name(new JLabel());
			arlg.setLblPlayer6Pilot(new JLabel());
			arlg.setLblPlayer6Item(new JLabel());
		}

		return arlg;
	}

	private static JLabel getAirMechLabel(AirMechPlayer amp) throws Exception {
		JLabel jlabel = new JLabel();
		Icon icon = SpriteStore.get().getSprite(amp.getAirmech().getImage());
		jlabel.setIcon(icon);
		return jlabel;
	}

	private static JLabel getItemLabel(AirMechPlayer amp) throws Exception {
		JLabel jlabel = new JLabel();
		Icon icon = SpriteStore.get().getSprite(amp.getItem().getImage());
		jlabel.setIcon(icon);
		return jlabel;
	}

	private static JLabel getPilotLabel(AirMechPlayer amp) throws Exception {
		JLabel jlabel = new JLabel();
		Icon icon = SpriteStore.get().getSprite(amp.getPilot().getImage());
		jlabel.setIcon(icon);
		return jlabel;
	}

	// -------------------- CONFIG MANAGER ----------------------

	public static String getAirMechPcPath() {
		// System.out.println(ConfigManager.get().getProperty("AIRMECH_PC_PATH"));
		return ConfigManager.get().getProperty("AIRMECH_PC_PATH");
	}

	public static String getAirMechSteamPath() {
		return ConfigManager.get().getProperty("AIRMECH_STEAM_PATH");
	}

	public static String getReplaysPcPath() {
		return ConfigManager.get().getProperty("REPLAYS_PC_PATH");
	}

	public static String getReplaysSteamPath() {
		return ConfigManager.get().getProperty("REPLAYS_STEAM_PATH");
	}

	public static int getNumberOfUses() {
		String uses = ConfigManager.get().getProperty("N");
		return Integer.parseInt(uses);
	}

	public static void addOneUse() {
		int uses = 1 + Integer.parseInt(ConfigManager.get().getProperty("N"));
		ConfigManager.get().setProperty("N", String.valueOf(uses));
	}

	public static void saveConfigValues(String AirMechPcPath, String ReplaysFolderPcPath, String SteamPath, String ReplaysFolderSteamPath) {
		ConfigManager.get().setProperty("AIRMECH_PC_PATH", AirMechPcPath);
		ConfigManager.get().setProperty("REPLAYS_PC_PATH", ReplaysFolderPcPath);
		ConfigManager.get().setProperty("AIRMECH_STEAM_PATH", SteamPath);
		ConfigManager.get().setProperty("REPLAYS_STEAM_PATH", ReplaysFolderSteamPath);
	}

	public static void setDefaultConfig() {
		ConfigManager.get().setDefaultValues();
	}

	public static boolean replayFoldersExist() {
		// TODO
		return false;
	}

	public static String welcomeMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("This is your first time using Amana!");
		boolean flag = !ConfigManager.get().validAirMechPcPath() || !ConfigManager.get().validReplaysPcPath()
				|| !ConfigManager.get().validAirMechSteamPath() || !ConfigManager.get().validReplaysSteamPath();
		if (flag) {
			sb.append("\n\nBefore you continue, you must know next default path(s) doesnt exist:\n");
		}
		if (!ConfigManager.get().validAirMechPcPath()) {
			sb.append(" -> AirMech Pc Version path.\n");
		}
		if (!ConfigManager.get().validReplaysPcPath()) {
			sb.append(" -> AirMech Pc Version Replays path.\n");
		}
		if (!ConfigManager.get().validAirMechSteamPath()) {
			sb.append(" -> Steam path.\n");
		}
		if (!ConfigManager.get().validReplaysSteamPath()) {
			sb.append(" -> AirMech Pc Version Replays path.\n");
		}
		if (flag) {
			sb.append("Please correct path(s) in the Settings tab.");
		} else {
			sb.append("\nA default settings must be autogenerated, you can see it in Settings tab.");
		}
		return sb.toString();
	}

	public static void refreshList(int version, JList listReplays, boolean popup) {
		Object[] replaysList = null;
		try {
			if (version == AmanaManager.AIRMECH_PC) {
				replaysList = AmanaManager.listReplayInfoDir(AmanaManager.AIRMECH_PC);
			} else if (version == AmanaManager.AIRMECH_STEAM) {
				replaysList = AmanaManager.listReplayInfoDir(AmanaManager.AIRMECH_STEAM);
			}
		} catch (Exception e1) {
			System.out.println("FALLO EN RefreshListener");
			e1.printStackTrace();
		}

		if (replaysList != null && replaysList.length > 0) {
			listReplays.setListData(replaysList);
		} else {
			listReplays.removeAll();
			if (popup) {
				try {
					String message = null;
					if (version == AmanaManager.AIRMECH_PC) {
						message = "Dude, looks like you don't have any replay from the Build " + ConfigManager.BUILD_THRESHOLD
								+ " or higher.\nGo play some AirMech right now! (PC Version)";
					} else if (version == AmanaManager.AIRMECH_STEAM) {
						message = "Dude, looks like you don't have any replay from the Build " + ConfigManager.BUILD_THRESHOLD
								+ " or higher.\nGo play some AirMech right now! (Steam Version)";
					}
					JOptionPane.showMessageDialog(listReplays, message, "Whoops!", JOptionPane.INFORMATION_MESSAGE,
							SpriteStore.get().getSprite("ratchet.png"));
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static PlayerLoadoutPanel loadPlayerLoadoutPanel(AirMechPlayer amp) {
		PlayerLoadoutPanel pnlPlayer = null;
		if (amp == null) {
			pnlPlayer = new PlayerLoadoutPanel();
		} else {
			try {
				pnlPlayer = new PlayerLoadoutPanel(amp.getPlayer(), SpriteStore.get().getSprite(amp.getAirmech().getImage()), SpriteStore.get()
						.getSprite(amp.getPilot().getImage()), SpriteStore.get().getSprite(amp.getItem().getImage()), SpriteStore.get().getSprite(
						amp.getUnit8().getImage()), SpriteStore.get().getSprite(amp.getUnit1().getImage()), SpriteStore.get().getSprite(
						amp.getUnit2().getImage()), SpriteStore.get().getSprite(amp.getUnit7().getImage()), SpriteStore.get().getSprite(
						ColorConst.GREEN_LEVEL_1.getImage()), SpriteStore.get().getSprite(amp.getUnit3().getImage()), SpriteStore.get().getSprite(
						amp.getUnit6().getImage()), SpriteStore.get().getSprite(amp.getUnit5().getImage()), SpriteStore.get().getSprite(
						amp.getUnit4().getImage()), SpriteStore.get().getSprite(amp.getFlair1().getImage()), SpriteStore.get().getSprite(
						amp.getFlair3().getImage()), SpriteStore.get().getSprite(amp.getFlair2().getImage()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pnlPlayer;
	}

}
