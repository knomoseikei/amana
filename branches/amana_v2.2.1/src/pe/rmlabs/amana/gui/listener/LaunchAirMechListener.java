package pe.rmlabs.amana.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import pe.rmlabs.amana.AmanaManager;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
import pe.rmlabs.amana.launcher.Launcher;

public class LaunchAirMechListener implements ActionListener {

	private int version;
	private JCheckBox chkReplay;
//	private JCheckBox chkArguments;
//	private JTextField txtArguments;
	private JList lstReplays;

	public LaunchAirMechListener(int version, JCheckBox chkReplay, JCheckBox chkArguments, JTextField txtArguments, JList lstReplays) {
		super();
		this.version = version;
		this.chkReplay = chkReplay;
//		this.chkArguments = chkArguments;
//		this.txtArguments = txtArguments;
		this.lstReplays = lstReplays;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arguments = "";
		String replayFileName = "";
		String batchBody = null;

		try{
		if (chkReplay.isSelected() && lstReplays.getSelectedValue() != null) {
			replayFileName = ((AirMechReplayInfo)lstReplays.getSelectedValue()).getName();
		}
//		if (chkArguments.isSelected()) {
//			arguments = txtArguments.getText();
//		}

		if (version == AmanaManager.AIRMECH_PC) {
			batchBody = Launcher.createPcLaunchBatchBody(replayFileName, arguments);
		} else if (version == AmanaManager.AIRMECH_STEAM) {
			batchBody = Launcher.createSteamLaunchBatchBody(replayFileName, arguments);
		}

		Launcher.launchAirMech(batchBody);
		}catch(Exception ex){
			StringWriter sw = new StringWriter();
			PrintWriter pw= new PrintWriter(sw);
			ex.printStackTrace(pw);
			JOptionPane.showMessageDialog(null, sw);
		}
	}

}
