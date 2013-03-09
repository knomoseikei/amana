package pe.rmlabs.amana.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PlayerLoadoutPanel extends JPanel {

	private JLabel lblAirMech;
	private JLabel lblPilot;
	private JLabel lblItem;
	private JLabel lblUnit8;
	private JLabel lblUnit1;
	private JLabel lblUnit2;
	private JLabel lblUnit7;
	private JLabel lblColor;
	private JLabel lblUnit3;
	private JLabel lblUnit6;
	private JLabel lblUnit5;
	private JLabel lblUnit4;
	private JLabel lblFlair1;
	private JLabel lblFlair3;
	private JLabel lblFlair2;

	public PlayerLoadoutPanel() {
//		super();
//
//		setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
//		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
//		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
//		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
//		setLayout(gridBagLayout);
//
//		try {
//			lblAirMech = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblAirMech = new GridBagConstraints();
//			gbc_lblAirMech.insets = new Insets(0, 0, 5, 5);
//			gbc_lblAirMech.gridx = 0;
//			gbc_lblAirMech.gridy = 0;
//			add(lblAirMech, gbc_lblAirMech);
//
//			lblPilot = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblPilot = new GridBagConstraints();
//			gbc_lblPilot.insets = new Insets(0, 0, 5, 5);
//			gbc_lblPilot.gridx = 1;
//			gbc_lblPilot.gridy = 0;
//			add(lblPilot, gbc_lblPilot);
//
//			lblItem = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblItem = new GridBagConstraints();
//			gbc_lblItem.insets = new Insets(0, 0, 5, 0);
//			gbc_lblItem.gridx = 2;
//			gbc_lblItem.gridy = 0;
//			add(lblItem, gbc_lblItem);
//
//			JSeparator separator = new JSeparator();
//			GridBagConstraints gbc_separator = new GridBagConstraints();
//			gbc_separator.weightx = 1.0;
//			gbc_separator.insets = new Insets(0, 0, 5, 0);
//			gbc_separator.gridwidth = 3;
//			gbc_separator.gridx = 0;
//			gbc_separator.gridy = 1;
//			add(separator, gbc_separator);
//
//			lblUnit8 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit8 = new GridBagConstraints();
//			gbc_lblUnit8.insets = new Insets(0, 0, 5, 5);
//			gbc_lblUnit8.gridx = 0;
//			gbc_lblUnit8.gridy = 2;
//			add(lblUnit8, gbc_lblUnit8);
//
//			lblUnit1 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit1 = new GridBagConstraints();
//			gbc_lblUnit1.insets = new Insets(0, 0, 5, 5);
//			gbc_lblUnit1.gridx = 1;
//			gbc_lblUnit1.gridy = 2;
//			add(lblUnit1, gbc_lblUnit1);
//
//			lblUnit2 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit2 = new GridBagConstraints();
//			gbc_lblUnit2.insets = new Insets(0, 0, 5, 0);
//			gbc_lblUnit2.gridx = 2;
//			gbc_lblUnit2.gridy = 2;
//			add(lblUnit2, gbc_lblUnit2);
//
//			lblUnit7 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit7 = new GridBagConstraints();
//			gbc_lblUnit7.insets = new Insets(0, 0, 5, 5);
//			gbc_lblUnit7.gridx = 0;
//			gbc_lblUnit7.gridy = 3;
//			add(lblUnit7, gbc_lblUnit7);
//
//			lblColor = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblColor = new GridBagConstraints();
//			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
//			gbc_lblColor.gridx = 1;
//			gbc_lblColor.gridy = 3;
//			add(lblColor, gbc_lblColor);
//
//			lblUnit3 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit3 = new GridBagConstraints();
//			gbc_lblUnit3.insets = new Insets(0, 0, 5, 0);
//			gbc_lblUnit3.gridx = 2;
//			gbc_lblUnit3.gridy = 3;
//			add(lblUnit3, gbc_lblUnit3);
//
//			lblUnit6 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit6 = new GridBagConstraints();
//			gbc_lblUnit6.insets = new Insets(0, 0, 5, 5);
//			gbc_lblUnit6.gridx = 0;
//			gbc_lblUnit6.gridy = 4;
//			add(lblUnit6, gbc_lblUnit6);
//
//			lblUnit5 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit5 = new GridBagConstraints();
//			gbc_lblUnit5.insets = new Insets(0, 0, 5, 5);
//			gbc_lblUnit5.gridx = 1;
//			gbc_lblUnit5.gridy = 4;
//			add(lblUnit5, gbc_lblUnit5);
//
//			lblUnit4 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblUnit4 = new GridBagConstraints();
//			gbc_lblUnit4.insets = new Insets(0, 0, 5, 0);
//			gbc_lblUnit4.gridx = 2;
//			gbc_lblUnit4.gridy = 4;
//			add(lblUnit4, gbc_lblUnit4);
//
//			JSeparator separator_1 = new JSeparator();
//			GridBagConstraints gbc_separator_1 = new GridBagConstraints();
//			gbc_separator_1.weightx = 1.0;
//			gbc_separator_1.insets = new Insets(0, 0, 5, 0);
//			gbc_separator_1.gridwidth = 3;
//			gbc_separator_1.gridx = 0;
//			gbc_separator_1.gridy = 5;
//			add(separator_1, gbc_separator_1);
//
//			lblFlair1 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblFlair1 = new GridBagConstraints();
//			gbc_lblFlair1.insets = new Insets(0, 0, 0, 5);
//			gbc_lblFlair1.gridx = 0;
//			gbc_lblFlair1.gridy = 6;
//			add(lblFlair1, gbc_lblFlair1);
//
//			lblFlair2 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblFlair2 = new GridBagConstraints();
//			gbc_lblFlair2.insets = new Insets(0, 0, 0, 5);
//			gbc_lblFlair2.gridx = 1;
//			gbc_lblFlair2.gridy = 6;
//			add(lblFlair2, gbc_lblFlair2);
//
//			lblFlair3 = new JLabel(SpriteStore.get().getSprite("new-thumb.png"));
//			GridBagConstraints gbc_lblFlair3 = new GridBagConstraints();
//			gbc_lblFlair3.gridx = 2;
//			gbc_lblFlair3.gridy = 6;
//			add(lblFlair3, gbc_lblFlair3);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public PlayerLoadoutPanel(String player, Icon iconAirMech, Icon iconPilot, Icon iconItem, Icon iconUnit8, Icon iconUnit1, Icon iconUnit2,
			Icon iconUnit7, Icon iconColor, Icon iconUnit3, Icon iconUnit6, Icon iconUnit5, Icon iconUnit4, Icon iconFlair1, Icon iconFlair3,
			Icon iconFlair2) {
		super();

		this.lblAirMech = new JLabel(iconAirMech);
		this.lblPilot = new JLabel(iconPilot);
		this.lblItem = new JLabel(iconItem);
		this.lblColor = new JLabel(iconColor);
		this.lblUnit1 = new JLabel(iconUnit1);
		this.lblUnit2 = new JLabel(iconUnit2);
		this.lblUnit3 = new JLabel(iconUnit3);
		this.lblUnit4 = new JLabel(iconUnit4);
		this.lblUnit5 = new JLabel(iconUnit5);
		this.lblUnit6 = new JLabel(iconUnit6);
		this.lblUnit7 = new JLabel(iconUnit7);
		this.lblUnit8 = new JLabel(iconUnit8);
		this.lblFlair1 = new JLabel(iconFlair1);
		this.lblFlair2 = new JLabel(iconFlair2);
		this.lblFlair3 = new JLabel(iconFlair3);

		setBorder(new TitledBorder(null, player, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0,0.0};
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);


		// lblAirMech = new JLabel("New");
		GridBagConstraints gbc_lblAirMech = new GridBagConstraints();
		gbc_lblAirMech.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirMech.gridx = 0;
		gbc_lblAirMech.gridy = 0;
		add(lblAirMech, gbc_lblAirMech);

		// lblPilot = new JLabel("New");
		GridBagConstraints gbc_lblPilot = new GridBagConstraints();
		gbc_lblPilot.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilot.gridx = 1;
		gbc_lblPilot.gridy = 0;
		add(lblPilot, gbc_lblPilot);

		// lblItem = new JLabel("New");
		GridBagConstraints gbc_lblItem = new GridBagConstraints();
		gbc_lblItem.insets = new Insets(0, 0, 5, 0);
		gbc_lblItem.gridx = 2;
		gbc_lblItem.gridy = 0;
		add(lblItem, gbc_lblItem);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.weightx = 1.0;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 3;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);

		// lblUnit8 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit8 = new GridBagConstraints();
		gbc_lblUnit8.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit8.gridx = 0;
		gbc_lblUnit8.gridy = 2;
		add(lblUnit8, gbc_lblUnit8);

		// lblUnit1 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit1 = new GridBagConstraints();
		gbc_lblUnit1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit1.gridx = 1;
		gbc_lblUnit1.gridy = 2;
		add(lblUnit1, gbc_lblUnit1);

		// lblUnit2 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit2 = new GridBagConstraints();
		gbc_lblUnit2.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnit2.gridx = 2;
		gbc_lblUnit2.gridy = 2;
		add(lblUnit2, gbc_lblUnit2);

		// lblUnit7 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit7 = new GridBagConstraints();
		gbc_lblUnit7.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit7.gridx = 0;
		gbc_lblUnit7.gridy = 3;
		add(lblUnit7, gbc_lblUnit7);

		// lblColor = new JLabel("New label");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 1;
		gbc_lblColor.gridy = 3;
		add(lblColor, gbc_lblColor);

		// lblUnit3 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit3 = new GridBagConstraints();
		gbc_lblUnit3.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnit3.gridx = 2;
		gbc_lblUnit3.gridy = 3;
		add(lblUnit3, gbc_lblUnit3);

		// lblUnit6 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit6 = new GridBagConstraints();
		gbc_lblUnit6.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit6.gridx = 0;
		gbc_lblUnit6.gridy = 4;
		add(lblUnit6, gbc_lblUnit6);

		// lblUnit5 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit5 = new GridBagConstraints();
		gbc_lblUnit5.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnit5.gridx = 1;
		gbc_lblUnit5.gridy = 4;
		add(lblUnit5, gbc_lblUnit5);

		// lblUnit4 = new JLabel("New label");
		GridBagConstraints gbc_lblUnit4 = new GridBagConstraints();
		gbc_lblUnit4.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnit4.gridx = 2;
		gbc_lblUnit4.gridy = 4;
		add(lblUnit4, gbc_lblUnit4);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.weightx = 1.0;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		add(separator_1, gbc_separator_1);

		// lblFlair1 = new JLabel("New label");
		GridBagConstraints gbc_lblFlair1 = new GridBagConstraints();
		gbc_lblFlair1.insets = new Insets(0, 0, 0, 5);
		gbc_lblFlair1.gridx = 0;
		gbc_lblFlair1.gridy = 6;
		add(lblFlair1, gbc_lblFlair1);

		// lblFlair2 = new JLabel("New label");
		GridBagConstraints gbc_lblFlair2 = new GridBagConstraints();
		gbc_lblFlair2.insets = new Insets(0, 0, 0, 5);
		gbc_lblFlair2.gridx = 1;
		gbc_lblFlair2.gridy = 6;
		add(lblFlair2, gbc_lblFlair2);

		// lblFlair3 = new JLabel("New label");
		GridBagConstraints gbc_lblFlair3 = new GridBagConstraints();
		gbc_lblFlair3.gridx = 2;
		gbc_lblFlair3.gridy = 6;
		add(lblFlair3, gbc_lblFlair3);
	}

}
