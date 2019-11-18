package com.article.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.liyinghua.entity.Article;
import com.liyinghua.service.ArticleService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class GetArticle {
	@Autowired
	ArticleService service;
	
	@Test
	public void getArticle() {
		Article articleById = service.getArticleById(10);
		
		System.out.println(articleById.getContent());
	}
}
