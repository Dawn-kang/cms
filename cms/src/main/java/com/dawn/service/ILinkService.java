package com.dawn.service;

import java.util.List;

import com.dawn.bean.Link;

public interface ILinkService {
	public void saveOrUpdate(Link link) throws Exception;
	public void deleteById(int id) throws Exception;
	public List<Link> findAll();
	public Link findById(int id);
}
