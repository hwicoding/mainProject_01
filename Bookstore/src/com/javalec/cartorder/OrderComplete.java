package com.javalec.cartorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.product.SearchPage;
import com.javalec.purchase.Purchase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderComplete extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnPurchase;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderComplete dialog = new OrderComplete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderComplete() {
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getBtnPurchase());
		contentPanel.add(getBtnHome());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("주문완료");
			lblNewLabel.setBounds(159, 39, 50, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("고객님 감사합니다");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(57, 101, 251, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("주문이 완료되었습니다");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(57, 126, 251, 15);
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtnPurchase() {
		if (btnPurchase == null) {
			btnPurchase = new JButton("구매내역보기");
			btnPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPurchase.setBounds(57, 411, 121, 23);
		}
		return btnPurchase;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈으로");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnHome.setBounds(211, 411, 121, 23);
		}
		return btnHome;
	}
	
	// -------- Function
	
	// 구매내역 버튼 눌렀을 때
	private void purchaseinfo(int num) {
		
		btnPurchase.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CartorderDAO dao = new CartorderDAO();
				Integer booknum = num;
				boolean result = dao.insertCartInfo(booknum);
				if(result==true) {
					JOptionPane.showMessageDialog(null, "구매내역 보기로 들어갑니다.");
					
		//창종료 
		 dispose();
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 부분이 있습니다.");
				}			
				}
			
		});
	}
	
	// 홈으로 버튼 눌렀을 때
	
	
	
	
	
}
