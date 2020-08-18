package com.dawn.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dawn.bean.Article;

public interface ArticleDao extends JpaRepository<Article, Integer>{
	@Transactional
	@Modifying
	@Query(value = "update article set click=?1 where id=?2",nativeQuery = true)
	//自定义sql语句根据id更新文章的click
	public void updateClickById(int click,int id);
}
