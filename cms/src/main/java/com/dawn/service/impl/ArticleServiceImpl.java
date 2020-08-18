package com.dawn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawn.bean.Article;
import com.dawn.dao.ArticleDao;
import com.dawn.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService{
	@Autowired
	private ArticleDao articleDao;

	@Override
	public void saveOrUpdate(Article article) {
		articleDao.save(article);
	}

	@Override
	public Article findById(int id) {
		Optional<Article> optional = articleDao.findById(id);
		Article article = optional.isPresent()?optional.get():null;
		if(article!=null) {
			//更新数据库中文章的点击量
			articleDao.updateClickById(article.getClick()+1, id);
			//更新接口中返回article对象的点击量
			article.setClick(article.getClick()+1);
		}
		return article;
	}

	@Override
	public void deleteById(int id) throws Exception {
		Optional<Article> optional = articleDao.findById(id);
		Article article = optional.isPresent()?optional.get():null;
		if(article==null) {
			throw new Exception("文章id不存在，请重新输入!");
		}else {
			
			articleDao.deleteById(id);
		}
	}

	@Override
	public List<Article> findAll() {
		List<Article> list = articleDao.findAll();
		return list;
	}

}
