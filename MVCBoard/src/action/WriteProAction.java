package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class WriteProAction implements CommandAction {// 

	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");//

		BoardDataBean article = new BoardDataBean();// 모든 데이터 저장할 객체 생성
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPasswd(request.getParameter("passwd"));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr()); //getRemoteAddr : 사용자의 ip를 구하는 메소드
		//BoardDBBean객체 만들어서 BoardDataBean객체(article)삽입하기(db에 등록됨)
		BoardDBBean dbPro = BoardDBBean.getInstance();
		dbPro.insertArticle(article);

		return "/MVC/writePro.jsp";
	}
}







