package pe.rmlabs.amana.launcher;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import pe.rmlabs.amana.AmanaManager;

public class Launcher {

	public static void launchAirMech(String batchBody) {

		File launcher = new File(".\\rsc\\launcher.bat");
		try {
			FileUtils.writeStringToFile(launcher, batchBody);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Runtime.getRuntime().exec("rsc\\launcher.bat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String createPcLaunchBatchBody(String replayFileName, String arguments) {
		File f = new File(AmanaManager.getReplaysPcPath() + replayFileName + ".replay");
		System.out.println("F PC: " + f);
		File replay999_p9 = new File(AmanaManager.getReplaysPcPath() + "replay999_p9.replay");
		replay999_p9.delete();
		try {
			replay999_p9.createNewFile();
			System.out.println(replay999_p9.getName());
			System.out.println(f.getName());
			FileUtils.copyFile(f, replay999_p9);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		System.out.println("AIRMECH_PC");
		sb.append(AmanaManager.getAirMechPcPath());
		if (!replayFileName.isEmpty()) {
			sb.append(AmanaManager.REPLAY_FLAG);
			sb.append(" ");
			sb.append("replay999_p9");
		}
		if (!arguments.isEmpty()) {
			sb.append(" ");
			sb.append(arguments);
		}
		System.out.println("running PC:" + sb.toString());
		return sb.toString();
	}

	public static String createSteamLaunchBatchBody(String replayFileName, String arguments) {
		File f = new File(AmanaManager.getReplaysSteamPath() + replayFileName + ".replay");
		System.out.println("F Steam: " + f);
		File replay999_p9 = new File(AmanaManager.getReplaysSteamPath() + "replay999_p9.replay");
		replay999_p9.delete();
		try {
			replay999_p9.createNewFile();
			FileUtils.copyFile(f, replay999_p9);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		System.out.println("AIRMECH_STEAM");
		sb.append("\"");
		sb.append(AmanaManager.getAirMechSteamPath());
		sb.append("\" ");
		sb.append(AmanaManager.STEAM_AIRMECH_ID);
		if (!replayFileName.isEmpty()) {
			sb.append(AmanaManager.REPLAY_FLAG);
			sb.append(" ");
			sb.append("replay999_p9");
		}
		if (!arguments.isEmpty()) {
			sb.append(" ");
			sb.append(arguments);
		}
		System.out.println("running Steam:" + sb.toString());
		return sb.toString();
	}

}
