package com.javalec.cartorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.product.InformationPage;
import com.javalec.product.SearchPage;
import com.javalec.user.UserDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CartPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable innertable;
	private JLabel lblPublishername;
	private JLabel lblBookname;
	private JLabel lblAuthorname;
	private JLabel lblBooktitle;
	private JLabel lblGenre;
	private JLabel lblCount;
	private JLabel lblTotalprice;
	private JTextField tfPublishername;
	private JTextField tfBookname;
	private JTextField tfBooktitle;
	private JTextField tfAuthorname;
	private JTextField tfGenre;
	private JTextField tfCartcount;
	private JTextField tfTotalmoney;
	private JButton btnOrder;
	
	
	private final DefaultTableModel outertable = new DefaultTableModel();
	ArrayList<CartorderDTO> dtolist = null;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		try {
			CartPage dialog = new CartPage();
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
	public CartPage() {
		getContentPane().setBackground(new Color(29, 84, 141));
		setBackground(new Color(64, 62, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
//				showTotalInfo();
			}
		});
	
		setTitle("장바구니");
		setBounds(100, 100, 401, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblPublishername());
		contentPanel.add(getLblBookname());
		contentPanel.add(getLblAuthorname());
		contentPanel.add(getLblBooktitle());
		contentPanel.add(getLblGenre());
		contentPanel.add(getLblCount());
		contentPanel.add(getLblTotalprice());
		contentPanel.add(getTfPublishername());
		contentPanel.add(getTfBookname());
		contentPanel.add(getTfBooktitle());
		contentPanel.add(getTfAuthorname());
		contentPanel.add(getTfGenre());
		contentPanel.add(getTfCartcount());
		contentPanel.add(getTfTotalmoney());
		contentPanel.add(getBtnOrder());
		contentPanel.add(getTextField());
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
			innertable = new JTable() {
				
				  @Override
		            public boolean isCellEditable(int row, int column) {
		               return false;
		            }
				
				
			};
			innertable.setFillsViewportHeight(true);
			
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
					}
			});
			innertable.setBorder(new LineBorder(new Color(0,0,0)));
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outertable);
		}
		return innertable;
	}
	private JLabel getLblPublishername() {
		if (lblPublishername == null) {
			lblPublishername = new JLabel("출판사 ");
			lblPublishername.setBounds(34, 308, 50, 15);
		}
		return lblPublishername;
	}
	private JLabel getLblBookname() {
		if (lblBookname == null) {
			lblBookname = new JLabel("책 제목");
			lblBookname.setBounds(34, 344, 50, 15);
		}
		return lblBookname;
	}
	private JLabel getLblAuthorname() {
		if (lblAuthorname == null) {
			lblAuthorname = new JLabel("작가");
			lblAuthorname.setBounds(34, 417, 50, 15);
		}
		return lblAuthorname;
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
	private JTextField getTfPublishername() {
		if (tfPublishername == null) {
			tfPublishername = new JTextField();
			tfPublishername.setEditable(false);
			tfPublishername.setBounds(114, 305, 119, 21);
			tfPublishername.setColumns(10);
		}
		return tfPublishername;
	}
	private JTextField getTfBookname() {
		if (tfBookname == null) {
			tfBookname = new JTextField();
			tfBookname.setEditable(false);
			tfBookname.setColumns(10);
			tfBookname.setBounds(114, 341, 191, 21);
		}
		return tfBookname;
	}
	private JTextField getTfBooktitle() {
		if (tfBooktitle == null) {
			tfBooktitle = new JTextField();
			tfBooktitle.setEditable(false);
			tfBooktitle.setColumns(10);
			tfBooktitle.setBounds(114, 378, 191, 21);
		}
		return tfBooktitle;
	}
	private JTextField getTfAuthorname() {
		if (tfAuthorname == null) {
			tfAuthorname = new JTextField();
			tfAuthorname.setEditable(false);
			tfAuthorname.setColumns(10);
			tfAuthorname.setBounds(114, 417, 119, 21);
		}
		return tfAuthorname;
	}
	private JTextField getTfGenre() {
		if (tfGenre == null) {
			tfGenre = new JTextField();
			tfGenre.setEditable(false);
			tfGenre.setColumns(10);
			tfGenre.setBounds(114, 453, 139, 21);
		}
		return tfGenre;
	}
	private JTextField getTfCartcount() {
		if (tfCartcount == null) {
			tfCartcount = new JTextField();
			tfCartcount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						int b= Integer.parseInt(tfCartcount.getText()); 
						
						if(0>=b || b>=11) {
							JOptionPane.showMessageDialog(null, "숫자는 1~10까지 입력해주십시오.");
						}else {
							int d= Integer.parseInt(tfTotalmoney.getText());
							int result = b*d;
							tfTotalmoney.setText(Integer.toString(result));
							tfCartcount.setEnabled(false);
							
							
							
						}
						
						
					}
				}
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					
					if(c != '\b') {	
						if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
								isSpecialCharacter(c)||(c >= 'ㄱ' && c <= 'ㅎ')||(c >= 'ㅏ' && c <= 'ㅣ'))){
							JOptionPane.showMessageDialog(null, "한글, 영어,특수문자는 사용 불가합니다.");
							e.consume(); // 이벤트를 소비하고 무시
						}
						
						// 여기서 특수문자 여부를 확인하고 원하는 동작 수행
						if (isSpecialCharacter(c)) {
							// 특수문자 처리 로직
							System.out.println("Special Character Typed: " + c);
						}
					}
				}
			});
			tfCartcount.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
				}
			});
			tfCartcount.setColumns(10);
			tfCartcount.setBounds(114, 494, 55, 21);
		}
		return tfCartcount;
	}
	private JTextField getTfTotalmoney() {
		if (tfTotalmoney == null) {
			tfTotalmoney = new JTextField();
			tfTotalmoney.setEditable(false);
			tfTotalmoney.setColumns(10);
			tfTotalmoney.setBounds(114, 534, 119, 21);
		}
		return tfTotalmoney;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("주문하기");
			btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					orderpage();
				}
			});
			btnOrder.setBounds(253, 603, 91, 23);
		}
		return btnOrder;
	}
	
	//---	Function  ---
	
	
	//	Table 초기화 하기
		private void tableInit() {
			outertable.addColumn("목록");
			outertable.addColumn("책 제목");
			outertable.addColumn("가격");
			outertable.setColumnCount(3);
	
	
	//	Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = innertable.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);	
			
		colNo = 1;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 105;
		col.setPreferredWidth(width);
	
		colNo = 2;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 109;
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
				String tmp2 = Integer.toString (dtolist.get(i).getNum());
				String wkTotalprice = decFormat.format(tmp3);
				String[] qTxt = { tmp2,dtolist.get(i).getBookname(), wkTotalprice };
				outertable.addRow(qTxt);
			}		
			return dtolist;
		}
		
   
		// 테이플 클릭했을 때
		private void tableClick() {
			
			int j=innertable.getSelectedRow();
			
			
		//	for(int i =0;i<innertable.getColumnCount();i++) {
			//	System.out.println(innertable.getModel().getValueAt(row, i)+"\t");
			//}
		
			
			CartorderDAO dao = new CartorderDAO();
			dao.selectlist();
			ArrayList<CartorderDTO> dtolist = dao.selectlist();
			
			
			tfPublishername.setText(dtolist.get(j).getPublishename());
			tfBookname.setText(dtolist.get(j).getBookname());
			tfBooktitle.setText(dtolist.get(j).getBooktitle());
			tfAuthorname.setText(dtolist.get(j).getAuthorname());
			tfGenre.setText(dtolist.get(j).getGenrekind());
			tfCartcount.setText(Integer.toString(dtolist.get(j).getCount()));
			tfTotalmoney.setText(Integer.toString(dtolist.get(j).getTotalprice()));
			textField.setText(Integer.toString(dtolist.get(j).getBooknum()));
			tfCartcount.setEnabled(true);
			tfCartcount.requestFocus();
		
			
					
				
			}
	
		
	
			
		
			
	
		
		
			
			
		// 수량에 맞게 가격 변동 
		/*private void countAction(int price) {
			String selectedValue = cbCount.getSelectedItem().toString();
		      switch(cbCount.getSelectedIndex()) {
		       case 0:
		            tfCartcount.setEnabled(false);
		            break;
		       case 1:
		    	   tfCartcount.setEnabled(true);
		    	    tfCartcount.setText(selectedValue);
		    	    break;
		       case 2:
		    	   tfCartcount.setEnabled(true);
		    	   tfCartcount.setText(selectedValue);
		    	  // tfTotalmoney.setText("0");
		    	   int b= Integer.parseInt(tfTotalmoney.getText()); 
		    	   System.out.println(b);
		    	   
		    	   int c=	Integer.parseInt(selectedValue);
		    	   System.out.println(c);
		    	   int d =Integer.parseInt(tfCartcount.getText());
		    	   System.out.println(d);
		    	   int result = price*c;
		    	   tfTotalmoney.setText(Integer.toString(result));
		    	   System.out.println(result);
		    	   break;
	
		       case 3:
		    	   tfCartcount.setEnabled(true);
		    	   tfCartcount.setText(selectedValue);
		          break;
		       case 4:
		    	   tfCartcount.setEnabled(true);
		    	   tfCartcount.setText(selectedValue);
			          break;}
		      
		         
			
			//int Countnumber = cbCount.getSelectedIndex();
			
			//tfCartcount.setText(String.valueOf(Countnumber+1));
			
		}*/
		
		private void showTotalInfo() {
			
			CartorderDAO dao = new CartorderDAO();
			CartorderDTO dto = dao.showTotalInfo();
			
			DecimalFormat decFormat = new DecimalFormat("###,###");	
			int tmp3 = dto.getTotalMoney();
			String wkPrice = decFormat.format(tmp3);
			String wkCartcount = decFormat.format(tmp3);
			tfCartcount.setText(wkPrice);
			tfTotalmoney.setText(wkPrice);
		}


		// 주문하기 버튼 클릭했을 때, (주문내역 테이블로 호출, 장바구니 테이블 delete 처리)
	
		private void orderpage() {
			int a = Integer.parseInt(tfCartcount.getText());
			int b  = Integer.parseInt(textField.getText());
			System.out.println(a);
			System.out.println(b);
			CartorderDAO dao = new CartorderDAO(a,b);
			boolean result = dao.insertAction();
			
			if(result==true) {
				JOptionPane.showMessageDialog(null, "...");
				dispose();
				SearchPage search = new SearchPage();
				search.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "실패");}
			
			
		// Orderpage로 정보 보내기
//		Orderpage orderpage = new Orderpage();
//		Orderpage.setVisible(true);
//		Orderpage.selectByinfo(array);
//
//		return array;

			}
		
		private boolean isSpecialCharacter(char ch) {
	        // 특수문자 여부를 판단하는 메서드
	        return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
	    }
		
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(114, 565, 96, 21);
			textField.setColumns(10);
		}
		return textField;
	}
}


		// 창종료 

	
	// 열기
	

