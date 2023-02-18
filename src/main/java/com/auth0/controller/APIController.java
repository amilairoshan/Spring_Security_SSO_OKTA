package com.auth0.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.model.Item;
import com.auth0.model.ShoppingCart;
import com.auth0.service.ItemService;


/**
 * @author AMILA
 *
 */
@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class APIController {

	@Autowired
	private ItemService itemService;
	
    @GetMapping(value = "/cartDetails")
    public ShoppingCart privateEndpoint() {
    	return itemService.getShopingCart();
    }


	
}
