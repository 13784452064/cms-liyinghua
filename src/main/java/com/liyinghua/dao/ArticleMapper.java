package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyinghua.entity.Article;

public interface ArticleMapper {
	/**
	 * 
	 * @Title: getArticleByChannelId 
	 * @Description: 通过频道id获取符合频道的新闻
	 * @param channelId
	 * @param fy
	 * @param size
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleByChannelId(@Param("channelId")Integer channelId,@Param("fy")Integer fy,@Param("size")Integer size);
	/**
	 * 
	 * @Title: getArticleBychannelIdAndByCategoryId 
	 * @Description: 通过分类和频道获取符合条件的新闻
	 * @param chanId
	 * @param fy
	 * @param pageSize
	 * @param categoryId
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getArticleBychannelIdAndByCategoryId(@Param("channelId")Integer chanId, @Param("fy")Integer fy, @Param("size")Integer pageSize, @Param("categoryId")Integer categoryId);
	/**
	 * 
	 * @Title: getArticleById 
	 * @Description: 获取文章内容
	 * 
	 * @param articleId
	 * @return
	 * @return: List<Article>
	 */
	Article getArticleById(@Param("articleId")Integer articleId);

}
