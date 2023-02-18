package com.auth0.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.service.ItemService;

//import com.auth0.AuthenticationController;



/**
 * @author AMILA
 *
 */
@Controller
@SuppressWarnings("unused")
public class HomeController {

	@Autowired
	private ItemService itemService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }
    
    @GetMapping("/home")
    public String sucessLogin(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
            model.addAttribute("shopingcart",itemService.getShopingCart());
        }
        return "home";
    }
    
    
   
    
}