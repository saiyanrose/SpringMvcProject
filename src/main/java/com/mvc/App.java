package com.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

@Component
public class App {

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;	
	private Statistics statistic;
	
	public App() {
		
	}	
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(Metadata meta) {
		this.factory = meta.getSessionFactoryBuilder().build();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(SessionFactory factory) {
		this.session =factory.openSession();
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Session session) {
		this.transaction = session.beginTransaction();;
	}

	public Statistics getStatistic() {
		return statistic;
	}

	public void setStatistic(SessionFactory factory) {
		this.statistic = factory.getStatistics();
	}		
	
	public void beginTransaction() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		setFactory(meta);
		
		//this.statistic=getStatistic();
		
		//this.factory.getStatistics().setStatisticsEnabled(true);		
		
		setSession(this.factory);
		
		setTransaction(this.session);		
		
	}
}
