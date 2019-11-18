package com.liyinghua.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Article;

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

	Article getArticleById(Integer articleId);

}
