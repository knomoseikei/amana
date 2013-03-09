package pe.rmlabs.amana;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pe.rmlabs.amana.gui.MainWindow;

public class AmanaMain {
	
	public static void main(String[] args) {
		System.out.println("-------------------------------Amana 2.0 start");
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		//ConfigManager.get().setDefaultValues();
		//ConfigManager.get().setProperty("N", "0");
		AmanaManager.createReplayFolders();
		if (AmanaManager.getNumberOfUses() == 0) {
			AmanaManager.setDefaultConfig();
		}
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					@SuppressWarnings("unused")
					MainWindow window = new MainWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
