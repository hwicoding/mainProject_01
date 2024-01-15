package com.javalec.admin.book;

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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.javalec.admin.menu.Header;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class AdminBookPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();

	public AdminBookPage() {
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
			lblNewLabel = new JLabel("책 현황");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 39, 200, 50);
		}
		return lblNewLabel;
	}

	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] { "책제목", "작가명", "출판사명" }));
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

	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("책제목");
		outerTable.addColumn("부제목");
		outerTable.addColumn("작가명");
		outerTable.addColumn("출판사명");
		outerTable.addColumn("가격(원)");
		outerTable.addColumn("책현황");
		outerTable.setColumnCount(6);

		// outerTable 제목 가운데정렬 과연?
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(150);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(90);

		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(110);

		col = innerTable.getColumnModel().getColumn(4);
		col.setPreferredWidth(80);
		
		col = innerTable.getColumnModel().getColumn(5);
		col.setPreferredWidth(120);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.RIGHT);
		innerTable.getColumnModel().getColumn(4).setCellRenderer(r);

		DefaultTableCellRenderer c = new DefaultTableCellRenderer();
		c.setHorizontalAlignment(JLabel.CENTER);
		innerTable.getColumnModel().getColumn(2).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(3).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(5).setCellRenderer(c);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchAction() {
		AdminBookDao dao = new AdminBookDao();
		ArrayList<AdminBookDto> dtoList = dao.searchAction();

		for (int i = 0; i < dtoList.size(); i++) {

			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dtoList.get(i).getPresspirce();
			String tmPressPrice = decFormat.format(tmp3);

			String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
					dtoList.get(i).getPublishername(), tmPressPrice, dtoList.get(i).getBookstatus() };

			outerTable.addRow(qTxt);
		}
	}

	// 검색 - "책제목", "작가명", "출판사명
	private void searchBtnClicked() {
		AdminBookDao dao = null;
		String inputStr = tfSearch.getText();
		ArrayList<AdminBookDto> dtoList = new ArrayList<>();
		int index = cbSearch.getSelectedIndex();

		switch (index) {
		case 0:	//책제목
			dao = new AdminBookDao();
			dtoList = dao.searchConditionToBookName(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPresspirce();
				String tmPressPrice = decFormat.format(tmp3);

				String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, dtoList.get(i).getBookstatus() };

				outerTable.addRow(qTxt);
			}
			break;

		case 1: // 작가명
			dao = new AdminBookDao();
			dtoList = dao.searchConditionToAuthor(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPresspirce();
				String tmPressPrice = decFormat.format(tmp3);

				String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, dtoList.get(i).getBookstatus() };

				outerTable.addRow(qTxt);
			}
			break;
		case 2:
			// 출판사명
			dao = new AdminBookDao();
			dtoList = dao.searchConditionToPublisher(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPresspirce();
				String tmPressPrice = decFormat.format(tmp3);

				String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, dtoList.get(i).getBookstatus() };

				outerTable.addRow(qTxt);
			}
			break;
		}
	}

}
