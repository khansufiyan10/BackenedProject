
package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Order;


@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public void addOrder(Order order) 
	{
		
		sessionFactory.getCurrentSession().save(order);
	}

	public void cancelOrder(Order order) 
	{
		
		
	}

	public void updateOrder(Order order) 
	{
		sessionFactory.getCurrentSession().update(order);
		
	}

	public List<Order> displayOrders(Order order)
	{
		try 
		{
		
			//HQL hibernate Querry Language
			
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Order").list();
		}

		catch (Exception e)
		{
		return null;	
		}
	
		
	}

}
