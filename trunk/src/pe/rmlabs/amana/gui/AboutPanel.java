package pe.rmlabs.amana.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

import pe.rmlabs.amana.loader.SpriteStore;

import java.awt.Color;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class AboutPanel extends JPanel {

	public AboutPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{379, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 29, 14, 0, 14, 29, 0, 14, 14, 14, 29, 17, 29, 11, 13, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Amana 2.2 *");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel label_6 = new JLabel("by Knomo Seikei** ");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		add(label_6, gbc_label_6);
		
		JLabel label_2 = new JLabel("This tool is maded for the AirMech community, so go enjoy");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_5 = new JLabel("");
		try {
			label_5.setIcon(SpriteStore.get().getSprite("indiebundleairmech2.png"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 4;
		add(label_5, gbc_label_5);
		
		JLabel label_4 = new JLabel("a totally F2P game, by CarbonGames");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.NORTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		add(label_4, gbc_label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("If you feel thankful about this AirMech tool,");
		label_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 7;
		add(label_1, gbc_label_1);
		
		JLabel label_3 = new JLabel("please bring more friends to the game and tell 'em");
		label_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 8;
		add(label_3, gbc_label_3);
		
		JLabel label_7 = new JLabel("to enter \"Knomo\" into Customize>Store>Codes");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.NORTH;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 9;
		add(label_7, gbc_label_7);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_8 = new JLabel("before Level 6 and win 1000 KUDOS FREE! ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.NORTH;
		gbc_label_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 10;
		add(label_8, gbc_label_8);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_9 = new JLabel("Visit my page www.elairmech.com !!!");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_9.anchor = GridBagConstraints.NORTHEAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 12;
		add(label_9, gbc_label_9);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(SystemColor.textHighlight);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_10 = new JLabel("<html>(*) I do not own any of the art used in this software. I'm not an AirMech developer or part of CarbonGames, i'm just an AirMech fan. CarbonGames devs are awesome and you can contact em through the CarbonGames Forum. Go to <a href=\"www.carbongames.com\">www.carbongames.com</a> and <a href=\"www.airmech.com\">www.airmech.com</a> for more info.<html>");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_10.anchor = GridBagConstraints.NORTH;
		gbc_label_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 14;
		add(label_10, gbc_label_10);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel label_11 = new JLabel("<html>(**)Special thanks to (in alphabetical order): All CarbonGames developers (specially Ken for the help!), Broadside, ChroniX, ComponEMT, DeathofaStar, GeneralRay, jhamm, KittenAqua, Kutai, Liquidsnake3(Solid_Snake3133), MrN0b0di, pepote, rigelglen, SP0TFIR3, Tetsuken, Triplicity, Ununoctio, Virtuallazy. <html>");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_11.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 15;
		add(label_11, gbc_label_11);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 10));

	}

}
