package com.dawn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.bean.Link;
import com.dawn.service.ILinkService;
import com.dawn.util.Message;
import com.dawn.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/link")
@Api(description = "链接相关接口")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	
	@PostMapping("/save")
	@ApiOperation(value = "插入或更新link信息",notes = "若id为空则为插入信息,不为空则为更新信息")
	public Message<String> saveOrUpdate(Link link) {
		String msg = null;
		try {
			linkService.saveOrUpdate(link);
			msg = "更新成功";
			return MessageUtil.success();
		} catch (Exception e) {
			msg = e.getMessage();
			return MessageUtil.error(500, msg);
		}
		
	}
	
	@GetMapping("/deleteById")
	@ApiOperation("根据id删除链接信息")
	@ApiImplicitParam(name = "id",value = "链接id",required = true,paramType = "query",dataType = "int")
	public Message<String> deleteById(int  id) {
		String msg = null;
		try {
			linkService.deleteById(id);
			msg = "删除成功";
			return MessageUtil.success();
		} catch (Exception e) {
			msg = e.getMessage();
			return MessageUtil.error(500, msg);
		}
	}
	
	@GetMapping("/findAll")
	@ApiOperation("查询所有的链接信息")
	public Message<List<Link>> findAll() {
		List<Link> list = linkService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查询链接信息")
	@ApiImplicitParam(name = "id",value = "链接id",required = true,paramType = "query",dataType = "int")
	public Message<Link> findById(int id) {
		Link link = linkService.findById(id);
		return MessageUtil.success(link);
	}
}
