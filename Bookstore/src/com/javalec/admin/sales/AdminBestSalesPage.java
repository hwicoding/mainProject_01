package com.javalec.admin.sales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.javalec.admin.menu.Header;
import com.javalec.admin.menu.MenuMain;
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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AdminBestSalesPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private DefaultTableModel outerTable = new DefaultTableModel();

	
	public AdminBestSalesPage() {
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
		add(getScrollPane());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("인기 책 TOP 5");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 39, 200, 50);
		}
		return lblNewLabel;
	}



	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 116, 740, 480);
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
				
				@Override
				public boolean isCellSelected(int row, int column) {
					return false;
				}
				
				@Override
				public Class<?> getColumnClass(int column) {
					return getValueAt(0, column).getClass();
				}
			};
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			innerTable.setRowHeight(250);
			
			innerTable.setShowGrid(true);
			innerTable.setShowVerticalLines(true);
			innerTable.setGridColor(Color.black);
		}
		return innerTable;
	}


	// ------ function --------

	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("순위");
		outerTable.addColumn("책이미지");
		outerTable.addColumn("책제목");
		outerTable.addColumn("작가명");
		outerTable.addColumn("출판사명");
		outerTable.setColumnCount(5);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(80);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(180);

		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(300);

		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(4);
		col.setPreferredWidth(120);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);

		DefaultTableCellRenderer c = new DefaultTableCellRenderer();
		c.setHorizontalAlignment(JLabel.CENTER);
		innerTable.getColumnModel().getColumn(0).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(2).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(3).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(4).setCellRenderer(c);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchAction() {
		AdminSalesDao dao = new AdminSalesDao();
		ArrayList<AdminSalesDto> dtoList = dao.searchBestBook();
		
		for (int i = 0; i < 5; i++) {
//			String image = dtoList.get(i).getFile().toString();
//			ImageIcon icon = new ImageIcon(image);
			ImageIcon icon = new ImageIcon("./"+dtoList.get(i).getFilename());
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);

			Object[] qTxt = {i+1, changeIcon, dtoList.get(i).getBookname(), dtoList.get(i).getAuthorname(), dtoList.get(i).getPublishername() };

			outerTable.addRow(qTxt);
		}
	}

}
