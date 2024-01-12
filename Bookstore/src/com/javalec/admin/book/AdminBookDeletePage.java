package com.javalec.admin.book;

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

public class AdminBookDeletePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfBookName;
	private JLabel lblNewLabel_2_1;
	private JTextField tfBookSubTitle;
	private JLabel lblNewLabel_2_1_1;
	private JTextField tfContent;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblImage;
	private JButton btnRegister;
	private JLabel lblNewLabel_2_1_1_2;
	private JTextField tfCount;
	private JLabel lblNewLabel_2_1_1_2_2;
	private JTextField tfPrice;
	private JLabel lblNewLabel_2_1_1_2_3;
	private JLabel lblNewLabel_2_1_1_2_3_1;

	public AdminBookDeletePage() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tableInit();
				searchBook();
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
		add(getLblNewLabel_2());
		add(getTfBookName());
		add(getLblNewLabel_2_1_1());
		add(getTextField_1_1());
		add(getLblNewLabel_2_1_1_1());
		add(getTfContent());
		add(getLblNewLabel_2_1_1_1_1());
		add(getLblImage());
		add(getBtnRegister());
		add(getLblNewLabel_2_1_1_2());
		add(getTfCount());
		add(getLblNewLabel_2_1_1_2_2());
		add(getTfPrice());
		add(getLblNewLabel_2_1_1_2_3());
		add(getLblNewLabel_2_1_1_2_3_1());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("책 삭제");
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
					searchBtnClickedToBook();
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
			scrollPane.setBounds(29, 170, 740, 100);
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
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("책제목 : ");
			lblNewLabel_1.setBounds(29, 129, 100, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("책 제목");
			lblNewLabel_2.setBounds(340, 300, 61, 16);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfBookName() {
		if (tfBookName == null) {
			tfBookName = new JTextField();
			tfBookName.setEditable(false);
			tfBookName.setBounds(340, 320, 400, 40);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfBookName.setBackground(new Color(234, 234, 234));
			tfBookName.setBorder(line);
			tfBookName.setColumns(10);
		}
		return tfBookName;
	}

	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("책 부제");
			lblNewLabel_2_1.setBounds(340, 380, 120, 16);
		}
		return lblNewLabel_2_1;
	}

	private JTextField getTextField_1_1() {
		if (tfBookSubTitle == null) {
			tfBookSubTitle = new JTextField();
			tfBookSubTitle.setEditable(false);
			tfBookSubTitle.setColumns(10);
			tfBookSubTitle.setBackground(new Color(234, 234, 234));
			tfBookSubTitle.setBounds(340, 400, 400, 40);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfBookSubTitle.setBorder(line);
		}
		return tfBookSubTitle;
	}

	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("줄거리 (100자 내)");
			lblNewLabel_2_1_1.setBounds(340, 460, 120, 16);
		}
		return lblNewLabel_2_1_1;
	}

	private JTextField getTfContent() {
		if (tfContent == null) {
			tfContent = new JTextField();
			tfContent.setEditable(false);
			tfContent.setColumns(10);
			tfContent.setBackground(new Color(234, 234, 234));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfContent.setBorder(line);
			tfContent.setBounds(340, 480, 400, 40);
		}
		return tfContent;
	}

	private JLabel getLblNewLabel_2_1_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("책 이미지");
			lblNewLabel_2_1_1_1.setBounds(29, 300, 61, 16);
		}
		return lblNewLabel_2_1_1_1;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(29, 320, 180, 250);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			lblImage.setBorder(line);
		}
		return lblImage;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("삭제");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteBtnClicked();
				}
			});
			btnRegister.setBounds(652, 120, 117, 35);
			btnRegister.setBackground(new Color(255, 153, 153));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			btnRegister.setBorder(line);
			btnRegister.setForeground(new Color(253, 253, 253));
			btnRegister.setOpaque(true);
			btnRegister.setBorderPainted(false);

		}
		return btnRegister;
	}

	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("수량");
			lblNewLabel_2_1_1_2.setBounds(340, 538, 61, 16);
		}
		return lblNewLabel_2_1_1_2;
	}

	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER
							|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {

					} else {
						JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
						tfCount.setText("");
						tfCount.requestFocus(true);
					}
				}
			});
			tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
			tfCount.setColumns(10);
			tfCount.setBackground(new Color(234, 234, 234));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfCount.setBorder(line);
			tfCount.setBounds(340, 558, 180, 40);
		}
		return tfCount;
	}

	private JLabel getLblNewLabel_2_1_1_2_2() {
		if (lblNewLabel_2_1_1_2_2 == null) {
			lblNewLabel_2_1_1_2_2 = new JLabel("가격");
			lblNewLabel_2_1_1_2_2.setBounds(560, 538, 61, 16);
		}
		return lblNewLabel_2_1_1_2_2;
	}

	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setColumns(10);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfPrice.setBorder(line);
			tfPrice.setBackground(new Color(234, 234, 234));
			tfPrice.setBounds(560, 558, 180, 40);
		}
		return tfPrice;
	}

	private JLabel getLblNewLabel_2_1_1_2_3() {
		if (lblNewLabel_2_1_1_2_3 == null) {
			lblNewLabel_2_1_1_2_3 = new JLabel("개");
			lblNewLabel_2_1_1_2_3.setBounds(521, 568, 30, 16);
		}
		return lblNewLabel_2_1_1_2_3;
	}

	private JLabel getLblNewLabel_2_1_1_2_3_1() {
		if (lblNewLabel_2_1_1_2_3_1 == null) {
			lblNewLabel_2_1_1_2_3_1 = new JLabel("원");
			lblNewLabel_2_1_1_2_3_1.setBounds(741, 568, 30, 16);
		}
		return lblNewLabel_2_1_1_2_3_1;
	}

	// ------ function --------

	// 테이블 초기화
	public void tableInit() {
		outerTable.addColumn("책제목");
		outerTable.addColumn("책부제목");
		outerTable.addColumn("출판사명");
		outerTable.addColumn("수량");
		outerTable.addColumn("가격");
		outerTable.addColumn("책현황");
		outerTable.setColumnCount(6);

		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(250);

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
		innerTable.getColumnModel().getColumn(2).setCellRenderer(c);
		innerTable.getColumnModel().getColumn(5).setCellRenderer(c);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// 테이블 조회 메소드
	private void searchBook() {
		AdminBookDao dao = new AdminBookDao();
		ArrayList<AdminBookDto> dtoList = dao.searchBook();

		for (int i = 0; i < dtoList.size(); i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmPrice = dtoList.get(i).getPresspirce();
			int tmCount = dtoList.get(i).getPresscount();
			String tmPressPrice = decFormat.format(tmPrice);
			String tmPressCount = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(),
					dtoList.get(i).getPublishername(), tmPressCount, tmPressPrice, dtoList.get(i).getBookstatus() };

			outerTable.addRow(qTxt);
		}
	}

	// 검색 - 책제목명
	private void searchBtnClickedToBook() {
		AdminBookDao dao = null;
		String inputStr = tfSearch.getText();
		ArrayList<AdminBookDto> dtoList = new ArrayList<>();

		dao = new AdminBookDao();
		dtoList = dao.searchConditionToBook(inputStr);

		for (int i = 0; i < dtoList.size(); i++) {

			// 가격 포맷 ###,### 설정
			DecimalFormat decFormat = new DecimalFormat("###,###");
			int tmPrice = dtoList.get(i).getPresspirce();
			int tmCount = dtoList.get(i).getPresscount();
			String tmPressPrice = decFormat.format(tmPrice);
			String tmPressCount = decFormat.format(tmCount);

			String[] qTxt = { dtoList.get(i).getBookname(), dtoList.get(i).getBooktitle(),
					dtoList.get(i).getPublishername(), tmPressCount, tmPressPrice, dtoList.get(i).getBookstatus() };

			outerTable.addRow(qTxt);
		}
	}

	// 테이블의 셀 클릭했을 때
	private int cellClicked() {
		int i = innerTable.getSelectedRow();

		String bookName = (String) innerTable.getValueAt(i, 0);
		String bookPrice = (String) innerTable.getValueAt(i, 4);
		int price = Integer.parseInt(bookPrice.replaceAll(",", ""));

		AdminBookDao dao = new AdminBookDao(bookName, price);
		int bookNum = dao.bookSeqNum();

		if (bookNum > 0) {
			AdminBookDto dto = dao.tableClick();

			tfBookName.setText(dto.getBookname());
			tfBookSubTitle.setText(dto.getBooktitle());
			tfContent.setText(dto.getBookcontent());
			tfCount.setText(Integer.toString(dto.getPresscount()));
			tfPrice.setText(Integer.toString(dto.getPresspirce()));

			String filePath = Integer.toString(ShareVar.filename);

			ImageIcon icon = new ImageIcon(filePath);
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblImage.setIcon(changeIcon);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);

			File file = new File(filePath);
			file.delete();

		} else {
			JOptionPane.showMessageDialog(this, "테이블을 다시 선택해주세요!");
		}

		return bookNum;
	}

	// 삭제 버튼 클릭 시
	private void deleteBtnClicked() {
		String bookName = tfBookName.getText();

		int infoAlert = JOptionPane.showConfirmDialog(this,
		"<html>책제목 : [" + bookName + "]을 삭제하시겠습니까?", "알림",
		JOptionPane.YES_NO_OPTION);
		
		if(infoAlert == JOptionPane.YES_OPTION) {
			AdminBookDao dao =new AdminBookDao();
			boolean check = dao.deleteBookInfo(bookName);
			if(check == true) {
				JOptionPane.showMessageDialog(this, "<html>책제목 : [" + bookName + "]이 삭제되었습니다.");
				tableInit();
				searchBook();
				tfBookName.setText("");
				tfBookSubTitle.setText("");
				tfContent.setText("");
				tfCount.setText("");
				tfPrice.setText("");
				lblImage.setIcon(null);
				
			} else {
				JOptionPane.showMessageDialog(this, "오류가 발생했습니다.");
			}
		} else if (infoAlert == JOptionPane.NO_OPTION) {
			tfBookName.setText("");
			tfBookSubTitle.setText("");
			tfContent.setText("");
			tfCount.setText("");
			tfPrice.setText("");
			lblImage.setIcon(null);
		}
		
		
	}

}
