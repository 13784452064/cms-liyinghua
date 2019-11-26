package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.liyinghua.entity.Article;
import com.liyinghua.entity.Review;


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
	/**
	 * 
	 * @Title: getUserNewsList 
	 * @Description: 获取所有用户文章
	 * @return
	 * @return: List<Article>
	 */
	List<Article> getUserNewsList();
	/**
	 * 
	 * @Title: delNews 
	 * @Description: 删除新闻
	 * @param articleId
	 * @return
	 * @return: Integer
	 */
	Integer delNews(@Param("articleId")Integer articleId);
	/**
	 * 
	 * @Title: setHot 
	 * @Description: 设置热门
	 * @param articleId
	 * @param status 
	 * @return
	 * @return: Integer
	 */
	Integer setHot(@Param("articleId")Integer articleId, @Param("status")Integer status);
	/**
	 * 
	 * @Title: getUserNewsByHot 
	 * @Description: 查找热门
	 * @param articleId
	 * @return
	 * @return: Article
	 */
	Article getUserNewsByHot(@Param("articleId")Integer articleId);
	/**
	 * 
	 * @Title: apply 
	 * @Description: 设置通过
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int apply(@Param("id")Integer id,@Param("status")Integer status);
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加文章
	 * @param article
	 * @return
	 * @return: Integer
	 */
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},0,"
			+ "now(),now(),#{commentCnt},"
			+ "#{articleType,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler,"
			+ "jdbcType=INTEGER,javaType=com.liyinghua.entity.TypeEnum})")
	Integer add(Article article);
	
	int minId();
	
	Integer maxId();
	
	List<Article> getUserNewsListByUserId(@Param("id")Integer id);
	
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channelId},"
			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int update(Article article);
	
	List<Review> getReview(@Param("articleId")Integer articleId);

	List<Article> findById(Integer id);
	
	Integer getReviewsNum(@Param("id")Integer id);
	
	
	List<Article> getImgArticles(Integer i);
}
