package com.javalec.cartorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;
import com.mysql.cj.protocol.Resultset;

public class CartorderDAO {

	// Field
	   private final String url_mysql = ShareVar.dbName;
	   private final String id_mysql = ShareVar.dbUser;
	   private final String ps_mysql = ShareVar.dbPass;
	
	   String publishename,bookname,booktitle,authorname,genrekind,genreseckind,genrethirdkind;
	   int count,totalprice;
	
	   
	// Constructor
	
	   public CartorderDAO() {
		// TODO Auto-generated constructor stub
	}
	 
	  
	   public CartorderDAO(String publishename, String bookname, String booktitle, String authorname, String genrekind,
			String genreseckind, String genrethirdkind, int count, int totalprice, Exception e) {
		super();
		this.publishename = publishename;
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.authorname = authorname;
		this.genrekind = genrekind;
		this.genreseckind = genreseckind;
		this.genrethirdkind = genrethirdkind;
		this.count = count;
		this.totalprice = totalprice;

	}
			
			
	// Method
	   
	 //테이블에 정보조회되도록 select
	   public ArrayList<CartorderDTO> selecList() {
		   ArrayList<CartorderDTO> dtoliList = new ArrayList<CartorderDTO>();
	   
		   // bookname, price를 불러와야
		   String where1 = "select bookname ,pressprice ";
		   String where2 = "from book, press, cart ";
		   String where3 = "where press.booknum = book.booknum and cart.booknum = book.booknum ";
		   
		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
				
				while(rs.next()) {
					
					String wkBookname = rs.getString(1);
					int wkTotalprice = rs.getInt(2);
					
				CartorderDTO dto = new CartorderDTO(wkBookname,wkTotalprice);
				dtoliList.add(dto);
				}
		   	    conn_mysql.close();
		   	    
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   return dtoliList;
	   }
				   
	   
	   // Table 을 Click 하였을 경우
	  public CartorderDTO tableClick() {
		   
		   CartorderDTO dto = null;
		   
		String where4 = "select bookname, pressprice ";
		String where5 = "from book, press, cart ";
		String where6 = "where press.booknum = book.booknum and cart.booknum = book.booknum ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql  = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where4 + where5 + where6);
		
			while(rs.next()) {
				String wkBookname = rs.getString(1);
				int wkTotalprice = rs.getInt(2);
				
				dto = new CartorderDTO(wkBookname, wkTotalprice);
		}
		

		conn_mysql.close();
		
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	 
	   return dto;	
}

	  // table 데이터를 tf에 보내기 
	  public ArrayList<CartorderDTO> selectlist(){
		  ArrayList<CartorderDTO> dtoList = new ArrayList<CartorderDTO>();
		  
		  // publishername, bookname, booktitle, authorname, genrekind, genreseckind, genrethirdkind, count, totalprice 불러오기
		  String query = "select publishername, bookname, booktitle, authorname, genrekind, genreseckind, genrethirdkind, cartcount, pressprice ";
		  String query1 = "from publisher, book, bookstore.write w, author, bookstore.register r, genre, cart, press ";
		  String query2 = "where publisher.publishernum = press.publishernum and publisher.publishernum = w.publishernum and w.authornum = author.authornum ";
		  String query3 = "and publisher.publishernum = r.publishernum and r.genrenum = genre.genrenum ";
		  String query4 = "and cart.booknum = book.booknum and book.booknum = press.booknum ";
		  
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(query + query1 + query2 + query3 + query4);
				
				while(rs.next()) {
					
					String wkPublishername = rs.getString(1);
					String wkBookname = rs.getString(2);
					String wkBooktitle = rs.getString(3);
					String wkAuthorname = rs.getString(4);
					String wkGenrekind = rs.getString(5);
					String wkGenreseckind = rs.getString(6);
					String wkGenrethirdkind = rs.getString(7);
					int wkCount = rs.getInt(8);
					int wkTotalprice = rs.getInt(9);
				
					CartorderDTO dto = new CartorderDTO(wkPublishername, wkBookname, wkBooktitle, wkAuthorname, wkGenrekind, wkGenreseckind, wkGenrethirdkind, wkCount, wkTotalprice);
					dtoList.add(dto);
				}
				conn_mysql.close();
				
		  } catch (Exception e) {
			e.printStackTrace();
		}
		  return dtoList;
	  }
}
