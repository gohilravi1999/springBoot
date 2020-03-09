package com.springWithJpa.springBootWithJpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Ticket 
{
	@Id
	private int id;
	private String city;
	private String catagory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", city=" + city + ", catagory=" + catagory + "]";
	}	
}
