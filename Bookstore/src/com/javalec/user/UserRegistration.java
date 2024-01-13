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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

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
	private JLabel lblNewLabel_8;
	private boolean isFirstInput = true;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton;
	private JLabel lblNewLabel_11_1;
	private JLabel lblNewLabel_13;

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
			tfId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
			tfId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
				
					if(typedChar != '\b') {	
						if (isSpecialCharacter(typedChar)) {
							lblNewLabel_9.setText("");
							lblNewLabel_9.setText("ID에는 특수문자를 사용할 수 없습니다.");
							e.consume(); // 이벤트를 소비하고 무시
						}
						
						// 여기서 특수문자 여부를 확인하고 원하는 동작 수행
						if (isSpecialCharacter(typedChar)) {
							// 특수문자 처리 로직
							System.out.println("Special Character Typed: " + typedChar);
						}
					}
					
					
						
					}
					
					
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						check();
			}
				}
			});
			tfId.setBounds(85, 170, 120, 25);
			contentPanel.add(tfId);
			tfId.setColumns(10);
		}
		{
			pfPw = new JPasswordField();
			pfPw.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				
						
			
					 /*char typedChar = e.getKeyChar();

		                // 첫 번째 문자가 특수 문자인 경우
					 
					 if(typedChar != '\b') {	
		                if (Character.isDigit(typedChar)||isSpecialCharacter(typedChar)) {
		                   JOptionPane.showMessageDialog(null, "처음 문자는 특수문자를 사용할 수 없습니다.");
		                    e.consume(); // 이벤트를 소비하고 무시
		                }

		                // 여기서 특수문자 여부를 확인하고 원하는 동작 수행
		                if (Character.isDigit(typedChar)||isSpecialCharacter(typedChar)) {
		                    // 특수문자 처리 로직
		                    System.out.println("Special Character Typed: " + typedChar);
		                }
		            }*/
				}
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						pwcheck();
					}
		
	                }}
			); 
			pfPw.setEditable(false);
			pfPw.setBounds(85, 250, 170, 25);
			contentPanel.add(pfPw);
		}
		{
			pfPw2 = new JPasswordField();
			pfPw2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					/*char typedChar = e.getKeyChar();
				
					 if(typedChar != '\b') {	
			                if (Character.isDigit(typedChar)||isSpecialCharacter(typedChar)) {
			                   JOptionPane.showMessageDialog(null, "처음 문자는 특수문자를 사용할 수 없습니다.");
			                    e.consume(); // 이벤트를 소비하고 무시
			                }

			                // 여기서 특수문자 여부를 확인하고 원하는 동작 수행
			                if (Character.isDigit(typedChar)||isSpecialCharacter(typedChar)) {
			                    // 특수문자 처리 로직
			                    System.out.println("Special Character Typed: " + typedChar);}}*/
			                    }
			          
			            
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==e.VK_ENTER) {
						pwcheck();
						
					}
				}
					});
			pfPw2.setEditable(false);
			pfPw2.setBounds(85, 305, 170, 25);
			contentPanel.add(pfPw2);
		}
		{
			tfName = new JTextField();
			tfName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String name = tfName.getText();
					if(name.length()!=0) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						tfPhone.requestFocus();
					}
						
					}
				}
			});
			tfName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(85, 400, 110, 25);
			contentPanel.add(tfName);
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
			lblNewLabel.setBounds(162, 520, 20, 25);
			contentPanel.add(lblNewLabel);
		}
		{
			tfEmail2 = new JTextField();
			tfEmail2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
				}
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					/*if(typedChar != '\b') {	
						if (isSpecialCharacter(typedChar)) {
							lblNewLabel_13.setText("");
							lblNewLabel_13.setText("이메일에는 특수문자를 사용할 수 없습니다.");
							e.consume(); // 이벤트를 소비하고 무시
						}
						
						// 여기서 특수문자 여부를 확인하고 원하는 동작 수행
						if (isSpecialCharacter(typedChar)) {
							// 특수문자 처리 로직
							System.out.println("Special Character Typed: " + typedChar);
						}
					}*/
				
				}
			});
			tfEmail2.setEditable(false);
			tfEmail2.setBounds(184, 520, 80, 25);
			contentPanel.add(tfEmail2);
			tfEmail2.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("• ID:");
			lblNewLabel_1.setBounds(15, 170, 50, 25);
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
			lblNewLabel_4.setBounds(15, 400, 50, 25);
			contentPanel.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("• 전화번호:");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_5.setBounds(15, 460, 62, 25);
			contentPanel.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("• 이메일:");
			lblNewLabel_6.setBounds(15, 520, 50, 25);
			contentPanel.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon(UserRegistration.class.getResource("/com/javalec/image/회원가입창.png")));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(0, 0, 386, 97);
			contentPanel.add(lblNewLabel_7);
		}
		{
			tfEmail1 = new JTextField();
			tfEmail1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(typedChar != '\b') {	
						if (isSpecialCharacter(typedChar)) {
							lblNewLabel_13.setText("");
							lblNewLabel_13.setText("이메일 에는 특수문자를 사용할 수 없습니다.");
							e.consume(); // 이벤트를 소비하고 무시
						}
						
						// 여기서 특수문자 여부를 확인하고 원하는 동작 수행
						if (isSpecialCharacter(typedChar)) {
							// 특수문자 처리 로직
							System.out.println("Special Character Typed: " + typedChar);
						}
					}
				
				}
			});
			tfEmail1.setEditable(false);
			tfEmail1.setColumns(10);
			tfEmail1.setBounds(85, 520, 80, 25);
			contentPanel.add(tfEmail1);
		}
		{
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(85, 460, 200, 25);
			contentPanel.add(tfPhone);
		}
		{
			btnconfirm = new JButton("비밀번호 확인");
			btnconfirm.setEnabled(false);
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
			comboBox.setBounds(276, 520, 95, 25);
			contentPanel.add(comboBox);
		}
		{
			lblNewLabel_8 = new JLabel("New label");
			lblNewLabel_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			lblNewLabel_8.setBounds(0, 55, 30, 20);
			contentPanel.add(lblNewLabel_8);
		}
		contentPanel.add(getLblNewLabel_9());
		{
			lblNewLabel_11 = new JLabel("");
			lblNewLabel_11.setForeground(Color.RED);
			lblNewLabel_11.setBounds(85, 493, 200, 20);
			contentPanel.add(lblNewLabel_11);
		}
		{
			lblNewLabel_12 = new JLabel("");
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_12.setForeground(Color.RED);
			lblNewLabel_12.setBounds(15, 339, 300, 40);
			contentPanel.add(lblNewLabel_12);
		}
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getLblNewLabel_11_1());
		{
			lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setForeground(Color.RED);
			lblNewLabel_13.setBounds(85, 555, 280, 20);
			contentPanel.add(lblNewLabel_13);
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
		 String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(id);
	        
		
		UserDAO dao = new UserDAO(id,pass);
		boolean result = dao.check();
		
		/*if(!matcher.matches()) {
			JOptionPane.showMessageDialog(null, "ID 형식이 잘못되었습니다.");
		}*/
		/*if(id.length()==0 || id.length()<6 ) {
			JOptionPane.showMessageDialog(null, "ID값은 7자리 이상이어야 합니다.");
		}*/
		if(id.length()==0) {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("ID는 비워둘 수 없습니다.");
		}
		else if(id.length()<6 || id.length()>10) {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("ID는 6자리에서 10자리로 설정해주세요.");
		}
		
		else if(Character.isLetter(id.charAt(0))==false) {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("ID의 처음 문자는 영어여야 합니다.");
		}
		
		else if(!matcher.matches()) {
			lblNewLabel_9.setText("");
			
			lblNewLabel_9.setText("영문자 최소 1개, 숫자 최소 1개를 포함해야 함");
		}
		else if(id.contains("admin")) {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("사용할 수 없는 아이디입니다.");
		}else {
		if(result==false) {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("중복입니다.");
		}
		else {
			lblNewLabel_9.setText("");
			lblNewLabel_9.setText("사용가능 합니다.");
			
			tfId.setEditable(false);
			pfPw.setEditable(true);
			pfPw2.setEditable(true);
			btnconfirm.setEnabled(true);
			pfPw.requestFocus();
			btnNewButton.setEnabled(false);
		
		}
		}
		
	}
	private void pwcheck() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		final String SAMEPT="(\\w)\\1\\1";
		Pattern ThreeChar=null;
		ThreeChar = Pattern.compile("(\\p{Alnum})\\1{2,}");
		Matcher matcher1;
		matcher1 = ThreeChar.matcher(pass);
		String regex = "(?!.*\\d{3}).*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		matcher = pattern.matcher(pass);
		 String regex1 = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!?@#$%^&*()+|=])[A-Za-z\\d~!?@#$%^&*()+|=]{7,16}$";
	        Pattern pattern1 = Pattern.compile(regex1);
	        Matcher matcher2 = pattern1.matcher(pass);
		
		if(pass.length()==0||pass2.length()==0) {
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("비밀번호는 비워둘 수 없습니다.");
		}else if(pass.length()<7||pass.length()>15) {
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("비밀번호는 7자리이상, 15자리이하로 설정해주십시오.");
		}
		else if(!matcher2.matches()) {
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("특수문자, 대/소문자, 숫자가 1개이상 들어가야합니다.");
		}
		else if(pwContinue()==true) {
			
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("동일한 문자나 숫자는 3글자 이상 연속 사용할 수 없습니다.");
		}
		
		/*else if(id.equals(pass)) {
	    	lblNewLabel_12.setText("");
	    	lblNewLabel_12.setText("비밀번호는 ID와 동일 할 수 없습니다.");
	    }*/
		/*else if(matcher.matches()) {
			lblNewLabel_10.setText("");
			lblNewLabel_10.setText("연속된 숫자가 포함되어있습니다.");
		}*/
		else if(pass.equals(pass2)) {
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("<html><center>비밀번호가 일치합니다.</center></html>");
			tfName.setEditable(true);
			tfPhone.setEditable(true);
			tfEmail1.setEditable(true);
			btnRegi.setEnabled(true);
			pfPw.setEditable(false);
			pfPw2.setEditable(false);
			comboBox.setEnabled(true);
			tfName.requestFocus();
			btnconfirm.setEnabled(false);
			
		}else {
			lblNewLabel_12.setText("");
			lblNewLabel_12.setText("<html><center>비밀번호가 일치하지 않습니다.</center></html>");
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
		String regex = "\\d{2,3}-\\d{4}-\\d{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		
		String regex1 = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{1,30}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher2 = pattern1.matcher(email);
		
		
		if(name.length()!=0&&email1.length()!=0 && matcher.matches()&&Character.isLetter(email.charAt(0))==true&&matcher2.matches()) {
			okAction1();}
			else if(name.length()==0) {
				lblNewLabel_9.setText("");
				lblNewLabel_12.setText("");
				lblNewLabel_11_1.setText("");
				lblNewLabel_11_1.setText("이름을 입력해주세요.");
				tfName.requestFocus();
			}
		else if(!matcher.matches()) {
			lblNewLabel_9.setText("");
			lblNewLabel_12.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_11.setText("전화번호를 정확히 입력해주세요.");
			tfPhone.requestFocus();
		}
		else {
			lblNewLabel_9.setText("");
			lblNewLabel_12.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_13.setText("");
			lblNewLabel_13.setText("이메일을 정확히 입력해주세요");
			tfEmail1.requestFocus();
			
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
		/*try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(pass.getBytes());
			
			StringBuilder hexString = new StringBuilder();
			for(byte hashedByte : hashedBytes) {
				hexString.append(String.format("%02X", hashedByte));
			}
			String pass1 = new String(hexString.toString()); 
			
		}catch(NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}*/
		
		
		UserDAO dao = new UserDAO(id,pass,name,Email,phone,insert);
		boolean result= dao.insertAction();
		
		if(result==true) {
			lblNewLabel_9.setText("");
			lblNewLabel_12.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_13.setText("");
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
  		  lblNewLabel_13.setText("");
  		  	tfEmail2.setText("");
            tfEmail2.setText(selectedValue);
            break;
  	  case 2:
  		  lblNewLabel_13.setText("");
  		  tfEmail2.setText("");
  		  tfEmail2.setText(selectedValue);
  		  break;
  	  case 3:
  		  lblNewLabel_13.setText("");
  		  tfEmail2.setText("");
  		  tfEmail2.setText(selectedValue);
  		  break;
  	  case 4:
  		  lblNewLabel_13.setText("");
  		  tfEmail2.setText("");
  		  tfEmail2.setEditable(true);
  		  tfEmail2.requestFocus();
  		  break;
  		  
	}}
	
	 private boolean isSpecialCharacter(char ch) {
	        // 특수문자 여부를 판단하는 메서드
	        return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
	    }
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setForeground(new Color(255, 0, 0));
			lblNewLabel_9.setBounds(15, 200, 300, 40);
		}
		return lblNewLabel_9;
	}
	
	private boolean pwContinue() {
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		int o = 0;
		  int d = 0;
		  int p = 0;
		  int n = 0;  
		  int limit = 3;
		  
		  for(int i=0; i<pass.length(); i++) {
		   char tempVal = pass.charAt(i);
		   if(i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 :0) > limit -3) {
		    return true;
		   }
		   d = p;
		   o = tempVal;
		  }
		  return false;
		 }
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("중복체크");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnNewButton.setBounds(270, 170, 91, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_11_1() {
		if (lblNewLabel_11_1 == null) {
			lblNewLabel_11_1 = new JLabel("");
			lblNewLabel_11_1.setForeground(Color.RED);
			lblNewLabel_11_1.setBounds(85, 430, 200, 20);
		}
		return lblNewLabel_11_1;
	}
}