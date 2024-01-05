package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sample_name_button extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sample_name_button dialog = new Sample_name_button();
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
	public Sample_name_button() {
		setTitle("logo");
		setBounds(0, 0, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTitle());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());

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

	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(Sample_name_button.class.getResource("/com/javalec/image/back_button.png"));
			imgTest = imageSetSize(imgTest, 50, 50);
			lblBack.setIcon(imgTest);
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			
			lblBack.setBounds(0, 650, 128, 60);
		}
		return lblBack;
	}
	
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("");
			lblHome.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(Sample_name_button.class.getResource("/com/javalec/image/home_button.png"));
			imgTest = imageSetSize(imgTest, 40, 40);
			lblHome.setIcon(imgTest);
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblHome.setBounds(129, 650, 128, 60);
		}
		return lblHome;
	}
	
	private JLabel getLblMypage() {
		if (lblMypage == null) {
			lblMypage = new JLabel("");
			lblMypage.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(Sample_name_button.class.getResource("/com/javalec/image/mypage_button.png"));
			imgTest = imageSetSize(imgTest, 50, 50);
			lblMypage.setIcon(imgTest);
			lblMypage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblMypage.setBounds(258, 650, 128, 60);
		}
		return lblMypage;
	}
	
	
//	--- Function ---
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
}
