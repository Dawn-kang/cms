package com.dawn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawn.bean.Category;
import com.dawn.dao.CategoryDao;
import com.dawn.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void saveOrUpdate(Category category) throws Exception {
		//栏目名称不能重复，根据栏目名称查询数据库信息，
		//如果查询到对应信息，说明栏目存在
		String name = category.getName();
		List<Category> list = categoryDao.findByName(name);
		if(list.size()>0) {
			throw new Exception("该栏目已存在，请重新输入！");
		}else {
			categoryDao.save(category);
		}
	}

	@Override
	public void deleteById(int id) throws Exception {
		//判断id是否存在,根据id查询数据库信息，如果查询到对应信息，说明id存在
		 Optional<Category> optional = categoryDao.findById(id);
		 Category category = optional.isPresent()?optional.get():null;
		if(category == null) {
			throw new Exception("当前id不存在，请重新验证输入！");
		}else {
			categoryDao.deleteById(id);
		}
		
	}

	@Override
	public List<Category> findAll() {
		List<Category> list = categoryDao.findAll();
		return list;
	}

	@Override
	public Category findById(int id) {
		 Optional<Category> optional = categoryDao.findById(id);
		 Category category = optional.isPresent()?optional.get():null;
		 return category;
	}

}
