package com.javalec.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;

public class ProductDAO {
	
//	Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String ps_mysql = ShareVar.dbPass;
	
//	constructor
	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
//	Method

//	검색 결과를 Table 로 보내자
	public ArrayList<ProductDTO> selecList(){
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		
		String select_01 = "select bookname, genrekind, genreseckind, ";
		String select_02 = "genrethirdkind, authorname, translatorname, publishername, pressprice ";
		String from_01 = "from book b, press p, publisher pub, bookstore.write w, ";
		String from_02 = "author a, translator ttor, translate tte, genre g, register r ";
		String where_01 = "where pub.publishernum = w.publishernum and w.authornum = a.authornum ";
		String where_02 = "and pub.publishernum = tte.publishernum and tte.translatornum = ttor.translatornum ";
		String where_03 = "and b.booknum = p.booknum and p.publishernum = pub.publishernum ";
		String where_04 = "and g.genrenum = r.genrenum and pub.publishernum = r.publishernum";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(select_01 + select_02 +
					 														from_01 + from_02 + 
					 														where_01 + where_02 + 
					 														where_03 +where_04);
			while(rs.next()) {
				
				String bookname = rs.getString(1);
				String genrekind = rs.getString(2);
				String genreseckind = rs.getString(3);
				String genrethirdkind = rs.getString(4);
				String authorname = rs.getString(5);
				String translatorname = rs.getString(6);
				String publishername = rs.getString(7);
				int pressprice = rs.getInt(8);

				ProductDTO dto = new ProductDTO(bookname, genrekind, genreseckind,
						genrethirdkind, authorname, translatorname, publishername, pressprice);
				dtoList.add(dto);

				
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}

}
