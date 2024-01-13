package com.javalec.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Edit extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnPw;
	private JButton btnEdit;
	private JButton btnOut;
	private JLabel lblNewLabel;
	private JTextField tfEmail1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JComboBox cbAdd;
	private JTextField tfId;
	private JPasswordField pfPw;
	private JPasswordField pfPw1;
	private JTextField tfName;
	private JTextField tfPhone;
	private JTextField tfEmail;
	
	private int checkdialog=0;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_11_1;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Edit dialog = new Edit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Edit() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(checkdialog==0) {
					action1();
				}
			}
		});
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnPw());
		contentPanel.add(getBtnEdit());
		contentPanel.add(getBtnOut());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTfEmail1());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getLblNewLabel_1_1_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_2_1());
		contentPanel.add(getLblNewLabel_2_1_1());
		contentPanel.add(getCbAdd());
		contentPanel.add(getTfId());
		contentPanel.add(getPfPw());
		contentPanel.add(getPfPw1());
		contentPanel.add(getTfName());
		contentPanel.add(getTfPhone());
		contentPanel.add(getTfEmail());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblNewLabel_4());
		contentPanel.add(getLblNewLabel_12());
		contentPanel.add(getLblNewLabel_11_1());
		contentPanel.add(getLblNewLabel_11());
		contentPanel.add(getLblNewLabel_13());
	}
	private JButton getBtnPw() {
		if (btnPw == null) {
			btnPw = new JButton("비밀번호확인");
			btnPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwcheck();
				}
			});
			btnPw.setBounds(270, 280, 110, 25);
		}
		return btnPw;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정 완료");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnEdit.setEnabled(false);
			btnEdit.setBounds(23, 650, 140, 40);
		}
		return btnEdit;
	}
	private JButton getBtnOut() {
		if (btnOut == null) {
			btnOut = new JButton("회원 탈퇴");
			btnOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					del();
				}
			});
			btnOut.setEnabled(false);
			btnOut.setBounds(223, 650, 140, 40);
		}
		return btnOut;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("@");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(162, 520, 20, 25);
		}
		return lblNewLabel;
	}
	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField();
			tfEmail1.setEditable(false);
			tfEmail1.setBounds(184, 520, 80, 25);
			tfEmail1.setColumns(10);
		}
		return tfEmail1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("• ID:");
			lblNewLabel_1.setBounds(15, 170, 50, 25);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("• PW:");
			lblNewLabel_1_1.setBounds(15, 250, 50, 25);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("• PW확인:");
			lblNewLabel_1_1_1.setBounds(15, 305, 60, 25);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("• 이름:");
			lblNewLabel_2.setBounds(15, 400, 50, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("• 전화번호:");
			lblNewLabel_2_1.setBounds(15, 460, 62, 25);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("• 이메일:");
			lblNewLabel_2_1_1.setBounds(15, 520, 50, 25);
		}
		return lblNewLabel_2_1_1;
	}
	private JComboBox getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JComboBox();
			cbAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedValue = cbAdd.getSelectedItem().toString();
					  switch(cbAdd.getSelectedIndex()) {
	            	  case 0:
			              tfEmail1.setText("");
			              break;
	            	  case 1:
	            		  lblNewLabel_13.setText("");
	            		  tfEmail1.setText("");
			              tfEmail1.setText(selectedValue);
			              break;
	            	  case 2:
	            		  lblNewLabel_13.setText("");
	            		  tfEmail1.setText("");
	            		  tfEmail1.setText(selectedValue);
	            		  break;
	            	  case 3:
	            		  lblNewLabel_13.setText("");
	            		  tfEmail1.setText("");
	            		  tfEmail1.setText(selectedValue);
	            		  break;
	            	  case 4:
	            		  lblNewLabel_13.setText("");
	            		  tfEmail1.setText("");
	            		  tfEmail1.setEditable(true);
	            		  tfEmail1.requestFocus();
	            		  break;
				
			}}
			});
			cbAdd.setEnabled(false);
			cbAdd.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "naver.com", "daum.net", "google.com", "직접입력"}));
			cbAdd.setBounds(276, 520, 95, 25);
		}
		return cbAdd;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setBounds(85, 170, 120, 25);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						pwcheck();
					}
				}
			});
			pfPw.setBounds(85, 250, 150, 25);
		}
		return pfPw;
	}
	private JPasswordField getPfPw1() {
		if (pfPw1 == null) {
			pfPw1 = new JPasswordField();
			pfPw1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						pwcheck();
					}
				}
			});
			pfPw1.setBounds(85, 305, 150, 25);
		}
		return pfPw1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setBounds(86, 400, 100, 25);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setBounds(85, 460, 200, 25);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setBounds(85, 520, 80, 25);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	
	private void pwcheck() {
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw1.getPassword();
		String pass2 = new String(pw1);
		int i=1;
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
				btnEdit.setEnabled(true);
				pfPw.setEditable(false);
				pfPw1.setEditable(false);
				cbAdd.setEnabled(true);
				tfName.requestFocus();
				btnOut.setEnabled(true);
				
			}else {
				lblNewLabel_12.setText("");
				lblNewLabel_12.setText("<html><center>비밀번호가 일치하지 않습니다.</center></html>");
			}
			
		}
	private void action1() {
		UserDAO dao = new UserDAO();
		UserDTO dto =dao.Action2();
		
		tfId.setText(dto.getUserid());
		tfName.setText(dto.getUsername());
		tfPhone.setText(dto.getUserphone());
		pfPw.setText(dto.getUserpw());
		char[] pw = pfPw1.getPassword();
		String pass = new String(pw);
		String[] ch = dto.getUseremail().split("@");
		System.out.println(ch[0]);
		tfEmail.setText(ch[0]);
		tfEmail1.setText(ch[1]);
		
	}
	private void update() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw1.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String phone =tfPhone.getText();
		String email = tfEmail.getText();
		String email1=tfEmail1.getText();
		String regex = "\\d{2,3}-\\d{4}-\\d{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		
		String regex1 = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{1,30}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher2 = pattern1.matcher(email);
		
		
		if(name.length()!=0&&email1.length()!=0 && matcher.matches()&&Character.isLetter(email.charAt(0))==true&&matcher2.matches()) {
			update2();}
			else if(name.length()==0) {
				lblNewLabel_12.setText("");
				lblNewLabel_11_1.setText("");
				lblNewLabel_11_1.setText("이름을 입력해주세요.");
				tfName.requestFocus();
			}
		else if(!matcher.matches()) {
			lblNewLabel_12.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_11.setText("전화번호를 정확히 입력해주세요.");
			tfPhone.requestFocus();
		}
		else {
			lblNewLabel_12.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_13.setText("");
			lblNewLabel_13.setText("이메일을 정확히 입력해주세요");
			tfEmail1.requestFocus();
			
		}
		
	}
	private void update2() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw1.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String email = tfEmail.getText();
		String email1=tfEmail1.getText();
		String Email = email+"@"+email1;
		String phone =tfPhone.getText();
		String update="";
		
		
		UserDAO dao = new UserDAO(id,pass,name,Email,phone,update);
		boolean result= dao.updateAction();
		
		if(result==true) {
			lblNewLabel_12.setText("");
			lblNewLabel_11.setText("");
			lblNewLabel_11_1.setText("");
			lblNewLabel_13.setText("");
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "잘못된 부분이 없는지 확인하세요.");
			//System.out.println(email);
			//System.out.println(email1);
			//System.out.println(Email);
			//System.out.println(update);
		}
		
	}
	private void del() {
		
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw1.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String email = tfEmail.getText();
		String email1=tfEmail1.getText();
		String Email = email+"@"+email1;
		String phone =tfPhone.getText();
		String delete="";
		int a=0;
		
		
	
		int result1 = JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
		if(result1==JOptionPane.YES_OPTION) {
			UserDAO dao = new UserDAO(id,delete);
			boolean result = dao.delAction();
			if(result==true) {
				JOptionPane.showMessageDialog(null, "탈퇴완료, 앱을 다시 실행시켜 주세요.");
				System.exit(0);
				login();
			}else {
				JOptionPane.showMessageDialog(null, "잘못된 부분이 없는지 확인하십시오");
				checkdialog=1;
			}}else if (result1==JOptionPane.NO_OPTION ) {
				checkdialog=1;
			}else if (result1==JOptionPane.CLOSED_OPTION) {
				checkdialog=1;
				
			}
			
		}
				
		
		
		
		
	
	private void login() {
		Login login = new Login();
		login.setVisible(true);
	}
		
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Edit.class.getResource("/com/javalec/image/회원정보.png")));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(0, 0, 386, 97);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			lblNewLabel_4.setBounds(0, 55, 30, 20);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("");
			lblNewLabel_12.setForeground(Color.RED);
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_12.setBounds(15, 339, 300, 40);
		}
		return lblNewLabel_12;
	}
	
	private boolean pwContinue() {
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw1.getPassword();
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
	private JLabel getLblNewLabel_11_1() {
		if (lblNewLabel_11_1 == null) {
			lblNewLabel_11_1 = new JLabel("");
			lblNewLabel_11_1.setForeground(Color.RED);
			lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_11_1.setBounds(85, 430, 200, 20);
		}
		return lblNewLabel_11_1;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("");
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_11.setForeground(Color.RED);
			lblNewLabel_11.setBounds(85, 493, 200, 20);
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_13.setForeground(Color.RED);
			lblNewLabel_13.setBounds(85, 555, 280, 20);
		}
		return lblNewLabel_13;
	}
}
