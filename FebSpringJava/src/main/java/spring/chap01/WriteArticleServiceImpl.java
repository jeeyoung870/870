package spring.chap01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("writeArticleService")
public class WriteArticleServiceImpl implements WriteArticleService {
	@Autowired 
	private ArticleDao articleDao;	
	 
	 public WriteArticleServiceImpl() {}
	 public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}


	public WriteArticleServiceImpl(ArticleDao articleDao) {
		 this.articleDao = articleDao;
	 }
	 
	 public void write(Article article) {
		 System.out.println("WriteArticleServiceImpl.write() 메서드 실행");
		 articleDao.insert(article);
	 }
}