package com.javalec.purchase;

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


	public PurchaseDAO(int purchasedate, String purchasedetails, int totalprice, String purchasestatus) {
		super();
		this.purchasedate = purchasedate;
		this.purchasedetails = purchasedetails;
		this.totalprice = totalprice;
		this.purchasestatus = purchasestatus;
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
	
	
	
	
	
	
	
	
	
	
	
}
