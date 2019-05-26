package com.blackhole.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="1orders")
public class Order {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 private int id;
 
 private String customer; 
 
 private Integer price;
 
 @Column(name="date_of_order")
 @DateTimeFormat(pattern = "MM-dd-yyyy")
 private Date dateOfOrder;
 
 public Order(){
 }
 /* ... */

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCustomer() {
	return customer;
}

public void setCustomer(String customer) {
	this.customer = customer;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

public Date getDateOfOrder() {
	return dateOfOrder;
}

public void setDateOfOrder(Date dateOfOrder) {
	this.dateOfOrder = dateOfOrder;
}
}