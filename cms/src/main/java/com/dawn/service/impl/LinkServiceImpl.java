package com.dawn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawn.bean.Link;
import com.dawn.dao.LinkDao;
import com.dawn.service.ILinkService;

@Service
public class LinkServiceImpl implements ILinkService{
	@Autowired
	private LinkDao linkDao;

	@Override
	public void saveOrUpdate(Link link) throws Exception {
		//获取链接的url地址，如果根据该url查询到对应数据库信息则表明该url已存在
		String url = link.getUrl();
		List<Link> list = linkDao.findByUrl(url);
		if(list.size()>0) {
			throw new Exception("该url地址已存在，请重新输入！");
		}else {
			linkDao.save(link);
		}
	}

	@Override
	public void deleteById(int id) throws Exception {
		//根据id查找对应链接信息，如果未查询到对应信息，则说明链接不存在
		Optional<Link> optional = linkDao.findById(id);
		Link link = optional.isPresent()?optional.get():null;
		if(link==null) {
			throw new Exception("该链接id不存在，请重新输入！");
		}else {
			linkDao.delete(link);
		}
	}

	@Override
	public List<Link> findAll() {
		List<Link> list = linkDao.findAll();
		return list;
	}

	@Override
	public Link findById(int id) {
		Optional<Link> optional = linkDao.findById(id);
		Link link = optional.isPresent()?optional.get():null;
		return link;
	}

}
