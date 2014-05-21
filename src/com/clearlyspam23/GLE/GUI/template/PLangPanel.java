package com.clearlyspam23.GLE.GUI.template;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.clearlyspam23.GLE.PLanguageOptions;
import com.clearlyspam23.GLE.GUI.template.dialog.ParameterDialog;
import com.clearlyspam23.GLE.recognizedlanguages.JavaLanguageOptions;

public class PLangPanel extends JPanel {
	private JTextField displayInputField;
	private JTextField exeFileLoc;
	
	private JComboBox<String> comboBox;
	
	private JList<String> list_1;
	
	private PLanguageOptions[] recognizedLanguages;

	/**
	 * Create the panel.
	 */
	public PLangPanel() {
		
		recognizedLanguages = new PLanguageOptions[]{
				new JavaLanguageOptions()
		};
		
		displayInputField = new JTextField();
		displayInputField.setBounds(89, 458, 368, 20);
		displayInputField.setEditable(false);
		displayInputField.setColumns(10);
		
		JLabel label = new JLabel("Run Options");
		label.setBounds(10, 11, 128, 20);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_1 = new JLabel("Language");
		label_1.setBounds(10, 102, 69, 14);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateText();
			}
		});
		DefaultComboBoxModel<String> cm = new DefaultComboBoxModel<String>();
		for(int i = 0; i < recognizedLanguages.length; i++)
			cm.addElement(recognizedLanguages[i].getName());
		comboBox.setBounds(104, 99, 142, 20);
		comboBox.setModel(cm);
		
		JLabel label_2 = new JLabel("Parameters");
		label_2.setBounds(10, 252, 69, 14);
		
		JLabel label_3 = new JLabel("Full Input");
		label_3.setBounds(10, 461, 69, 14);
		
		JLabel lblExecutableLocation = new JLabel("Game Executable");
		lblExecutableLocation.setBounds(10, 62, 83, 14);
		
		exeFileLoc = new JTextField();
		exeFileLoc.setBounds(104, 59, 283, 20);
		exeFileLoc.setColumns(10);
		
		final JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(true);
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setBounds(405, 58, 67, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ret = fc.showOpenDialog(PLangPanel.this);
				if(ret==JFileChooser.APPROVE_OPTION)
				{
					exeFileLoc.setText(fc.getSelectedFile().getPath());
					calculateText();
				}
			}
		});
		
		JList<String> list = new JList<String>();
		list.setBounds(104, 265, 1, 1);
		setLayout(null);
		add(label);
		add(label_3);
		add(displayInputField);
		add(lblExecutableLocation);
		add(label_1);
		add(label_2);
		add(list);
		add(comboBox);
		add(exeFileLoc);
		add(btnNewButton);
		
		list_1 = new JList<String>();
		final DefaultListModel<String> model = new DefaultListModel<String>();
		list_1.setModel(model);
		
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(104, 251, 283, 148);
		add(list_1);
		
		JButton btnAdd = new JButton("Add");
		final ParameterDialog pdialog = new ParameterDialog();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pdialog.setVisible(true);
				System.out.println("here");
			}
		});
		btnAdd.setBounds(219, 410, 79, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()>=0&&list_1.getSelectedIndex()<list_1.getModel().getSize()){
					model.remove(list_1.getSelectedIndex());
				}
					
			}
		});
		btnDelete.setBounds(308, 410, 79, 23);
		add(btnDelete);
		
		calculateText();

	}
	
	private void calculateText()
	{
		String ans = "";
		if(comboBox.getSelectedIndex()>=0&&comboBox.getSelectedIndex()<recognizedLanguages.length)
		{
			PLanguageOptions lang = recognizedLanguages[comboBox.getSelectedIndex()];
			if(lang.getRuntimeCall()!=null&&lang.getRuntimeCall().length()>0)
				ans += recognizedLanguages[comboBox.getSelectedIndex()].getRuntimeCall() + " ";
		}
		if(exeFileLoc.getText()!=null&&exeFileLoc.getText().trim().length()>0)
			ans+=exeFileLoc.getText();
		for(int i = 0; i < list_1.getModel().getSize(); i++)
		{
			ans+=" " + list_1.getModel().getElementAt(i);
		}
		displayInputField.setText(ans);
	}
}