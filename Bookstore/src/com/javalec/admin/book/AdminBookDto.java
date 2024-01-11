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

	public AdminBookDto() {

	}
	

	public AdminBookDto(String bookname, String authorname, String publishername, int presspirce) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.publishername = publishername;
		this.presspirce = presspirce;
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
