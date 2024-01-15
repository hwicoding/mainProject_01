package com.javalec.product;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javalec.user.Mypage;

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
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

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
	private JButton btnCart;
	private JLabel lblBokNum;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1;
	private JTextArea taBookcontents;
	private JLabel lblNewLabel_1_1_1_1_1_1_1;

	

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
		setBounds(750, 180, 400, 760);
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
		getContentPane().add(getBtnCart());
		getContentPane().add(getLblBokNum());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_1_1_1_1());
		getContentPane().add(getTaBookcontents());
		getContentPane().add(getLblNewLabel_1_1_1_1_1_1_1());

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
					
					 if(e.getClickCount()==2) {
						 
//							창 종료
							dispose();
							
//							열기
							Mypage mypage = new Mypage();
							mypage.setVisible(true);
					 }				
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
			lblBookname.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblBookname.setBounds(85, 253, 130, 31);
		}
		return lblBookname;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("New label");
			lblAuthor.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblAuthor.setBounds(85, 330, 130, 25);
		}
		return lblAuthor;
	}
	private JLabel getLblBooktitle() {
		if (lblBooktitle == null) {
			lblBooktitle = new JLabel("New label");
			lblBooktitle.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblBooktitle.setBounds(85, 294, 130, 26);
		}
		return lblBooktitle;
	}
	private JLabel getLbltranslator() {
		if (lbltranslator == null) {
			lbltranslator = new JLabel("New label");
			lbltranslator.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lbltranslator.setBounds(85, 365, 130, 25);
		}
		return lbltranslator;
	}
	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("New label");
			lblPublisher.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblPublisher.setBounds(85, 401, 130, 25);
		}
		return lblPublisher;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("New label");
			lblPrice.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblPrice.setBounds(85, 436, 130, 25);
		}
		return lblPrice;
	}
	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel("New label");
			lblGenre.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblGenre.setBounds(85, 477, 180, 25);
		}
		return lblGenre;
	}
	
	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton("장바구니 담기");
			btnCart.setFont(new Font("나눔고딕", Font.BOLD, 12));
			
			btnCart.setBounds(234, 615, 112, 25);
		}
		return btnCart;
	}
	
	private JLabel getLblBokNum() {
		if (lblBokNum == null) {
			lblBokNum = new JLabel("");
			lblBokNum.setBounds(50, 98, 52, 15);
		}
		return lblBokNum;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제목 : ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel.setBounds(25, 261, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("부제 : ");
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(25, 300, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("글쓴이 : ");
			lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1.setBounds(25, 335, 57, 15);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("옮긴이 : ");
			lblNewLabel_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1.setBounds(25, 370, 57, 15);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("출판사 : ");
			lblNewLabel_1_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1.setBounds(25, 406, 57, 15);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("가격 : ");
			lblNewLabel_1_1_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_1.setBounds(25, 441, 57, 15);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1 = new JLabel("분류 : ");
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_1_1.setBounds(25, 482, 57, 15);
		}
		return lblNewLabel_1_1_1_1_1_1;
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
		taBookcontents.setText((String) list.get(10));

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
	private JTextArea getTaBookcontents() {
		if (taBookcontents == null) {
			taBookcontents = new JTextArea();
			taBookcontents.setForeground(new Color(0, 0, 0));
			taBookcontents.setFont(new Font("나눔고딕", Font.BOLD, 12));
			taBookcontents.setEnabled(false);
			taBookcontents.setEditable(false);
			
			taBookcontents.setLineWrap(true);
			taBookcontents.setWrapStyleWord(true);
			
			taBookcontents.setBounds(85, 512, 289, 82);
		}
		return taBookcontents;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1_1 = new JLabel("줄거리 : ");
			lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
			lblNewLabel_1_1_1_1_1_1_1.setBounds(25, 514, 57, 15);
		}
		return lblNewLabel_1_1_1_1_1_1_1;
	}
}
