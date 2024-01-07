package com.javalec.admin.genre;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class AdminStockStatus extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblLogo;
	private JLabel lblInfo;
	private JLabel lblLogout;
	private JLabel lblTitle;
	private JLabel lbltMenu;
	private JLabel lblSearch;
	private JTextField tfSearch;
	private JComboBox cbSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblBookNum;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfBookNum;
	private JTextField tfBookName;
	private JTextField tfPressPrice;
	private JTextField tfPressCount;
	private JTextField tfStockCount;
	private JTextField tfPressDate;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_1_2_1;
	private JLabel lblNewLabel_1_1_2_1_1;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminStockStatus dialog = new AdminStockStatus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminStockStatus() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setBounds(0, 0, 400, 750);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblLogo());
		contentPanel.add(getLblInfo());
		contentPanel.add(getLblLogout());
		contentPanel.add(getLblTitle());
		contentPanel.add(getLbltMenu());
		contentPanel.add(getLblSearch());
		contentPanel.add(getTfSearch());
		contentPanel.add(getCbSearch());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblBookNum());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_1_2());
		contentPanel.add(getLblNewLabel_1_1_1());
		contentPanel.add(getTfBookNum());
		contentPanel.add(getTfBookName());
		contentPanel.add(getTfPressPrice());
		contentPanel.add(getTfPressCount());
		contentPanel.add(getTfStockCount());
		contentPanel.add(getTfPressDate());
		contentPanel.add(getLblNewLabel_1_1_2());
		contentPanel.add(getLblNewLabel_1_1_2_1());
		contentPanel.add(getLblNewLabel_1_1_2_1_1());
		contentPanel.add(getBtnSearch());
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			ImageIcon icon = new ImageIcon(AdminStockStatus.class.getResource("/com/javalec/image/logo.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblLogo.setIcon(changeIcon);
			lblLogo.setBounds(10, 10, 40, 40);

		}
		return lblLogo;
	}

	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("관리자님 환영합니다.");
			lblInfo.setBounds(57, 15, 107, 28);
		}
		return lblInfo;
	}

	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.setForeground(new Color(255, 31, 0));
			lblLogout.setBackground(new Color(255, 255, 255));
			ImageIcon icon = new ImageIcon(AdminStockStatus.class.getResource("/com/javalec/image/logoutIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblLogout.setIcon(changeIcon);
			lblLogout.setBounds(365, 13, 35, 35);
		}
		return lblLogout;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("입고 및 재고현황");
			lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblTitle.setBounds(10, 75, 131, 28);
		}
		return lblTitle;
	}

	private JLabel getLbltMenu() {
		if (lbltMenu == null) {
			lbltMenu = new JLabel("");
			ImageIcon icon = new ImageIcon(AdminStockStatus.class.getResource("/com/javalec/image/menuIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lbltMenu.setIcon(changeIcon);
			lbltMenu.setBounds(370, 80, 25, 25);
		}
		return lbltMenu;
	}

	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("");
		}
		return lblSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("");
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchBtnClicked();
				}
			});
			ImageIcon icon = new ImageIcon(AdminStockStatus.class.getResource("/com/javalec/image/searchIcon.png"));
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			btnSearch.setIcon(changeIcon);
			btnSearch.setBounds(365, 145, 30, 30);
		}
		return btnSearch;
	}
	
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						tableInit();
						searchBtnClicked();
					}
				}
			});
			tfSearch.setBounds(228, 147, 130, 26);
			LineBorder line = new LineBorder(Color.black, 2, true);
			tfSearch.setBorder(line);
			tfSearch.setVisible(true);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] { "책 제목", "입고일" }));
			cbSearch.setBounds(130, 139, 100, 45);
		}
		return cbSearch;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(18, 195, 360, 200);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cellClicked();
				}
			});
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	private JLabel getLblBookNum() {
		if (lblBookNum == null) {
			lblBookNum = new JLabel("책번호 : ");
			lblBookNum.setBounds(18, 432, 61, 16);
		}
		return lblBookNum;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("책제목 : ");
			lblNewLabel_1.setBounds(18, 479, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("정가 : ");
			lblNewLabel_1_1.setBounds(18, 525, 61, 16);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("입고수량 : ");
			lblNewLabel_2.setBounds(18, 566, 61, 16);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("재고수량 : ");
			lblNewLabel_1_2.setBounds(18, 613, 61, 16);
		}
		return lblNewLabel_1_2;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("입고일 : ");
			lblNewLabel_1_1_1.setBounds(18, 659, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}

	private JTextField getTfBookNum() {
		if (tfBookNum == null) {
			tfBookNum = new JTextField();
			tfBookNum.setEditable(false);
			tfBookNum.setBounds(91, 427, 250, 26);
			tfBookNum.setColumns(10);
		}
		return tfBookNum;
	}

	private JTextField getTfBookName() {
		if (tfBookName == null) {
			tfBookName = new JTextField();
			tfBookName.setEditable(false);
			tfBookName.setColumns(10);
			tfBookName.setBounds(91, 474, 250, 26);
		}
		return tfBookName;
	}

	private JTextField getTfPressPrice() {
		if (tfPressPrice == null) {
			tfPressPrice = new JTextField();
			tfPressPrice.setEditable(false);
			tfPressPrice.setColumns(10);
			tfPressPrice.setBounds(91, 520, 250, 26);
		}
		return tfPressPrice;
	}

	private JTextField getTfPressCount() {
		if (tfPressCount == null) {
			tfPressCount = new JTextField();
			tfPressCount.setEditable(false);
			tfPressCount.setColumns(10);
			tfPressCount.setBounds(91, 561, 250, 26);
		}
		return tfPressCount;
	}

	private JTextField getTfStockCount() {
		if (tfStockCount == null) {
			tfStockCount = new JTextField();
			tfStockCount.setEditable(false);
			tfStockCount.setColumns(10);
			tfStockCount.setBounds(91, 608, 250, 26);
		}
		return tfStockCount;
	}

	private JTextField getTfPressDate() {
		if (tfPressDate == null) {
			tfPressDate = new JTextField();
			tfPressDate.setEditable(false);
			tfPressDate.setColumns(10);
			tfPressDate.setBounds(91, 654, 250, 26);
		}
		return tfPressDate;
	}

	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("원");
			lblNewLabel_1_1_2.setBounds(345, 525, 30, 16);
		}
		return lblNewLabel_1_1_2;
	}

	private JLabel getLblNewLabel_1_1_2_1() {
		if (lblNewLabel_1_1_2_1 == null) {
			lblNewLabel_1_1_2_1 = new JLabel("개");
			lblNewLabel_1_1_2_1.setBounds(345, 566, 30, 16);
		}
		return lblNewLabel_1_1_2_1;
	}

	private JLabel getLblNewLabel_1_1_2_1_1() {
		if (lblNewLabel_1_1_2_1_1 == null) {
			lblNewLabel_1_1_2_1_1 = new JLabel("개");
			lblNewLabel_1_1_2_1_1.setBounds(345, 616, 30, 16);
		}
		return lblNewLabel_1_1_2_1_1;
	}
	
	
	
	// ------------ function -------------
	//테이블 초기화 
	private void tableInit() {
		outerTable.addColumn("NO");
		outerTable.addColumn("책제목");
		outerTable.addColumn("가격(원)");
		outerTable.addColumn("입고수량(개)");
		outerTable.addColumn("재고수량(개)");
		outerTable.addColumn("입고일");
		outerTable.addColumn("");
		outerTable.setColumnCount(7);

		// outerTable 제목 가운데정렬 과연?

		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(30);

		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(200);

		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(70);

		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(4);
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(5);
		col.setPreferredWidth(100);
		
		col = innerTable.getColumnModel().getColumn(6);
		col.setPreferredWidth(0);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	//테이블 조회 메소드 
	private void searchAction() {
		AdminStockStatusDao dao = new AdminStockStatusDao();
		ArrayList<AdminStockStatusDto> dtoList = dao.searchAction();

		int listCnt = dtoList.size();
		// g.genrenum, b.bookname, p.pressprice, p.presscount, p.presscount, p.pressdate
		for (int i = 0; i < listCnt; i++) {

			String tmBookNum = Integer.toString(dtoList.get(i).getBooknum());

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dtoList.get(i).getPressPrice();
			int tmCount = dtoList.get(i).getPressCount();
			String tmPressPrice = decFormat.format(tmp3);
			String tmPressCount = decFormat.format(tmCount);

			// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
			String[] qTxt = { tmBookNum, dtoList.get(i).getBookName(), tmPressPrice, tmPressCount, tmPressCount,
					dtoList.get(i).getPressDate() };

			outerTable.addRow(qTxt);
		}
	}

	//테이블의 셀 클릭했을 때
	private void cellClicked() {
		int i = innerTable.getSelectedRow();
		
		String bookNum = (String)innerTable.getValueAt(i, 0);
		String bookName = (String)innerTable.getValueAt(i, 1);
		String pressPrice = (String)innerTable.getValueAt(i, 2);
		String pressCount = (String)innerTable.getValueAt(i, 3);
		String stockCount = (String)innerTable.getValueAt(i, 4);
		String pressDate = (String)innerTable.getValueAt(i, 5);
		
		tfBookNum.setText(bookNum);
		tfBookName.setText(bookName);
		tfPressPrice.setText(pressPrice);
		tfPressCount.setText(pressCount);
		tfStockCount.setText(stockCount);
		tfPressDate.setText(pressDate);
		
	}
	
	//검색 
	private void searchBtnClicked() {
		AdminStockStatusDao dao = null;
		String inputStr = tfSearch.getText();
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<>(); 
		int index = cbSearch.getSelectedIndex();
		
		switch(index) {
		case 0:
			dao = new AdminStockStatusDao();
			dtoList = dao.searchConditionToBookName(inputStr);
			
			for (int i = 0; i < dtoList.size(); i++) {

				String tmBookNum = Integer.toString(dtoList.get(i).getBooknum());

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getPressCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressCount = decFormat.format(tmCount);

				// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
				String[] qTxt = { tmBookNum, dtoList.get(i).getBookName(), tmPressPrice, tmPressCount, tmPressCount,
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		case 1 :
			dao = new AdminStockStatusDao();
			dtoList = dao.searchConditionToPressDate(inputStr);
			
			for (int i = 0; i < dtoList.size(); i++) {

				String tmBookNum = Integer.toString(dtoList.get(i).getBooknum());

				// 가격 포맷 ###,### 설정
				DecimalFormat decFormat = new DecimalFormat("###,###");
				int tmp3 = dtoList.get(i).getPressPrice();
				int tmCount = dtoList.get(i).getPressCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressCount = decFormat.format(tmCount);

				// tmPressCount 하나는 재고 갯수로 바꿔줘야한다.
				String[] qTxt = { tmBookNum, dtoList.get(i).getBookName(), tmPressPrice, tmPressCount, tmPressCount,
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		}
	}
	
}
