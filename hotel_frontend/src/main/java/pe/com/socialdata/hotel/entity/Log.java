package pe.com.socialdata.hotel.entity;

import java.util.Date;



import org.springframework.data.annotation.Id;
public class Log {

	
	private long id;
	

	private Date date;
	
	
	private String Details;
	
	
	private String username;
	
	
	private String url;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDetails() {
		return Details;
	}


	public void setDetails(String details) {
		Details = details;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	public Log(long id  ,Date date, String details, String username, String url) {
		super();
		this.id=id;
		this.date = date;
		Details = details;
		this.username = username;
		this.url = url;
	}
	
	
	
}
