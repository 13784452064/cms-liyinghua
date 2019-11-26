package com.liyinghua.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.entity.Review;

public interface ArticleService {
	/**
	 * 
	 * @Title: getArticleByChannelId 
	 * @Description: 通过频道id获取新闻
	 * @param channelId
	 * @param fy
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByChannelId(Integer channelId,Integer fy);

	/**
	 * 
	 * @Title: getArticleBychannelIdAndByCategoryId 
	 * @Description: 同时通过频道和分类获取新闻
	 * @param categoryId
	 * @param fy
	 * @param chanId
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleBychannelIdAndByCategoryId(Integer categoryId, Integer fy, Integer chanId);
	/**
	 * 
	 * @Title: getArticleById 
	 * @Description: 通过id获取新闻
	 * @param articleId
	 * @return
	 * @return: Article
	 */
	Article getArticleById(Integer articleId);
	/**
	 * 
	 * @Title: delNews 
	 * @Description: 删除新闻
	 * @param articleId
	 * @return
	 * @return: Integer
	 */
	Integer delNews(Integer articleId);
	/**
	 * 
	 * @Title: setHot 
	 * @Description: 设置热门
	 * @param articleId
	 * @param status 
	 * @return
	 * @return: Integer
	 */
	Integer setHot(Integer articleId, Integer status);
	/**
	 * 
	 * @Title: getUserNewsByHot 
	 * @Description: 判断是否热门
	 * @param articleId
	 * @return
	 * @return: Article
	 */
	Article getUserNewsByHot(Integer articleId);
	/**
	 * 
	 * @Title: apply 
	 * @Description: 设置是否通过
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	Integer apply(Integer id, Integer status);

	Integer add(Article article);

	Article onNews(Integer id);

	Integer minId();

	Integer maxId();

	Article putNews(Integer id);

	Article getDetailById(int id);

	int update(Article article);

	PageInfo<Review> getReview(Integer articleId, Integer fy);

	Integer getReviewsNum(Integer id);

	List<Article> getImgArticles(int i);

}
