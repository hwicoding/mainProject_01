package com.javalec.cartorder;

import java.io.File;

public class CartorderDTO {

	String publishename, bookfilename, bookname, booktitle, authorname, genrekind, genreseckind, genrethirdkind;
	int totalprice, count, cartcount, totalMoney;
	File bookimg;
	
	public CartorderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	// outtable
	public CartorderDTO(String bookname, String booktitle, int totalprice) {
		super();
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.totalprice = totalprice;
	}

    
	public CartorderDTO(String publishename, String bookname, String booktitle, String authorname, String genrekind,
						int cartcount, int totalprice) {
		super();
		this.publishename = publishename;
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.authorname = authorname;
		this.genrekind = genrekind;
		this.cartcount = cartcount;
		this.totalprice = totalprice;
		
	}
	

	public CartorderDTO(String publishename, String bookfilename, String bookname, String booktitle, String authorname,
			String genrekind, String genreseckind, String genrethirdkind, int count, int totalprice, int cartcount,
			int totalMoney, File bookimg) {
		super();
		this.publishename = publishename;
		this.bookfilename = bookfilename;
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.authorname = authorname;
		this.genrekind = genrekind;
		this.genreseckind = genreseckind;
		this.genrethirdkind = genrethirdkind;
		this.count = count;
		this.totalprice = totalprice;
		this.cartcount = cartcount;
		this.totalMoney = totalMoney;
		this.bookimg = bookimg;
	}


	public CartorderDTO(int cartcount, int totalMoney) {
		super();
		this.cartcount = cartcount;
		this.totalMoney = totalMoney;
	}

	public String getPublishename() {
		return publishename;
	}

	public void setPublishename(String publishename) {
		this.publishename = publishename;
	}

	public String getBookfilename() {
		return bookfilename;
	}

	public void setBookfilename(String bookfilename) {
		this.bookfilename = bookfilename;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getGenrekind() {
		return genrekind;
	}

	public void setGenrekind(String genrekind) {
		this.genrekind = genrekind;
	}

	public String getGenreseckind() {
		return genreseckind;
	}

	public void setGenreseckind(String genreseckind) {
		this.genreseckind = genreseckind;
	}

	public String getGenrethirdkind() {
		return genrethirdkind;
	}

	public void setGenrethirdkind(String genrethirdkind) {
		this.genrethirdkind = genrethirdkind;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getCartcount() {
		return cartcount;
	}

	public void setCartcount(int cartcount) {
		this.cartcount = cartcount;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public File getBookimg() {
		return bookimg;
	}

	public void setBookimg(File bookimg) {
		this.bookimg = bookimg;
	}

}
