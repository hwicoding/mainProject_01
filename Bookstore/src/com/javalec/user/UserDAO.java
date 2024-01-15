package com.javalec.user;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.javalec.util.ShareVar;

public class UserDAO {
	
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql=ShareVar.dbUser;
	private final String pw_mysql=ShareVar.dbPass;
	private static final String SECRET_KEY = "mysecretkey1234";
    private static final String SALT = "mysalt";
	
	String userid;
	String userpw;
	String username;
	String userphone;
	String useremail;
	String useraddress;
	String userinsert;
	String userupdate;
	String userdelete;
	
	
public UserDAO(){
		
	}



	//중요! -- 회원가입 데이터 들어가는 것.
	public UserDAO(String userid, String userpw, String username, String useremail, String userphone, String userinsert) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.userinsert = userinsert;
	}



	public UserDAO(String userid, String userpw, String username, String useremail, String userphone) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
	}

	public UserDAO(String userid, String userpw, String username, String userphone) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphone = userphone;
	}


	
	

	public UserDAO(String userid, String userdelete) {
		super();
		this.userid = userid;
		this.userdelete = userdelete;
	}



	public UserDAO(String userupdate) {
		super();
		this.userupdate = userupdate;
	}
	public ArrayList<UserDTO> confirm(String id, String pw){
		ArrayList<UserDTO> dtolist1 = new ArrayList<UserDTO>();
		String query = "select userid,userpassword,username,useremail,usertelno,userdeletedate from user";
		String query1=" where userid='"+id+"' and userpassword='"+pw+"'and userdeletedate is null";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			ResultSet rs =stmt_mysql.executeQuery(query+query1);
			
			while(rs.next()) {
				/*SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
	            SecretKey tmp = factory.generateSecret(spec);
	            SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
	            Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.DECRYPT_MODE, secret);

				byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(pw));
				pw =  new String(decryptedBytes);*/
				String wkid = rs.getString(1);
				String wkpw=rs.getString(2);
				String wkname = rs.getString(3);
				String wkemail = rs.getString(4);
				String wktelno = rs.getString(5);
				String wkdel = rs.getString(6);
				
				UserDTO dto = new UserDTO(wkid,wkpw,wkname,wkemail,wktelno,wkdel);
				dtolist1.add(dto);
			
		
				}
			conn_mysql.close();
			
		}catch (Exception e) {
	
		}return dtolist1;}
	
	
	public boolean check() {
		String login = "";
		UserDTO dto = null;  // arraylist안쓰고 null값으로 표현한다. //위에서 선언해야 try문 밖에서도 사용가능.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			HashMap<String, String> memberlist = new HashMap<>();
			
			String where1 = "select userid,userpassword from user"; //실행할 쿼리
			
			ResultSet rs =stmt_mysql.executeQuery(where1);  //whereDefault 실행
			
			//while(rs.next()) {
			while(rs.next()) {
				String[] qTxt = {rs.getString(1),rs.getString(2)};
				memberlist.put(qTxt[0], qTxt[1]);

				
			}
			for(String key : memberlist.keySet()) {
					if(userid.equals(key.trim())){
						login = "중복";
					}
					conn_mysql.close();
				}
				
			}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		if(login.equals("중복")) {
			return false;
		}else {
			return true;
		}}
	
	//중요 !  -- 회원가입 날짜 구하는 법!!
	public boolean insertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			String A = "insert into user(userid,userpassword,username,useremail,usertelno,userinsertdate)"; //실행할 쿼리
			String B=" values(?,?,?,?,?,now())";
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, userid);
			
			/*SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(userpw.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secret);

            byte[] encryptedBytes = cipher.doFinal(userpw.getBytes());
            userpw =  Base64.getEncoder().encodeToString(encryptedBytes);*/
			
			/* Cipher cipher = Cipher.getInstance("AES");
	            /*SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			/*MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(userpw.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b :hash) {
				sb.append(String.format("%02X", b));
				userpw = sb.toString();*/
				ps.setString(2, userpw);
			
			ps.setString(3, username);
			ps.setString(4, useremail);
			ps.setString(5, userphone);
			ps.executeUpdate();
			
			conn_mysql.close();

			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}return true;
		}
	
	public UserDTO Action2() {
		//데이터 하나씩만 받을거라 arraylist안씀
		
		UserDTO dto = null;  // arraylist안쓰고 null값으로 표현한다. //위에서 선언해야 try문 밖에서도 사용가능.
		
		String where1 = "select userid,userpassword,username,useremail,usertelno from user"; //실행할 쿼리
		String where2=" where userid='"+ShareVar.userid+"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			ResultSet rs =stmt_mysql.executeQuery(where1+where2);  //whereDefault 실행
			
			//while(rs.next()) {
			while(rs.next()) {
				String wkid = rs.getString(1);
				String wkpw=rs.getString(2);
				String wkname=rs.getString(3);
				String wkemail=rs.getString(4);
				String wktelno = rs.getString(5);
				
				dto = new UserDTO(wkid, wkpw, wkname, wkemail, wktelno);  // dto에 이 값을 한번에 저장한다.
			}
			conn_mysql.close();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}return dto;
		

		
	}
	//중요 ! -- 업데이트 날짜 들어감.
	public boolean updateAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			String A = "update user set userpassword=?, username=?, useremail=?, usertelno=?,userupdate=now()"; //실행할 쿼리
			String B=" where userid=?";
			ps = conn_mysql.prepareStatement(A+B);
			
			ps.setString(1, userpw);
			ps.setString(2, username);
			ps.setString(3, useremail);
			ps.setString(4, userphone);
			ps.setString(5, userid);
			ps.executeUpdate();
			
			conn_mysql.close();

			}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}return true;}
	
	//중요!!! -- 회원 탈퇴 날짜 설정기능.
	public boolean delAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			String A = "update user set userdeletedate=now()"; //실행할 쿼리
			String B=" where userid=?";
			ps = conn_mysql.prepareStatement(A+B);
			
			ps.setString(1, userid);
			ps.executeUpdate();
			
			conn_mysql.close();

			}
		
		catch (Exception e) {
			return false;   //e.printStackTrace(); --오류정보를 확인할 수 있다.
			// TODO: handle exception
		}return true;}

	
	public boolean Action() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();  //  db를 연결
			
			String A = "update  user set userupdate=?"; //실행할 쿼리
			String B=" where userid =?";
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, userinsert);
			ps.setString(2, userid);
			ps.executeUpdate();
			
			conn_mysql.close();

			}
		catch (Exception e) {
			return false;
			
		}return true;
		}










}
		
		
	



