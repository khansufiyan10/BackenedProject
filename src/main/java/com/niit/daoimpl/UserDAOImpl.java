package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.User;


@Transactional
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean addUser(User user) 
	{
		sessionFactory.getCurrentSession().save(user);
		return true;
		
	}

	public void deleteUser(User user)
	{
		sessionFactory.getCurrentSession().delete(user);
		
	}

	public void updateUser(User user)
	{
		sessionFactory.getCurrentSession().update(user);
		
	}

	public List<User> displayUsers()
	{
	
		try 
		{
		
			//HQL hibernate Querry Language
			
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.User").list();
		}

		catch (Exception e)
		{
		return null;	
		}
	}

	public User displayUserById(User user) 
	{

		try 
		{
		
			//positional arguments:- ?
			//named      arguments:- :anyname
			
			Query query=DBConfig.getSession().createQuery("from com.niit.model.User where userid= :userid");
			query.setParameter("userid",user.getUserid());
			return(User)query.getResultList().get(0);
		}

		catch (Exception e)
		{
		return null;	
		
	}
	}

	public User displayUserByUserName(User user) 
	{
	
		try 
		{
			
			Criteria ctx=DBConfig.getSession().createCriteria(User.class);
			return(User)ctx.add(Restrictions.eq("username",user.getUsername())).list().get(0);
		}

		catch (Exception e)
		{
		return null;	
		}
	}
}