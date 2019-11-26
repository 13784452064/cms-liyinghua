package com.article.test;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Review;
import com.liyinghua.service.ArticleService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class GetArticle {
	@Autowired
	ArticleService service;
	@Test
	public void getArticle() {
		PageInfo<Review> review = service.getReview( 27, 1);
		List<Review> list = review.getList();
		for (Review review2 : list) {
			System.out.println(review2.getContent());
			System.out.println(review2.getUser().getUsername());
		}
	}
}
