package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Product;
import com.niit.model.User;


@Transactional
public class ProductDAOImpl implements ProductDAO
{

	SessionFactory sessionFactory;
	@Autowired
	public void addProduct(Product product)
	{
		sessionFactory.getCurrentSession().save(product);	
	}

	public void deleteProduct(Product product) 
	{
		sessionFactory.getCurrentSession().delete(product);	
		
	}

	public void updateProduct(Product product) 
	{
		sessionFactory.getCurrentSession().update(product);	
		
	}

	public List<Product> displayProducts()
	{
		try 
		{
		
			//HQL hibernate Querry Language
			
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product").list();
		}

		catch (Exception e)
		{
		return null;	
		}
	}


	public Product displayProductById(Product product) 
	{
		try 
		{
		
			//positional arguments:- ?
			//named      arguments:- :anyname
			
			Query query=DBConfig.getSession().createQuery("from com.niit.model.Product where productid= :productid");
			query.setParameter("productid",product.getProductid());
			return(Product)query.getResultList().get(0);

		}

		catch (Exception e)
		{
		return null;	
		}
	}

	public Product displayProductByName(Product product) 
	{
	
		try 
		{
		
			//positional arguments:- ?
			//named      arguments:- :anyname
			
			Query query=DBConfig.getSession().createQuery("from com.niit.model.Product where productname= :productname");
			query.setParameter("productname",product.getProductname());
			return(Product)query.getResultList().get(0);
	}
		
		catch (Exception e)
		{
		return null;	
		}

	}
}