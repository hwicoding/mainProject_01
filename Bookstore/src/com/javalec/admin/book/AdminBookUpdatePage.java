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

public class AdminBookUpdatePage extends JPanel {

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
	private JTextField tfImagePath;
	private JButton btnImage;
	private JButton btnRegister;
	private JLabel lblNewLabel_2_1_1_2;
	private JTextField tfCount;
	private JLabel lblNewLabel_2_1_1_2_2;
	private JTextField tfPrice;
	private JLabel lblNewLabel_2_1_1_2_3;
	private JLabel lblNewLabel_2_1_1_2_3_1;
	private JLabel lblNewLabel_2_1_1_2_1;
	private JComboBox cbStatus;

	public AdminBookUpdatePage() {
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
		add(getTfImagePath());
		add(getBtnImage());
		add(getBtnRegister());
		add(getLblNewLabel_2_1_1_2());
		add(getTfCount());
		add(getLblNewLabel_2_1_1_2_2());
		add(getTfPrice());
		add(getLblNewLabel_2_1_1_2_3());
		add(getLblNewLabel_2_1_1_2_3_1());
		add(getLblNewLabel_2_1_1_2_1());
		add(getCbStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("책 수정");
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
			tfBookName.setBounds(340, 320, 400, 40);
			LineBorder line = new LineBorder(Color.gray, 1, true);
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
			tfBookSubTitle.setColumns(10);
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
			tfContent.setColumns(10);
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

	private JTextField getTfImagePath() {
		if (tfImagePath == null) {
			tfImagePath = new JTextField();
			tfImagePath.setBounds(29, 580, 180, 35);
			tfImagePath.setColumns(10);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfImagePath.setBorder(line);
		}
		return tfImagePath;
	}

	private JButton getBtnImage() {
		if (btnImage == null) {
			btnImage = new JButton("이미지 등록");
			btnImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imageRegisterBtnClicked();
				}
			});
			btnImage.setBounds(220, 580, 80, 35);
			btnImage.setBackground(new Color(130, 179, 235));
			LineBorder line = new LineBorder(Color.gray, 1, true);
			btnImage.setBorder(line);
			btnImage.setForeground(new Color(253, 253, 253));
			btnImage.setOpaque(true);
			btnImage.setBorderPainted(false);
		}
		return btnImage;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("수정");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (nullCheck() == 0) {
						updateBtnClicked();
					}
				}
			});
			btnRegister.setBounds(652, 120, 117, 35);
			btnRegister.setBackground(new Color(130, 179, 235));
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
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setColumns(10);
			LineBorder line = new LineBorder(Color.gray, 1, true);
			tfPrice.setBorder(line);
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

	private JLabel getLblNewLabel_2_1_1_2_1() {
		if (lblNewLabel_2_1_1_2_1 == null) {
			lblNewLabel_2_1_1_2_1 = new JLabel("책 현황");
			lblNewLabel_2_1_1_2_1.setBounds(340, 620, 61, 16);
		}
		return lblNewLabel_2_1_1_2_1;
	}

	private JComboBox getCbStatus() {
		if (cbStatus == null) {
			cbStatus = new JComboBox();
			cbStatus.setModel(new DefaultComboBoxModel(new String[] { "판매중", "판매종료" }));
			cbStatus.setBounds(340, 638, 200, 27);
		}
		return cbStatus;
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

	// 검색 - 출판사명
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

			if (dto.getBookstatus().equals("판매중")) {
				cbStatus.setSelectedIndex(0);
			} else {
				cbStatus.setSelectedIndex(1);
			}

		} else {
			JOptionPane.showMessageDialog(this, "테이블을 다시 선택해주세요!");
		}

		return bookNum;
	}

	// 이미지 등록 버튼 클릭했을 때
	private void imageRegisterBtnClicked() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		FileNameExtensionFilter filter = new FileNameExtensionFilter("png 파일", "png");
		fileChooser.addChoosableFileFilter(filter);

		String name = "";
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			tfImagePath.setText(selectedFile.toString());

			ImageIcon icon = new ImageIcon(selectedFile.toString());
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			lblImage.setIcon(changeIcon);

		}
	}

	// 수정 버튼 눌렀을 때
	private void updateBtnClicked() {
		
		String bookName = tfBookName.getText();
		int cnt = Integer.parseInt(tfCount.getText());
		int price = Integer.parseInt(tfPrice.getText());
		
		// 등록하겠냐는 메세지
		int infoAlert = JOptionPane.showConfirmDialog(this,
		"<html>책제목 : " + bookName + "\n 수량 : " + cnt + " 개, "+price+"원으로 \n 수정하시겠습니까?", "알림",
		JOptionPane.YES_NO_OPTION);
		
		if(infoAlert == JOptionPane.YES_OPTION) {
			
			if(updateBookInfo() == true && updatePressInfo(cnt, price) == true) {
				JOptionPane.showMessageDialog(this, "<html>책제목 : " + bookName + "\n 수량 : " + cnt + " 개, "+price+"원으로  등록되었습니다.");
				tableInit();
				searchBook();
				tfBookName.setText("");
				tfBookSubTitle.setText("");
				tfContent.setText("");
				tfCount.setText("");
				tfPrice.setText("");
				lblImage.setIcon(null);
				tfImagePath.setText(""); 
			} else {
				JOptionPane.showMessageDialog(this, "입력한 내용을 확인해주세요.");
			}
		} else if (infoAlert == JOptionPane.NO_OPTION) {
			tableInit();
			searchBook();
			tfBookName.setText("");
			tfBookSubTitle.setText("");
			tfContent.setText("");
			tfCount.setText("");
			tfPrice.setText("");
			lblImage.setIcon(null);
			tfImagePath.setText("");
			System.out.println("아니요 성공");
		}
	}

	
	private boolean updateBookInfo() {
		String bookName = tfBookName.getText();
		String bookSubName = tfBookSubTitle.getText();
		String bookContent = tfContent.getText();
		String bookStatus = "";
		
		System.out.println("121212 : " + tfBookSubTitle.getText());
		boolean check;
		System.out.println("book 시작");
		int bookNum = cellClicked();
		System.out.println("수정bookNum : "+bookNum);
		
		System.out.println("23233 : " + tfBookSubTitle.getText());
		
		int i = cbStatus.getSelectedIndex();
		if(i == 0) {
			bookStatus = "판매중";
		} else {
			bookStatus = "판매종료";
		}
		
		AdminBookDao dao = null;
		if(tfImagePath.getText().length() <= 0) {
			System.out.println("djdjf : "+bookSubName);
			dao = new AdminBookDao(bookNum, bookName, bookSubName, bookContent, bookStatus);
			check =  dao.updateBook();
		} else {
			FileInputStream input = null;
			File file = new File(tfImagePath.getText());
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			dao = new AdminBookDao(bookNum, bookName, bookSubName, bookContent, input, bookStatus); 
			check = dao.updateWithImgBook();
		}
		
		System.out.println("book 끝");
		return check;
	}
	
	private boolean updatePressInfo(int count, int price) {
		System.out.println("press 시작");
		System.out.println("cnt : "+count);
		System.out.println("price : "+price);
		int bookNum = cellClicked();
		System.out.println("수정bookNum : "+bookNum);
		AdminBookDao dao = new AdminBookDao(bookNum, count, price);
		System.out.println("press끝");
		
		return dao.updatePress();
	}
	
