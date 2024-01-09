package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Sample_name extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sample_name dialog = new Sample_name();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sample_name() {
		setTitle("logo");
		setBounds(0, 0, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblBack());
		getContentPane().add(getLblTitle());


	}
	
	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(Sample_name.class.getResource("/com/javalec/image/back_button_01.png"));
			imgTest = imageSetSize(imgTest, 45, 45);
			lblBack.setIcon(imgTest);
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblBack.setBounds(3, 7, 60, 60);
		}
		return lblBack;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목/입력");
			lblTitle.setEnabled(false);
			lblTitle.setFont(new Font("나눔고딕", Font.PLAIN, 26));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//			ImageIcon imgTest = new ImageIcon(Sample_name.class.getResource("/com/javalec/image/logo(name_add).png"));
//			imgTest = imageSetSize(imgTest, 150, 50);
//			lblTitle.setIcon(imgTest);
			lblTitle.setBounds(0, 0, 386, 74);
		}
		return lblTitle;
	}
	

	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
	Image ximg = icon.getImage();
	Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
	ImageIcon xyimg = new ImageIcon(yimg);
	return xyimg;
	
}
}
