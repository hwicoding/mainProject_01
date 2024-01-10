package com.javalec.user;

public class UserDTO {
	
	String userid;
	String userpw;
	String username;
	String userphone;
	String useremail;
	String useraddress;
	String driverid;
	String driverpw;
	String drivername;
	String driverphone;
	String update;
	String delete;
	
public UserDTO() {
		
	}

public String getDelete() {
	return delete;
}




public void setDelete(String delete) {
	this.delete = delete;
}




public UserDTO(String userid, String userpw, String username, String useremail, String userphone,
		String useraddress, String update) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.useremail = useremail;
	this.userphone = userphone;
	this.useraddress = useraddress;
	this.update = update;
}




public String getUpdate() {
	return update;
}




public void setUpdate(String update) {
	this.update = update;
}




public UserDTO(String userid, String userpw, String username, String userphone, String useremail,
		String useraddress, String driverid, String driverpw, String drivername, String driverphone) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.userphone = userphone;
	this.useremail = useremail;
	this.useraddress = useraddress;
	this.driverid = driverid;
	this.driverpw = driverpw;
	this.drivername = drivername;
	this.driverphone = driverphone;
}




public String getDriverphone() {
	return driverphone;
}




public void setDriverphone(String driverphone) {
	this.driverphone = driverphone;
}









public String getDriverid() {
	return driverid;
}




public String getUseraddress() {
	return useraddress;
}




public void setUseraddress(String useraddress) {
	this.useraddress = useraddress;
}




public UserDTO(String userid, String userpw, String username, String userphone, String useremail,
		String useraddress, String driverid, String driverpw, String drivername) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.userphone = userphone;
	this.useremail = useremail;
	this.useraddress = useraddress;
	this.driverid = driverid;
	this.driverpw = driverpw;
	this.drivername = drivername;
}




public void setDriverid(String driverid) {
	this.driverid = driverid;
}




public String getDriverpw() {
	return driverpw;
}




public void setDriverpw(String driverpw) {
	this.driverpw = driverpw;
}




public String getDrivername() {
	return drivername;
}




public void setDrivername(String drivername) {
	this.drivername = drivername;
}




public UserDTO(String userid, String userpw, String username, String userphone, String useremail, String driverid,
		String driverpw, String drivername) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.userphone = userphone;
	this.useremail = useremail;
	this.driverid = driverid;
	this.driverpw = driverpw;
	this.drivername = drivername;
}




public UserDTO(String userid, String userpw, String username) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
}




public UserDTO(String userid, String userpw, String username, String useremail, String userphone) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.useremail = useremail;
	this.userphone = userphone;
}




public UserDTO(String userid, String userpw, String username, String useremail, String userphone, String update) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.useremail = useremail;
	this.userphone = userphone;
	this.update = update;
}




public UserDTO(String userid, String userpw) {
	super();
	this.userid = userid;
	this.userpw = userpw;
}




public UserDTO(String userid, String userpw, String username, String userphone) {
	super();
	this.userid = userid;
	this.userpw = userpw;
	this.username = username;
	this.userphone = userphone;
}




public String getUserid() {
	return userid;
}


public void setUserid(String userid) {
	this.userid = userid;
}


public String getUserpw() {
	return userpw;
}


public void setUserpw(String userpw) {
	this.userpw = userpw;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getUserphone() {
	return userphone;
}


public void setUserphone(String userphone) {
	this.userphone = userphone;
}


public String getUseremail() {
	return useremail;
}


public void setUseremail(String useremail) {
	this.useremail = useremail;
}

}
