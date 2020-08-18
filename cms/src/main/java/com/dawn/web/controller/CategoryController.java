package com.dawn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.bean.Category;
import com.dawn.service.ICategoryService;
import com.dawn.util.Message;
import com.dawn.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(description = "栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/saveOrUpdate")
	@ApiOperation(value = "保存或更新栏目信息",notes = "若id为空则为保存信息，不为空则为更新")
	public Message<String> saveOrUpdate(Category category) {
		String msg = null;
		try {
			categoryService.saveOrUpdate(category);
			msg = "更新成功";
			return MessageUtil.success();
		} catch (Exception e) {
			msg = e.getMessage();
			return MessageUtil.error(500, msg);
		}
	}
	
	@GetMapping("/deleteById")
	@ApiOperation(value = "根据id删除栏目信息")
	@ApiImplicitParam(name = "id",value = "栏目id",required = true,paramType = "query",dataType = "int")
	public Message<String> deleteById(int id) {
		String msg = null;
		try {
			categoryService.deleteById(id);
			msg = "删除成功";
			return MessageUtil.success(msg);
		} catch (Exception e) {
			msg = e.getMessage();
			return MessageUtil.error(500, msg);
		}
	}
	
	@GetMapping("/findAll")
	@ApiOperation("查询所有栏目信息")
	public Message<List<Category>> findAll() {
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查询栏目信息")
	@ApiImplicitParam(name = "id",value = "栏目id",required = true,paramType = "query",dataType = "int")
	public Message<Category> findById(int id) {
		Category category = categoryService.findById(id);
		return MessageUtil.success(category);
	}
}
