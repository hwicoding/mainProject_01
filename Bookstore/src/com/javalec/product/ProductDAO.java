package com.javalec.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.javalec.util.ShareVar;

public class ProductDAO {
	
//	Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String ps_mysql = ShareVar.dbPass;
	private final String userid = ShareVar.userid;
	
	String bookname, bookfilename, genrekind, genreseckind, genrethirdkind, authorname, translatorname, publishername;
	int booknum, pressprice;
	File bookimg;
	
//	constructor
	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
public ProductDAO(String bookname, String bookfilename, String genrekind, String genreseckind, String genrethirdkind,
		String authorname, String translatorname, String publishername, int pressprice, File bookimg) {
	super();
	this.bookname = bookname;
	this.bookfilename = bookfilename;
	this.genrekind = genrekind;
	this.genreseckind = genreseckind;
	this.genrethirdkind = genrethirdkind;
	this.authorname = authorname;
	this.translatorname = translatorname;
	this.publishername = publishername;
	this.pressprice = pressprice;
	this.bookimg = bookimg;
}


public ProductDAO(int booknum) {
	super();
	this.booknum = booknum;
}


//	Method

	//	검색 결과를 Table 로 보내자
	public ArrayList<ProductDTO> selecList(){
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		
		String select_01 = "select b.booknum, bookimage, bookname, bookfilename, booktitle, bookcontents, genrekind, genreseckind, ";
		String select_02 = "genrethirdkind, authorname, translatorname, publishername, pressprice ";
		String from_01 = "from book b, press p, publisher pub, bookstore.write w, ";
		String from_02 = "author a, translator ttor, translate tte, genre g, register r ";
		String where_01 = "where pub.publishernum = w.publishernum and w.authornum = a.authornum ";
		String where_02 = "and pub.publishernum = tte.publishernum and tte.translatornum = ttor.translatornum ";
		String where_03 = "and b.booknum = p.booknum and p.publishernum = pub.publishernum ";
		String where_04 = "and g.genrenum = r.genrenum and pub.publishernum = r.publishernum";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(select_01 + select_02 +
					 														from_01 + from_02 + 
					 														where_01 + where_02 + 
					 														where_03 +where_04);		
			
			while(rs.next()) {

				int booknum = rs.getInt(1);
				String bookname = rs.getString(3);
				String bookfilename = rs.getString(4);
				String booktitle = rs.getString(5);
				String bookcontents = rs.getString(6);
				String genrekind = rs.getString(7);
				String genreseckind = rs.getString(8);
				String genrethirdkind = rs.getString(9);
				String authorname = rs.getString(10);
				String translatorname = rs.getString(11);
				String publishername = rs.getString(12);
				int pressprice = rs.getInt(13);
				
//				file
				File file = new File("./" + bookfilename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				ProductDTO dto = new ProductDTO(booknum, bookname, bookfilename, booktitle,
						                                                  bookcontents, genrekind, genreseckind,
						                                                  genrethirdkind, authorname,
						                                                  translatorname, publishername, pressprice);

				dtoList.add(dto);

				
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}
	
	
	public boolean insertinfo(Integer booknum) {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String insert =  "insert into cart (userid, booknum) ";
			String values = "values('" + userid + "', " + booknum + ")";
			
			ps = conn_mysql.prepareStatement(insert + values);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;

	}

}
