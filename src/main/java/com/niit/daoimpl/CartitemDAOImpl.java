package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.CartItem;

@Transactional
public class CartitemDAOImpl implements CartItemDAO
{
	@Autowired
	SessionFactory sessionFactory;
	

	public void addCart(CartItem cart) 
	{

		sessionFactory.getCurrentSession().save(cart);
		
		
	}

	public void deleteCart(CartItem cart)
	{
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	public void updateCart(CartItem cart) 
	{
		sessionFactory.getCurrentSession().update(cart);
		
	}

	public List<CartItem> displayCart(CartItem cart)
	{
		
		try 
		{
		
			//HQL hibernate Querry Language
			
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.CartItem").list();
		}

		catch (Exception e)
		{
		return null;	
		}
		
	}

}
