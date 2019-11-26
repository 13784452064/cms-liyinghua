package com.liyinghua.entity;

public class Collect {
	   private Integer id            ;
	   private Integer userId             ;
	   private User user;
	   private Integer articleId          ;
	   private Article article;
	   private Integer url                ;
	   private Integer collectTime        ;
	   private Integer del        ;
	public Collect(Integer id, Integer userId, User user, Integer articleId, Article article, Integer url,
			Integer collectTime, Integer del) {
		super();
		this.id = id;
		this.userId = userId;
		this.user = user;
		this.articleId = articleId;
		this.article = article;
		this.url = url;
		this.collectTime = collectTime;
		this.del = del;
	}
	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getUrl() {
		return url;
	}
	public void setUrl(Integer url) {
		this.url = url;
	}
	public Integer getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Integer collectTime) {
		this.collectTime = collectTime;
	}
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", userId=" + userId + ", user=" + user + ", articleId=" + articleId + ", article="
				+ article + ", url=" + url + ", collectTime=" + collectTime + ", del=" + del + "]";
	}
	
	   
	   
	
}
