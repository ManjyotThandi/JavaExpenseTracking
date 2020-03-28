package com.example.codeengine.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Tells JPA that we need to build a table
@Entity
@Table(name = "user")
public class User {

	@Id
	private Long id;

	private String name;

	private String email;

	// One user can have many categories. Set removes duplicates
	@OneToMany
	private Set<Category> category;

	@OneToMany
	private Set<Expense> expense;

	// Need a no arg constructor for JPA
	public User() {

	}

	public User(Long id, String name, String email, Set<Category> category, Set<Expense> expense) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.category = category;
		this.expense = expense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<Expense> getExpense() {
		return expense;
	}

	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
