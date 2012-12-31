package pe.rmlabs.amana.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import pe.rmlabs.amana.AmanaManager;

public class RefreshListener implements ActionListener {

	private int version;
	private JList listReplays;

	public RefreshListener(int version, JList listReplaysPc) {
		super();
		this.version = version;
		this.listReplays = listReplaysPc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AmanaManager.refreshList(version, listReplays, true);
	}

}
