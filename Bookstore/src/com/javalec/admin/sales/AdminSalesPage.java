package com.javalec.admin.sales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import com.javalec.admin.publisher.AdminPublishDao;
import com.javalec.admin.publisher.AdminPublishDto;
import com.javalec.admin.stock.AdminStockStatusDao;
import com.javalec.admin.stock.AdminStockStatusDto;
import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AdminSalesPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblNewLabel_1;

	public AdminSalesPage() {
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
		add(getTfSearch());
		add(getBtnSearch());
		add(getScrollPane());
		add(getLblNewLabel_1());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("매출 현황");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 39, 200, 50);
		}
		return lblNewLabel;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(80, 122, 180, 30);
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
			btnSearch.setBounds(270, 116, 40, 40);
		}
		return btnSearch;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 170, 740, 480);
			scrollPane.setViewportView(getInnerTable());

		}
		return scrollPane;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("날짜 : ");
			lblNewLabel_1.setBounds(29, 129, 100, 16);
		}
		return lblNewLabel_1;
	}

	// ------ function --------

	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("날짜");
		outerTable.addColumn("총매출액(원)");
		outerTable.addColumn("총수량(개)");
		outerTable.setColumnCount(3);

		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(80);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.RIGHT);
		innerTable.getColumnModel().getColumn(1).setCellRenderer(r);
		innerTable.getColumnModel().getColumn(2).setCellRenderer(r);

		DefaultTableCellRenderer c = new DefaultTableCellRenderer();
		c.setHorizontalAlignment(JLabel.CENTER);
		innerTable.getColumnModel().getColumn(0).setCellRenderer(c);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchAction() {
		AdminSalesDao dao = new AdminSalesDao();
		ArrayList<AdminSalesDto> dtoList = dao.searchAction();

		for (int i = 0; i < dtoList.size(); i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmPrice = dtoList.get(i).getTotalPrice();
			int tmCount = dtoList.get(i).getTotalCount();
			String tmPressPrice = decFormat.format(tmPrice);
			String tmPressCount = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getDate(), tmPressPrice, tmPressCount };

			outerTable.addRow(qTxt);
		}
	}

	// 날짜 검색
	private void searchBtnClicked() {
		String str = tfSearch.getText();

		AdminSalesDao dao = new AdminSalesDao();
		ArrayList<AdminSalesDto> dtoList = dao.searchDate(str);

		for (int i = 0; i < dtoList.size(); i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmPrice = dtoList.get(i).getTotalPrice();
			int tmCount = dtoList.get(i).getTotalCount();
			String tmPressPrice = decFormat.format(tmPrice);
			String tmPressCount = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getDate(), tmPressPrice, tmPressCount };

			outerTable.addRow(qTxt);
		}

	}
}
