package com.javalec.admin.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.book.AdminBookPage;
import com.javalec.admin.book.AdminBookRegisterPage;
import com.javalec.admin.publisher.AdminPublishPage;
import com.javalec.admin.stock.AdminStockPage;
import com.javalec.admin.stock.AdminStockReqPage;
import com.javalec.admin.stock.AdminStockStatusDao;
import com.javalec.admin.stock.AdminStockStatusDto;
import com.javalec.admin.stock.DefaultForm;

import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLayeredPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Menu dropMenu;
	private JLabel lblTitle;
	private JLabel lblLogout;
	private Panel body;
	private JLayeredPane layeredPane;
	private JLabel lblInfo;
	private JLabel lblNewLabel;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMain frame = new MenuMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLayeredPane_1());
		contentPane.add(getDropMenu());
		contentPane.add(getPanel_1_1());
		setUndecorated(true);
		tableInit();
		searchAction();

		dropMenu.setEvent(new MenuEvent() {

			@Override
			public void selected(int index, int subIndex) {

				if (index == 0 && subIndex == 1) {
					showForm(new AdminStockPage());

				} else if (index == 0 && subIndex == 2) {
					showForm(new AdminStockReqPage());

				} else if (index == 1 && subIndex == 0) {
					showForm(new AdminPublishPage());

				} else if (index == 2 && subIndex == 1) {
					showForm(new AdminBookPage());

				} else if (index == 2 && subIndex == 2) {
					showForm(new AdminBookRegisterPage());

				} else {
					showForm(new DefaultForm("Form : " + index + " " + subIndex));
				}
			}

		});

	}

	private void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.repaint();
		body.revalidate();
	}

	private Menu getDropMenu() {
		if (dropMenu == null) {
			dropMenu = new Menu();
			dropMenu.setBounds(0, 64, 200, 690);
		}
		return dropMenu;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("THEJOEUN");
			lblTitle.setBackground(new Color(253, 253, 253));
			lblTitle.setBounds(10, 0, 129, 64);
			lblTitle.setFont(new Font("Marker Felt", Font.BOLD, 18));
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/logo1.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblTitle.setIcon(changeIcon);

		}
		return lblTitle;
	}

	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setPaint(new GradientPaint(0, 0, new Color(14, 76, 49), 0, getHeight(), new Color(21, 110, 71)));
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		g2.dispose();
		super.paintComponents(g);
	}

	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblLogout.setBackground(new Color(253, 253, 253));
			lblLogout.setBounds(950, 0, 48, 64);
			lblLogout.setFont(new Font("Marker Felt", Font.BOLD, 18));
			ImageIcon icon = new ImageIcon(Header.class.getResource("/com/javalec/image/logoutIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblLogout.setIcon(changeIcon);
		}
		return lblLogout;
	}

	private Panel getPanel_1_1() {
		if (body == null) {
			body = new Panel();
			body.setBounds(200, 64, 800, 690);
			body.setBackground(new Color(253, 253, 253));
			body.setLayout(null);
			body.add(getLblNewLabel());
			body.add(getCbSearch());
			body.add(getTfSearch());
			body.add(getBtnSearch());
			body.add(getScrollPane());
		}
		return body;
	}

	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setBounds(0, 0, 1001, 64);
			layeredPane.add(getLblTitle());
			layeredPane.add(getLblLogout());
			layeredPane.setBackground(new Color(253, 253, 253));
			layeredPane.setBorder(BorderFactory.createLineBorder(Color.black));
			layeredPane.add(getLblInfo());
		}
		return layeredPane;
	}

	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("관리자님 환영합니다!");
			lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblInfo.setBounds(850, 25, 200, 16);
		}
		return lblInfo;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("입고 및 재고 현황");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 39, 200, 50);
		}
		return lblNewLabel;
	}

	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] { "책제목", "출판사", "입고일" }));
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
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	// -------function -----
	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("책제목");
		outerTable.addColumn("작가");
		outerTable.addColumn("출판사");
		outerTable.addColumn("가격(원)");
		outerTable.addColumn("입고수량(개)");
		outerTable.addColumn("재고수량(개)");
		outerTable.addColumn("입고일");
		outerTable.setColumnCount(7);

		// outerTable 제목 가운데정렬 과연?

		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(200);

		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(120);

		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(4);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(5);
		col.setPreferredWidth(100);

		col = innerTable.getColumnModel().getColumn(6);
		col.setPreferredWidth(100);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);
		
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		innerTable.getColumnModel().getColumn(3).setCellRenderer(celAlignRight);
		innerTable.getColumnModel().getColumn(4).setCellRenderer(celAlignRight);
		innerTable.getColumnModel().getColumn(5).setCellRenderer(celAlignRight);
		
		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchAction() {
		AdminStockStatusDao dao = new AdminStockStatusDao();
		ArrayList<AdminStockStatusDto> dtoList = dao.searchAction();

		int listCnt = dtoList.size();

		// b.bookname, a.authorname, pub.publishername, p.pressprice, p.presscount,
		// (p.presscount - pur.purchasecount), date(p.pressdate)
		for (int i = 0; i < listCnt; i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dtoList.get(i).getPressPrice();
			int tmCount = dtoList.get(i).getPressCount();
			int tmStock = dtoList.get(i).getStockCount();
			String tmPressPrice = decFormat.format(tmp3);
			String tmPressCount = decFormat.format(tmCount);
			String tmStockCount = decFormat.format(tmStock);

			// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
			String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
					dtoList.get(i).getPublishername(), tmPressPrice, tmPressCount, tmStockCount,
					dtoList.get(i).getPressDate() };

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
			dtoList = dao.searchConditionToBookName(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getPressCount();
				int tmStock = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressCount = decFormat.format(tmCount);
				String tmStockCount = decFormat.format(tmStock);

				// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressCount, tmStockCount,
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		case 1:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchConditionToPublisher(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getPressCount();
				int tmStock = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressCount = decFormat.format(tmCount);
				String tmStockCount = decFormat.format(tmStock);

				// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressCount, tmStockCount,
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;

		case 2:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchConditionToPressDate(inputStr);

			for (int i = 0; i < dtoList.size(); i++) {

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getPressCount();
				int tmStock = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressCount = decFormat.format(tmCount);
				String tmStockCount = decFormat.format(tmStock);

				// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressCount, tmStockCount,
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		}
	}
}
