package com.dawn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawn.bean.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	//根据栏目名称查询栏目信息
	public List<Category> findByName(String name);
}
