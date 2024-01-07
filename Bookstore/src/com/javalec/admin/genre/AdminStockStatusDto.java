package com.javalec.admin.genre;

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
	
	public AdminStockStatusDto(int booknum, String bookName, int pressPrice, int pressCount, int stockCount, String pressDate) {
		super();
		this.booknum = booknum;
		this.bookName = bookName;
		this.pressPrice = pressPrice;
		this.pressCount = pressCount;
		this.stockCount = stockCount;
		this.pressDate = pressDate;
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
	
	
}
