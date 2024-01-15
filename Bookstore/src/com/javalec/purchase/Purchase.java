package com.javalec.purchase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.cartorder.CartorderDAO;
import com.javalec.cartorder.CartorderDTO;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Purchase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable innertable;
	
	//outbertable 만들기
	private final DefaultTableModel outertable = new DefaultTableModel();

	//	file 정리
		ArrayList<CartorderDTO> dtoList = null;
		
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
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 67, 309, 189);
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

	//	Table 초기화 하기
		private void tableInit() {
			outertable.addColumn("주문일");
			outertable.addColumn("책 제목");
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
			
			// purchasedate, bookname, purchasecount, totalsum를 가져오기
			ArrayList<PurchaseDTO> dtolist = dao.selecList();
				for(int i = 0; i < dtolist.size(); i++) {
				Date wkPurchasedate = dtolist.get(i).getPurchasedate();
				String wkPurchasecount = Integer.toString(dtolist.get(i).getPurchasecount());
				
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtolist.get(i).getTotalsum();
				String wkTotalsum = decFormat.format(tmp3);
				Object[] qTxt = { wkPurchasedate, dtolist.get(i).getBookname(), wkPurchasecount, wkTotalsum };
				outertable.addRow(qTxt);
			}		
			return dtolist;
		}
			}
			

	
