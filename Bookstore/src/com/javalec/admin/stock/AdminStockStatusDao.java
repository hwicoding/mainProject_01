package com.javalec.admin.stock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.admin.book.AdminBookDto;
import com.javalec.util.ShareVar;

public class AdminStockStatusDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;

	int genrenum;
	String genrekind;
	String genreseckind;
	String genrethirdkind;
	String genrestatus;
	String bookName;
	int pressPrice;
	int pressCount;
	int stockCount;
	String pressDate;
	int booknum;
	String publishername;
	int publishernum;
	int ordercount;

	public AdminStockStatusDao() {

	}

	public AdminStockStatusDao(String bookName, String publishername) {
		super();
		this.bookName = bookName;
		this.publishername = publishername;
	}

	public AdminStockStatusDao(int booknum, int publishernum, int ordercount) {
		super();
		this.booknum = booknum;
		this.publishernum = publishernum;
		this.ordercount = ordercount;
	}

	public AdminStockStatusDao(String bookName, int pressPrice) {
		super();
		this.bookName = bookName;
		this.pressPrice = pressPrice;
	}

	// 입고 현황_ 테이블 조회 메소드
	public ArrayList<AdminStockStatusDto> searchAction() {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle ";
		String query2 = "from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum ";
		String query3 = " inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum order by bookstatus desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 + query3);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}


	// 입고 현황_ 책제목으로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToBookName(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 = " inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and b.bookname like '%" + str + "%' order by bookstatus desc ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고 현황_출판사로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToPublisher(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 = " inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and pub.publishername like '%" + str + "%' order by bookstatus desc ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고 현황_입고일로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToPressDate(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 = " inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and p.pressdate like '%" + str + "%' order by bookstatus desc ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고 현황_책현황로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToBoostatus(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 = " inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and b.bookstatus like '%" + str + "%' order by bookstatus desc ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고요청_테이블 클릭했을 때, 출판사 조회하기
	public ArrayList<AdminStockStatusDto> showPublisher(String bookname) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query = "select pub.publishername from publisher pub, press p, book b where b.booknum = p.booknum and p.publishernum = pub.publishernum and b.bookname = '"
				+ bookname + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String wkPublisherName = rs.getString(1);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkPublisherName);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// bookNum과 publisherNum 가져오기
	public AdminStockStatusDto getBookAndPublisherNum() {
		AdminStockStatusDto dto = null;
		String query = "select b.booknum, p.publishernum from book b, publisher p, press where press.booknum = b.booknum and press.publishernum = p.publishernum and b.bookname = '"
				+ bookName + "' and p.publishername ='" + publishername + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int wkBookNum = rs.getInt(1);
				int wkPublisherNum = rs.getInt(1);

				dto = new AdminStockStatusDto(wkBookNum, wkPublisherNum);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 불러온 bookNum과 publisherNum을 가지고 order table에 insert하기
	public boolean requestOrderInsert() {
		PreparedStatement ps = null;
		String query = "insert into bookstore.order (ordercount, orderrequsetdate, booknum, publishernum ) values ("
				+ ordercount + ", sysdate() ," + booknum + "," + publishernum + "); ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(query);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 재고 현황_ 테이블 조회 메소드
	public ArrayList<AdminStockStatusDto> searchStockAction() {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  (p.presscount - pur.purchasecount),	b.bookstatus, date(p.pressdate), b.booktitle from book b inner join press p on p.booknum = b.booknum ";
		String query2 = " inner join publisher pub on p.publishernum = pub.publishernum inner join bookstore.write w on w.publishernum = pub.publishernum ";
		String query3 = " inner join author a on a.authornum = w.authornum inner join purchase pur on pur.booknum = b.booknum order by bookstatus desc ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 + query3);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 재고 현황_ 책제목 검색
	public ArrayList<AdminStockStatusDto> searchBookName(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();
		
		String query1 = "select b.bookname, a.authorname, pub.publishername, p.pressprice,  (p.presscount - pur.purchasecount),	b.bookstatus, date(p.pressdate), b.booktitle from book b inner join press p on p.booknum = b.booknum ";
		String query2 = " inner join publisher pub on p.publishernum = pub.publishernum inner join bookstore.write w on w.publishernum = pub.publishernum ";
		String query3 = " inner join author a on a.authornum = w.authornum inner join purchase pur on pur.booknum = b.booknum and b.bookname like '%"+str+"%' order by bookstatus desc ";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 + query3);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 재고 현황_출판사명 검색
	public ArrayList<AdminStockStatusDto> searchPublisher(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 =" inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and pub.publishername like '%"+str+"%' order by bookstatus desc";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 );

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 재고 현황_입고일 검색
	public ArrayList<AdminStockStatusDto> searchPressDate(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 =" inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and date(p.pressdate) like '%"+str+"%' order by bookstatus desc";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 );

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 재고 현황_책현황 검색
	public ArrayList<AdminStockStatusDto> searchBookStatus(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice,  p.presscount, b.bookstatus, date(p.pressdate) , b.booktitle from book b inner join press p on p.booknum = b.booknum inner join publisher pub on p.publishernum = pub.publishernum "; 
		String query2 =" inner join bookstore.write w on w.publishernum = pub.publishernum inner join author a on a.authornum = w.authornum and b.bookstatus like '%"+str+"%' order by bookstatus desc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkAuthorName = rs.getString(2);
				String wkPublisherName = rs.getString(3);
				int wkPressPrice = rs.getInt(4);
				int wkPressCount = rs.getInt(5);
				String wkBookStatus = rs.getString(6);
				String wkPressDate = rs.getString(7);
				String wkBookTitle = rs.getString(8);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName,
						wkPressPrice, wkPressCount, wkBookStatus, wkPressDate, wkBookTitle);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
