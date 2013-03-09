package pe.rmlabs.amana.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class ArgumentsListener implements ActionListener {

	private JCheckBox chkArguments;
	private JTextField txtArguments;	

	public ArgumentsListener(JCheckBox chkArgumentsPc, JTextField txtArgumentsPc) {
		super();
		this.chkArguments = chkArgumentsPc;
		this.txtArguments = txtArgumentsPc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (chkArguments.isSelected()) {
			txtArguments.setEnabled(true);
			txtArguments.requestFocus();
		} else {
			txtArguments.setEnabled(false);
		}
	}
}
