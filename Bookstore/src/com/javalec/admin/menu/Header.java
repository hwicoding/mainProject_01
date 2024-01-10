package com.javalec.admin.menu;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Header extends JPanel implements Icon {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;

	
	/**
	 * Create the panel.
	 */
	public Header() {
		setBackground(new Color(237, 231, 230));
		setLayout(null);
		add(getLblTitle());

	}
	
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("THEJOEUN");
			lblTitle.setFont(new Font("Marker Felt", Font.BOLD, 18));
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/logo1.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblTitle.setIcon(changeIcon);
			lblTitle.setBackground(new Color(253, 253, 253));
			lblTitle.setBounds(0, 0, 129, 64);
		}
		return lblTitle;
	}
	
	
	

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D)g.create();
		g2.setPaint(new GradientPaint(0, 0, new Color(14, 76, 49), 0, getHeight(), new Color(21, 110, 71)));
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		g2.dispose();
		super.paintComponent(g);
	}
}
