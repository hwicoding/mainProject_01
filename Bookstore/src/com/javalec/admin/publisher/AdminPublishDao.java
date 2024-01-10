package com.javalec.admin.publisher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.admin.stock.AdminStockStatusDto;
import com.javalec.util.ShareVar;

public class AdminPublishDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;

	String publishername;
	String publishertelno;
	String publisheremail;
	String authorname;
	String authortelno;
	String authoremail;

	public AdminPublishDao() {

	}

	// 메뉴 클릭 시 테이블 조회 메소드
	public ArrayList<AdminPublishDto> searchAction() {
		ArrayList<AdminPublishDto> dtoList = new ArrayList<AdminPublishDto>();

		String query1 = "select pub.publishername, pub.publishertelno, pub.publisheremail, a.authorname, a.authortelno, a.authoremail from publisher pub, bookstore.write w, author a ";
		String query2 = " where w.publishernum = pub.publishernum and a.authornum = w.authornum and pub.publisherstatus = '계약중' and a.authorstatus = '계약중'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkPublisherName = rs.getString(1);
				String wkPubTelNo = rs.getString(2);
				String wkPubEmail = rs.getString(3);
				String wkAuthorName = rs.getString(4);
				String wkAuthorTelNo = rs.getString(5);
				String wkAuthorEmail = rs.getString(6);

				AdminPublishDto dto = new AdminPublishDto(wkPublisherName, wkPubTelNo, wkPubEmail, wkAuthorName,
						wkAuthorTelNo, wkAuthorEmail);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 출판사명으로 검색
	public ArrayList<AdminPublishDto> searchConditionToPublisher(String str) {
		ArrayList<AdminPublishDto> dtoList = new ArrayList<AdminPublishDto>();

		String query1 = "select pub.publishername, pub.publishertelno, pub.publisheremail, a.authorname, a.authortelno, a.authoremail from publisher pub, bookstore.write w, author a ";
		String query2 = " where w.publishernum = pub.publishernum and a.authornum = w.authornum and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' and pub.publishername like '%"
				+ str + "%'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkPublisherName = rs.getString(1);
				String wkPubTelNo = rs.getString(2);
				String wkPubEmail = rs.getString(3);
				String wkAuthorName = rs.getString(4);
				String wkAuthorTelNo = rs.getString(5);
				String wkAuthorEmail = rs.getString(6);

				AdminPublishDto dto = new AdminPublishDto(wkPublisherName, wkPubTelNo, wkPubEmail, wkAuthorName,
						wkAuthorTelNo, wkAuthorEmail);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 출판사명으로 검색
	public ArrayList<AdminPublishDto> searchConditionToAuthor(String str) {
		ArrayList<AdminPublishDto> dtoList = new ArrayList<AdminPublishDto>();

		String query1 = "select pub.publishername, pub.publishertelno, pub.publisheremail, a.authorname, a.authortelno, a.authoremail from publisher pub, bookstore.write w, author a ";
		String query2 = " where w.publishernum = pub.publishernum and a.authornum = w.authornum and pub.publisherstatus = '계약중' and a.authorstatus = '계약중' and a.authorname like '%"
				+ str + "%'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				String wkPublisherName = rs.getString(1);
				String wkPubTelNo = rs.getString(2);
				String wkPubEmail = rs.getString(3);
				String wkAuthorName = rs.getString(4);
				String wkAuthorTelNo = rs.getString(5);
				String wkAuthorEmail = rs.getString(6);

				AdminPublishDto dto = new AdminPublishDto(wkPublisherName, wkPubTelNo, wkPubEmail, wkAuthorName,
						wkAuthorTelNo, wkAuthorEmail);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
