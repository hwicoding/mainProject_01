package com.javalec.purchase;

public class PurchaseDTO {
	
	//	Field
	
	int purchasedate, totalprice, purchasecount;
	String purchasedetails, purchasestatus;
	
	
	//	constructor
	
	public PurchaseDTO() {
		// TODO Auto-generated constructor stub
	}


	public PurchaseDTO(int purchasedate, String purchasedetails, int totalprice, String purchasestatus) {
		super();
		this.purchasedate = purchasedate;
		this.purchasedetails = purchasedetails;
		this.totalprice = totalprice;
		this.purchasestatus = purchasestatus;
	}


	public PurchaseDTO(int purchasedate, int totalprice, int purchasecount, String purchasedetails,
			String purchasestatus) {
		super();
		this.purchasedate = purchasedate;
		this.totalprice = totalprice;
		this.purchasecount = purchasecount;
		this.purchasedetails = purchasedetails;
		this.purchasestatus = purchasestatus;
	}


	public int getPurchasedate() {
		return purchasedate;
	}


	public void setPurchasedate(int purchasedate) {
		this.purchasedate = purchasedate;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


	public int getPurchasecount() {
		return purchasecount;
	}


	public void setPurchasecount(int purchasecount) {
		this.purchasecount = purchasecount;
	}


	public String getPurchasedetails() {
		return purchasedetails;
	}


	public void setPurchasedetails(String purchasedetails) {
		this.purchasedetails = purchasedetails;
	}


	public String getPurchasestatus() {
		return purchasestatus;
	}


	public void setPurchasestatus(String purchasestatus) {
		this.purchasestatus = purchasestatus;
	}
	
	
}
