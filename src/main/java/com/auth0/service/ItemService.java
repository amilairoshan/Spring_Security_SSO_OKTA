package com.auth0.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auth0.model.Item;
import com.auth0.model.ShoppingCart;

@Service
public class ItemService {
	
	public ShoppingCart getShopingCart() {
		
		 List<Item> itemList=new ArrayList<Item>();
	       Item itemOne= new Item.ItemBuilder("1").setName("Rice Packet").setNoOfUnit("2").setUnitPrice("1500").build();
	       Item itemTwo= new Item.ItemBuilder("2").setName("Sugar").setNoOfUnit("4").setUnitPrice("150").build();
	       Item itemThree= new Item.ItemBuilder("3").setName("Dhal").setNoOfUnit("3").setUnitPrice("200").build();
	       Item itemFour= new Item.ItemBuilder("4").setName("Milk Powder").setNoOfUnit("5").setUnitPrice("5000").build();
	       itemList.add(itemOne);
	       itemList.add(itemTwo);
	       itemList.add(itemThree);
	       itemList.add(itemFour);
	       
	       return new ShoppingCart("1",itemList);
		
	}
	

}