//	private void registerBtnClicked() {
//
//		String bookName = tfBookName.getText();
//		int cnt = Integer.parseInt(tfCount.getText());
//		int price = Integer.parseInt(tfPrice.getText());
//		String pubName = tfPubName.getText();
//
//		// 등록하겠냐는 메세지
//		int infoAlert = JOptionPane.showConfirmDialog(this,
//				"<html>책제목 : " + bookName + "\n 출판사 : " + pubName + "\n 수량 : " + cnt + " 개를 \n 등록하시겠습니까?", "알림",
//				JOptionPane.YES_NO_OPTION);
//
//		// 메세지 확인버튼 눌렀을 때
//		if (infoAlert == JOptionPane.YES_OPTION) {
//			boolean checkInsertBook = insertBook();
//			AdminBookDao dao4 = new AdminBookDao(cnt, price, getPublisherNum(), getBookNum()); // press table insert
//
//			if (checkInsertBook == true && dao4.insertPress() == true) {
//				JOptionPane.showMessageDialog(this,
//						"<html>책제목 : " + bookName + "\n 출판사 : " + pubName + "\n 수량 : " + cnt + " 개가 \n 등록되었습니다.");
//				tfBookName.setText("");
//				tfBookSubTitle.setText("");
//				tfPubName.setText("");
//				tfContent.setText("");
//				tfCount.setText("");
//				tfPrice.setText("");
//				tfImagePath.setText("");
//				lblImage.setIcon(null);
//				tfImagePath.setText("");
//			} else {
//				JOptionPane.showMessageDialog(this, "입력한 내용을 확인해주세요.");
//			}
//
//			// 취소버튼 눌렀을 때
//		} else if (infoAlert == JOptionPane.NO_OPTION) {
//			tableInit();
//			searchAction();
//			tfBookName.setText("");
//			tfBookSubTitle.setText("");
//			tfPubName.setText("");
//			tfContent.setText("");
//			tfCount.setText("");
//			tfPrice.setText("");
//			lblImage.setIcon(null);
//			tfImagePath.setText("");
//			System.out.println("아니요 성공");
//		}
//
//	}
//
//	// 책 insert
//	private boolean insertBook() {
//		String bookName = tfBookName.getText();
//		String bookSubName = tfBookSubTitle.getText();
//		String bookContent = tfContent.getText();
//
//		FileInputStream input = null;
//		File file = new File(tfImagePath.getText());
//		try {
//			input = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		AdminBookDao dao = new AdminBookDao(bookName, bookSubName, bookContent, input); // 책 insert
//		return dao.insertBook();
//	}
//
//	// 출판사 번호 가져오기
//	private int getPublisherNum() {
//		int i = innerTable.getSelectedRow();
//		String publisherName = (String) innerTable.getValueAt(i, 0);
//		AdminBookDao dao = new AdminBookDao(publisherName);
//		return dao.getPublisherNum();
//	}
//
//	// 책 번호 가져오기
//	private int getBookNum() {
//
//		AdminBookDao dao = new AdminBookDao(tfBookName.getText());
//		return dao.getBookNum();
//	}
//
	// 빈 칸 체크 메소드
	private int nullCheck() {
		int num = 0;
		
		if(lblImage.getIcon() != null) {
			return num;
		} else {
			if (tfImagePath.getText().length() <= 0) {
				JOptionPane.showMessageDialog(this, "이미지를 선택하세요.");
				num++;
				return num;
			}
		}

		if (tfBookName.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "책 제목을 작성하세요.");
			tfBookName.requestFocus();
			num++;
			return num;
		}

		if (tfContent.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "책 줄거리 작성하세요.");
			tfContent.requestFocus();
			num++;
			return num;
		}

		if (tfContent.getText().length() >= 100) {
			JOptionPane.showMessageDialog(this, "책 줄거리 100자 내로 작성하세요.");
			tfContent.setText("");
			tfContent.requestFocus();
			num++;
			return num;
		}

		if (tfCount.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "수량을 입력하세요.");
			tfCount.requestFocus();
			num++;
			return num;
		}

		if (tfPrice.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "가격을 입력하세요.");
			tfPrice.requestFocus();
			num++;
			return num;
		}
		return num;
	}

}
