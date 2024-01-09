package com.javalec.product;

public class ProductDTO {
	
//	Field
	String bookname, genrekind, genreseckind, genrethirdkind, authorname, translatorname, publishername;
	int pressprice;
	
//	constructor
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String bookname, String genrekind, String genreseckind, 
								   String genrethirdkind, String authorname,
								   String translatorname, String publishername, int pressprice) {
								   super();
								   this.bookname = bookname;
								   this.genrekind = genrekind;
								   this.genreseckind = genreseckind;
								   this.genrethirdkind = genrethirdkind;
								   this.authorname = authorname;
								   this.translatorname = translatorname;
								   this.publishername = publishername;
								   this.pressprice = pressprice;
	}
	
//	Method
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
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

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getTranslatorname() {
		return translatorname;
	}

	public void setTranslatorname(String translatorname) {
		this.translatorname = translatorname;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public int getPressprice() {
		return pressprice;
	}

	public void setPressprice(int pressprice) {
		this.pressprice = pressprice;
	}
	
}
