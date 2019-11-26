package com.liyinghua.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * @ClassName: Article 
 * @Description: 文章表(连接有用户表,类型表,频道表)
 * @author:李英华
 * @date: 2019年11月14日 下午6:36:58
 */
public class Article implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -7235083744274782805L;
	/**
	 * 文章id
	 */
	private Integer id            ;
	/**
	 * 文章标题
	 */
	private String title         ;
	/**
	 * 文章内容
	 */
	private String content       ;
	/**
	 * 标题图片地址
	 */
	private String picture       ;
	/**
	 * 频道
	 */
	private Integer channelId    ;
	private Channel channel;
	/**
	 * 文章分类
	 */
	private Integer categoryId   ;
	private Category category;
	/**
	 * 用户
	 */
	private Integer userId       ;
	private User user;
	/**
	 * 点击数量
	 */
	private Integer hits          ;
	/**
	 * 是否热门
	 */
	private Integer hot           ;
	/**
	 * 未审核=0,审核通过=1,审核未通过=2
	 */
	private Integer status        ;
	/**
	 * 是否删除
	 */
	private Integer deleted       ;
	/**
	 * 发表时间
	 */
	private Date created       ;
	/**
	 * 最后修改时间
	 */
	private Date updated       ;
	/**
	 * 评论数量
	 */
	private Integer commentCnt    ;
	/**
	 * 文章类型
	 */
	private TypeEnum articleType = TypeEnum.HTML ;
	/**
	 * 该文章的所有图片
	 */
	private List<Image> imgList;
	public Article(Integer id, String title, String content, String picture, Integer channelId, Channel channel,
			Integer categoryId, Category category, Integer userId, User user, Integer hits, Integer hot, Integer status,
			Integer deleted, Date created, Date updated, Integer commentCnt, TypeEnum articleType,
			List<Image> imgList) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.channel = channel;
		this.categoryId = categoryId;
		this.category = category;
		this.userId = userId;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
		this.imgList = imgList;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}
	public TypeEnum getArticleType() {
		return articleType;
	}
	public void setArticleType(TypeEnum articleType) {
		this.articleType = articleType;
	}
	public List<Image> getImgList() {
		return imgList;
	}
	public void setImgList(List<Image> imgList) {
		this.imgList = imgList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", channelId=" + channelId + ", channel=" + channel + ", categoryId=" + categoryId + ", category="
				+ category + ", userId=" + userId + ", user=" + user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created + ", updated=" + updated + ", commentCnt="
				+ commentCnt + ", articleType=" + articleType + ", imgList=" + imgList + "]";
	}
	
	
	
}
