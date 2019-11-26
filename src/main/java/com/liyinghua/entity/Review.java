package com.liyinghua.entity;

import java.io.Serializable;

public class Review implements Serializable{
	private Integer id             ;
	private Integer articleId      ;
	private Article article;
	private Integer userId         ;
	private User user;
	private String content        ;
	private String created        ;
	public Review(Integer id, Integer articleId, Article article, Integer userId, User user, String content,
			String created) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.article = article;
		this.userId = userId;
		this.user = user;
		this.content = content;
		this.created = created;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", articleId=" + articleId + ", article=" + article + ", userId=" + userId
				+ ", user=" + user + ", content=" + content + ", created=" + created + "]";
	}
	
}
