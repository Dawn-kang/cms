package com.dawn.service;

import java.util.List;

import com.dawn.bean.Article;

public interface IArticleService {
	public void saveOrUpdate(Article article);
	public Article findById(int id);
	public void deleteById(int id) throws Exception;
	public List<Article> findAll();
}
