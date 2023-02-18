package com.auth0.model;

import java.util.List;

public class ShoppingCart {

	private String id;
	private List<Item> item;
	
	
	
	public ShoppingCart(String id, List<Item> item) {
		super();
		this.id = id;
		this.item = item;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", item=" + item + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
	
	
	
	
	
	
	
}
