package com.javalec.cartorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Cartcomplete extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cartcomplete dialog = new Cartcomplete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cartcomplete() {
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("주문완료");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(107, 23, 148, 67);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("주문이 완료되었습니다");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(52, 243, 267, 67);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("고객님 감사합니다");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(78, 184, 211, 67);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("구매내역보기");
			btnNewButton.setBounds(63, 562, 109, 41);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("홈으로");
			btnNewButton.setBounds(210, 562, 109, 41);
			contentPanel.add(btnNewButton);
		}
	}

}
