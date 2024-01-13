package com.javalec.admin.stock;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminStockReqPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblNewLabel_1;
	private JTextField tfBookName;
	private JTextField tfPublisherName;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfOrderCount;
	private JButton btnRequest;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_2;

	public AdminStockReqPage() {
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
		add(getLblNewLabel_1());
		add(getTfBookName());
		add(getTfPublisherName());
		add(getLblNewLabel_1_1());
		add(getLblNewLabel_1_1_1());
		add(getTfOrderCount());
		add(getBtnRequest());
		add(getLblNewLabel_1_2());
		add(getLblNewLabel_2());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("입고 요청");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblNewLabel.setBounds(29, 34, 83, 55);
		}
		return lblNewLabel;
	}

	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] { "책제목", "출판사" }));
			cbSearch.setBounds(29, 125, 120, 27);
		}
		return cbSearch;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(155, 122, 180, 30);
			LineBorder line = new LineBorder(Color.black, 2, true);
			tfSearch.setBorder(line);
			tfSearch.setColumns(10);
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
			scrollPane.setBounds(29, 180, 740, 200);
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
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cellClicked();
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("* 판매종료된 책은 입고요청 불가합니다.");
			lblNewLabel_1.setBounds(124, 54, 210, 16);
			lblNewLabel_1.setForeground((new Color(255, 51, 51)));
		}
		return lblNewLabel_1;
	}

	private JTextField getTfBookName() {
		if (tfBookName == null) {
			tfBookName = new JTextField();
			tfBookName.setEditable(false);
			tfBookName.setBackground(new Color(240, 240, 240));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfBookName.setBorder(line);
			tfBookName.setColumns(10);
			tfBookName.setBounds(26, 443, 600, 45);
		}
		return tfBookName;
	}

	private JTextField getTfPublisherName() {
		if (tfPublisherName == null) {
			tfPublisherName = new JTextField();
			tfPublisherName.setEditable(false);
			tfPublisherName.setBackground(new Color(240, 240, 240));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfPublisherName.setBorder(line);
			tfPublisherName.setColumns(10);
			tfPublisherName.setBounds(26, 527, 600, 45);
		}
		return tfPublisherName;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("출판사(입력불가)");
			lblNewLabel_1_1.setBounds(29, 508, 120, 16);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("입고 수량 *");
			lblNewLabel_1_1_1.setBounds(29, 592, 120, 16);
		}
		return lblNewLabel_1_1_1;
	}

	private JTextField getTfOrderCount() {
		if (tfOrderCount == null) {
			tfOrderCount = new JTextField();
			tfOrderCount.setHorizontalAlignment(SwingConstants.TRAILING);
			tfOrderCount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER
							|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

					} else {
						JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
						tfOrderCount.setText("");
						tfOrderCount.requestFocus(true);
					}
				}
			});
			tfOrderCount.setColumns(10);
			tfOrderCount.setBounds(26, 611, 600, 45);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfOrderCount.setBorder(line);
		}
		return tfOrderCount;
	}

	private JButton getBtnRequest() {
		if (btnRequest == null) {
			btnRequest = new JButton("요청");
			btnRequest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requestBtnClicked();
				}
			});
			btnRequest.setBounds(652, 120, 117, 35);
			btnRequest.setBackground(new Color(130, 179, 235));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			btnRequest.setBorder(line);
			btnRequest.setOpaque(true);
			btnRequest.setForeground(new Color(253, 253, 253));
			btnRequest.setBorderPainted(false);

		}
		return btnRequest;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("책제목(입력불가)");
			lblNewLabel_1_2.setBounds(29, 424, 120, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("개");
			lblNewLabel_2.setBounds(638, 625, 61, 16);
		}
		return lblNewLabel_2;
	}

	// ------ function --------

	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("책제목");
		outerTable.addColumn("작가");
		outerTable.addColumn("출판사");
		outerTable.addColumn("가격(원)");
		outerTable.addColumn("입고수량(개)");
		outerTable.addColumn("책현황");
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
		col.setPreferredWidth(80);

		col = innerTable.getColumnModel().getColumn(6);
		col.setPreferredWidth(100);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) innerTable.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		innerTable.getTableHeader().setDefaultRenderer(renderer);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.RIGHT);
		innerTable.getColumnModel().getColumn(3).setCellRenderer(r);
		innerTable.getColumnModel().getColumn(4).setCellRenderer(r);

		DefaultTableCellRenderer c = new DefaultTableCellRenderer();
		c.setHorizontalAlignment(JLabel.CENTER);
		innerTable.getColumnModel().getColumn(1).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(2).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(5).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(6).setCellRenderer(c);
		
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

		for (int i = 0; i < listCnt; i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmp3 = dtoList.get(i).getPressPrice();
			int tmCount = dtoList.get(i).getStockCount();
			String tmPressPrice = decFormat.format(tmp3);
			String tmPressStock = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
					dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus(),
					dtoList.get(i).getPressDate() };

			outerTable.addRow(qTxt);
		}
	}

	// 테이블의 셀 클릭했을 때
	private void cellClicked() {
		int i = innerTable.getSelectedRow();
		
		String bookName = (String) innerTable.getValueAt(i, 0);
		String publisherName = (String) innerTable.getValueAt(i, 2);

		tfBookName.setText(bookName);
		tfPublisherName.setText(publisherName);
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
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus(),
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
				int tmCount = dtoList.get(i).getStockCount();
				String tmPressPrice = decFormat.format(tmp3);
				String tmPressStock = decFormat.format(tmCount);

				String[] qTxt = { dtoList.get(i).getBookName(), dtoList.get(i).getAuthorname(),
						dtoList.get(i).getPublishername(), tmPressPrice, tmPressStock, dtoList.get(i).getBookstatus(),
						dtoList.get(i).getPressDate() };

				outerTable.addRow(qTxt);
			}
			break;
		}
	}

	private void requestBtnClicked() {

		String bookname = tfBookName.getText();
		String publisher = tfPublisherName.getText();
		int i = innerTable.getSelectedRow();

		// 책 제목이나 출판사가 빈칸일 때
		if (tfBookName.getText().length() <= 0 || tfPublisherName.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "위 테이블에서 책제목을 클릭하세요.");
			return;
		}
		
		//책 현황이 판매종료일 때
		if(innerTable.getValueAt(i, 5).equals("판매종료")) {
			JOptionPane.showMessageDialog(this, "<html>판매종료된 책은 입고요청 할 수 없습니다! \n [책 관리] > [책 수정] 에서 책 현황 변경 후에 입고요청하세요.");
			return;
		}

		// 입고수량이 빈칸일 때
		if (tfOrderCount.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "입고수량을 입력하세요.");
			tfOrderCount.requestFocus();

		} else {
			int orderCnt = Integer.parseInt(tfOrderCount.getText());
			int var = JOptionPane.showConfirmDialog(this, "<html>책제목 : " + bookname + "\n 출판사 : " + publisher
					+ "\n 수량 : " + orderCnt + " 개를 \n 입고요청을 하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);

			// 확인버튼 눌렀을 때
			if (var == JOptionPane.YES_OPTION) {
				AdminStockStatusDao dao = new AdminStockStatusDao(bookname, publisher);
				AdminStockStatusDto dto = dao.getBookAndPublisherNum();

				int bookNum = dto.getBooknum();
				int publisherNum = dto.getPublishernum();

				dao = new AdminStockStatusDao(bookNum, publisherNum, orderCnt);
				if (dao.requestOrderInsert() == true) {
					JOptionPane.showMessageDialog(this, "<html>책제목 : " + bookname + "\n 출판사 : " + publisher + "\n 수량 : "
							+ orderCnt + " 개가 \n입고요청 되었습니다.");
					tfBookName.setText("");
					tfPublisherName.setText("");
					tfOrderCount.setText("");
					tfSearch.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "입력한 내용을 확인해주세요.");
				}

				// 취소버튼 눌렀을 때
			} else if (var == JOptionPane.NO_OPTION) {
				tableInit();
				searchAction();
				tfBookName.setText("");
				tfPublisherName.setText("");
				tfOrderCount.setText("");
				tfSearch.setText("");
				System.out.println("아니요 성공");
			}
		}

	}

}
