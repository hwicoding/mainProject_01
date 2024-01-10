package com.javalec.admin.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.admin.publisher.AdminPublishPage;
import com.javalec.admin.stock.AdminStockPage;
import com.javalec.admin.stock.AdminStockReqPage;
import com.javalec.admin.stock.DefaultForm;

import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLayeredPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Menu dropMenu;
	private JLabel lblTitle;
	private JLabel lblLogout;
	private Panel body;
	private JLayeredPane layeredPane;
	private JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMain frame = new MenuMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLayeredPane_1());
		contentPane.add(getDropMenu());
		contentPane.add(getPanel_1_1());
		//setUndecorated(true);

		dropMenu.setEvent(new MenuEvent() {

			@Override
			public void selected(int index, int subIndex) {

				if (index == 0 && subIndex == 1) {
					showForm(new AdminStockPage());
					
				} else if(index == 0 && subIndex == 2) {
					showForm(new AdminStockReqPage());
				
				} else if(index == 1 && subIndex == 0) {
					showForm(new AdminPublishPage());
					
				}else {
					showForm(new DefaultForm("Form : " + index + " " + subIndex));
				}
			}

		});

	}

	private void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.repaint();
		body.revalidate();
	}

	private Menu getDropMenu() {
		if (dropMenu == null) {
			dropMenu = new Menu();
			dropMenu.setBounds(0, 64, 200, 690);
		}
		return dropMenu;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("THEJOEUN");
			lblTitle.setBackground(new Color(253, 253, 253));
			lblTitle.setBounds(10, 0, 129, 64);
			lblTitle.setFont(new Font("Marker Felt", Font.BOLD, 18));
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/logo1.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblTitle.setIcon(changeIcon);

		}
		return lblTitle;
	}

	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setPaint(new GradientPaint(0, 0, new Color(14, 76, 49), 0, getHeight(), new Color(21, 110, 71)));
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		g2.dispose();
		super.paintComponents(g);
	}

	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.setBackground(new Color(253, 253, 253));
			lblLogout.setBounds(950, 0, 48, 64);
			lblLogout.setFont(new Font("Marker Felt", Font.BOLD, 18));
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/logoutIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblLogout.setIcon(changeIcon);
		}
		return lblLogout;
	}

	private Panel getPanel_1_1() {
		if (body == null) {
			body = new Panel(new BorderLayout());
			body.setBounds(200, 64, 800, 690);
			body.setBackground(new Color(253, 253, 253));
		}
		return body;
	}

	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setBounds(0, 0, 1001, 64);
			layeredPane.add(getLblTitle());
			layeredPane.add(getLblLogout());
			layeredPane.setBackground(new Color(253, 253, 253));
			layeredPane.setBorder(BorderFactory.createLineBorder(Color.black));
			layeredPane.add(getLblInfo());
		}
		return layeredPane;
	}
	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("관리자님 환영합니다!");
			lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblInfo.setBounds(850, 25, 200, 16);
		}
		return lblInfo;
	}
}
