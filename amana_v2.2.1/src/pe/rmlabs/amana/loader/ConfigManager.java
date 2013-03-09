package pe.rmlabs.amana.loader;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigManager {

	private static ConfigManager single = new ConfigManager();
	private static PropertiesConfiguration pc = null;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>\n");
		if (new File(getProperty("AIRMECH_PC_PATH")).exists())
			builder.append("<b><font color=\"blue\">OK</font></b>: ");
		else {
			builder.append("<b><font color=\"red\">WRONG</font></b>: ");
		}
		builder.append("AIRMECH_PC_PATH=");
		builder.append(getProperty("AIRMECH_PC_PATH"));
		builder.append("<br>");

		if (new File(getProperty("REPLAYS_PC_PATH")).exists())
			builder.append("<b><font color=\"blue\">OK</font></b>: ");
		else {
			builder.append("<b><font color=\"red\">WRONG</font></b>: ");
		}
		builder.append("REPLAYS_PC_PATH=");
		builder.append(getProperty("REPLAYS_PC_PATH"));
		builder.append("<br>");

		if (new File(getProperty("AIRMECH_STEAM_PATH")).exists())
			builder.append("<b><font color=\"blue\">OK</font></b>: ");
		else {
			builder.append("<b><font color=\"red\">WRONG</font></b>: ");
		}
		builder.append("AIRMECH_STEAM_PATH=");
		builder.append(getProperty("AIRMECH_STEAM_PATH"));
		builder.append("<br>");

		if (new File(getProperty("REPLAYS_STEAM_PATH")).exists())
			builder.append("<b><font color=\"blue\">OK</font></b>: ");
		else {
			builder.append("<b><font color=\"red\">WRONG</font></b>: ");
		}
		builder.append("REPLAYS_STEAM_PATH=");
		builder.append(getProperty("REPLAYS_STEAM_PATH"));
		builder.append("<br>");
		builder.append("N=");
		builder.append(getProperty("N"));
		builder.append("</html>");
		return builder.toString();
	}

	// private static final String CONFIG_PATH =
	// "pe/rmlabs/amana/config/config.properties";
	private static final String CONFIG_PATH = "config.properties";

	public static final int BUILD_THRESHOLD = 14400;

	private ConfigManager() {
	}

	public static ConfigManager get() {
		return single;
	}

	public String getProperty(String key) {
		if (pc == null) {
			System.out.println("SETTING PROP in get");
			try {
				// URL configFile =
				// this.getClass().getClassLoader().getResource(CONFIG_PATH);
				File configFile = new File(CONFIG_PATH);
				pc = new PropertiesConfiguration(configFile);
			} catch (ConfigurationException ex) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				JOptionPane.showMessageDialog(null, sw);
			}
		}
		return (String) pc.getProperty(key);
	}

	public void setProperty(String key, String value) {
		pc.setProperty(key, value);
		System.out.println("SETTING PROP in set");
		try {
			pc.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public String getAppDataPath() {
		return System.getenv("APPDATA");

	}

	public void setDefaultValues() {
		String APPDATA_PATH = getAppDataPath();

		// *** AIRMECH_PC_PATH ***
		String AIRMECH_PC_PATH = APPDATA_PATH + "\\Carbon\\AirMech\\Airmech.exe";

		// *** REPLAYS_PC_PATH ***
		String REPLAYS_PC_PATH = APPDATA_PATH + "\\Carbon\\.debug\\replay\\";

		// *** AIRMECH_STEAM_PATH ***
		String AIRMECH_STEAM_PATH;

		String progFiles32 = System.getenv("ProgramFiles");
		String progFiles64 = System.getenv("ProgramFiles(x86)");
		File steam32 = new File(progFiles32 + "\\Steam\\Steam.exe");
		File steam64 = new File(progFiles64 + "\\Steam\\Steam.exe");
		if (steam64.exists()) {
			AIRMECH_STEAM_PATH = steam64.getAbsolutePath();
		} else {
			AIRMECH_STEAM_PATH = steam32.getAbsolutePath();
		}

		// *** REPLAYS_STEAM_PATH ***
		String REPLAYS_STEAM_PATH = APPDATA_PATH + "\\Carbon\\AirMechSteam\\.debug\\replay\\";

		setProperty("AIRMECH_PC_PATH", AIRMECH_PC_PATH);
		setProperty("REPLAYS_PC_PATH", REPLAYS_PC_PATH);
		setProperty("AIRMECH_STEAM_PATH", AIRMECH_STEAM_PATH);
		setProperty("REPLAYS_STEAM_PATH", REPLAYS_STEAM_PATH);
		setProperty("DRAG_AND_DROP_TARGET", "PC");

	}

	public boolean validAirMechPcPath() {
		System.out.println("testing: "+getProperty("AIRMECH_PC_PATH"));
		if (new File(getProperty("AIRMECH_PC_PATH")).exists())
			return true;
		else {
			return false;
		}
	}

	public boolean validAirMechSteamPath() {
		System.out.println("testing: "+getProperty("AIRMECH_STEAM_PATH"));
		if (new File(getProperty("AIRMECH_STEAM_PATH")).exists())
			return true;
		else {
			return false;
		}
	}

	public boolean validReplaysPcPath() {
		System.out.println("testing: "+getProperty("REPLAYS_PC_PATH"));
		if (new File(getProperty("REPLAYS_PC_PATH")).exists())
			return true;
		else {
			return false;
		}
	}

	public boolean validReplaysSteamPath() {
		System.out.println("testing: "+getProperty("REPLAYS_STEAM_PATH"));
		if (new File(getProperty("REPLAYS_STEAM_PATH")).exists())
			return true;
		else {
			return false;
		}
	}

}
