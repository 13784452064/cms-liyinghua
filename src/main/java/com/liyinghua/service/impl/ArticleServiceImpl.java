package com.liyinghua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.dao.ArticleMapper;
import com.liyinghua.entity.Article;
import com.liyinghua.service.ArticleService;
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

}
