package com.javalec.cartorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.product.ProductDTO;
import com.javalec.user.UserDAO;
import com.javalec.util.ShareVar;
import com.mysql.cj.protocol.Resultset;

public class CartorderDAO {

	// Field
	   private final String url_mysql = ShareVar.dbName;
	   private final String id_mysql = ShareVar.dbUser;
	   private final String ps_mysql = ShareVar.dbPass;
	
	   String publishename,bookname,booktitle,authorname,genrekind;
	   int cartcount,totalprice;
	
	   
	// Constructor
	
	   public CartorderDAO() {
		// TODO Auto-generated constructor stub
	}
	 
	  
	   public CartorderDAO(String publishename, String bookname, String booktitle, String authorname, String genrekind,
			               int cartcount, int totalprice, Exception e) {
		super();
		this.publishename = publishename;
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.authorname = authorname;
		this.genrekind = genrekind;
		this.cartcount = cartcount;
		this.totalprice = totalprice;

	}
			
			
	// Method
	   
	 //테이블에 정보조회되도록 select
	   public ArrayList<CartorderDTO> selecList() {
		   ArrayList<CartorderDTO> dtoliList = new ArrayList<CartorderDTO>();
	   
		   // bookname, price를 불러와야
		   String where1 = "select bookname , booktitle, pressprice ";
		   String where2 = "from book, press, cart ";
		   String where3 = "where press.booknum = book.booknum and cart.booknum = book.booknum ";
		   
		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
				
				while(rs.next()) {
					
					String wkBookname = rs.getString(1);
					String wkBooktitle = rs.getString(2);
					int wkTotalprice = rs.getInt(3);
					
				CartorderDTO dto = new CartorderDTO(wkBookname,wkBooktitle,wkTotalprice);
				dtoliList.add(dto);
				}
		   	    conn_mysql.close();
		   	    
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   return dtoliList;
	   }
				   
	   
	   // Table 을 Click 하였을 경우
	  public CartorderDTO tableclick() {
		     CartorderDTO dto = null;
		  
		  String query = "select publishername, bookname, booktitle, authorname, genrekind, cartcount, (cartcount*pressprice) as totalsum ";
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
					int wkCartcount = rs.getInt(6);
					int wkTotalprice = rs.getInt(7);
					
					
//					file
//					File file = new File("./" + wkBookfilename);
//					FileOutputStream output = new FileOutputStream(file);
//					InputStream input = rs.getBinaryStream(11);
//					byte[] buffer = new byte[1024];
//					while (input.read(buffer) > 0) {
//						output.write(buffer);
//					}
					dto = new CartorderDTO(wkPublishername, wkBookname, wkBooktitle, wkAuthorname, wkGenrekind, wkCartcount, wkTotalprice);
				}
				conn_mysql.close();
			 } catch (Exception e) {
			e.printStackTrace();
		  }
		  return dto;
	}
	 
	  // 수량에 맞춰서 금액 변경하기 
	  public CartorderDTO showTotalInfo() {
		  CartorderDTO dto = null;
		  String query = "select (cartcount*pressprice) as totalsum ";
		  String query1 = "from cart, book, press ";
		  String query2 = "where cart.booknum = book.booknum and press.booknum = book.booknum ";
		  
		  try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(query + query1 + query2);
				
				if(rs.next()) {
					int wkCartcount = rs.getInt(1);
					int wkTotalmoney = rs.getInt(2);
					
					int a = wkCartcount*wkTotalmoney;
					
					dto = new CartorderDTO(wkCartcount, a);
				}
				
				conn_mysql.close();
	  } catch (Exception e) {
			e.printStackTrace();
	  
	  	}
		  return dto;
	  }
	  
	  public void insertCartInfo() {
		  PreparedStatement ps = null;
		  
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String
				String
				
				ps = conn_mysql.prepareStatement(query);
				ps.executeUpdate();
				
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return true;
		}
	  }
	  

	  

	  
	 
	  

