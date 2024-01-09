package com.javalec.product;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;

public class SearchPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;
	private JTextField tfSearch;
	private JPanel groupSearch;
	private JToolBar toolBar;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPage dialog = new SearchPage();
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
	public SearchPage() {
		setTitle("logo");
		setBounds(0, 0, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());
		getContentPane().add(getGroupSearch());
		getContentPane().add(getToolBar());
		getContentPane().add(getMntmNewMenuItem());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/logo(name_add).png"));
			imgTest = imageSetSize(imgTest, 150, 50);
			lblLogo.setIcon(imgTest);
			lblLogo.setBounds(0, 0, 386, 74);
		}
		return lblLogo;
	}	

	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/back_button.png"));
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
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/home_button.png"));
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
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/mypage_button.png"));
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
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBorder(new LineBorder(new Color(255,255,255), 1, true));
			tfSearch.setBounds(1, 1, 175, 19);
			tfSearch.setText(" ");
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JPanel getGroupSearch() {
		if (groupSearch == null) {
			groupSearch = new JPanel();
			groupSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			groupSearch.setBounds(88, 69, 202, 21);
			groupSearch.setLayout(null);
			groupSearch.add(getTfSearch());
		}
		return groupSearch;
	}
	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setBounds(88, 181, 202, 17);
		}
		return toolBar;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("New menu item");
			mntmNewMenuItem.setBounds(93, 248, 139, 27);
		}
		return mntmNewMenuItem;
	}
}
