package pe.rmlabs.amana.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;
import pe.rmlabs.amana.domain.AirMechReplayInfo;
import pe.rmlabs.amana.loader.SpriteStore;

@SuppressWarnings("serial")
public class ReplaysListCellRenderer extends JPanel implements ListCellRenderer {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:ss");

	private JLabel lblName;
	private JLabel lblP1;
	private JLabel lblBuild;
	private JLabel lblDate;
	private JLabel lblAm1;
	private JLabel lblPilot1;
	private JLabel lblItem1;
	private JLabel lblP3;
	private JLabel lblAm3;
	private JLabel lblPilot3;
	private JLabel lblItem3;
	private JLabel lblP5;
	private JLabel lblAm5;
	private JLabel lblPilot5;
	private JLabel lblItem5;
	private JLabel lblP6;
	private JLabel lblAm6;
	private JLabel lblPilot6;
	private JLabel lblItem6;
	private JLabel lblAm4;
	private JLabel lblPilot4;
	private JLabel lblItem4;
	private JLabel lblP4;
	private JLabel lblAm2;
	private JLabel lblPilot2;
	private JLabel lblItem2;
	private JLabel lblP2;
	private JLabel lblMap;
	private JLabel lblMode;
	private JPanel panel;
	private JLabel lblVs;
	private JLabel lblS;

