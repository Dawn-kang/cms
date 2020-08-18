package com.dawn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.bean.Article;
import com.dawn.service.IArticleService;
import com.dawn.util.Message;
import com.dawn.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
@Api(description = "文章相关接口")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	@PostMapping("/saveOrUpdate")
	@ApiOperation(value = "保存或更新文章信息",notes = "当文章id为空时则保存，不为空则为更新")
	public Message<String> saveOrUpdate(Article article) {
		articleService.saveOrUpdate(article);
		return MessageUtil.success();	
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查找文章信息")
	@ApiImplicitParam(name = "id", value = "文章的id",paramType = "query",dataType = "int")
	public Message<Article> findById(int id) {
		Article article = articleService.findById(id);
		return MessageUtil.success(article);
	}
	
	@GetMapping("/deleteById")
	@ApiOperation("根据id删除文章信息")
	@ApiImplicitParam(name = "id",value = "文章的id",paramType = "query",dataType = "int")
	public Message<String> deleteById(int id) {
		String msg = null;
		try {
			articleService.deleteById(id);
			msg = "删除成功";
			return MessageUtil.success(msg);
		} catch (Exception e) {
			msg = e.getMessage();
			return MessageUtil.error(500, msg);
		}
	}
	
	@GetMapping("/findAll")
	@ApiOperation("查询所有文章信息")
	public Message<List<Article>> findAll() {
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}
}
