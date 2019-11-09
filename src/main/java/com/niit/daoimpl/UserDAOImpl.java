package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		user.setAuthority("user");
		user.setEnabled(true);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
			
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where userid= :userid");
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
			
			System.out.println("inside method............");
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where username= :username");
			query.setParameter("username",user.getUsername());
			User u=(User)query.getResultList().get(0);
			System.out.println("inside method................................");
			System.out.println(u.getUsername());
			System.out.println(u.getAuthority());
			System.out.println(u.isEnabled());
			return u;
		}

		catch (Exception e)
		{
		return null;	
		}
	}
}