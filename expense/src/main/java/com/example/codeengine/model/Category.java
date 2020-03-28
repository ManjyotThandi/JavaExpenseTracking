package com.example.codeengine.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cateogry")
public class Category {
	@Id
	private Long id;

	private String name;

	// In user we have a one to many, here we have a many to one, creates a bi
	// directional relationship
	// Persist operation is going to be cascading throughout. So when you add the
	// category, you need to add the user
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;

	@OneToMany
	private Set<Expense> expense;

	public Category() {

	}

	public Category(Long id, String name, User user, Set<Expense> expense) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Expense> getExpense() {
		return expense;
	}

	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
