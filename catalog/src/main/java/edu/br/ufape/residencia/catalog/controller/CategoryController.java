package edu.br.ufape.residencia.catalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.br.ufape.residencia.catalog.dto.CategoryRequest;
import edu.br.ufape.residencia.catalog.dto.CategoryResponse;
import edu.br.ufape.residencia.catalog.exception.NotFoundException;
import edu.br.ufape.residencia.catalog.facade.Facade;

@RestController
public class CategoryController {
	@Autowired
	private Facade facade;
	
	@PostMapping(value = "/category")
	public CategoryResponse create(@RequestBody @Valid CategoryRequest category) {
		return facade.createCategory(category);
	}
	
	@GetMapping(value = "/category/{id}")
	public CategoryResponse find(@PathVariable long id) throws NotFoundException {
		return facade.loadCategory(id);
	}
	
	@GetMapping(value = "/category")
	public List<CategoryResponse> listAll() {
		return facade.findAllCategories();
	}
}
