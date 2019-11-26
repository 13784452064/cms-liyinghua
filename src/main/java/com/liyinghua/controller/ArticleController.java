package com.liyinghua.controller;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.liyinghua.common.ConstantClass;
import com.liyinghua.entity.Article;
import com.liyinghua.entity.Category;
import com.liyinghua.entity.Channel;
import com.liyinghua.entity.Image;
import com.liyinghua.entity.Review;
import com.liyinghua.entity.TypeEnum;
import com.liyinghua.entity.User;
import com.liyinghua.service.ArticleService;
import com.liyinghua.service.CategoryService;
import com.liyinghua.service.ChannelService;

@Controller
@RequestMapping("/home/Article")
public class ArticleController<V> {
	@Value("${upload.path}")
	String updloadPath;
	private Integer chanId=0;
	@Autowired()
	private ArticleService service;
	@Autowired()
	private ChannelService service1;
	@Autowired
	private CategoryService service2;
	private SimpleDateFormat dateFormat;
	
	
	

	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = service.getArticleById(id); 
		if(article==null) {
			request.setAttribute("imp", 1);
		}
		request.setAttribute("article",article);
		if(article.getArticleType()==TypeEnum.HTML)
			return "article/detail";
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(article.getContent(), List.class);
			article.setImgList(imgs);
			System.out.println(" article is "  + article);
			return "admin/news/detailimg";
		}
		
		
	}
	/**
	 * 
	 * @Title: getArticleByChannelId 
	 * @Description: 通过频道id获取新闻列表
	 * @param channelId
	 * @param hs
	 * @param fy
	 * @return
	 * @return: String
	 */
	@RequestMapping("getArticleBychannelId")
	private String getArticleByChannelId(Integer channelId,HttpServletRequest hs,@RequestParam(defaultValue ="1")Integer fy) {
		/**
		 * 频道的id共享
		 */
		chanId=0;
		if(chanId==0) {
			chanId=channelId;
			System.out.println(chanId);
		}

		List<Article> list= service.getArticleByChannelId(channelId,fy);
		hs.setAttribute("Articles", list);
		return "admin/news/categoryNews";
	}
	/**
	 * 
	 * @Title: getArticleBychannelIdAndByCategoryId 
	 * @Description: 通过频道ID和分类id共同获得符合条件的新闻列表
	 * @param categoryId
	 * @param hs
	 * @param fy
	 * @return
	 * @return: String
	 */
	@RequestMapping("getArticleBychannelIdAndByCategoryId")
	private String getArticleBychannelIdAndByCategoryId(Integer categoryId,HttpServletRequest hs,@RequestParam(defaultValue ="1")Integer fy) {
		List<Article> list= service.getArticleBychannelIdAndByCategoryId(categoryId,fy,chanId);
		hs.setAttribute("Articles", list);
		return "admin/news/categoryNews";
	}
	/**
	 * 
	 * @Title: getContent 
	 * @Description: 获取文章内容
	 * @param articleId
	 * @return
	 * @return: String
	 */
	@RequestMapping("getContent")
	private String getContent(Integer articleId,HttpServletRequest hs) {
		Article list=service.getArticleById(articleId);
		hs.setAttribute("content",list);
		return "admin/news/news";
		
	}
	/**
	 * 
	 * @Title: getContent 
	 * @Description: 获取文章内容(json)
	 * @param articleId
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("getContent1")
	private Object getContent1(Integer articleId) {
		
		Article article=service.getArticleById(articleId);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		if(article!=null) {
			map.put("result", 1);
			map.put("article", article);
		}else {
			map.put("result", 0);

		}
		
		return map;
		
	}
	/**
	 * 
	 * @Title: delNews 
	 * @Description: 删除文章
	 * @param articleId
	 * @param hs
	 * @return
	 * @return: Integer
	 */
	@ResponseBody
	@RequestMapping("delNews")
	private Integer delNews(Integer articleId) {
		Integer delNum=service.delNews(articleId);
		
		return delNum;
		
	}
	/**
	 * 
	 * @Title: delNews 
	 * @Description: 用户删除文章
	 * @param articleId
	 * @param hs
	 * @return
	 * @return: Integer
	 */
	@ResponseBody
	@RequestMapping("delUserNews")
	private Integer delUserNews(Integer articleId) {
		Integer delNum=service.delNews(articleId);
		
		return delNum;
		
	}
	/**
	 * 
	 * @Title: delNews 
	 * @Description: 设置热门
	 * @param articleId
	 * @param hs
	 * @return
	 * @return: Integer
	 */
	@ResponseBody
	@RequestMapping("setHot")
	private Object setHot(Integer id,Integer status) {
		
		if(status==1) {
			/**
			 * 文章是否存在
			 */
			Article article = service.getArticleById(id);
			if(article!=null) {
				Article  article1 =service.getUserNewsByHot(id);
				if(article1!=null) {
					/**
					 * 文章是热门
					 */
					return 2;
	 			}else {
	 				Integer setHot=service.setHot(id,status);
	 				if(setHot==1) {
	 					/**
	 					 * 设置成功
	 					 */
	 					return 3;
	 				}else {
	 					/**
	 					 * 设置失败
	 					 */
	 					return 4;
	 				}
	 			}
			}else {
				/**
				 * 文章不存在
				 */
				return 1;
			}
		
			
		}
		if(status==0) {
			/**
			 * 文章是否存在
			 */
			Article article = service.getArticleById(id);
			if(article!=null) {
	 				Integer setHot=service.setHot(id,status);
	 				if(setHot==1) {
	 					/**
	 					 * 设置成功
	 					 */
	 					return 3;
	 				}else {
	 					/**
	 					 * 设置失败
	 					 */
	 					return 4;
	 				}
	 			}
			}else {
				/**
				 * 文章不存在
				 */
				return 1;
			}
		return null;
		
			
		}


	@RequestMapping("applyArticle")
	@ResponseBody
	public Object applyArticle(Integer id,Integer status) {

		Article article = service.getArticleById(id);
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		if(article==null) {
			map.put("result", 1);
			return map;
		}
		int result = service.apply( id,status);
	
		if(result>0) {
			map.put("result", 2);
			return map;
		}else {
			map.put("result", 3);
			return map;
		}
	}
	
	/**
	 * 进入发表文章的界面
	 * @param request
	 * @return
	 */
	@RequestMapping("toPostArticle")
	public String toPostArticle(HttpServletRequest request,@RequestParam(defaultValue = "0")Integer n) {
		if(n==1) {
			//管理员发布
			// 获取所有的频道
			List<Channel> channels =  service1.getChannelList();
			request.setAttribute("channels", channels);
			return "admin/news/putArticle1";
		}else {
			// 获取所有的频道
			List<Channel> channels =  service1.getChannelList();
			request.setAttribute("channels", channels);
			return "admin/news/putArticle";
		}
		
	}
	/**
	 * 
	 * @Title: postArticle 1
	 * @Description: 发布文章
	 * @param request
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("postArticle")
	public Object  postArticle(HttpServletRequest request, MultipartFile file,Article article) throws Exception {
		System.out.println(article);
		if(!file.isEmpty()) {
			String fileUrl = processFile(file);
			article.setPicture(fileUrl);
		}
		User loginUser  = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		article.setUserId(loginUser.getId());
		int result = service.add(article);
		if(result>0) {
			return 1;
		}else {
			return 0;
		}
		
		

	}
	private String processFile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		

    	
    	//1 求扩展名  "xxx.jpg"
    	String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    	String fileNamePre = UUID.randomUUID().toString();
    	// 计算出新的文件名称
    	String fileName = fileNamePre + suffixName;
    	            
    	dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String path = dateFormat.format(new Date());
    	File pathFile  = new File(updloadPath + "/" + path);
    	if(!pathFile.exists()) {
    		pathFile.mkdirs();
    	}
    	
    	// 最终的新的文件名称
    	String newFileName = updloadPath + "/"+ path + "/" + fileName;
    	file.transferTo(new File(newFileName));
    	
    	return path + "/" + fileName ;
	}

	@RequestMapping("onNews")
	private String onNews(Integer id,HttpServletRequest hs) {
		Article a=service.onNews(id);
		System.out.println(a.getId());
		if(a!=null) {
			hs.setAttribute("content",a);
			hs.setAttribute("ids", a.getId());
		}
		
		return "admin/news/news1";
		
	}
	@ResponseBody
	@RequestMapping("minId")
	private Object minId(){
		Integer minId=service.minId();
		return minId;
		
	}
	
	@RequestMapping("putNews")
	private String putNews(Integer id,HttpServletRequest hs) {
		Article a=service.putNews(id);
		if(a!=null) {
			hs.setAttribute("content",a);
			hs.setAttribute("ids", a.getId());
		}
		return "admin/news/news1";
		
	}
	@ResponseBody
	@RequestMapping("maxId")
	private Object maxId(){
		Integer maxId=service.maxId();
		return maxId;
		
	}
	/**
	 * 
	 * @param request
	 * @param id  文章id 获取回显
	 * @return
	 */
	@RequestMapping("updArticle")
	public String updateArticle(HttpServletRequest request,int id) {
		
		// 获取文章的详情 用于回显
		Article article = service.getDetailById(id);
		System.out.println(article.getCategory().getId());
		request.setAttribute("article", article);
		request.setAttribute("content1", htmlspecialchars(article.getContent()));
		
		System.out.println(" 将要修改文章 " + article);
		 
		// 获取所有的频道
		List<Channel> channelList = service1.getChannelList();			
		request.setAttribute("channels", channelList);
		
		List<Category> categorys = service2.getCategoryByChannelId(article.getChannel().getId());
		request.setAttribute("categorys",categorys);
		
		return "admin/user/updUserNews";
	}
	@ResponseBody
	@RequestMapping("updateArticle")
	private Object updateArticle( MultipartFile file, Article article) throws Exception {
			//文章id 是否存在
			
			//用户是否有权限修改
			
			//
			if(!file.isEmpty()) {
				String picUrl = processFile(file);
				article.setPicture(picUrl);
			}
			
			int result = service.update(article);
			
			if(result>0) {
				// 成功
				return true;
			}else {
				return false;
			}

		
	}
	/**
	 * 
	 * @Title: getReview 
	 * @Description: 查看评论
	 * @param userId
	 * @param articleId
	 * @return
	 * @return: String
	 */
	@RequestMapping("getReview")
	private String getReview(Integer userId,Integer id,HttpServletRequest hs,@RequestParam(defaultValue = "1")Integer fy) {
		System.out.println(id);
		PageInfo<Review> Reviews=service.getReview(id,fy);

		Integer ReviewsNum=service.getReviewsNum(id);
		hs.setAttribute("Reviews",Reviews);
		hs.setAttribute("ReviewsNum",ReviewsNum);
		
		return "admin/news/review";
	}
	/**
	 * 
	 * @Title: postImg 
	 * @Description: 图片文章
	 * @return
	 * @return: Object
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("postImg")
	private Object postImg(HttpServletRequest request,Article article,
			MultipartFile file[],String desc[]) throws Exception {
User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		
		List<Image> list = new ArrayList<>();
		// 遍历处理每个上传图片 并存入list
		for (int i = 0; i < file.length && i < desc.length; i++) {
			String url = processFile(file[i]);
			Image image = new Image();
			image.setDesc(desc[i]);
			image.setUrl(url);
			list.add(image);
		}
		
		//
		Gson gson = new Gson();
		
		//设置作者
		article.setUserId(loginUser.getId());
		article.setContent(gson.toJson(list));
		//设置文章类型 是图片
		article.setArticleType(TypeEnum.IMG);
		
		int add = service.add(article);
		if(add > 0) {
			return true;
		}else {
			return false;
		}
		
	}
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
