package com.javalec.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserRegistration extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfId;
	private JPasswordField pfPw;
	private JPasswordField pfPw2;
	private JTextField tfName;
	private JButton btnRegi;
	private JLabel lblNewLabel;
	private JTextField tfEmail2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField tfEmail1;
	private JTextField tfPhone;
	private JButton btnconfirm;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserRegistration dialog = new UserRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserRegistration() {
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			tfId = new JTextField();
			tfId.setBounds(85, 195, 170, 25);
			contentPanel.add(tfId);
			tfId.setColumns(10);
		}
		{
			pfPw = new JPasswordField();
			pfPw.setEditable(false);
			pfPw.setBounds(85, 250, 170, 25);
			contentPanel.add(pfPw);
		}
		{
			pfPw2 = new JPasswordField();
			pfPw2.setEditable(false);
			pfPw2.setBounds(85, 305, 170, 25);
			contentPanel.add(pfPw2);
		}
		{
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(85, 360, 110, 25);
			contentPanel.add(tfName);
		}
		{
			JButton btnNewButton = new JButton("중복확인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnNewButton.setBounds(270, 196, 91, 23);
			contentPanel.add(btnNewButton);
		}
		{
			btnRegi = new JButton("회원가입 완료");
			btnRegi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					okAction();
				}
			});
			btnRegi.setBounds(23, 650, 340, 40);
			contentPanel.add(btnRegi);
		}
		{
			lblNewLabel = new JLabel("@");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(162, 470, 20, 25);
			contentPanel.add(lblNewLabel);
		}
		{
			tfEmail2 = new JTextField();
			tfEmail2.setEditable(false);
			tfEmail2.setBounds(184, 470, 80, 25);
			contentPanel.add(tfEmail2);
			tfEmail2.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("• ID:");
			lblNewLabel_1.setBounds(15, 195, 50, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("• PW:");
			lblNewLabel_2.setBounds(15, 250, 50, 25);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("• PW확인:");
			lblNewLabel_3.setBounds(15, 305, 60, 25);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("• 이름:");
			lblNewLabel_4.setBounds(15, 360, 50, 25);
			contentPanel.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("• 전화번호:");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_5.setBounds(15, 415, 62, 25);
			contentPanel.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("• 이메일:");
			lblNewLabel_6.setBounds(15, 470, 50, 25);
			contentPanel.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("New label");
			lblNewLabel_7.setBounds(0, 0, 386, 110);
			contentPanel.add(lblNewLabel_7);
		}
		{
			tfEmail1 = new JTextField();
			tfEmail1.setEditable(false);
			tfEmail1.setColumns(10);
			tfEmail1.setBounds(85, 470, 80, 25);
			contentPanel.add(tfEmail1);
		}
		{
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(85, 415, 200, 25);
			contentPanel.add(tfPhone);
		}
		{
			btnconfirm = new JButton("비밀번호 확인");
			btnconfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwcheck();
				}
			});
			btnconfirm.setBounds(270, 280, 110, 25);
			contentPanel.add(btnconfirm);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a();
				}
			});
			comboBox.setEnabled(false);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "naver.com", "daum.net", "gmail.com", "직접입력"}));
			comboBox.setBounds(276, 471, 95, 25);
			contentPanel.add(comboBox);
		}
	}
	private void check() {
		
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String phone =tfPhone.getText();
		String email = tfEmail1.getText();
		String email1=tfEmail2.getText();
		
		
		UserDAO dao = new UserDAO(id,pass);
		boolean result = dao.check();
		
		if(id.length()==0) {
			JOptionPane.showMessageDialog(null, "ID값은 비워둘 수 없습니다.");
		}
		else if(id.contains("admin")) {
			JOptionPane.showMessageDialog(null, "사용할 수 없는 아이디입니다.");
		}else {
		if(result==false) {
			JOptionPane.showMessageDialog(null, "중복입니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "사용가능합니다.");
			tfId.setEditable(false);
			pfPw.setEditable(true);
			pfPw2.setEditable(true);
			btnconfirm.setEnabled(true);
		
		}
		}
		
	}
	private void pwcheck() {
		
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		final String SAMEPT="(\\w)\\1\\1";
		Pattern ThreeChar=null;
		ThreeChar = Pattern.compile("(\\p{Alnum})\\1{2,}");
		Matcher matcher1;
		matcher1 = ThreeChar.matcher(pass);
		
		if(pass.length()<4||pass2.length()>8) {
			JOptionPane.showMessageDialog(null, "비밀번호를 4자리 이상 8자리 미만으로 입력하세요");
		}
		else if(matcher1.find()) {
			JOptionPane.showMessageDialog(null, "동일한 문자나 숫자를 3개이상 사용하실 수 없습니다.");
		}
		else if(pass.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다");
			tfName.setEditable(true);
			tfPhone.setEditable(true);
			tfEmail1.setEditable(true);
			btnRegi.setEnabled(true);
			pfPw.setEditable(false);
			pfPw2.setEditable(false);
			comboBox.setEnabled(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
		}
		
	}
	private void okAction() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String phone =tfPhone.getText();
		String email = tfEmail1.getText();
		String email1=tfEmail2.getText();
		
		if(name.length()!=0&&phone.length()!=0&&email.length()!=0&&email1.length()!=0) {
			okAction1();
		}
		else {
			JOptionPane.showMessageDialog(null, "잘못된 부분이 있습니다.");
		}
		
	}
	private void okAction1() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String phone =tfPhone.getText();
		String email = tfEmail1.getText();
		String email1=tfEmail2.getText();
		String Email = email+"@"+email1;
		String insert="";
		
		
		UserDAO dao = new UserDAO(id,pass,name,Email,phone,insert);
		boolean result= dao.insertAction();
		
		if(result==true) {
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "잘못된 부분이 있습니다.");
		}
		
	}
	private void a() {
		String selectedValue = comboBox.getSelectedItem().toString();
		switch(comboBox.getSelectedIndex()) {
  	  case 0:
            tfEmail2.setText("");
            break;
  	  case 1:
  		  tfEmail2.setText("");
            tfEmail2.setText(selectedValue);
            break;
  	  case 2:
  		  tfEmail2.setText("");
  		  tfEmail2.setText(selectedValue);
  		  break;
  	  case 3:
  		  tfEmail2.setText("");
  		  tfEmail2.setText(selectedValue);
  		  break;
  	  case 4:
  		  tfEmail2.setText("");
  		  tfEmail2.setEditable(true);
  		  break;
  		  
	}}
	


}