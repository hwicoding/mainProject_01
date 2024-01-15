package com.javalec.admin.stock;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.menu.Header;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class AdminStockStatusPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();

	public AdminStockStatusPage() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
				searchAction();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		setBounds(0, 0, 800, 690);
		setBackground(new Color(253, 253, 253));
		setLayout(null);
		add(getLblNewLabel());
		add(getCbSearch());
		add(getTfSearch());
		add(getBtnSearch());
		add(getScrollPane());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("재고 현황");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 39, 200, 50);
		}
		return lblNewLabel;
	}

	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] { "책제목", "출판사", "입고일", "책현황" }));
			cbSearch.setBounds(29, 125, 120, 27);
		}
		return cbSearch;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(155, 122, 180, 30);
			tfSearch.setColumns(10);
			LineBorder line = new LineBorder(Color.black, 2, true);
			tfSearch.setBorder(line);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInit();
					searchBtnClicked();
				}
			});
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/searchIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			btnSearch.setIcon(changeIcon);
			btnSearch.setBounds(342, 116, 40, 40);
		}
		return btnSearch;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 180, 740, 480);
			scrollPane.setViewportView(getInnerTable());

		}
		return scrollPane;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	// ------ function --------

	// -------function -----
	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("책제목");
		outerTable.addColumn("부제");
		outerTable.addColumn("작가");
		outerTable.addColumn("출판사");
		outerTable.addColumn("가격(원)");
		outerTable.addColumn("재고수량(개)");
		outerTable.addColumn("책현황");
		outerTable.addColumn("입고일");
		outerTable.setColumnCount(8);

		// outerTable 제목 가운데정렬 과연?

		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(200);

		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(120);

		col = innerTable.getColumnModel().getColumn(4);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(5);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(6);
		col.setPreferredWidth(80);
		
		col = innerTable.getColumnModel().getColumn(7);
		col.setPreferredWidth(100);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.RIGHT);
		innerTable.getColumnModel().getColumn(4).setCellRenderer(r);
		innerTable.getColumnModel().getColumn(5).setCellRenderer(r);

		DefaultTableCellRenderer c = new DefaultTableCellRenderer();
		c.setHorizontalAlignment(JLabel.CENTER);
		innerTable.getColumnModel().getColumn(2).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(3).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(6).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(7).setCellRenderer(c);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchAction() {
		AdminStockStatusDao dao = new AdminStockStatusDao();
		ArrayList<AdminStockStatusDto> dtoList = dao.searchStockAction();

		int listCnt = dtoList.size();

		for (int i = 0; i < listCnt; i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dtoList.get(i).getPressPrice();
			int tmCount = dtoList.get(i).getStockCount();
			String tmPressPrice = decFormat.format(tmp3);
			String tmPressStock = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
					dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus() ,dtoList.get(i).getPressDate() };

			outerTable.addRow(qTxt);
		}
	}


	// 검색
	private void searchBtnClicked() {
		AdminStockStatusDao dao = null;
		String inputStr = tfSearch.getText();
		System.out.println("page : " + inputStr);
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<>();
		int index = cbSearch.getSelectedIndex();
		System.out.println("index : " + index);
		switch (index) {
		case 0:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchBookName(inputStr);
			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus() ,dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		case 1:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchPublisher(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus() ,dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;

		case 2:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchPressDate(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus() ,dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
			
		case 3:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchBookStatus(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus() ,dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		}
	}

}
