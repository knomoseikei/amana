package pe.rmlabs.amana.gui.listener;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.TransferHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import pe.rmlabs.amana.AmanaManager;
import pe.rmlabs.amana.launcher.Launcher;

@SuppressWarnings("serial")
public class FileHandler extends TransferHandler {
	
	private JTabbedPane tabVersionPane;
	
	public FileHandler(JTabbedPane tabVersionPane) {
		this.tabVersionPane = tabVersionPane;
	}

	@Override
	public boolean canImport(TransferHandler.TransferSupport support) {
		if (!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean importData(TransferHandler.TransferSupport support) {
		if (!canImport(support)) {
			return false;
		}

		Transferable t = support.getTransferable();

		try {
			@SuppressWarnings("unchecked")
			List<File> l = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

			for (File f : l) {
				System.out.println(f.getName());
			}
			
			System.out.println("tabVersionPane.getSelectedIndex():"+tabVersionPane.getSelectedIndex());
			
			int version = tabVersionPane.getSelectedIndex();
			if(version == AmanaManager.AIRMECH_PC){
				File f = new File(AmanaManager.getReplaysPcPath()+"dnd1324.replay");
				FileUtils.copyFile(l.get(0), f);
				System.out.println(f.getName());
				Launcher.launchAirMech(Launcher.createPcLaunchBatchBody(FilenameUtils.removeExtension(f.getName()), ""));
			}else if(version == AmanaManager.AIRMECH_STEAM){
				File f = new File(AmanaManager.getReplaysSteamPath()+"dnd1324.replay");
				FileUtils.copyFile(l.get(0), f);
				System.out.println(f.getName());
				Launcher.launchAirMech(Launcher.createSteamLaunchBatchBody(FilenameUtils.removeExtension(f.getName()), ""));
			}
			
		} catch (UnsupportedFlavorException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

		return true;
	}
}