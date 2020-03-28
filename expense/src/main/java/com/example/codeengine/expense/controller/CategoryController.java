package com.example.codeengine.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/category")
	public Collection<Category> categories() {
		// equiv to select * from category in SQL. No SQL required since JPA and
		// hibernate automatically do it
		return categoryRepository.findAll();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Long id) {
		// Optional since the category may exist or it may not
		Optional<Category> category = categoryRepository.findById(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping("/category")
	// valid makes sure you are recieving a valid request. (Model contains @Not Null
	// annothation etc)
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
		Category result = categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
	}
	
	
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		Category result = categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("category/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
