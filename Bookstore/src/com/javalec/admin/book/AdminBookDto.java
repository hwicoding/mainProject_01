package com.javalec.admin.book;

import java.io.FileInputStream;

public class AdminBookDto {

	String bookname;
	String authorname;
	String publishername;
	int presspirce;
	String booksubtitle;
	String bookcontent;
	FileInputStream file;
	int presscount;
	int publishernum;
	int booknum;
	String booktitle;
	String bookstatus;

	public AdminBookDto() {

	}
	

	public AdminBookDto(String bookname, String authorname, String publishername, int presspirce, String bookstatus, String booktitle) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.publishername = publishername;
		this.presspirce = presspirce;
		this.bookstatus = bookstatus;
		this.booktitle = booktitle;
	}


	public AdminBookDto(String bookname, String booktitle, String publishername, int presscount, int presspirce, String bookstatus ) {
		super();
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.publishername = publishername;
		this.presscount = presscount;
		this.presspirce = presspirce;
		this.bookstatus = bookstatus;
	}
	
	public AdminBookDto(String bookname, String booktitle, int presscount, int presspirce, String bookstatus, String bookcontent) {
		super();
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.presscount = presscount;
		this.presspirce = presspirce;
		this.bookstatus = bookstatus;
		this.bookcontent = bookcontent;
	}
	
	
	public String getBookstatus() {
		return bookstatus;
	}


	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}


	public String getBooktitle() {
		return booktitle;
	}


	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public int getPresspirce() {
		return presspirce;
	}

	public void setPresspirce(int presspirce) {
		this.presspirce = presspirce;
	}


	public String getBooksubtitle() {
		return booksubtitle;
	}


	public void setBooksubtitle(String booksubtitle) {
		this.booksubtitle = booksubtitle;
	}


	public String getBookcontent() {
		return bookcontent;
	}


	public void setBookcontent(String bookcontent) {
		this.bookcontent = bookcontent;
	}


	public FileInputStream getFile() {
		return file;
	}


	public void setFile(FileInputStream file) {
		this.file = file;
	}


	public int getPresscount() {
		return presscount;
	}


	public void setPresscount(int presscount) {
		this.presscount = presscount;
	}


	public int getPublishernum() {
		return publishernum;
	}


	public void setPublishernum(int publishernum) {
		this.publishernum = publishernum;
	}


	public int getBooknum() {
		return booknum;
	}


	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	
}
