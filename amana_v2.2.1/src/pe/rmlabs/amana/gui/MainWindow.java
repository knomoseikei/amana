package pe.rmlabs.amana.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import pe.rmlabs.amana.AmanaManager;
import pe.rmlabs.amana.gui.listener.FileHandler;
import pe.rmlabs.amana.gui.listener.LaunchAirMechListener;
import pe.rmlabs.amana.gui.listener.OpenReplaysFolderListener;
import pe.rmlabs.amana.gui.listener.RefreshListener;
import pe.rmlabs.amana.gui.listener.ReplayPreviewListener;
import pe.rmlabs.amana.loader.ConfigManager;
import pe.rmlabs.amana.loader.SpriteStore;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MainWindow {

	private JFrame frmAmana;
	private JCheckBox chkReplayPc;
	private JList lstReplaysPc;
	private JCheckBox chkReplaySteam;
	private JList lstReplaysSteam;
	private JScrollPane scrollPaneSteam;
	private JButton btnLaunchAirMechPc;
	private JButton btnOpenFolderPc;
	private JButton btnRefreshPc;
	private JButton btnLaunchAirMechSteam;
	private JButton btnOpenFolderSteam;
	private JButton btnRefreshSteam;
	private JTabbedPane tabVersionPane;
	private JPanel pnlLoadoutsPc;
	private JPanel pnlLoadoutsSteam;
	private JScrollPane scrollPanePc;
	private JSeparator sepPc;
	private JSeparator separator;
	private JPanel pntConfig;
	private JLabel lblAirmechPcPath;
	private JTextField txtAirmechPcPath;
	private JTextField txtArgsPc;
	private JTextField txtAirMechSteamPath;
	private JTextField txtArgsSteam;
	private JLabel lblArgsSteam;
	private JLabel lblAirmechSteamPath;
	private JLabel lblArgsPc;
	private JLabel lblPcReplaysFolder;
	private JLabel lblSteamReplaysFolder;
	private JTextField txtSteamReplaysFolder;
	private JTextField txtPcReplaysFolder;
	private JPanel panel;
	private JButton btnSaveChanges;
	private JButton btnDefaultConfig;
	private JButton btnCancelChanges;
	private JButton btnValidatePaths;
	private JSeparator separator_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblDragdropTarget;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radPcVersion;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		initializeListeners();
	}

	private void initializeListeners() {
		// PC Listeners
		btnRefreshPc.addActionListener(new RefreshListener(AmanaManager.AIRMECH_PC, lstReplaysPc));
		btnOpenFolderPc.addActionListener(new OpenReplaysFolderListener(AmanaManager.AIRMECH_PC));
		btnLaunchAirMechPc.addActionListener(new LaunchAirMechListener(AmanaManager.AIRMECH_PC, chkReplayPc, null, null, lstReplaysPc));
		lstReplaysPc.addListSelectionListener(new ReplayPreviewListener(pnlLoadoutsPc, lstReplaysPc));

		// Steam Listeners
		btnRefreshSteam.addActionListener(new RefreshListener(AmanaManager.AIRMECH_STEAM, lstReplaysSteam));
		btnOpenFolderSteam.addActionListener(new OpenReplaysFolderListener(AmanaManager.AIRMECH_STEAM));
		btnLaunchAirMechSteam.addActionListener(new LaunchAirMechListener(AmanaManager.AIRMECH_STEAM, chkReplaySteam, null, null, lstReplaysSteam));
		lstReplaysSteam.addListSelectionListener(new ReplayPreviewListener(pnlLoadoutsSteam, lstReplaysSteam));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmana = new JFrame();
		frmAmana.setTitle("Amana 2.2 by Knomo Seikei");

		try {
			frmAmana.setIconImage(((ImageIcon) SpriteStore.get().getSprite("airmech128.png")).getImage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		frmAmana.setResizable(false);
		frmAmana.setVisible(true);
		frmAmana.setBounds(100, 100, 800, 600);
		frmAmana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frmAmana.getContentPane().setLayout(gridBagLayout);

		tabVersionPane = new JTabbedPane(SwingConstants.TOP);
		GridBagConstraints gbc_tabVersionPane = new GridBagConstraints();
		gbc_tabVersionPane.fill = GridBagConstraints.BOTH;
		gbc_tabVersionPane.gridx = 0;
		gbc_tabVersionPane.gridy = 0;
		frmAmana.setTransferHandler(new FileHandler(tabVersionPane));
		frmAmana.getContentPane().add(tabVersionPane, gbc_tabVersionPane);

		JPanel pnlPc = new JPanel();
		tabVersionPane.addTab("PC Version", new ImageIcon(MainWindow.class.getResource("/pe/rmlabs/amana/sprites/windows-icon16.png")), pnlPc, null);
		pnlPc.setLayout(getAmanaFormLayout());
		GridBagLayout gbl_pnlPc = new GridBagLayout();
		gbl_pnlPc.columnWidths = new int[] { 29, 87, 105, 37, 93, 0, 395, 0 };
		gbl_pnlPc.rowHeights = new int[] { 1, 23, 505, 0 };
		gbl_pnlPc.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlPc.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlPc.setLayout(gbl_pnlPc);

		chkReplayPc = new JCheckBox("Run replay file");
		chkReplayPc.setSelected(true);
		GridBagConstraints gbc_chkReplayPc = new GridBagConstraints();
		gbc_chkReplayPc.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkReplayPc.insets = new Insets(0, 0, 5, 5);
		gbc_chkReplayPc.gridx = 2;
		gbc_chkReplayPc.gridy = 1;
		pnlPc.add(chkReplayPc, gbc_chkReplayPc);

		btnRefreshPc = new JButton("");
		try {
			btnRefreshPc.setIcon(SpriteStore.get().getSprite("refresh-green.png"));
		} catch (Exception e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		GridBagConstraints gbc_btnRefreshPc = new GridBagConstraints();
		gbc_btnRefreshPc.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefreshPc.gridx = 3;
		gbc_btnRefreshPc.gridy = 1;
		pnlPc.add(btnRefreshPc, gbc_btnRefreshPc);

		btnOpenFolderPc = new JButton("Open folder");
		try {
			btnOpenFolderPc.setIcon(SpriteStore.get().getSprite("open-folder.png"));
		} catch (Exception e5) {
			e5.printStackTrace();
		}
		GridBagConstraints gbc_btnOpenFolderPc = new GridBagConstraints();
		gbc_btnOpenFolderPc.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenFolderPc.gridx = 4;
		gbc_btnOpenFolderPc.gridy = 1;
		pnlPc.add(btnOpenFolderPc, gbc_btnOpenFolderPc);

		btnLaunchAirMechPc = new JButton("Run AirMech");
		try {
			btnLaunchAirMechPc.setIcon(SpriteStore.get().getSprite("airmech16.png"));
		} catch (Exception e5) {
			e5.printStackTrace();
		}
		GridBagConstraints gbc_btnLaunchAirMechPc = new GridBagConstraints();
		gbc_btnLaunchAirMechPc.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLaunchAirMechPc.insets = new Insets(0, 0, 5, 5);
		gbc_btnLaunchAirMechPc.gridx = 1;
		gbc_btnLaunchAirMechPc.gridy = 1;
		pnlPc.add(btnLaunchAirMechPc, gbc_btnLaunchAirMechPc);

		scrollPanePc = new JScrollPane();

		Object[] listPc = getObjectListPc();
		if (listPc == null) {
			lstReplaysPc = new JList();
		} else {
			lstReplaysPc = new JList(listPc);
		}
		lstReplaysPc.setCellRenderer(new ReplaysListCellRenderer());

		scrollPanePc.setViewportView(lstReplaysPc);
		GridBagConstraints gbc_scrollPanePc = new GridBagConstraints();
		gbc_scrollPanePc.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePc.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPanePc.gridwidth = 5;
		gbc_scrollPanePc.gridx = 0;
		gbc_scrollPanePc.gridy = 2;
		pnlPc.add(scrollPanePc, gbc_scrollPanePc);

		pnlLoadoutsPc = new JPanel();
		GridBagConstraints gbc_pnlLoadoutsPc = new GridBagConstraints();
		gbc_pnlLoadoutsPc.anchor = GridBagConstraints.WEST;
		gbc_pnlLoadoutsPc.gridheight = 2;
		gbc_pnlLoadoutsPc.gridx = 6;
		gbc_pnlLoadoutsPc.gridy = 1;
		pnlPc.add(pnlLoadoutsPc, gbc_pnlLoadoutsPc);

		GridBagLayout gbl_pnlLoadoutsPc = new GridBagLayout();
		gbl_pnlLoadoutsPc.columnWidths = new int[] { 409, 0 };
		gbl_pnlLoadoutsPc.rowHeights = new int[] { 0, 0 };
		gbl_pnlLoadoutsPc.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlLoadoutsPc.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlLoadoutsPc.setLayout(gbl_pnlLoadoutsPc);
		
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		pnlLoadoutsPc.add(new AboutPanel(), gbc_lblNewLabel_2);

		sepPc = new JSeparator();
		sepPc.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sepPc = new GridBagConstraints();
		gbc_sepPc.weighty = 1.0;
		gbc_sepPc.fill = GridBagConstraints.VERTICAL;
		gbc_sepPc.gridheight = 2;
		gbc_sepPc.insets = new Insets(0, 0, 0, 5);
		gbc_sepPc.gridx = 5;
		gbc_sepPc.gridy = 1;
		pnlPc.add(sepPc, gbc_sepPc);

		// Steam
		JPanel pnlSteam = new JPanel();
		tabVersionPane.addTab("Steam Version", new ImageIcon(MainWindow.class.getResource("/pe/rmlabs/amana/sprites/steam-icon16.png")), pnlSteam, null);
		pnlSteam.setLayout(getAmanaFormLayout());
		GridBagLayout gbl_pnlSteam = new GridBagLayout();
		gbl_pnlSteam.columnWidths = new int[] { 29, 87, 105, 37, 93, 0, 395, 0 };
		gbl_pnlSteam.rowHeights = new int[] { 1, 23, 505, 0 };
		gbl_pnlSteam.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlSteam.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlSteam.setLayout(gbl_pnlSteam);

		chkReplaySteam = new JCheckBox("Run replay file");
		chkReplaySteam.setSelected(true);

		GridBagConstraints gbc_chkReplaySteam = new GridBagConstraints();
		gbc_chkReplaySteam.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkReplaySteam.insets = new Insets(0, 0, 5, 5);
		gbc_chkReplaySteam.gridx = 2;
		gbc_chkReplaySteam.gridy = 1;

		pnlSteam.add(chkReplaySteam, gbc_chkReplaySteam);

		btnRefreshSteam = new JButton("");
		try {
			btnRefreshSteam.setIcon(SpriteStore.get().getSprite("refresh-green.png"));
		} catch (Exception e4) {
			e4.printStackTrace();
		}

		GridBagConstraints gbc_btnRefreshSteam = new GridBagConstraints();
		gbc_btnRefreshSteam.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefreshSteam.gridx = 3;
		gbc_btnRefreshSteam.gridy = 1;

		pnlSteam.add(btnRefreshSteam, gbc_btnRefreshSteam);

		btnOpenFolderSteam = new JButton("Open folder");
		try {
			btnOpenFolderSteam.setIcon(SpriteStore.get().getSprite("open-folder.png"));
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		GridBagConstraints gbc_btnOpenFolderSteam = new GridBagConstraints();

		gbc_btnOpenFolderSteam.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOpenFolderSteam.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenFolderSteam.gridx = 4;
		gbc_btnOpenFolderSteam.gridy = 1;

		pnlSteam.add(btnOpenFolderSteam, gbc_btnOpenFolderSteam);

		btnLaunchAirMechSteam = new JButton("Run AirMech");
		try {
			btnLaunchAirMechSteam.setIcon(SpriteStore.get().getSprite("airmech16.png"));
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		GridBagConstraints gbc_btnLaunchAirMechSteam = new GridBagConstraints();

		gbc_btnLaunchAirMechSteam.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLaunchAirMechSteam.insets = new Insets(0, 0, 5, 5);
		gbc_btnLaunchAirMechSteam.gridx = 1;
		gbc_btnLaunchAirMechSteam.gridy = 1;

		pnlSteam.add(btnLaunchAirMechSteam, gbc_btnLaunchAirMechSteam);

		scrollPaneSteam = new JScrollPane();

		Object[] listSteam = getObjectListSteam();
		if (listSteam == null) {
			lstReplaysSteam = new JList();
		} else {
			lstReplaysSteam = new JList(listSteam);
		}
		lstReplaysSteam.setCellRenderer(new ReplaysListCellRenderer());

		scrollPaneSteam.setViewportView(lstReplaysSteam);
		GridBagConstraints gbc_scrollPaneSteam = new GridBagConstraints();

		gbc_scrollPaneSteam.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneSteam.fill = GridBagConstraints.BOTH;

		gbc_scrollPaneSteam.gridwidth = 5;
		gbc_scrollPaneSteam.gridx = 0;
		gbc_scrollPaneSteam.gridy = 2;

		pnlSteam.add(scrollPaneSteam, gbc_scrollPaneSteam);

		pnlLoadoutsSteam = new JPanel();
		GridBagConstraints gbc_pnlLoadoutsSteam = new GridBagConstraints();
		gbc_pnlLoadoutsSteam.anchor = GridBagConstraints.WEST;

		gbc_pnlLoadoutsSteam.gridheight = 2;
		gbc_pnlLoadoutsSteam.gridx = 6;
		gbc_pnlLoadoutsSteam.gridy = 1;

		pnlSteam.add(pnlLoadoutsSteam, gbc_pnlLoadoutsSteam);
		
		GridBagLayout gbl_pnlLoadoutsSteam = new GridBagLayout();
		gbl_pnlLoadoutsSteam.columnWidths = new int[] { 409, 0 };
		gbl_pnlLoadoutsSteam.rowHeights = new int[] { 0, 0 };
		gbl_pnlLoadoutsSteam.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlLoadoutsSteam.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlLoadoutsSteam.setLayout(gbl_pnlLoadoutsSteam);

		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		pnlLoadoutsSteam.add(new AboutPanel(), gbc_lblNewLabel_3);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.weighty = 1.0;
		gbc_separator.gridheight = 2;
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 5;
		gbc_separator.gridy = 1;
		pnlSteam.add(separator, gbc_separator);

		pntConfig = new JPanel();
		tabVersionPane.addTab("Settings", new ImageIcon(MainWindow.class.getResource("/pe/rmlabs/amana/sprites/settings-icon16.png")), pntConfig, null);
		GridBagLayout gbl_pntConfig = new GridBagLayout();
		gbl_pntConfig.columnWidths = new int[] { 30, 169, 530, 59, 0 };
		gbl_pntConfig.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pntConfig.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_pntConfig.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pntConfig.setLayout(gbl_pntConfig);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Program Arguments", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		pntConfig.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblArgsPc = new JLabel("Arguments (PC Version)");
		GridBagConstraints gbc_lblArgsPc = new GridBagConstraints();
		gbc_lblArgsPc.anchor = GridBagConstraints.EAST;
		gbc_lblArgsPc.insets = new Insets(0, 0, 5, 5);
		gbc_lblArgsPc.gridx = 0;
		gbc_lblArgsPc.gridy = 0;
		panel_1.add(lblArgsPc, gbc_lblArgsPc);

		txtArgsPc = new JTextField();
		GridBagConstraints gbc_txtArgsPc = new GridBagConstraints();
		gbc_txtArgsPc.insets = new Insets(0, 0, 5, 0);
		gbc_txtArgsPc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArgsPc.gridx = 1;
		gbc_txtArgsPc.gridy = 0;
		panel_1.add(txtArgsPc, gbc_txtArgsPc);
		txtArgsPc.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtArgsPc.setEnabled(false);
		txtArgsPc.setColumns(70);

		lblArgsSteam = new JLabel("Arguments (Steam Version)");
		GridBagConstraints gbc_lblArgsSteam = new GridBagConstraints();
		gbc_lblArgsSteam.anchor = GridBagConstraints.EAST;
		gbc_lblArgsSteam.insets = new Insets(0, 0, 0, 5);
		gbc_lblArgsSteam.gridx = 0;
		gbc_lblArgsSteam.gridy = 1;
		panel_1.add(lblArgsSteam, gbc_lblArgsSteam);

		txtArgsSteam = new JTextField();
		GridBagConstraints gbc_txtArgsSteam = new GridBagConstraints();
		gbc_txtArgsSteam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArgsSteam.gridx = 1;
		gbc_txtArgsSteam.gridy = 1;
		panel_1.add(txtArgsSteam, gbc_txtArgsSteam);
		txtArgsSteam.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtArgsSteam.setEnabled(false);
		txtArgsSteam.setColumns(70);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Config", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		pntConfig.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblAirmechPcPath = new JLabel("AirMech PC Version Path");
		GridBagConstraints gbc_lblAirmechPcPath = new GridBagConstraints();
		gbc_lblAirmechPcPath.anchor = GridBagConstraints.EAST;
		gbc_lblAirmechPcPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirmechPcPath.gridx = 0;
		gbc_lblAirmechPcPath.gridy = 0;
		panel_2.add(lblAirmechPcPath, gbc_lblAirmechPcPath);

		txtAirmechPcPath = new JTextField();
		GridBagConstraints gbc_txtAirmechPcPath = new GridBagConstraints();
		gbc_txtAirmechPcPath.gridwidth = 2;
		gbc_txtAirmechPcPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAirmechPcPath.insets = new Insets(0, 0, 5, 0);
		gbc_txtAirmechPcPath.gridx = 1;
		gbc_txtAirmechPcPath.gridy = 0;
		panel_2.add(txtAirmechPcPath, gbc_txtAirmechPcPath);
		txtAirmechPcPath.setHorizontalAlignment(SwingConstants.LEFT);
		txtAirmechPcPath.setColumns(70);

		lblPcReplaysFolder = new JLabel("Replays Folder (PC Version)");
		GridBagConstraints gbc_lblPcReplaysFolder = new GridBagConstraints();
		gbc_lblPcReplaysFolder.anchor = GridBagConstraints.EAST;
		gbc_lblPcReplaysFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblPcReplaysFolder.gridx = 0;
		gbc_lblPcReplaysFolder.gridy = 1;
		panel_2.add(lblPcReplaysFolder, gbc_lblPcReplaysFolder);

		txtPcReplaysFolder = new JTextField();
		GridBagConstraints gbc_txtPcReplaysFolder = new GridBagConstraints();
		gbc_txtPcReplaysFolder.gridwidth = 2;
		gbc_txtPcReplaysFolder.insets = new Insets(0, 0, 5, 0);
		gbc_txtPcReplaysFolder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPcReplaysFolder.gridx = 1;
		gbc_txtPcReplaysFolder.gridy = 1;
		panel_2.add(txtPcReplaysFolder, gbc_txtPcReplaysFolder);
		txtPcReplaysFolder.setHorizontalAlignment(SwingConstants.LEFT);
		txtPcReplaysFolder.setColumns(70);

		lblAirmechSteamPath = new JLabel("Steam Path");
		GridBagConstraints gbc_lblAirmechSteamPath = new GridBagConstraints();
		gbc_lblAirmechSteamPath.anchor = GridBagConstraints.EAST;
		gbc_lblAirmechSteamPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirmechSteamPath.gridx = 0;
		gbc_lblAirmechSteamPath.gridy = 2;
		panel_2.add(lblAirmechSteamPath, gbc_lblAirmechSteamPath);

		txtAirMechSteamPath = new JTextField();
		GridBagConstraints gbc_txtAirMechSteamPath = new GridBagConstraints();
		gbc_txtAirMechSteamPath.gridwidth = 2;
		gbc_txtAirMechSteamPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAirMechSteamPath.insets = new Insets(0, 0, 5, 0);
		gbc_txtAirMechSteamPath.gridx = 1;
		gbc_txtAirMechSteamPath.gridy = 2;
		panel_2.add(txtAirMechSteamPath, gbc_txtAirMechSteamPath);
		txtAirMechSteamPath.setColumns(70);

		lblSteamReplaysFolder = new JLabel("Replays Folder (Steam Version)");
		GridBagConstraints gbc_lblSteamReplaysFolder = new GridBagConstraints();
		gbc_lblSteamReplaysFolder.anchor = GridBagConstraints.EAST;
		gbc_lblSteamReplaysFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblSteamReplaysFolder.gridx = 0;
		gbc_lblSteamReplaysFolder.gridy = 3;
		panel_2.add(lblSteamReplaysFolder, gbc_lblSteamReplaysFolder);

		txtSteamReplaysFolder = new JTextField();
		GridBagConstraints gbc_txtSteamReplaysFolder = new GridBagConstraints();
		gbc_txtSteamReplaysFolder.gridwidth = 2;
		gbc_txtSteamReplaysFolder.insets = new Insets(0, 0, 5, 0);
		gbc_txtSteamReplaysFolder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSteamReplaysFolder.gridx = 1;
		gbc_txtSteamReplaysFolder.gridy = 3;
		panel_2.add(txtSteamReplaysFolder, gbc_txtSteamReplaysFolder);
		txtSteamReplaysFolder.setColumns(70);

		lblDragdropTarget = new JLabel("Drag&Drop Launch Target");
		GridBagConstraints gbc_lblDragdropTarget = new GridBagConstraints();
		gbc_lblDragdropTarget.anchor = GridBagConstraints.EAST;
		gbc_lblDragdropTarget.insets = new Insets(0, 0, 0, 5);
		gbc_lblDragdropTarget.gridx = 0;
		gbc_lblDragdropTarget.gridy = 4;
		panel_2.add(lblDragdropTarget, gbc_lblDragdropTarget);

		radPcVersion = new JRadioButton("PC Version");
		radPcVersion.setSelected(true);
		radPcVersion.setEnabled(false);
		GridBagConstraints gbc_radPcVersion = new GridBagConstraints();
		gbc_radPcVersion.insets = new Insets(0, 0, 0, 5);
		gbc_radPcVersion.gridx = 1;
		gbc_radPcVersion.gridy = 4;
		panel_2.add(radPcVersion, gbc_radPcVersion);

		rdbtnNewRadioButton = new JRadioButton("Steam Version");
		rdbtnNewRadioButton.setEnabled(false);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 4;
		panel_2.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 9;
		pntConfig.add(separator_1, gbc_separator_1);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 10;
		pntConfig.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AmanaManager.saveConfigValues(txtAirmechPcPath.getText(), txtPcReplaysFolder.getText(), txtAirMechSteamPath.getText(),
						txtSteamReplaysFolder.getText());
				try {
					JOptionPane.showMessageDialog(null, "Config Saved Successfully,\nplease restart Amana to make changes effective.",
							"Amana Settings", JOptionPane.INFORMATION_MESSAGE, SpriteStore.get().getSprite("probe.png"));
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSaveChanges = new GridBagConstraints();
		gbc_btnSaveChanges.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveChanges.gridx = 0;
		gbc_btnSaveChanges.gridy = 0;
		panel.add(btnSaveChanges, gbc_btnSaveChanges);

		btnCancelChanges = new JButton("Cancel Changes");
		btnCancelChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadConfig();
			}
		});
		GridBagConstraints gbc_btnCancelChanges = new GridBagConstraints();
		gbc_btnCancelChanges.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelChanges.gridx = 2;
		gbc_btnCancelChanges.gridy = 0;
		panel.add(btnCancelChanges, gbc_btnCancelChanges);

		btnDefaultConfig = new JButton("Default Config");
		btnDefaultConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultConfig();
				try {
					JOptionPane.showMessageDialog(null, "Default Config established.", "Amana Settings", JOptionPane.INFORMATION_MESSAGE, SpriteStore
							.get().getSprite("probe.png"));
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnDefaultConfig = new GridBagConstraints();
		gbc_btnDefaultConfig.insets = new Insets(0, 0, 0, 5);
		gbc_btnDefaultConfig.gridx = 4;
		gbc_btnDefaultConfig.gridy = 0;
		panel.add(btnDefaultConfig, gbc_btnDefaultConfig);

		btnValidatePaths = new JButton("Validate Paths");
		btnValidatePaths.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JLabel label = new JLabel(ConfigManager.get().toString());
				try {
					JOptionPane.showMessageDialog(null, label, "Amana Settings", JOptionPane.INFORMATION_MESSAGE,
							SpriteStore.get().getSprite("probe.png"));
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnValidatePaths = new GridBagConstraints();
		gbc_btnValidatePaths.gridx = 6;
		gbc_btnValidatePaths.gridy = 0;
		panel.add(btnValidatePaths, gbc_btnValidatePaths);
		
		
		AboutPanel aboutPanel = new AboutPanel();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) aboutPanel.getLayout();
		gridBagLayout_1.columnWeights = new double[]{0.0};
		gridBagLayout_1.columnWidths = new int[]{379};
		tabVersionPane.addTab("About", new ImageIcon(MainWindow.class.getResource("/pe/rmlabs/amana/sprites/about-icon16.png")), aboutPanel, null);
		
		if (AmanaManager.getNumberOfUses() == 0) {
			setDefaultConfig();
			AmanaManager.refreshList(AmanaManager.AIRMECH_PC, lstReplaysPc, false);
			AmanaManager.refreshList(AmanaManager.AIRMECH_STEAM, lstReplaysSteam, false);

			try {
				JOptionPane.showMessageDialog(null, AmanaManager.welcomeMessage(), "Welcome!", JOptionPane.INFORMATION_MESSAGE, SpriteStore.get()
						.getSprite("probe.png"));
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			loadConfig();
		}
		AmanaManager.addOneUse();
		
	}

	private static LayoutManager getAmanaFormLayout() {
		return new FormLayout(new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(169dlu;default):grow"), FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, });
	}

	private static Object[] getObjectListSteam() {
		try {
			System.out.println("getObjectListSteam");
			Object[] list = AmanaManager.listReplayInfoDir(AmanaManager.AIRMECH_STEAM);
			if (list.length == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Object[] getObjectListPc() {
		try {
			Object[] list = AmanaManager.listReplayInfoDir(AmanaManager.AIRMECH_PC);
			if (list.length == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void loadConfig() {
		System.out.println("config start");
		txtAirmechPcPath.setText(AmanaManager.getAirMechPcPath());
		txtArgsPc.setText("not available");
		txtPcReplaysFolder.setText(AmanaManager.getReplaysPcPath());
		txtAirMechSteamPath.setText(AmanaManager.getAirMechSteamPath());
		txtArgsSteam.setText("not available");
		txtSteamReplaysFolder.setText(AmanaManager.getReplaysSteamPath());
		System.out.println("config end");
	}

	public void setDefaultConfig() {
		AmanaManager.setDefaultConfig();
		txtAirmechPcPath.setText(AmanaManager.getAirMechPcPath());
		txtArgsPc.setText("not available");
		txtPcReplaysFolder.setText(AmanaManager.getReplaysPcPath());
		txtAirMechSteamPath.setText(AmanaManager.getAirMechSteamPath());
		txtArgsSteam.setText("not available");
		txtSteamReplaysFolder.setText(AmanaManager.getReplaysSteamPath());
	}

}
