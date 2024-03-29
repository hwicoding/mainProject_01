package com.javalec.purchase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.product.SearchPage;
import com.javalec.user.Mypage;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTable;

public class Purchase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblLogo;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;
	private JScrollPane scrollPane;
	private JTable innertable;
	
	private final DefaultTableModel outertable = new DefaultTableModel();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			Purchase dialog = new Purchase();
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
	public Purchase() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setBounds(650, 180, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
	}
	
//	Logo 새로고침
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.addMouseListener(new MouseAdapter() {
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
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/logo(name_add).png"));
			imgTest = imageSetSize(imgTest, 150, 50);
			lblLogo.setIcon(imgTest);
			lblLogo.setBounds(113, 0, 159, 74);
		}
		return lblLogo;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 67, 322, 482);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.setFillsViewportHeight(true);
			innertable.setBorder(new LineBorder(new Color(0,0,0)));
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outertable);
		}
		return innertable;
	}
	
//	하단바
	
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
//					창 종료
					dispose();
					
//					열기
					SearchPage searchPage = new SearchPage();
					searchPage.setVisible(true);
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
					 if(e.getClickCount()==1) {				 
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
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/mypage_button.png"));
			imgTest = imageSetSize(imgTest, 50, 50);
			lblMypage.setIcon(imgTest);
			lblMypage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {			
					 if(e.getClickCount()==1) {
						 
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
	
	
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
	

	//	Table 초기화 하기
		private void tableInit() {
			outertable.addColumn("주문일");
			outertable.addColumn("책제목");
			outertable.addColumn("주문수량");
			outertable.addColumn("총금액");
			
    //	Table Column 크기 정하기
			int colNo = 0;
			TableColumn col = innertable.getColumnModel().getColumn(colNo);
			int width = 80;
			col.setPreferredWidth(width);
		
			colNo = 1;
			col = innertable.getColumnModel().getColumn(colNo);
			width = 80;
			col.setPreferredWidth(width);
			
			colNo = 2;
			col = innertable.getColumnModel().getColumn(colNo);
			width = 80;
			col.setPreferredWidth(width);
			
			colNo = 3;
			col = innertable.getColumnModel().getColumn(colNo);
			width = 80;
			col.setPreferredWidth(width);
		
			innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF);
			
			// table 내용 지우기 
			int i = outertable.getRowCount();
			for(int j=0; j<i; j++) {
				outertable.removeRow(0);
			}
		}
			// 테이블에 조회되도록
			public ArrayList<PurchaseDTO> searchAction() {
			PurchaseDAO dao = new PurchaseDAO();
			
			// purchasedate, purchasedetails, totalprice를 가져오기
			ArrayList<PurchaseDTO> dtolist = dao.selecList();
				for(int i = 0; i < dtolist.size(); i++) {
				Date wkPurchasedate = dtolist.get(i).getPurchasedate();
				String skPurchasecount = Integer.toString(dtolist.get(i).getPurchasecount());
				
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3  = dtolist.get(i).getTotalsum();
				String wkTotalsum = decFormat.format(tmp3);
				Object[] qTxt = { wkPurchasedate, dtolist.get(i).getBookname(),skPurchasecount, wkTotalsum };
				outertable.addRow(qTxt);
			}		
			return dtolist;
		}
			}
			

	
