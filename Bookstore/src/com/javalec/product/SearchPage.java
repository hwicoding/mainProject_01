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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.HTML;

import com.javalec.cartorder.CartPage;
import com.javalec.user.Mypage;
import com.mysql.cj.xdevapi.Table;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class SearchPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JLabel lblBack;
	private JLabel lblHome;
	private JLabel lblMypage;
	private JPanel groupSearch;
	private JLabel lblSearchbtn;
	private JScrollPane scrollPane;
	private JTable inner_table;
	private JLabel lblCart;
	
//	outerTable 생성
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	
//	file 정리
	ArrayList<ProductDTO> dtoList = null;
	private JRadioButton rbname;
	private JRadioButton rbpopular;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblSearchtyping;
	private JTextField tfSearch;




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
				searchNameAction();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				closingAction(); 
			}
		});
		setTitle("logo");
		setBounds(650, 180, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblBack());
		getContentPane().add(getLblHome());
		getContentPane().add(getLblMypage());
		getContentPane().add(getGroupSearch());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblCart());
		getContentPane().add(getRbname());
		getContentPane().add(getRbpopular());

	}

//	Cart button
	private JLabel getLblCart() {
		if (lblCart == null) {
			lblCart = new JLabel("");
			lblCart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 if(e.getClickCount()==1) {
						 
//							창 종료
							dispose();
							
//							열기
							CartPage cartPage = new CartPage();
							cartPage.setVisible(true);
					 }
				}
			});
//			lblCart.setIcon(new ImageIcon(SearchPage.class.getResource("/com/javalec/image/cart_icon.png")));
			lblCart.setHorizontalAlignment(SwingConstants.CENTER);
			lblCart.setBounds(307, 20, 52, 32);
		}
		return lblCart;
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
	
	
//	검색
	private JPanel getGroupSearch() {
		if (groupSearch == null) {
			groupSearch = new JPanel();
			groupSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			groupSearch.setBounds(24, 71, 333, 32);
			groupSearch.setLayout(null);
			groupSearch.add(getLblSearchbtn());
			groupSearch.add(getLblSearchtyping());
			groupSearch.add(getTfSearch());
		}
		return groupSearch;
	}
	
	private JLabel getLblSearchtyping() {
		if (lblSearchtyping == null) {
			lblSearchtyping = new JLabel("");
			lblSearchtyping.setBounds(1, 6, 295, 28);
		}
		return lblSearchtyping;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setForeground(Color.GRAY);
			tfSearch.setFont(new Font("나눔고딕", Font.PLAIN, 14));
			tfSearch.setColumns(10);
			tfSearch.setBorder(new LineBorder(new Color(255,255,255), 1, true));
			tfSearch.setBounds(1, 1, 295, 30);
		}
		return tfSearch;
	}
	
	private JLabel getLblSearchbtn() {
		if (lblSearchbtn == null) {
			lblSearchbtn = new JLabel("");
			lblSearchbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					tableInit();
					if(rbname.isSelected()) {
						tableInit();
						searchNameCondition();
					}
					
					if(rbpopular.isSelected()) {
						tableInit();
						searchPopularCondition();
					}
				}
			});
			lblSearchbtn.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imgTest = new ImageIcon(SearchPage.class.getResource("/com/javalec/image/search.png"));
			imgTest = imageSetSize(imgTest, 28, 28);
			lblSearchbtn.setIcon(imgTest);
			lblSearchbtn.setBackground(new Color(255 ,255, 255));
			lblSearchbtn.setBounds(297, 1, 36, 30);
		}
		return lblSearchbtn;
	}
	
//	Radio button
	private JRadioButton getRbname() {
		if (rbname == null) {
			rbname = new JRadioButton("가나다순");
			rbname.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInit();
					searchNameAction();
				}
			});
			buttonGroup.add(rbname);
			rbname.setSelected(true);
			rbname.setBounds(24, 121, 85, 23);
		}
		return rbname;
	}
	private JRadioButton getRbpopular() {
		if (rbpopular == null) {
			rbpopular = new JRadioButton("인기순");
			rbpopular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInit();
					searchPopularAction();
				}
			});
			buttonGroup.add(rbpopular);
			rbpopular.setBounds(113, 121, 73, 23);
		}
		return rbpopular;
	}
	
	
//	 목록창
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 150, 333, 438);
			scrollPane.setViewportView(getInner_table());
		}
		return scrollPane;
	}
	private JTable getInner_table() {
		if (inner_table == null) {
			inner_table = new JTable() {
				
//				테이블 입력기능 막기
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
				
//				이미지 테이블 인식 기능?
//				public Class getColumnClass(int column) { 				// <--****************
//			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
//			      }
			};		
			
			
			inner_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {		
					if(e.getClickCount()==2) {
						tableClick();
					}
				}
			});
			inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
	
	
	

	
//	--- Function ---
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
	
//	Table 초기화 하기
	private void tableInit() {
		outerTable.addColumn("제목");
		outerTable.addColumn("가격");
		outerTable.addColumn("작가");
		outerTable.addColumn("출판사");
		outerTable.setColumnCount(4);
		
//		Table Column 크기 정하기
		
		int colNo = 0;
		TableColumn col = inner_table.getColumnModel().getColumn(colNo);
		int width = 150;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo =2;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		inner_table.setAutoResizeMode(inner_table.AUTO_RESIZE_OFF);
		
//    Table 내용 지우기
		int i = outerTable.getRowCount();
		for(int j = 0; j<i; j++) {
			outerTable.removeRow(0);
		}
			
	}
	
