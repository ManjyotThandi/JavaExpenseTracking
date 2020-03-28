package com.example.codeengine.expense.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "category")
public class Category {
	@Id
	private Long id;

	@NotNull
	private String name;


	public Category() {

	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
