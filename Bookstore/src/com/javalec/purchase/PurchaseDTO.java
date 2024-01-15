package com.javalec.purchase;

public class PurchaseDTO {
	
	//	Field
	
	int purchasedate, totalprice, purchasecount, totalsum, cartcount;
	String purchasedetails, purchasestatus, bookname;
	
	
	//	constructor
	
	public PurchaseDTO() {
		// TODO Auto-generated constructor stub
	}


	
	public PurchaseDTO(int purchasedate, String bookname, int cartcount, int totalsum) {
		super();
		this.purchasedate = purchasedate;
		this.bookname = bookname;
		this.cartcount = cartcount;
		this.totalsum = totalsum;
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



	public int getTotalsum() {
		return totalsum;
	}



	public void setTotalsum(int totalsum) {
		this.totalsum = totalsum;
	}



	public int getCartcount() {
		return cartcount;
	}



	public void setCartcount(int cartcount) {
		this.cartcount = cartcount;
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



	public String getBookname() {
		return bookname;
	}



	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	
	
}
