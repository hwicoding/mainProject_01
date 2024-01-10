package com.javalec.admin.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

	// 입고 및 재고현황_ 테이블 조회 메소드
	public ArrayList<AdminStockStatusDto> searchAction() {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice, p.presscount, (p.presscount - pur.purchasecount), p.pressdate from press p, book b, publisher pub, bookstore.write w, author a, purchase pur ";
		String query2 =" where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and a.authornum = w.authornum ";
		String query3 =" and pur.booknum = b.booknum and pur.purchasestatus = '구매완료' and b.bookstatus='판매중' and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' ";
		
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
				int wkStockCount = rs.getInt(6);
				String wkPressDate = rs.getString(7);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice, wkPressCount, wkStockCount, wkPressDate);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고 및 재고현황_ 책제목으로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToBookName(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice, p.presscount, (p.presscount - pur.purchasecount), p.pressdate from press p, book b, publisher pub, bookstore.write w, author a, purchase pur ";
		String query2 =" where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and a.authornum = w.authornum ";
		String query3 =" and pur.booknum = b.booknum and pur.purchasestatus = '구매완료' and b.bookstatus='판매중' and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' and b.bookname like '%" + str +"%'  order by b.booknum";

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
				int wkStockCount = rs.getInt(6);
				String wkPressDate = rs.getString(7);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice, wkPressCount, wkStockCount, wkPressDate);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 입고 및 재고현황_출판사로 검색
		public ArrayList<AdminStockStatusDto> searchConditionToPublisher(String str) {
			ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();
			
			String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice, p.presscount, (p.presscount - pur.purchasecount), p.pressdate from press p, book b, publisher pub, bookstore.write w, author a, purchase pur ";
			String query2 =" where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and a.authornum = w.authornum ";
			String query3 =" and pur.booknum = b.booknum and pur.purchasestatus = '구매완료' and b.bookstatus='판매중' and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' and pub.publishername like '%" + str +"%'  order by b.booknum";

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
					int wkStockCount = rs.getInt(6);
					String wkPressDate = rs.getString(7);

					AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice, wkPressCount, wkStockCount, wkPressDate);
					dtoList.add(dto);
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dtoList;
		}

	// 입고 및 재고현황_입고일로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToPressDate(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 ="select b.bookname, a.authorname, pub.publishername, p.pressprice, p.presscount, (p.presscount - pur.purchasecount), p.pressdate from press p, book b, publisher pub, bookstore.write w, author a, purchase pur ";
		String query2 =" where b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and a.authornum = w.authornum ";
		String query3 =" and pur.booknum = b.booknum and pur.purchasestatus = '구매완료' and b.bookstatus='판매중' and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' and p.pressdate like '%" + str +"%'  order by b.booknum";


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
				int wkStockCount = rs.getInt(6);
				String wkPressDate = rs.getString(7);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBookName, wkAuthorName, wkPublisherName, wkPressPrice, wkPressCount, wkStockCount, wkPressDate);
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

	//bookNum과 publisherNum 가져오기 
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
	
	//불러온 bookNum과 publisherNum을 가지고 order table에 insert하기 
	public boolean requestOrderInsert() {
		int num = 0;
		PreparedStatement ps = null;
		String query = "insert into bookstore.order (ordercount, orderrequsetdate, booknum, publishernum ) values ("+ordercount+", sysdate() ,"+booknum+","+publishernum+"); ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(query);
			
			ps.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
