package com.poc2;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id
	private int id;
	
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	
	@NotBlank(message = "Locations cannot be empty")
	private String location;
	
	private boolean deleted = Boolean.FALSE;
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	User(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoingDate() {
		return joiningDate;
	}

	public void setJoingDate(Date joingDate) {
		this.joiningDate = joingDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}	
}
