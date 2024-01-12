package com.javalec.admin.sales;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.admin.book.AdminBookDto;
import com.javalec.util.ShareVar;

public class AdminSalesDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;

	String date;
	int totalCount;
	int totalPrice;

	// 메뉴 클릭 시 테이블 조회 메소드
	public ArrayList<AdminSalesDto> searchAction() {
		ArrayList<AdminSalesDto> dtoList = new ArrayList<AdminSalesDto>();

		String query1 = "select pur.purchasedate, sum(purchasecount), sum(purchasecount * p.pressprice) from purchase pur, book b, press p where pur.booknum = b.booknum and b.booknum = p.booknum group by purchasedate order by purchasedate desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				String wkDate = rs.getString(1);
				int wkTotalCount = rs.getInt(2);
				int wkTotalPrice = rs.getInt(3);

				AdminSalesDto dto = new AdminSalesDto(wkDate, wkTotalCount, wkTotalPrice);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 날짜 검색
	public ArrayList<AdminSalesDto> searchDate(String str) {
		ArrayList<AdminSalesDto> dtoList = new ArrayList<AdminSalesDto>();

		String query1 = "select pur.purchasedate, sum(purchasecount), sum(purchasecount * p.pressprice) from purchase pur, book b, press p where pur.booknum = b.booknum and b.booknum = p.booknum and pur.purchasedate like '%"
				+ str + "%' group by purchasedate order by purchasedate desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				String wkDate = rs.getString(1);
				int wkTotalCount = rs.getInt(2);
				int wkTotalPrice = rs.getInt(3);

				AdminSalesDto dto = new AdminSalesDto(wkDate, wkTotalCount, wkTotalPrice);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 베스트 top5 검색
	public ArrayList<AdminSalesDto> searchBestBook() {
		ArrayList<AdminSalesDto> dtoList = new ArrayList<AdminSalesDto>();

		 String query1 = "select b.bookimage, b.bookname, pub.publishername, a.authorname from purchase pur, book b, publisher pub, press p, author a, bookstore.write w ";
		 String query2 = " where pur.booknum = b.booknum and b.booknum = p.booknum and pub.publishernum = p.publishernum and w.publishernum = pub.publishernum and a.authornum = w.authornum order by purchasecount desc";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1+query2);

			while (rs.next()) {
				String wkBookName = rs.getString(2);
				String wkPublishername = rs.getString(3);
				String wkAuthorname = rs.getString(4);
				
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(1);
				
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				AdminSalesDto dto = new AdminSalesDto(wkBookName, wkPublishername, wkAuthorname, input);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
