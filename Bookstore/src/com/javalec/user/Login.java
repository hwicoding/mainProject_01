package com.javalec.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.product.SearchPage;
import com.javalec.util.ShareVar;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfId;
	private JPasswordField pfPw;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(650, 180, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getTfId());
		contentPanel.add(getPfPw());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/javalec/image/스플래시 (1).png")));
			lblNewLabel.setBounds(100, 113, 200, 191);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/javalec/image/아이디1.png")));
			//ImageIcon img = new ImageIcon(Login.class.getResource("/com/javalec/image/아이디1.png"));
			//img = Imagesetsize(img,50,25);
			lblNewLabel_1.setBounds(90, 350, 50, 25);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/com/javalec/image/비밀번호1.png")));
			lblNewLabel_2.setBounds(90, 403, 50, 25);
		}
		return lblNewLabel_2;
	}
	ImageIcon Imagesetsize(ImageIcon icon,int i,int j) {
		Image x = icon.getImage();
		Image y = x.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon1 = new ImageIcon(y);
		return icon1;
		
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						login();
					}
				}
				@Override
				public void keyTyped(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_TAB) {
						pfPw.requestFocus();
					}
				}
			});
			tfId.setBounds(90, 350, 220, 25);
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
						login();
					}
				}
			});
			pfPw.setBounds(90, 403, 220, 25);
		}
		return pfPw;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("로그인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnNewButton.setBounds(90, 485, 85, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("회원가입");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					regi();
				}
			});
			btnNewButton_1.setBounds(225, 485, 85, 23);
		}
		return btnNewButton_1;
	}
	
	private void login() {
		String id = tfId.getText();
		String pass = new String(pfPw.getPassword());
		
		if(tfId.getText().trim().length()==0) {
			JOptionPane.showMessageDialog(null, "아이디 입력필수");
			tfId.requestFocus();
			return;
		}else if(pass.trim().length()==0) {
			JOptionPane.showMessageDialog(null, "패스워드 입력 필수");
			pfPw.requestFocus();
			
		}else {
			confirm();
		}
		
	}
	private void confirm() {
		String inputID = tfId.getText();
		char[] pw = pfPw.getPassword();
		String inputPW= new String(pw);
		
		LocalDate now = LocalDate.now();
		LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
		
		String login="";
		UserDAO dao = new UserDAO();
		dao.confirm(inputID, inputPW);
		ArrayList<UserDTO> dtolist1=dao.confirm(inputID, inputPW);
		dtolist1.size();
		

		if(inputID.contains("admin")) {
			if(dtolist1.size()!=0) {
				if(inputID.equals(dtolist1.get(0).getUserid()) && inputPW.equals(dtolist1.get(0).getUserpw())) {
					JOptionPane.showMessageDialog(null, seoulNow+" 관리자 로그인 성공" );
					ShareVar.userid=dtolist1.get(0).getUserid();
					ShareVar.password=dtolist1.get(0).getUserpw();
					ShareVar.name = dtolist1.get(0).getUsername();
					ShareVar.phone=dtolist1.get(0).getUserphone();
	
					clearcolumn();
					//Lobby();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");	
					clearcolumn();}
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
				clearcolumn();}
		}else {if(dtolist1.size()!=0) {
				if(inputID.equals(dtolist1.get(0).getUserid()) && inputPW.equals(dtolist1.get(0).getUserpw())) {
					JOptionPane.showMessageDialog(null, seoulNow+" 로그인 성공" );
					ShareVar.userid=dtolist1.get(0).getUserid();
					System.out.println(dtolist1.get(0).getUserid());
					ShareVar.password=dtolist1.get(0).getUserpw();
					ShareVar.name = dtolist1.get(0).getUsername();
					ShareVar.email= dtolist1.get(0).getUseremail();
					ShareVar.phone=dtolist1.get(0).getUserphone();
					clearcolumn();
					searchpage();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");	}
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");	}}}
	
	private void clearcolumn() {
		tfId.setText("");
		pfPw.setText("");
	}


	private void regi() {
		UserRegistration user = new UserRegistration();
		user.setVisible(true);}
	
	private void searchpage() {
		SearchPage searchpage = new SearchPage();
		searchpage.setVisible(true);
		
	}
	
	private void Mypage() {
		Mypage mypage = new Mypage();
		mypage.setVisible(true);
		dispose();
	}
}
