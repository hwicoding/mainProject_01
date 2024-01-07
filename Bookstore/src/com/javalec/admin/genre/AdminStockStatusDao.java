package com.javalec.admin.genre;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public AdminStockStatusDao() {

	}

	// 테이블 조회 메소드
	public ArrayList<AdminStockStatusDto> searchAction() {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		// presscount 1개는 재고로 바꿔줘야
		String query1 = "select b.booknum, b.bookname, p.pressprice, p.presscount, p.presscount, date(p.pressdate) from genre g , book b, press p, register r ";
		String query2 = " where p.booknum = b.booknum and r.booknum = p.booknum and r.booknum = b.booknum and r.genrenum = g.genrenum and g.genrestatus = '진행중' and b.bookstatus='판매중' order by b.booknum";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2);

			while (rs.next()) {
				int wkBooknum = rs.getInt(1);
				String wkBookName = rs.getString(2);
				int wkPressPrice = rs.getInt(3);
				int wkPressCount = rs.getInt(4);
				int wkStockCount = rs.getInt(5);
				String wkPressDate = rs.getString(6);

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBooknum, wkBookName, wkPressPrice, wkPressCount, wkStockCount,
						wkPressDate);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 책제목으로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToBookName(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.booknum, b.bookname, p.pressprice, p.presscount, p.presscount, date(p.pressdate) from genre g , book b, press p, register r ";
		String query2 = " where p.booknum = b.booknum and r.booknum = p.booknum and r.booknum = b.booknum and r.genrenum = g.genrenum and g.genrestatus = '진행중' ";
		String query3 = " and b.bookstatus='판매중' and b.bookname like '%" + str + "%' order by b.booknum";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 + query3);

			while (rs.next()) {
				int wkBooknum = rs.getInt(1);
				String wkBookName = rs.getString(2);
				int wkPressPrice = rs.getInt(3);
				int wkPressCount = rs.getInt(4);
				int wkStockCount = rs.getInt(5);
				String wkPressDate = rs.getString(6);
				System.out.println("dddd");

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBooknum, wkBookName, wkPressPrice, wkPressCount, wkStockCount,
						wkPressDate);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 입고일로 검색
	public ArrayList<AdminStockStatusDto> searchConditionToPressDate(String str) {
		ArrayList<AdminStockStatusDto> dtoList = new ArrayList<AdminStockStatusDto>();

		String query1 = "select b.booknum, b.bookname, p.pressprice, p.presscount, p.presscount, date(p.pressdate) from genre g , book b, press p, register r ";
		String query2 = " where p.booknum = b.booknum and r.booknum = p.booknum and r.booknum = b.booknum and r.genrenum = g.genrenum and g.genrestatus = '진행중' ";
		String query3 = " and b.bookstatus='판매중' and p.pressdate like '%" + str + "%' order by b.booknum";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query1 + query2 + query3);

			while (rs.next()) {
				int wkBooknum = rs.getInt(1);
				String wkBookName = rs.getString(2);
				int wkPressPrice = rs.getInt(3);
				int wkPressCount = rs.getInt(4);
				int wkStockCount = rs.getInt(5);
				String wkPressDate = rs.getString(6);
				System.out.println("dddd");

				AdminStockStatusDto dto = new AdminStockStatusDto(wkBooknum, wkBookName, wkPressPrice, wkPressCount, wkStockCount,
						wkPressDate);
				dtoList.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
