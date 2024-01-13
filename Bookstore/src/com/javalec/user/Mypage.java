package com.javalec.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.product.SearchPage;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mypage extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblMy;
	private JLabel lblHome;
	private JLabel lblBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mypage dialog = new Mypage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mypage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getBtnNewButton_2());
		contentPanel.add(getBtnNewButton_3());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLabel());
		contentPanel.add(getLblMy());
		contentPanel.add(getLblHome());
		contentPanel.add(getLblBack());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("장바구니");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBackground(new Color(30, 144, 255));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
			btnNewButton.setBounds(206,230,160,150);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("구매내역");
			btnNewButton_1.setBackground(new Color(102, 205, 170));
			btnNewButton_1.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBounds(20, 421,160, 150);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("로그아웃");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logout();
				}
			});
			btnNewButton_2.setBackground(new Color(100, 149, 237));
			btnNewButton_2.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setBounds(206,421,160,150);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("<html><center>회원정보<br>관리</center></html>");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edit();
				}
			});
			btnNewButton_3.setBackground(new Color(255, 182, 193));
			btnNewButton_3.setForeground(Color.WHITE);
			btnNewButton_3.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
			btnNewButton_3.setBounds(20,230,160,150);
		}
		return btnNewButton_3;
	}
	private void edit() {
		Edit edit1 = new Edit();
		edit1.setVisible(true);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/image/더조은3.png")));
			lblNewLabel.setBounds(120, 20, 146, 80);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/image/배너.png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 670, 386, 50);
		}
		return label;
	}
	private JLabel getLblMy() {
		if (lblMy == null) {
			lblMy = new JLabel("New label");
			lblMy.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					Mypage mypage = new Mypage();
					mypage.setVisible(true);
				}
			});
			lblMy.setBounds(295, 670, 55, 50);
		}
		return lblMy;
	}
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("New label");
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchpage();
				}
			});
			lblHome.setBounds(157, 672, 55, 50);
		}
		return lblHome;
	}
	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("New label");
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			lblBack.setBounds(30, 670, 50, 50);
		}
		return lblBack;
	}
	
	private void logout() {
		JOptionPane.showMessageDialog(null, "로그아웃 완료");
		Login login = new Login();
		login.setVisible(true);
		dispose();
	}
	private void searchpage() {
		SearchPage searchpage = new SearchPage();
		searchpage.setVisible(true);
		dispose();
	}
}