//	검색	
	private void searchPopularAction() {
		ProductDAO dao = new ProductDAO();
		dtoList = dao.searchPopular();

		int listCount = dtoList.size();

		for(int index = 0; index < listCount; index++) {
			
//			ProductDTO dto = dtoList.get(i);
			
//			ImageIcon icon = new ImageIcon("./" +dtoList.get(index).getBookfilename());
//			icon = imageSetSize(icon, 50, 100);
			
//			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getAuthorname()};
			
			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getBooktitle(), 
					                      dtoList.get(index).getAuthorname(), dtoList.get(index).getPublishername()};
			
			Object[] qTxt1 = {String.format("%s : %s", contents[0], contents[1]), String.format("%,8d", dtoList.get(index).getPressprice())+"원",
					                  String.format("%s", contents[2]), String.format("%s", contents[3])};	
			
			
			outerTable.addRow(qTxt1);
			
		}
	}
	
	private void searchNameAction() {
		ProductDAO dao = new ProductDAO();
		dtoList = dao.searchName();

		int listCount = dtoList.size();

		for(int index = 0; index < listCount; index++) {
			
//			ProductDTO dto = dtoList.get(i);
			
//			ImageIcon icon = new ImageIcon("./" +dtoList.get(index).getBookfilename());
//			icon = imageSetSize(icon, 50, 100);
			
//			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getAuthorname()};
			
			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getBooktitle(), 
					                      dtoList.get(index).getAuthorname(), dtoList.get(index).getPublishername()};
			
			Object[] qTxt1 = {String.format("%s : %s", contents[0], contents[1]), String.format("%,8d", dtoList.get(index).getPressprice())+"원",
					                  String.format("%s", contents[2]), String.format("%s", contents[3])};	
			
			
			outerTable.addRow(qTxt1);
			
		}
	}
	
//	텍스트 입력으로 가나다순 검색 시
	private void searchNameCondition() {
		ProductDAO dao = new ProductDAO();
		String str = tfSearch.getText().trim();
		dtoList = dao.searchNameCondition(str);
		
		int listCount = dtoList.size();

		for(int index = 0; index < listCount; index++) {
					
			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getBooktitle(), 
					                      dtoList.get(index).getAuthorname(), dtoList.get(index).getPublishername()};
			
			Object[] qTxt1 = {String.format("%s : %s", contents[0], contents[1]), String.format("%,8d", dtoList.get(index).getPressprice())+"원",
					                  String.format("%s", contents[2]), String.format("%s", contents[3])};	
			
			outerTable.addRow(qTxt1);
		}
	};
	
//	텍스트 입력으로 인기순 검색 시
	private void searchPopularCondition() {
		ProductDAO dao = new ProductDAO();
		String str = tfSearch.getText().trim();
		dtoList = dao.searchPopularCondition(str);
		
		int listCount = dtoList.size();

		for(int index = 0; index < listCount; index++) {
					
			String[] contents = {dtoList.get(index).getBookname(),dtoList.get(index).getBooktitle(), 
					                      dtoList.get(index).getAuthorname(), dtoList.get(index).getPublishername()};
			
			Object[] qTxt1 = {String.format("%s : %s", contents[0], contents[1]), String.format("%,8d", dtoList.get(index).getPressprice())+"원",
					                  String.format("%s", contents[2]), String.format("%s", contents[3])};	
			
			outerTable.addRow(qTxt1);
		}
	};
	
//	Table 에서 Row 를 click 했을 경우
	public List<Object> tableClick() {
		int i = inner_table.getSelectedRow();	
		List<Object> array = new ArrayList<>();
			
		ImageIcon icon = new ImageIcon("./" +dtoList.get(i).getBookfilename());
		icon = imageSetSize(icon, 100, 200);
		String qTxt1 = dtoList.get(i).getBookname();
		String qTxt2 = dtoList.get(i).getBooktitle();
		String qTxt3 = dtoList.get(i).getAuthorname();
		String qTxt4 = dtoList.get(i).getTranslatorname();
		String qTxt5 = dtoList.get(i).getPublishername();
		int qTxt6 = dtoList.get(i).getPressprice();
		String qTxt7 = dtoList.get(i).getGenrekind();
		String qTxt8 = dtoList.get(i).getGenreseckind();
		String qTxt9 = dtoList.get(i).getGenrethirdkind();
		String qTxt10 = dtoList.get(i).getBookcontents();
		int qTxt11 = dtoList.get(i).getBooknum();
		
		array.add(icon);
		array.add(qTxt1);
		array.add(qTxt2);
		array.add(qTxt3);
		array.add(qTxt4);
		array.add(qTxt5);
		array.add(qTxt6);
		array.add(qTxt7);
		array.add(qTxt8);
		array.add(qTxt9);
		array.add(qTxt10);
		array.add(qTxt11);
		
		dispose();
		
//		InformationPage 로 정보 보내기
		InformationPage InformationPage = new InformationPage();
		InformationPage.setVisible(true);
		InformationPage.selectByinfo(array);
		
		return array;
		
	}
	
//	종료 후 초기화
	private void closingAction() {
		
		for(int index=0; index < dtoList.size(); index++) {
			File file = new File("./" + dtoList.get(index).getBookfilename());
			file.delete();	
		}
	}

}
