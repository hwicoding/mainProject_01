package com.javalec.admin.sales;

import java.io.InputStream;

public class AdminSalesDto {

	String date;
	int totalCount;
	int totalPrice;
	String bookname;
	String publishername;
	String authorname;
	InputStream file;

	public AdminSalesDto() {

	}

	public AdminSalesDto(String date, int totalCount, int totalPrice) {
		super();
		this.date = date;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
	}

	public AdminSalesDto(String bookname, String publishername, String authorname, InputStream file) {
		super();
		this.bookname = bookname;
		this.publishername = publishername;
		this.authorname = authorname;
		this.file = file;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

}
