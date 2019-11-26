package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.dao.ArticleMapper;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Channel;
import com.liyinghua.entity.Review;
import com.liyinghua.service.ArticleService;

import sun.print.resources.serviceui;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper mapper;
	
	/**
	 * 获取符合频道的新闻
	 */
	@Override
	public List<Article> getArticleByChannelId(Integer channelId,Integer fy) {
		
		List<Article> list=mapper.getArticleByChannelId(channelId,fy,ConstantClass.PAGE_SIZE);
		
		return list;
	}
	/**
	 * 查找符合频道和频道中分类的新闻
	 */
	@Override
	public List<Article> getArticleBychannelIdAndByCategoryId(Integer categoryId, Integer fy, Integer chanId) {
		// TODO Auto-generated method stub
		System.out.println("categoryId="+categoryId);
		System.out.println("channelId="+chanId);
		List<Article> list=mapper.getArticleBychannelIdAndByCategoryId(chanId,fy,ConstantClass.PAGE_SIZE,categoryId);
		
		return list;
	}
	@Override
	public Article getArticleById(Integer articleId) {
		// TODO Auto-generated method stub
		return mapper.getArticleById(articleId);
	}
	@Override
	public Integer delNews(Integer articleId) {
		// TODO Auto-generated method stub
		if(articleId<=0) {
			return 0;
		}
		Article article = mapper.getArticleById(articleId);
		
		if(article==null) {
			return 0;
		}
		return mapper.delNews(articleId);
	}
	@Override
	public Integer setHot(Integer articleId,Integer status) {
		// TODO Auto-generated method stub
		return mapper.setHot(articleId,status);
	}
	@Override
	public Article getUserNewsByHot(Integer articleId) {
		// TODO Auto-generated method stub
		return mapper.getUserNewsByHot(articleId);
	}
	@Override
	public Integer apply(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return mapper.apply(id,status);
	}

	@Override
	public Integer add(Article article) {
		// TODO Auto-generated method stub
		return mapper.add(article);
	}
	@Override
	public Article onNews(Integer id) {
		// TODO Auto-generated method stub
		int min=mapper.minId();
		System.out.println(min);
		while(true) {
			Article art = mapper.getArticleById(id);
			if(art==null) {
				id--;
				if(id<min) {
					return null;
				}
			}else {
				return art;
			}
		}
	
	}
	@Override
	public Integer minId() {
		// TODO Auto-generated method stub
		return mapper.minId();
	}
	@Override
	public Integer maxId() {
		// TODO Auto-generated method stub
		return mapper.maxId();
	}
	@Override
	public Article putNews(Integer id) {
		// TODO Auto-generated method stub
		int max=mapper.maxId();
		while(true) {
			Article art = mapper.getArticleById(id);
			if(art==null) {
				id++;
				if(id>max) {
					return null;
				}
			}else {
				return art;
			}
		}
	}
	@Override
	public Article getDetailById(int id) {
		// TODO Auto-generated method stub
		return mapper.getArticleById(id);
	}
	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return mapper.update(article);
	}
	@Override
	public PageInfo<Review> getReview( Integer articleId,Integer fy) {
		// TODO Auto-generated method stub
		PageHelper.startPage(fy,2);
		List<Review> list=mapper.getReview(articleId);
		PageInfo<Review> p=new PageInfo<Review>(list);
		return p;
	}
	@Override
	public Integer getReviewsNum(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getReviewsNum(id);
	}
	@Override
	public List<Article> getImgArticles(int i) {
		// TODO Auto-generated method stub
		return mapper.getImgArticles(i);
	}


}
