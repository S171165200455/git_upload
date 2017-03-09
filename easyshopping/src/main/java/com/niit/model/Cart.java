package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private double grandtotal;
@OneToOne
private Customer customer;
@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
private List<CartIteam> cartItems;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getGrandtotal() {
	return grandtotal;
}
public void setGrandtotal(double grandtotal) {
	this.grandtotal = grandtotal;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<CartIteam> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartIteam> cartItems) {
	this.cartItems = cartItems;
}



}
