package pe.rmlabs.amana.gui.listener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pe.rmlabs.amana.AmanaManager;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
import pe.rmlabs.amana.loader.SpriteStore;

public class ReplayPreviewListener implements ListSelectionListener {

	JPanel pnlLoadouts;
	JList lstReplays;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:ss");
	private JLabel lblName;
	private JLabel lblBuild;
	private JLabel lblDate;
	private JLabel lblMode;
	private JLabel lblMap;
	private JPanel pnlPlayer1;
	private JPanel pnlPlayer2;
	private JPanel pnlPlayer3;
	private JPanel pnlPlayer4;
	private JPanel pnlPlayer5;
	private JPanel pnlPlayer6;
	private JPanel pnlHeader1;
	private JPanel pnlHeader2;
	private JPanel pnlReplayName;
	private JPanel pnlBuild;
	private JPanel pnlDate;

	public ReplayPreviewListener(JPanel pnlLoadoutsPc, JList lstReplays) {
		super();
		this.pnlLoadouts = pnlLoadoutsPc;
		this.lstReplays = lstReplays;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		try {
			// pnlLoadouts = new
			// ReplayViewPanel((AirMechReplayInfo)lstReplays.getSelectedValue());
			pnlLoadouts.removeAll();
			AirMechReplayInfo amri = (AirMechReplayInfo) lstReplays.getSelectedValue();

			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
			gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
			gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
			pnlLoadouts.setLayout(gridBagLayout);

			pnlHeader1 = new JPanel();
			GridBagConstraints gbc_pnlHeader1 = new GridBagConstraints();
			gbc_pnlHeader1.gridwidth = 6;
			gbc_pnlHeader1.insets = new Insets(0, 0, 5, 0);
			gbc_pnlHeader1.fill = GridBagConstraints.BOTH;
			gbc_pnlHeader1.gridx = 0;
			gbc_pnlHeader1.gridy = 0;
			pnlLoadouts.add(pnlHeader1, gbc_pnlHeader1);
			pnlHeader1.setLayout(new GridLayout(1, 0, 0, 0));

			pnlReplayName = new JPanel();
			pnlHeader1.add(pnlReplayName);
			pnlReplayName.setBorder(new TitledBorder(null, "Replay Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));

			lblName = new JLabel("NOMBRE");
			pnlReplayName.add(lblName);

			pnlBuild = new JPanel();
			pnlHeader1.add(pnlBuild);
			pnlBuild.setBorder(new TitledBorder(null, "Build", TitledBorder.LEADING, TitledBorder.TOP, null, null));

			lblBuild = new JLabel("BUILD");
			pnlBuild.add(lblBuild);

			pnlDate = new JPanel();
			pnlHeader1.add(pnlDate);
			pnlDate.setBorder(new TitledBorder(null, "Date", TitledBorder.LEADING, TitledBorder.TOP, null, null));

			lblDate = new JLabel("FECHA");
			pnlDate.add(lblDate);

			pnlHeader2 = new JPanel();
			GridBagConstraints gbc_pnlHeader2 = new GridBagConstraints();
			gbc_pnlHeader2.gridwidth = 6;
			gbc_pnlHeader2.insets = new Insets(0, 0, 5, 5);
			gbc_pnlHeader2.fill = GridBagConstraints.BOTH;
			gbc_pnlHeader2.gridx = 0;
			gbc_pnlHeader2.gridy = 1;
			pnlLoadouts.add(pnlHeader2, gbc_pnlHeader2);
			pnlHeader2.setLayout(new GridLayout(1, 0, 0, 0));

			lblMode = new JLabel("MODO");
			lblMode.setHorizontalAlignment(SwingConstants.CENTER);
			pnlHeader2.add(lblMode);

			lblMap = new JLabel("MAPA");
			lblMap.setHorizontalAlignment(SwingConstants.CENTER);
			pnlHeader2.add(lblMap);
			
			pnlPlayer1 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer1());
			System.out.println(amri.getPlayer1());
			GridBagConstraints gbc_pnlPlayer1 = new GridBagConstraints();
			gbc_pnlPlayer1.gridwidth = 2;
			gbc_pnlPlayer1.insets = new Insets(0, 0, 5, 5);
			gbc_pnlPlayer1.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer1.gridx = 0;
			gbc_pnlPlayer1.gridy = 2;
			pnlLoadouts.add(pnlPlayer1, gbc_pnlPlayer1);
			
			pnlPlayer3 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer3());
			GridBagConstraints gbc_pnlPlayer3 = new GridBagConstraints();
			gbc_pnlPlayer3.gridwidth = 2;
			gbc_pnlPlayer3.insets = new Insets(0, 0, 5, 5);
			gbc_pnlPlayer3.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer3.gridx = 2;
			gbc_pnlPlayer3.gridy = 2;
			pnlLoadouts.add(pnlPlayer3, gbc_pnlPlayer3);
			
			System.out.println(amri.getPlayer5());
			pnlPlayer5 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer5());
			GridBagConstraints gbc_pnlPlayer5 = new GridBagConstraints();
			gbc_pnlPlayer5.gridwidth = 3;
			gbc_pnlPlayer5.insets = new Insets(0, 0, 5, 0);
			gbc_pnlPlayer5.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer5.gridx = 4;
			gbc_pnlPlayer5.gridy = 2;
			pnlLoadouts.add(pnlPlayer5, gbc_pnlPlayer5);
			
			pnlPlayer2 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer2());
			GridBagConstraints gbc_pnlPlayer2 = new GridBagConstraints();
			gbc_pnlPlayer2.gridwidth = 2;
			gbc_pnlPlayer2.insets = new Insets(0, 0, 5, 5);
			gbc_pnlPlayer2.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer2.gridx = 0;
			gbc_pnlPlayer2.gridy = 3;
			pnlLoadouts.add(pnlPlayer2, gbc_pnlPlayer2);
			
			pnlPlayer4 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer4());
			GridBagConstraints gbc_pnlPlayer4 = new GridBagConstraints();
			gbc_pnlPlayer4.gridwidth = 2;
			gbc_pnlPlayer4.insets = new Insets(0, 0, 5, 5);
			gbc_pnlPlayer4.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer4.gridx = 2;
			gbc_pnlPlayer4.gridy = 3;
			pnlLoadouts.add(pnlPlayer4, gbc_pnlPlayer4);
			
			pnlPlayer6 = AmanaManager.loadPlayerLoadoutPanel(amri.getPlayer6());
			GridBagConstraints gbc_pnlPlayer6 = new GridBagConstraints();
			gbc_pnlPlayer6.gridwidth = 3;
			gbc_pnlPlayer6.insets = new Insets(0, 0, 5, 0);
			gbc_pnlPlayer6.fill = GridBagConstraints.BASELINE;
			gbc_pnlPlayer6.gridx = 4;
			gbc_pnlPlayer6.gridy = 3;
			pnlLoadouts.add(pnlPlayer6, gbc_pnlPlayer6);

			fillLabels(amri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("valueChanged");
	}

	private void fillLabels(AirMechReplayInfo amri) throws Exception {
		lblName.setText(amri.getName());
		lblBuild.setText("Build " + amri.getBuild());
		lblDate.setText(sdf.format(amri.getDate().getTime()));

		lblMode.setIcon(SpriteStore.get().getSprite(amri.getGameMode().getImage()));
		lblMode.setText(null);
		lblMap.setIcon(SpriteStore.get().getSprite(amri.getMap().getImage()));
		lblMap.setText(null);
		
		
	}

}
