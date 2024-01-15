package com.javalec.cartorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.product.ProductDAO;
import com.javalec.product.ProductDTO;
import com.javalec.product.SearchPage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Orderpage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable innertable;
	private JLabel lblTotalmoney;
	private JTextField tfTotalmoney;
	private JButton btnProductorder;

	//	outerTable 생성
		private final DefaultTableModel outerTable = new DefaultTableModel();
	
	//	file 정리
		ArrayList<CartorderDTO> dtoList = null;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			Orderpage dialog = new Orderpage();
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
	public Orderpage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}

		});
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblTotalmoney());
		getContentPane().add(getTfTotalmoney());
		getContentPane().add(getBtnProductorder());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(39, 70, 297, 367);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable() {
			public Class getColumnClass(int column) { 				
		        return (column == 0) ? Icon.class : Object.class; 	
		      }
			};
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(e.getClickCount()==2) {
						tableClick();
					}
				}
			});
		innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		innertable.setRowHeight(150);
		innertable.setModel(outerTable);
	}
		return innertable;
 	}

	private JLabel getLblTotalmoney() {
		if (lblTotalmoney == null) {
			lblTotalmoney = new JLabel("총 주문예상금액");
			lblTotalmoney.setBounds(39, 584, 96, 15);
		}
		
		return lblTotalmoney;
	}
	private JTextField getTfTotalmoney() {
		if (tfTotalmoney == null) {
			tfTotalmoney = new JTextField();
			tfTotalmoney.setBounds(39, 622, 96, 21);
			tfTotalmoney.setColumns(10);
		}
		return tfTotalmoney;
	}
	private JButton getBtnProductorder() {
		if (btnProductorder == null) {
			btnProductorder = new JButton("선택상품 주문");
			btnProductorder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnProductorder.setBounds(210, 621, 120, 23);
		}
		return btnProductorder;
	}

	
	//	--- Function ---
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
	// Cartpage 정보를 받아서 출력
	private void selectByinfo(List<Object> list) {
		innertable.setIcon((Icon) list.get(0));
		innertable.setText((String) list.get(1));
	}
	
	
	
	//	Table 초기화 하기
		private void tableInit() {
			outerTable.addColumn("이미지");
			outerTable.addColumn("상품명");
			
	//	Table Column 크기 정하기
			
			int colNo = 0;
			TableColumn col = innertable.getColumnModel().getColumn(colNo);
			int width = 70;
			col.setPreferredWidth(width);
			
			colNo = 1;
			col = innertable.getColumnModel().getColumn(colNo);
			width = 280;
			col.setPreferredWidth(width);
			
			innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF);

	//  Table 내용 지우기
			int i = outerTable.getRowCount();
			for(int j = 0; j<i; j++) {
				outerTable.removeRow(0);
			}
		}
		
	
	//Table 에서 Row 를 click 했을 경우
		public List<Object> tableClick() {
			int i = innertable.getSelectedRow();	
			List<Object> array = new ArrayList<>();
			
			ImageIcon icon = new ImageIcon("./" +dtoList.get(i).getBookfilename());
			icon = imageSetSize(icon, 100, 200);
			}
		
	// 총 구매 금액 조회하기 
		private void showTotalInfo() {
			
			CartorderDAO dao = new CartorderDAO();
			CartorderDTO dto = dao.showTotalInfo();
			
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dto.getTotalMoney();
			String tmPrice = decFormat.format(tmp3);
			
			tfTotalmoney.setText(tmPrice);
	
		}
		
		// 선택상품 주문버튼을 눌렀을 때 
		public void orderinfo(int num) {
			
			btnProductorder.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					CartorderDAO dao = new CartorderDAO();
					Integer booknum =num;
					boolean result = dao.insertCartInfo(booknum);		
					if(result==true) {
						JOptionPane.showMessageDialog(null, " 선택된 상품을 주문했습니다.");
						
//						창 종료
						dispose();
						
//						열기
						CartPage cartPage = new CartPage();
						cartPage.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "잘못된 부분이 있습니다.");
					}			
				}
			});
			
		}
		
			
		
}
