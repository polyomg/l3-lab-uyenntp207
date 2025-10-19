package com.poly.lab5.controller;

import com.poly.lab5.service.ShoppingCartService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {
    private final ShoppingCartService cart;
    public GlobalModelAttributes(ShoppingCartService cart) { this.cart = cart; }

    @ModelAttribute("cartCount")
    public int cartCount(){
        return cart.getCount();
    }

    @ModelAttribute("cartAmount")
    public double cartAmount(){
        return cart.getAmount();
    }
}

