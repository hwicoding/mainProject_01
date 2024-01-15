package com.javalec.admin.stock;

public class AdminStockStatusDto {

	int genrenum;
	String genrekind;
	String genreseckind;
	String genrethirdkind;
	String genrestatus;
	String bookName;
	int pressPrice;
	int pressCount;
	int stockCount;
	String pressDate;
	int booknum;
	int publishernum;
	String authorname;
	String publishername;
	String bookstatus;
	String booktitle;

	public AdminStockStatusDto(String publishername) {
		super();
		this.publishername = publishername;
	}

	public AdminStockStatusDto(String bookName, int pressPrice) {
		super();
		this.bookName = bookName;
		this.pressPrice = pressPrice;
	}

	public AdminStockStatusDto(String bookName, String authorname, String publishername, int pressPrice, int stockCount,
			String bookstatus, String pressDate, String booktitle) {
		super();
		this.bookName = bookName;
		this.authorname = authorname;
		this.publishername = publishername;
		this.pressPrice = pressPrice;
		this.stockCount = stockCount;
		this.bookstatus = bookstatus;
		this.pressDate = pressDate;
		this.booktitle = booktitle;
	}

	public String getAuthorname() {
		return authorname;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public AdminStockStatusDto(int booknum, int publishernum) {
		super();
		this.booknum = booknum;
		this.publishernum = publishernum;
	}

	public int getPublishernum() {
		return publishernum;
	}

	public void setPublishernum(int publishernum) {
		this.publishernum = publishernum;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	public int getGenrenum() {
		return genrenum;
	}

	public void setGenrenum(int genrenum) {
		this.genrenum = genrenum;
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

	public String getGenrestatus() {
		return genrestatus;
	}

	public void setGenrestatus(String genrestatus) {
		this.genrestatus = genrestatus;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPressPrice() {
		return pressPrice;
	}

	public void setPressPrice(int pressPrice) {
		this.pressPrice = pressPrice;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public String getPressDate() {
		return pressDate;
	}

	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}

	public int getPressCount() {
		return pressCount;
	}

	public void setPressCount(int pressCount) {
		this.pressCount = pressCount;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

}
