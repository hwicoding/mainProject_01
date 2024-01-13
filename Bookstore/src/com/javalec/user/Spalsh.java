package com.javalec.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Spalsh extends JFrame {
	private static final long serialVersionUID=1L;

	private JFrame frame;
	private JProgressBar progressBar;

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
		label.setBounds(93, 200, 200, 191);
		label.setPreferredSize(new Dimension(400,760));
		label.setBackground(Color.white);
		getContentPane().add(label);
		
		JLabel label1 = new JLabel("화면을 터치해주세요");
		label1.setForeground(Color.GRAY);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("HYHeadLine-Medium", Font.PLAIN, 22));
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
		label1.setBounds(0,0,400,1100);
		getContentPane().add(label1);
		label1.setVisible(false);
		
		progressBar =  new JProgressBar(0,100);
		progressBar.setBounds(90, 570, 220, 20);
		progressBar.setFont(new Font("Gulim", Font.PLAIN, 13));
		progressBar.setStringPainted(true);
		progressBar.setVisible(true);
		
		getContentPane().add(progressBar);
		
		Timer timer = new Timer(100, e ->{
			int value = progressBar.getValue()+4;
			progressBar.setValue(value);
			
			if(value ==100) {
				progressBar.setVisible(false);
				label1.setVisible(true);


			}
		});
		
		timer.start();
		
	}
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Spalsh splash = new Spalsh();

			splash.setVisible(true);
		
		});
		
		
	}
	private void click() {
		Login login =  new Login();
		login.setVisible(true);
		dispose();
	}
		
		/*Spalsh splash1 = new Spalsh();
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
