package com.javalec.cartorder;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.product.ProductDTO;
import com.javalec.user.UserDAO;
import com.javalec.user.UserDTO;
import com.javalec.util.ShareVar;
import com.mysql.cj.protocol.Resultset;

public class CartorderDAO {


	// Field
	   private final String url_mysql = ShareVar.dbName;
	   private final String id_mysql = ShareVar.dbUser;
	   private final String ps_mysql = ShareVar.dbPass;
	   private final String userid = ShareVar.userid;
	   String publishename,bookname,booktitle,authorname,genrekind,genreseckind,genrethirdkind;
	   int purchasecount,booknum;
	   int count,totalprice;
	
	   
	// Constructor
	   public CartorderDAO(int purchasecount, int booknum) {
		   super();
		   this.purchasecount = purchasecount;
		   this.booknum = booknum;
	   }
	
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
		   String where1 = "select cartnum, bookname, pressprice ";
		   String where2 = "from book, press, cart ";
		   String where3 = "where press.booknum = book.booknum and cart.booknum = book.booknum and userid='"+userid+"'";
		   
		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
				
				while(rs.next()) {
					int wknum = rs.getInt(1);
					String wkBookname = rs.getString(2);
					int wkTotalprice = rs.getInt(3);
					
				CartorderDTO dto = new CartorderDTO(wknum,wkBookname, wkTotalprice);
				dtoliList.add(dto);
				}
		   	    conn_mysql.close();
		   	    
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   return dtoliList;
	   }
				   
	   
	   // Table 을 Click 하였을 경우
	  public ArrayList<CartorderDTO> selectlist() {
		   
		  ArrayList<CartorderDTO> dtolist = new ArrayList<CartorderDTO>();
		  //CartorderDTO dto = null;
		  
		  
		  String query = "select publishername, bookname, booktitle, authorname, genrekind, genreseckind, genrethirdkind, pressprice, cart.booknum ";
		  String query1 = " from publisher, book, bookstore.write w, author, bookstore.register r, genre, cart, press ";
		  String query2 = " where publisher.publishernum = press.publishernum and publisher.publishernum = w.publishernum and w.authornum = author.authornum ";
		  String query3 = " and publisher.publishernum = r.publishernum and r.genrenum = genre.genrenum ";
		  String query4 = " and cart.booknum = book.booknum and book.booknum = press.booknum ";
		  
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
					int wkTotalprice = rs.getInt(8);
					int wkbooknum = rs.getInt(9);
					//String wkBookfilename = rs.getString(10);
					
//					file
//					File file = new File("./" + wkBookfilename);
//					FileOutputStream output = new FileOutputStream(file);
//					InputStream input = rs.getBinaryStream(11);
//					byte[] buffer = new byte[1024];
//					while (input.read(buffer) > 0) {
//						output.write(buffer);
					CartorderDTO dto = new CartorderDTO(wkPublishername, wkBookname, wkBooktitle, wkAuthorname, wkGenrekind, wkGenreseckind, wkGenrethirdkind, wkTotalprice,wkbooknum);
					dtolist.add(dto);
//					}
				}
				conn_mysql.close();
		  }catch(NumberFormatException e) {
				
		  } catch (Exception e) {
			e.printStackTrace();
		  }return dtolist;
		
}
	 


	public CartorderDAO(int totalprice) {
		super();
		this.totalprice = totalprice;
	}


//	// 수량에 맞춰서 금액 변경하기 
//	  public CartorderDTO showTotalInfo() {
//		  CartorderDTO dto = null;
//		  String query = "select cartcount, (cartcount*pressprice) as totalsum ";
//		  String query1 = "from cart, book, press ";
//		  String query2 = "where cart.booknum = book.booknum and press.booknum = book.booknum ";
//		  
//		  try {
//
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//
//				ResultSet rs = stmt_mysql.executeQuery(query + query1 + query2);
//				
//				if(rs.next()) {
//					int wkCartcount = rs.getInt(1);
//					int wkTotalmoney = rs.getInt(2);
//					
//					int a = wkCartcount*wkTotalmoney;
//					
//					dto = new CartorderDTO(wkCartcount, a);
//				}
//				
//				conn_mysql.close();
//	  } catch (Exception e) {
//			e.printStackTrace();
//	  
//	  	}
//		  return dto;
//	  }
	  
/*
	  public CartorderDTO a() {
		  
		  CartorderDTO dto = null;
		  
		  String query1 = "select pressprice from press,book where press.booknum = book.booknum";
		  
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql =conn_mysql.createStatement();
				
				ResultSet rs =stmt_mysql.executeQuery(query1);
				
				if(rs.next()) {
					int wkseq = rs.getInt(1);
				
				dto = new CartorderDTO(wkseq);
				}
				conn_mysql.close();
	  
	  
	  
		  }catch (Exception e) {
				// TODO: handle exception
			}return dto;
			
		}*/
		public boolean insertAction() {
			PreparedStatement ps =null;
			

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String insert =  "insert into purchase (purchasecount,purchasedate,purchasestatus,userid,booknum) ";
				String values = " values(?,now(),'"+"구매완료"+"','"+userid+"',?)";
				
				ps = conn_mysql.prepareStatement(insert+values);
				ps.setInt(1, purchasecount);
				ps.setInt(2, booknum);
				ps.executeUpdate();
				
				System.out.println(booknum);
				System.out.println(purchasecount);
				
				conn_mysql.close();}
				catch(Exception e) {
					e.printStackTrace();
					return false;
				}return true;}
	

			

	  
	 
	  
			
	  
	  
	  
}