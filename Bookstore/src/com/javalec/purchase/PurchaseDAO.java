package com.javalec.purchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.cartorder.CartorderDTO;
import com.javalec.util.ShareVar;

public class PurchaseDAO {

	//	Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String ps_mysql = ShareVar.dbPass;
	
	int purchasedate, totalprice, purchasecount;
	String purchasedetails, purchasestatus;
	
	
	//	constructor
	
	public PurchaseDAO() {
		// TODO Auto-generated constructor stub
	}


	public PurchaseDAO(int purchasedate, String purchasedetails, int totalprice) {
		super();
		this.purchasedate = purchasedate;
		this.purchasedetails = purchasedetails;
		this.totalprice = totalprice;
	}


	public PurchaseDAO(int purchasedate, int totalprice, int purchasecount, String purchasedetails,
			String purchasestatus) {
		super();
		this.purchasedate = purchasedate;
		this.totalprice = totalprice;
		this.purchasecount = purchasecount;
		this.purchasedetails = purchasedetails;
		this.purchasestatus = purchasestatus;
	}
	
	// Method
	
	//테이블에 정보조회되도록 select
	   public ArrayList<PurchaseDTO> selecList() {
		   ArrayList<PurchaseDTO> dtoList = new ArrayList<PurchaseDTO>();
	   
		   // purchasedate, purchasedetails, totalprice를 가져오기
		   String where1 = "select purchasedate, bookname, cartcount, (pressprice*cartcount) as totalsum ";
		   String where2 = "from purchase, press, book, cart ";
		   String where3 = "where purchase.booknum = book.booknum and press.booknum = book.booknum and cart.booknum = book.booknum ";
		   
		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
				
				while(rs.next()) {
					
					int wkPurchasedate = rs.getInt(1);
					String wkBookname = rs.getString(2);
					int wkCartcount = rs.getInt(3);
					int wkTotalsum = rs.getInt(4);
					
					PurchaseDTO dto = new PurchaseDTO(wkPurchasedate, wkBookname, wkCartcount, wkTotalsum);
					dtoList.add(dto);
				
				
				}
		   	    conn_mysql.close();
		   	    
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   return dtoList;
	   }
	
	
	
	
	
	
	
	
	
}
