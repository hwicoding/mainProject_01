package com.javalec.cartorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable innertable;
	private JLabel lblPublisher;
	private JLabel lblBookname;
	private JLabel lblAuthor;
	private JLabel lblBooktitle;
	private JLabel lblGenre;
	private JLabel lblCount;
	private JLabel lblTotalprice;
	private JTextField tfPublisher;
	private JTextField tfBookname;
	private JTextField tfBooktitle;
	private JTextField tfAuthor;
	private JTextField tfGenre;
	private JTextField tfCount;
	private JTextField tfTotalprice;
	private JComboBox cbCount;
	private JButton btnCountchange;
	private JButton btnOrder;
	private JButton btnAdd;
	
	private final DefaultTableModel outertable = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			Cart dialog = new Cart();
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
	public Cart() {
		getContentPane().setBackground(new Color(29, 84, 141));
		setBackground(new Color(64, 62, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
				
			}
		});
	
		setTitle("장바구니");
		setBounds(100, 100, 401, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblPublisher());
		contentPanel.add(getLblBookname());
		contentPanel.add(getLblAuthor());
		contentPanel.add(getLblBooktitle());
		contentPanel.add(getLblGenre());
		contentPanel.add(getLblCount());
		contentPanel.add(getLblTotalprice());
		contentPanel.add(getTfPublisher());
		contentPanel.add(getTfBookname());
		contentPanel.add(getTfBooktitle());
		contentPanel.add(getTfAuthor());
		contentPanel.add(getTfGenre());
		contentPanel.add(getTfCount());
		contentPanel.add(getTfTotalprice());
		contentPanel.add(getCbCount());
		contentPanel.add(getBtnCountchange());
		contentPanel.add(getBtnOrder());
		contentPanel.add(getBtnAdd());
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 79, 310, 191);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						if(e.getButton()==1) {
						tableClick();
					}
				}
			});
			innertable.setFillsViewportHeight(true);
			innertable.setBorder(new LineBorder(new Color(0,0,0)));
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outertable);
		}
		return innertable;
	}
	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("출판사 ");
			lblPublisher.setBounds(34, 308, 50, 15);
		}
		return lblPublisher;
	}
	private JLabel getLblBookname() {
		if (lblBookname == null) {
			lblBookname = new JLabel("책 제목");
			lblBookname.setBounds(34, 344, 50, 15);
		}
		return lblBookname;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("작가");
			lblAuthor.setBounds(34, 417, 50, 15);
		}
		return lblAuthor;
	}
	private JLabel getLblBooktitle() {
		if (lblBooktitle == null) {
			lblBooktitle = new JLabel("책 부제");
			lblBooktitle.setBounds(34, 381, 50, 15);
		}
		return lblBooktitle;
	}
	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel("장르");
			lblGenre.setBounds(34, 456, 50, 15);
		}
		return lblGenre;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("수량");
			lblCount.setBounds(34, 497, 50, 15);
		}
		return lblCount;
	}
	private JLabel getLblTotalprice() {
		if (lblTotalprice == null) {
			lblTotalprice = new JLabel("총 가격");
			lblTotalprice.setBounds(34, 537, 50, 15);
		}
		return lblTotalprice;
	}
	private JTextField getTfPublisher() {
		if (tfPublisher == null) {
			tfPublisher = new JTextField();
			tfPublisher.setBounds(114, 305, 119, 21);
			tfPublisher.setColumns(10);
		}
		return tfPublisher;
	}
	private JTextField getTfBookname() {
		if (tfBookname == null) {
			tfBookname = new JTextField();
			tfBookname.setColumns(10);
			tfBookname.setBounds(114, 341, 191, 21);
		}
		return tfBookname;
	}
	private JTextField getTfBooktitle() {
		if (tfBooktitle == null) {
			tfBooktitle = new JTextField();
			tfBooktitle.setColumns(10);
			tfBooktitle.setBounds(114, 378, 191, 21);
		}
		return tfBooktitle;
	}
	private JTextField getTfAuthor() {
		if (tfAuthor == null) {
			tfAuthor = new JTextField();
			tfAuthor.setColumns(10);
			tfAuthor.setBounds(114, 417, 119, 21);
		}
		return tfAuthor;
	}
	private JTextField getTfGenre() {
		if (tfGenre == null) {
			tfGenre = new JTextField();
			tfGenre.setColumns(10);
			tfGenre.setBounds(114, 453, 139, 21);
		}
		return tfGenre;
	}
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setColumns(10);
			tfCount.setBounds(114, 494, 55, 21);
		}
		return tfCount;
	}
	private JTextField getTfTotalprice() {
		if (tfTotalprice == null) {
			tfTotalprice = new JTextField();
			tfTotalprice.setColumns(10);
			tfTotalprice.setBounds(114, 534, 119, 21);
		}
		return tfTotalprice;
	}
	private JComboBox getCbCount() {
		if (cbCount == null) {
			cbCount = new JComboBox();
			cbCount.setBounds(181, 493, 52, 23);
		}
		return cbCount;
	}
	private JButton getBtnCountchange() {
		if (btnCountchange == null) {
			btnCountchange = new JButton("수량 변경");
			btnCountchange.setBounds(253, 493, 91, 23);
		}
		return btnCountchange;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("주문하기");
			btnOrder.setBounds(253, 603, 91, 23);
		}
		return btnOrder;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("추가하기");
			btnAdd.setBounds(135, 603, 91, 23);
		}
		return btnAdd;
	}
	
	//---	Function  ---
	
	
	//	Table 초기화 하기
		private void tableInit() {
			outertable.addColumn("책 제목");
			outertable.addColumn("가격");
	
	
	//	Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = innertable.getColumnModel().getColumn(colNo);
		int width = 155;
		col.setPreferredWidth(width);
	
		colNo = 1;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 155;
		col.setPreferredWidth(width);
	
		innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF);
	
	
		// table 내용 지우기 
		int i = outertable.getRowCount();
		for(int j=0; j<i; j++) {
			outertable.removeRow(0);
		}
	}
	// 테이블에 조회되도록
		public ArrayList<CartorderDTO> searchAction() {
			CartorderDAO dao = new CartorderDAO();
			
			// bookname, totalprice를 가져
			ArrayList<CartorderDTO> dtolist = dao.selecList();
			for(int i = 0; i < dtolist.size(); i++) {
				
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtolist.get(i).getTotalprice();
				String wkTotalprice = decFormat.format(tmp3);
				String[] qTxt = { dtolist.get(i).getBookname(), wkTotalprice };
				outertable.addRow(qTxt);
			}		
			return dtolist;
		}
		
   
		// 테이플 클릭했을 때
		private void tableClick() {
			int i = innertable.getSelectedRow();
		
			return i;
		}
		}
	
	
	// 창종료 

	
	// 열기
	

