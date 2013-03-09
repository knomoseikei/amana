package pe.rmlabs.amana.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pe.rmlabs.amana.AmanaManager;

public class OpenReplaysFolderListener implements ActionListener {

	int version;
	
	public OpenReplaysFolderListener(int version) {
		super();
		this.version = version;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(version == AmanaManager.AIRMECH_PC){
			AmanaManager.openPcReplaysFolder();
		}else if(version == AmanaManager.AIRMECH_STEAM){
			AmanaManager.openSteamReplaysFolder();
		}
	}

}
