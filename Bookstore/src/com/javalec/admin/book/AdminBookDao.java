package com.javalec.admin.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;

public class AdminBookDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;

	String bookname;
	String authorname;
	String publishername;
	int pressprice;
	String booksubtitle;
	String bookcontent;
	FileInputStream file;
	int presscount;
	int publishernum;
	int booknum;
	String bookstatus;

	public AdminBookDao() {

	}

	public AdminBookDao(String bookname, String booksubtitle, String bookcontent, FileInputStream file) {
		super();
		this.bookname = bookname;
		this.booksubtitle = booksubtitle;
		this.bookcontent = bookcontent;
		this.file = file;
	}

	public AdminBookDao(String publishername) {
		super();
		this.publishername = publishername;
	}

	public AdminBookDao(int presscount, int pressprice, int publishernum, int booknum) {
		super();
		this.presscount = presscount;
		this.pressprice = pressprice;
		this.publishernum = publishernum;
		this.booknum = booknum;
	}

	public AdminBookDao(String bookname, int pressprice) {
		super();
		this.bookname = bookname;
		this.pressprice = pressprice;
	}

	public AdminBookDao(int booknum, String bookname, String booksubtitle, String bookcontent, FileInputStream file,
			String bookstatus) {
		super();
		this.booknum = booknum;
		this.bookname = bookname;
		this.booksubtitle = booksubtitle;
		this.bookcontent = bookcontent;
		this.file = file;
		this.bookstatus = bookstatus;
	}

	public AdminBookDao(int booknum, String bookname, String booksubtitle, String bookcontent, String bookstatus) {
		super();
		this.booknum = booknum;
		this.bookname = bookname;
		this.booksubtitle = booksubtitle;
		this.bookcontent = bookcontent;
		this.bookstatus = bookstatus;
	}

	public AdminBookDao(int booknum, int presscount, int pressprice) {
		super();
		this.booknum = booknum;
		this.presscount = presscount;
		this.pressprice = pressprice;
	}

	// 메뉴 클릭 시 테이블 조회 메소드
	public ArrayList<AdminBookDto> searchAction() {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select b.bookname, a.authorname, publishername, pressprice , b.bookstatus from book b, author a, publisher pub, press p, bookstore.write w ";
		String query2 = " where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and w.authornum = a.authornum order by bookstatus desc";

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
				String wkBookStatus = rs.getString(5);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 검색_책제목
	public ArrayList<AdminBookDto> searchConditionToBookName(String str) {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select b.bookname, a.authorname, publishername, pressprice , b.bookstatus from book b, author a, publisher pub, press p, bookstore.write w ";
		String query2 = " where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and w.authornum = a.authornum and b.bookname like '%"
				+ str + "%'";

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
				String wkBookStatus = rs.getString(5);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 검색_책제목
	public ArrayList<AdminBookDto> searchConditionToAuthor(String str) {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select b.bookname, a.authorname, publishername, pressprice , b.bookstatus from book b, author a, publisher pub, press p, bookstore.write w ";
		String query2 = " where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and w.authornum = a.authornum and a.authorname like '%"
				+ str + "%'";

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
				String wkBookStatus = rs.getString(5);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 검색_책제목
	public ArrayList<AdminBookDto> searchConditionToPublisher(String str) {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select b.bookname, a.authorname, publishername, pressprice, b.bookstatus  from book b, author a, publisher pub, press p, bookstore.write w ";
		String query2 = " where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and w.authornum = a.authornum and pub.publishername like '%"
				+ str + "%'";

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
				String wkBookStatus = rs.getString(5);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 출판사num 가져오기
	public int getPublisherNum() {
		int num = 0;

		String query1 = "select publishernum from publisher where publishername = '" + publishername + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			if (rs.next()) {
				num = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	// booknum 가져오기
	public int getBookNum() {
		int num = 0;

		String query1 = "select booknum from book where bookname = '" + publishername + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			if (rs.next()) {
				num = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	// 책 등록
	public boolean insertBook() {
		System.out.println("booktable insert start ");
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "insert into book (bookname, booktitle, bookcontents, bookimage, bookstatus ) ";
			String query2 = " values (?,?,?,?,?)";

			ps = conn.prepareStatement(query1 + query2);
			ps.setString(1, bookname);
			ps.setString(2, booksubtitle);
			ps.setString(3, bookcontent);
			ps.setBinaryStream(4, file);
			ps.setString(5, "판매중");
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("insert booktable success!!");
		return true;
	}

	// presstable에 등록하기
	public boolean insertPress() {
		System.out.println("presstable insert start ");
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "insert into press (presscount, pressprice, pressdate, booknum, publishernum ) ";
			String query2 = " values (?,?,sysdate(),?,?)";

			ps = conn.prepareStatement(query1 + query2);

			ps.setInt(1, presscount);
			ps.setInt(2, pressprice);
			ps.setInt(3, booknum);
			ps.setInt(4, publishernum);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("insert presstable success!!");
		return true;
	}

	// book 테이블 조회
	public ArrayList<AdminBookDto> searchBook() {

		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select bookname, booktitle, pub.publishername, presscount, pressprice, bookstatus from book b, press p, publisher pub where b.booknum = p.booknum and pub.publishernum = p.publishernum order by bookstatus desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkBookTitle = rs.getString(2);
				String wkPubName = rs.getString(3);
				int wkPressCount = rs.getInt(4);
				int wkPressPrice = rs.getInt(5);
				String wkBookStatus = rs.getString(6);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkBookTitle, wkPubName, wkPressCount, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 책제목으로 검색
	public ArrayList<AdminBookDto> searchConditionToBook(String str) {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select bookname, booktitle, pub.publishername, presscount, pressprice, bookstatus from book b, press p, publisher pub where b.booknum = p.booknum and pub.publishernum = p.publishernum  order by bookstatus desc";
		String query2 = " and b.bookname like '%" + str + "%'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkBookName = rs.getString(1);
				String wkBookTitle = rs.getString(2);
				String wkPubName = rs.getString(3);
				int wkPressCount = rs.getInt(4);
				int wkPressPrice = rs.getInt(5);
				String wkBookStatus = rs.getString(6);

				AdminBookDto dto = new AdminBookDto(wkBookName, wkBookTitle, wkPubName, wkPressCount, wkPressPrice,
						wkBookStatus);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 책 수정_ 테이블 클릭 했을 때
	public AdminBookDto tableClick() {
		AdminBookDto dto = null;

		String query1 = "select bookname, booktitle, bookcontents, presscount, pressprice, bookstatus, bookimage from book b, press p where b.booknum = p.booknum ";
		String query2 = " and bookname='" + bookname + "' and pressprice ='" + pressprice + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			if (rs.next()) {
				String bookName = rs.getString(1);
				String bookTitle = rs.getString(2);
				String bookContent = rs.getString(3);
				int presscount = rs.getInt(4);
				int pressprice = rs.getInt(5);
				String bookStatus = rs.getString(6);

				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(7);

				byte[] buffer = new byte[1024];

				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				dto = new AdminBookDto(bookName, bookTitle, presscount, pressprice, bookStatus, bookContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// bookNum 가져오기
	public int bookSeqNum() {
		int num = 0;
		String query1 = "select b.booknum from book b, press p where b.booknum = p.booknum and bookname='" + bookname
				+ "' and pressprice ='" + pressprice + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			if (rs.next()) {
				num = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	// booktable update
	public boolean updateBook() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "update book set bookname = ?, booktitle =?, bookcontents =?, bookstatus =? ";
			String query2 = " where booknum = ?";
			ps = conn.prepareStatement(query1 + query2);

			ps.setString(1, bookname);
			ps.setString(2, booksubtitle);
			ps.setString(3, bookcontent);
			ps.setString(4, bookstatus);
			ps.setInt(5, booknum);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// booktable update - no image
	public boolean updateWithImgBook() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "update book set bookname = ?, booktitle =?, bookcontents =?,  bookimage=?,  bookstatus =? ";
			String query2 = " where booknum = ?";
			ps = conn.prepareStatement(query1 + query2);

			ps.setString(1, bookname);
			ps.setString(2, booksubtitle);
			ps.setString(3, bookcontent);
			ps.setBinaryStream(4, file);
			ps.setString(5, bookstatus);
			ps.setInt(6, booknum);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// pressTable update
	public boolean updatePress() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "update press set presscount = ?, pressprice =? ";
			String query2 = " where booknum = ?";
			ps = conn.prepareStatement(query1 + query2);

			ps.setInt(1, presscount);
			ps.setInt(2, pressprice);
			ps.setInt(3, booknum);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// pressTable update
	public boolean deleteBookInfo(String bookName) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);

			String query1 = "update book set bookstatus = '판매종료' ";
			String query2 = " where bookname = '"+bookName+"'";
			ps = conn.prepareStatement(query1 + query2);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
