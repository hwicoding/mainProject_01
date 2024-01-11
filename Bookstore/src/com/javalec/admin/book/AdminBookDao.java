package com.javalec.admin.book;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.admin.publisher.AdminPublishDto;
import com.javalec.util.ShareVar;

public class AdminBookDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;

	String bookname;
	String authorname;
	String publishername;
	int presspirce;
	String booksubtitle;
	String bookcontent;
	FileInputStream file;
	int presscount;
	int publishernum;
	int booknum;

	// new AdminBookDao(bookName, bookSubName, bookContent, input);
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
	
	public AdminBookDao(int presscount, int presspirce, int publishernum, int booknum) {
		super();
		this.presscount = presscount;
		this.presspirce = presspirce;
		this.publishernum = publishernum;
		this.booknum = booknum;
	}

	// 메뉴 클릭 시 테이블 조회 메소드
	public ArrayList<AdminBookDto> searchAction() {
		ArrayList<AdminBookDto> dtoList = new ArrayList<AdminBookDto>();

		String query1 = "select b.bookname, a.authorname, publishername, pressprice from book b, author a, publisher pub, press p, bookstore.write w ";
		String query2 = " where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and w.authornum = a.authornum";

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

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice);
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

		String query1 = "select b.bookname, a.authorname, publishername, pressprice from book b, author a, publisher pub, press p, bookstore.write w ";
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

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice);
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

		String query1 = "select b.bookname, a.authorname, publishername, pressprice from book b, author a, publisher pub, press p, bookstore.write w ";
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

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice);
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

		String query1 = "select b.bookname, a.authorname, publishername, pressprice from book b, author a, publisher pub, press p, bookstore.write w ";
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

				AdminBookDto dto = new AdminBookDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice);
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
			ps.setInt(2, presspirce);
			ps.setInt(3, booknum);
			ps.setInt(4, publishernum );

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("insert presstable success!!");
		return true;
	}

}
