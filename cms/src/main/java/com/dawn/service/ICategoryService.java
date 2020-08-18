package com.dawn.service;

import java.util.List;

import com.dawn.bean.Category;

public interface ICategoryService {
	public void saveOrUpdate(Category category) throws Exception;
	public void deleteById(int id) throws Exception;
	public List<Category> findAll();
	public Category findById(int id);
}
