package com.dawn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dawn.bean.Link;

public interface LinkDao extends JpaRepository<Link, Integer>{
	//根据url查询link信息
	public List<Link> findByUrl(String url);
}
