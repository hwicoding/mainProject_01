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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;
	private JTextField tfSearch;
	private JPanel groupSearch;
	private JLabel lblSearchbtn;
	private JScrollPane scrollPane;
	private JTable inner_table;
	private JButton btnNewButton;
	
//	outerTable 생성
	private final DefaultTableModel outerTable = new DefaultTableModel();


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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setTitle("logo");
		setBounds(0, 0, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());
		getContentPane().add(getGroupSearch());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton());

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


	
//	검색
	
	private JPanel getGroupSearch() {
		if (groupSearch == null) {
			groupSearch = new JPanel();
			groupSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			groupSearch.setBounds(22, 71, 337, 32);
			groupSearch.setLayout(null);
			groupSearch.add(getTfSearch());
			groupSearch.add(getLblSearchbtn());
		}
		return groupSearch;
	}
	
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setFont(new Font("나눔고딕", Font.PLAIN, 14));
			tfSearch.setBorder(new LineBorder(new Color(255,255,255), 1, true));
			tfSearch.setBounds(1, 1, 295, 30);
			tfSearch.setText(" ");
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	
	private JLabel getLblSearchbtn() {
		if (lblSearchbtn == null) {
			lblSearchbtn = new JLabel("");
			lblSearchbtn.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/search.png"));
			imgTest = imageSetSize(imgTest, 28, 28);
			lblSearchbtn.setIcon(imgTest);
			lblSearchbtn.setBounds(297, 1, 40, 30);
		}
		return lblSearchbtn;
	}
	
//	 목록창
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 168, 337, 438);
			scrollPane.setViewportView(getInner_table());
		}
		return scrollPane;
	}
	private JTable getInner_table() {
		if (inner_table == null) {
			inner_table = new JTable();
			inner_table.setModel(outerTable);
		}
		return inner_table;
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
	
//	Table 초기화 하기
	private void tableInit() {
		outerTable.addColumn("브랜드");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.addColumn("상품명");
		outerTable.setColumnCount(8);
		
//		Table Column 크기 정하기
		
		int colNo = 0;
		TableColumn col = inner_table.getColumnModel().getColumn(colNo);
		int width = 200;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo =2;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 4;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 5;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 6;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 7;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		
		inner_table.setAutoResizeMode(inner_table.AUTO_RESIZE_OFF);
		
//    Table 내용 지우기
		int i = outerTable.getRowCount();
		for(int j = 0; j<i; j++) {
			outerTable.removeRow(0);
		}
			
	}
	
//	검색	
	private void searchAction() {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> dtoList = dao.selecList();
		
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {

			String[] qTxt = {dtoList.get(i).getBookname(),
									 dtoList.get(i).getGenrekind(),
									 dtoList.get(i).getGenreseckind(),
									 dtoList.get(i).getGenrethirdkind(),
									 dtoList.get(i).getAuthorname(),
									 dtoList.get(i).getTranslatorname(),
									 dtoList.get(i).getPublishername(),
									 Integer.toString(dtoList.get(i).getPressprice())};
			outerTable.addRow(qTxt);
		}
	}
	
	
//	버튼 눌렀을 떄 다음 폐이지 이동
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					창 종료
					dispose();
					
//					열기
					InformationPage informationPage = new InformationPage();
					informationPage.setVisible(true);
				}
			});
			btnNewButton.setBounds(258, 627, 95, 23);
		}
		return btnNewButton;
	}
}
