package com.javalec.admin.publisher;

public class AdminPublishDto {

	String publishername;
	String publishertelno;
	String publisheremail;
	String authorname;
	String authortelno;
	String authoremail;
	
	
	public AdminPublishDto(String publishername, String publishertelno, String publisheremail, String authorname,
			String authortelno, String authoremail) {
		super();
		this.publishername = publishername;
		this.publishertelno = publishertelno;
		this.publisheremail = publisheremail;
		this.authorname = authorname;
		this.authortelno = authortelno;
		this.authoremail = authoremail;
	}

	public AdminPublishDto() {

	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getPublishertelno() {
		return publishertelno;
	}

	public void setPublishertelno(String publishertelno) {
		this.publishertelno = publishertelno;
	}

	public String getPublisheremail() {
		return publisheremail;
	}

	public void setPublisheremail(String publisheremail) {
		this.publisheremail = publisheremail;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAuthortelno() {
		return authortelno;
	}

	public void setAuthortelno(String authortelno) {
		this.authortelno = authortelno;
	}

	public String getAuthoremail() {
		return authoremail;
	}

	public void setAuthoremail(String authoremail) {
		this.authoremail = authoremail;
	}
	
	
}
