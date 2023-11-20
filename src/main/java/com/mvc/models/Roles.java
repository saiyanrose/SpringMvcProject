package com.mvc.models;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "test_roles")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Roles {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long role_id;

	private String role_name;	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Roles() {

	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

}
