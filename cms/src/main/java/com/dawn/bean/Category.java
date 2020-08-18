package com.dawn.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "category")
@ApiModel
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "栏目id")
	private Integer id;
	@ApiModelProperty(value = "栏目名字")
	private String name;
	@ApiModelProperty(value = "栏目编码")
	private String number;
	
	public Category() {
	}

	public Category(Integer id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", number=" + number + "]";
	}
	
}
