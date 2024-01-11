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

import com.javalec.cartorder.Cart;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ListSelectionModel;
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
	
//	outerTable 생성
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
//	file 정리
	ArrayList<ProductDTO> dtoList = null;
	private JButton btnNewButton;
	private JLabel lblNewLabel;


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
			@Override
			public void windowClosing(WindowEvent e) {
				closingAction(); 
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
		getContentPane().add(getLblNewLabel());

	}

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
							Cart cart = new Cart();
							cart.setVisible(true);
					 }
				}
			});
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
			inner_table = new JTable() {
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
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
			inner_table.setRowHeight(150);
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
//		outerTable.addColumn("상품명");
//		outerTable.addColumn("상품명");
//		outerTable.addColumn("상품명");
//		outerTable.addColumn("상품명");
//		outerTable.addColumn("상품명");
//		outerTable.addColumn("상품명");
		outerTable.setColumnCount(2);
		
//		Table Column 크기 정하기
		
		int colNo = 0;
		TableColumn col = inner_table.getColumnModel().getColumn(colNo);
		int width = 70;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = inner_table.getColumnModel().getColumn(colNo);
		width = 280;
		col.setPreferredWidth(width);
		
//		colNo =2;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
//		
//		colNo = 3;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
//		
//		colNo = 4;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
//		
//		colNo = 5;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
//		
//		colNo = 6;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
//		
//		colNo = 7;
//		col = inner_table.getColumnModel().getColumn(colNo);
//		width = 200;
//		col.setPreferredWidth(width);
		
		
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
		dtoList = dao.selecList();

		int listCount = dtoList.size();

		for(int index = 0; index < listCount; index++) {
//			ProductDTO dto = dtoList.get(i);
			
			ImageIcon icon = new ImageIcon("./" +dtoList.get(index).getBookfilename());
			icon = imageSetSize(icon, 50, 100);
			Object[] qTxt1 = {icon, dtoList.get(index).getBookname()};
			
//			String productInfo = String.format("%s",
//					dto.getGenrekind()
//					dto.getGenreseckind(),
//					dto.getGenrethirdkind(),
// 				dto.getAuthorname(),
//					dto.getTranslatorname(),
//					dto.getPublishername(),
//					dto.getPressprice()
//					);
//
//			String[] qTxt = {fileImage, productInfo};
			
			outerTable.addRow(qTxt1);
			
		}
	}
	
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

	private void closingAction() {
		
		for(int index=0; index < dtoList.size(); index++) {
			File file = new File("./" + dtoList.get(index).getBookfilename());
			file.delete();
			
		}
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					showVirtualKeyboard();
				}
			});
			btnNewButton.setBounds(33, 133, 95, 23);
		}
		return btnNewButton;
	}
	
//	 private void showVirtualKeyboard() {
//	       String oskPath = "C:\\Windows\\System32\\osk.exe";
//	           try {
//	               // Windows에서는 osk.exe를 실행하여 가상 키보드를 띄웁니다.
//	              ProcessBuilder builder = new ProcessBuilder("runas", "/user:Administrator", oskPath);
//	               Process process = builder.start();
//	               int exitCode = process.waitFor();
//	               
//	               if(exitCode == 0) {
//	                   System.out.println("On-Screen Keyboard 실행 성공");
//	               } else {
//	                   System.err.println("On-Screen Keyboard 실행 중 오류 발생 (Exit Code: " + exitCode + ")");
//	               }
//	            
//	           } catch (IOException | InterruptedException e) {
//	               e.printStackTrace();
//	           }
//	       }
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(307, 20, 52, 32);
		}
		return lblNewLabel;
	}
}
