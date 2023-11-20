package com.mvc.service;

import java.util.Set;
import java.util.function.Predicate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mvc.App;
import com.mvc.exceptions.UserNotFoundException;
import com.mvc.models.Roles;
import com.mvc.models.User;

@Service
public class UserService {	
	
	@Autowired
	private App app;	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User getUserByEmail(String email) {
		Session session=null;
		SessionFactory factory=null;
		try {
			app.beginTransaction();
			factory=app.getFactory();
			session=app.getSession();			
			
			@SuppressWarnings("unchecked")
			Query<User> query=session.createQuery("from User where email=:email");//get user by email
			query.setParameter("email",email);
			query.setCacheable(true);//first level cache
			User user=query.uniqueResult();			
			
			Predicate<User>checkExits=u->u!=null;//check User exist or not
			boolean userExist=checkExits.test(user);				
			if(userExist) {
				return user;
			}else {
				throw new UserNotFoundException("User not found with email: "+email);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
			session.close();
		}
		return null;
	}

	public boolean registerUser(User user) {
		Session session=null;
		SessionFactory factory=null;
		Transaction transaction=null;
		try {
			app.beginTransaction();			
			factory=app.getFactory();
			session=app.getSession();
			transaction=app.getTransaction();
			
			Roles roles=new Roles();			
			roles.setRole_name("User_Customer");
			roles.setUser(user);
			user.setEnabled(true);
			user.setRoles(Set.of(roles));
			user.setPassword(passwordEncoder.encode(user.getPassword()));			
			
			session.save(user);//save user				
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			factory.close();
			session.close();
		}
		return false;		
	}
}
