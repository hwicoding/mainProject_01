package com.javalec.cartorder;

public class CartorderDTO {

	String publishename,bookname,booktitle,authorname,genrekind,genreseckind,genrethirdkind;
	int count,totalprice;
	
	
	public CartorderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	// outtable
	public CartorderDTO(String bookname, int totalprice) {
		super();
		this.bookname = bookname;
		this.totalprice = totalprice;
	}

    
	public CartorderDTO(String publishename, String bookname, String booktitle, String authorname, String genrekind,
			String genreseckind, String genrethirdkind, int count, int totalprice) {
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
	
	public CartorderDTO(String publishename, String bookname, String booktitle, String authorname, String genrekind,
			int totalprice, String genreseckind, String genrethirdkind, int count) {
		super();
		this.publishename = publishename;
		this.bookname = bookname;
		this.booktitle = booktitle;
		this.authorname = authorname;
		this.genrekind = genrekind;
		this.totalprice = totalprice;
		this.genreseckind = genreseckind;
		this.genrethirdkind = genrethirdkind;
		this.count = count;
	}

	public String getPublishename() {
		return publishename;
	}

	public void setPublishename(String publishename) {
		this.publishename = publishename;
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

	
	
	
}
