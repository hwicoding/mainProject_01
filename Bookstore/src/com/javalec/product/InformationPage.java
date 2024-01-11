package com.javalec.product;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformationPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;
	private JLabel lblImage;
	private JLabel lblBookname;
	private JLabel lblAuthor;
	private JLabel lblBooktitle;
	private JLabel lbltranslator;
	private JLabel lblPublisher;
	private JLabel lblPrice;
	private JLabel lblGenre;
	private JLabel lblBookcontents;
	private JButton btnCart;
	private JLabel lblBokNum;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationPage dialog = new InformationPage();
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
	public InformationPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setTitle("logo");
		setBounds(0, 0, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());
		getContentPane().add(getLblImage());
		getContentPane().add(getLblBookname());
		getContentPane().add(getLblAuthor());
		getContentPane().add(getLblBooktitle());
		getContentPane().add(getLbltranslator());
		getContentPane().add(getLblPublisher());
		getContentPane().add(getLblPrice());
		getContentPane().add(getLblGenre());
		getContentPane().add(getLblBookcontents());
		getContentPane().add(getBtnCart());
		getContentPane().add(getLblBokNum());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(InformationPage.class.getResource("/com/javalec/image/logo(name_add).png"));
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
			ImageIcon imgTest = new ImageIcon(InformationPage.class.getResource("/com/javalec/image/back_button.png"));
			imgTest = imageSetSize(imgTest, 50, 50);
			lblBack.setIcon(imgTest);
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 if(e.getClickCount()==1) {
						 
//							창 종료
							dispose();
							
//							열기
							SearchPage searchPage = new SearchPage();
							searchPage.setVisible(true);
					 }
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
			ImageIcon imgTest = new ImageIcon(InformationPage.class.getResource("/com/javalec/image/home_button.png"));
			imgTest = imageSetSize(imgTest, 40, 40);
			lblHome.setIcon(imgTest);
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 if(e.getClickCount()==2) {
						 
//							창 종료
							dispose();
							
//							열기
							SearchPage searchPage = new SearchPage();
							searchPage.setVisible(true);
					 }
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
			ImageIcon imgTest = new ImageIcon(InformationPage.class.getResource("/com/javalec/image/mypage_button.png"));
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
	
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(145, 76, 112, 167);
		}
		return lblImage;
	}
	private JLabel getLblBookname() {
		if (lblBookname == null) {
			lblBookname = new JLabel("New label");
			lblBookname.setBounds(49, 253, 194, 31);
		}
		return lblBookname;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("New label");
			lblAuthor.setBounds(49, 330, 194, 25);
		}
		return lblAuthor;
	}
	private JLabel getLblBooktitle() {
		if (lblBooktitle == null) {
			lblBooktitle = new JLabel("New label");
			lblBooktitle.setBounds(49, 294, 194, 26);
		}
		return lblBooktitle;
	}
	private JLabel getLbltranslator() {
		if (lbltranslator == null) {
			lbltranslator = new JLabel("New label");
			lbltranslator.setBounds(49, 365, 194, 25);
		}
		return lbltranslator;
	}
	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("New label");
			lblPublisher.setBounds(49, 401, 194, 25);
		}
		return lblPublisher;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("New label");
			lblPrice.setBounds(49, 436, 194, 25);
		}
		return lblPrice;
	}
	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel("New label");
			lblGenre.setBounds(49, 477, 194, 25);
		}
		return lblGenre;
	}
	private JLabel getLblBookcontents() {
		if (lblBookcontents == null) {
			lblBookcontents = new JLabel("New label");
			lblBookcontents.setBounds(49, 500, 297, 106);
		}
		return lblBookcontents;
	}
	
	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton("New button");
			
			btnCart.setBounds(251, 617, 95, 23);
		}
		return btnCart;
	}
	
	private JLabel getLblBokNum() {
		if (lblBokNum == null) {
			lblBokNum = new JLabel("New label");
			lblBokNum.setBounds(50, 98, 52, 15);
		}
		return lblBokNum;
	}
	
//	--- Function ---
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
	
// SearchPage 정보를 받아서 출력
	public void selectByinfo(List<Object> list) {
		lblImage.setIcon((Icon) list.get(0));
		lblBookname.setText((String) list.get(1));
		lblBooktitle.setText((String) list.get(2));
		lblAuthor.setText((String) list.get(3));
		lbltranslator.setText((String) list.get(4));
		lblPublisher.setText((String) list.get(5));
		lblPrice.setText(Integer.toString((int) list.get(6)));
		lblGenre.setText(String.format("%s > %s > %s", list.get(7), list.get(8), list.get(9)));
		lblBookcontents.setText((String) list.get(10));

		cartinfo(Integer.parseInt(String.valueOf( list.get(11))));
	}
	
	public void cartinfo(int num) {
		
		btnCart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ProductDAO dao = new ProductDAO();
				Integer booknum =num;
				boolean result = dao.insertinfo(booknum);		
				if(result==true) {
					JOptionPane.showMessageDialog(null, "장바구니에 담았습니다.");
					
//					창 종료
					dispose();
					
//					열기
					SearchPage searchPage = new SearchPage();
					searchPage.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 부분이 있습니다.");
				}			
			}
		});
		
	}
	
}