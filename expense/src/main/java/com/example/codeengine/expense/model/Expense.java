package com.example.codeengine.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	private Long id;
	private Instant expenseDate;
	private String description;
	private String location;

	// Many of these expense can go under one category
	@ManyToOne
	private Category category;

	// Many expenses can go under one user
	@ManyToOne
	private User user;

	public Expense() {

	}

	public Expense(Long id, Instant expenseDate, String description, String location, Category category, User user) {
		super();
		this.id = id;
		this.expenseDate = expenseDate;
		this.description = description;
		this.location = location;
		this.category = category;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Instant expenseDate) {
		this.expenseDate = expenseDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseDate=" + expenseDate + ", description=" + description + "]";
	}

}
