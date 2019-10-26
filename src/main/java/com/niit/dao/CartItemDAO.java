package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDAO
{
	public void addCart(CartItem cart);
	public void deleteCart(CartItem cart);
	public void updateCart(CartItem cart);
	public List<CartItem> displayCart(CartItem cart);
}
