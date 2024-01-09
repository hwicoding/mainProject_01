package com.javalec.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Spalsh extends JFrame {
	private static final long serialVersionUID=1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public Spalsh() {
		getContentPane().setBackground(Color.white);
		setUndecorated(true);
		setSize(400,760);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon(Spalsh.class.getResource("/com/javalec/image/스플래시3.gif")));
		label.setBounds(0, 0, 400, 760);
		label.setPreferredSize(new Dimension(400,760));
		label.setBackground(Color.white);
		getContentPane().add(label);
		
	}
	
	
	public static void main(String[] args) {
		
		Spalsh splash1 = new Spalsh();
		splash1.setVisible(true);
		try {
			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Login login = new Login();
		login.setVisible(true);
		splash1.dispose();
		
	}
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spalsh window = new Spalsh();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

}