	public ReplaysListCellRenderer() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new MigLayout("", "[114.00][][][][][11.00][][][]", "[17.00][][][][][]"));

		panel = new JPanel();
		add(panel, "cell 0 0 1 6,grow");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		panel.setOpaque(false);

		lblName = new JLabel();
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);

		lblBuild = new JLabel();
		GridBagConstraints gbc_lblBuild = new GridBagConstraints();
		gbc_lblBuild.anchor = GridBagConstraints.WEST;
		gbc_lblBuild.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuild.gridx = 0;
		gbc_lblBuild.gridy = 1;
		panel.add(lblBuild, gbc_lblBuild);

		lblDate = new JLabel();
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 2;
		panel.add(lblDate, gbc_lblDate);

		lblMode = new JLabel();
		GridBagConstraints gbc_lblMode = new GridBagConstraints();
		gbc_lblMode.insets = new Insets(0, 0, 5, 0);
		gbc_lblMode.gridx = 0;
		gbc_lblMode.gridy = 3;
		panel.add(lblMode, gbc_lblMode);
		lblMode.setIcon(null);

		lblMap = new JLabel();
		GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.gridx = 0;
		gbc_lblMap.gridy = 4;
		panel.add(lblMap, gbc_lblMap);
		lblMap.setIcon(null);

		lblS = new JLabel();
		add(lblS, "cell 1 0 1 6");

		lblP1 = new JLabel();
		add(lblP1, "cell 2 0 3 1");

		lblVs = new JLabel();
		add(lblVs, "cell 5 0 1 6");

		lblP2 = new JLabel();
		add(lblP2, "cell 6 0 3 1");

		lblAm1 = new JLabel();
		lblAm1.setToolTipText("");
		lblAm1.setIcon(null);
		add(lblAm1, "cell 2 1");

		lblPilot1 = new JLabel();
		lblPilot1.setIcon(null);
		add(lblPilot1, "cell 3 1");

		lblItem1 = new JLabel();
		lblItem1.setIcon(null);
		add(lblItem1, "cell 4 1");

		lblAm2 = new JLabel();
		lblAm2.setIcon(null);
		add(lblAm2, "cell 6 1");

		lblPilot2 = new JLabel();
		lblPilot2.setIcon(null);
		add(lblPilot2, "cell 7 1");

		lblItem2 = new JLabel();
		lblItem2.setIcon(null);
		add(lblItem2, "cell 8 1");

		lblP3 = new JLabel();
		add(lblP3, "cell 2 2 3 1");

		lblP4 = new JLabel();
		add(lblP4, "cell 6 2 3 1");

		lblAm3 = new JLabel();
		lblAm3.setIcon(null);
		add(lblAm3, "cell 2 3");

		lblPilot3 = new JLabel();
		lblPilot3.setIcon(null);
		add(lblPilot3, "cell 3 3");

		lblItem3 = new JLabel();
		lblItem3.setIcon(null);
		add(lblItem3, "cell 4 3");

		lblAm4 = new JLabel();
		lblAm4.setIcon(null);
		add(lblAm4, "cell 6 3");

		lblPilot4 = new JLabel();
		lblPilot4.setIcon(null);
		add(lblPilot4, "cell 7 3");

		lblItem4 = new JLabel();
		lblItem4.setIcon(null);
		add(lblItem4, "cell 8 3");

		lblP5 = new JLabel();
		add(lblP5, "cell 2 4 3 1");

		lblP6 = new JLabel();
		add(lblP6, "cell 6 4 3 1");

		lblAm5 = new JLabel();
		add(lblAm5, "cell 2 5");

		lblPilot5 = new JLabel();
		lblPilot5.setIcon(null);
		add(lblPilot5, "cell 3 5");

		lblItem5 = new JLabel();
		lblItem5.setIcon(null);
		add(lblItem5, "cell 4 5");

		lblAm6 = new JLabel();
		lblAm6.setIcon(null);
		add(lblAm6, "cell 6 5");

		lblPilot6 = new JLabel();
		lblPilot6.setIcon(null);
		add(lblPilot6, "cell 7 5");

		lblItem6 = new JLabel();
		lblItem6.setIcon(null);
		add(lblItem6, "cell 8 5");

	}

	private static int CELL_WIDTH = 380;
	private static int CELL_HEIGHT_2P = 140;
	private static int CELL_HEIGHT_3P = 180;

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		AirMechReplayInfo amri = (AirMechReplayInfo) value;

		lblName.setText(amri.getName());
		lblBuild.setText("Build " + amri.getBuild());
		lblDate.setText(sdf.format(amri.getDate().getTime()));

		try {
			lblMode.setIcon(SpriteStore.get().getSprite(amri.getGameMode().getImage()));
			lblMap.setIcon(SpriteStore.get().getSprite(amri.getMap().getImage()));

			if (amri.getPlayer1() != null) {
				lblP1.setText(amri.getPlayer1().getPlayer());
				lblAm1.setIcon(SpriteStore.get().getSprite(amri.getPlayer1().getAirmech().getImage()));
				lblPilot1.setIcon(SpriteStore.get().getSprite(amri.getPlayer1().getPilot().getImage()));
				lblItem1.setIcon(SpriteStore.get().getSprite(amri.getPlayer1().getItem().getImage()));
				setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT_2P));
			} else {
				lblP1.setText(null);
				lblAm1.setIcon(null);
				lblPilot1.setIcon(null);
				lblItem1.setIcon(null);
			}
			
			if (amri.getPlayer2() != null) {
				lblP2.setText(amri.getPlayer2().getPlayer());
				lblAm2.setIcon(SpriteStore.get().getSprite(amri.getPlayer2().getAirmech().getImage()));
				lblPilot2.setIcon(SpriteStore.get().getSprite(amri.getPlayer2().getPilot().getImage()));
				lblItem2.setIcon(SpriteStore.get().getSprite(amri.getPlayer2().getItem().getImage()));
			} else {
				lblP2.setText(null);
				lblAm2.setIcon(null);
				lblPilot2.setIcon(null);
				lblItem2.setIcon(null);
			}
			if (amri.getPlayer3() != null) {
				lblP3.setText(amri.getPlayer3().getPlayer());
				lblAm3.setIcon(SpriteStore.get().getSprite(amri.getPlayer3().getAirmech().getImage()));
				lblPilot3.setIcon(SpriteStore.get().getSprite(amri.getPlayer3().getPilot().getImage()));
				lblItem3.setIcon(SpriteStore.get().getSprite(amri.getPlayer3().getItem().getImage()));
			} else {
				lblP3.setText(null);
				lblAm3.setIcon(null);
				lblPilot3.setIcon(null);
				lblItem3.setIcon(null);
			}
			if (amri.getPlayer4() != null) {
				lblP4.setText(amri.getPlayer4().getPlayer());
				lblAm4.setIcon(SpriteStore.get().getSprite(amri.getPlayer4().getAirmech().getImage()));
				lblPilot4.setIcon(SpriteStore.get().getSprite(amri.getPlayer4().getPilot().getImage()));
				lblItem4.setIcon(SpriteStore.get().getSprite(amri.getPlayer4().getItem().getImage()));
				setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT_2P));
			} else {
				lblP4.setText(null);
				lblAm4.setIcon(null);
				lblPilot4.setIcon(null);
				lblItem4.setIcon(null);
			}
			if (amri.getPlayer5() != null) {
				lblP5.setText(amri.getPlayer5().getPlayer());
				lblAm5.setIcon(SpriteStore.get().getSprite(amri.getPlayer5().getAirmech().getImage()));
				lblPilot5.setIcon(SpriteStore.get().getSprite(amri.getPlayer5().getPilot().getImage()));
				lblItem5.setIcon(SpriteStore.get().getSprite(amri.getPlayer5().getItem().getImage()));
			} else {
				lblP5.setText(null);
				lblAm5.setIcon(null);
				lblPilot5.setIcon(null);
				lblItem5.setIcon(null);
			}
			if (amri.getPlayer6() != null) {
				lblP6.setText(amri.getPlayer6().getPlayer());
				lblAm6.setIcon(SpriteStore.get().getSprite(amri.getPlayer6().getAirmech().getImage()));
				lblPilot6.setIcon(SpriteStore.get().getSprite(amri.getPlayer6().getPilot().getImage()));
				lblItem6.setIcon(SpriteStore.get().getSprite(amri.getPlayer6().getItem().getImage()));
				setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT_3P));
			} else {
				lblP6.setText(null);
				lblAm6.setIcon(null);
				lblPilot6.setIcon(null);
				lblItem6.setIcon(null);
			}

		} catch (Exception e) {
			System.out.println("ERROR " + amri);
			System.out.println("PLAYER 1" + amri.getPlayer1());
			System.out.println("PLAYER 2" + amri.getPlayer2());
			System.out.println("PLAYER 3" + amri.getPlayer3());
			System.out.println("PLAYER 4" + amri.getPlayer4());
			System.out.println("PLAYER 5" + amri.getPlayer5());
			System.out.println("PLAYER 6" + amri.getPlayer6());
			e.printStackTrace();
		}

		if (isSelected) {
			System.out.println("Selected");
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		return this;
	}

}