package com.dawn.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "article")
@ApiModel
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "文章标题")
	private String title;
	@ApiModelProperty("文章作者")
	private String author;
	@ApiModelProperty("文章点击次数")
	private int click;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category catgory; 
	
	public Article() {
	}

	public Article(Integer id, String title, String author,int click) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.click = click;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCatgory() {
		return catgory;
	}

	public void setCatgory(Category catgory) {
		this.catgory = catgory;
	}
	
	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", click=" + click + ", catgory="
				+ catgory + "]";
	}

	
	
	
}
