package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class UpdateProAction implements CommandAction {

    public String requestPro( HttpServletRequest request,
        HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("UTF-8");

        String pageNum = request.getParameter("pageNum");

	BoardDataBean article = new BoardDataBean();
	//BoardDataBean객체에 전송된 파라미터를 모두 넣기
        article.setNum(Integer.parseInt(request.getParameter("num")));
        article.setWriter(request.getParameter("writer"));
        article.setEmail(request.getParameter("email"));
        article.setSubject(request.getParameter("subject"));
        article.setContent(request.getParameter("content"));
        article.setPasswd(request.getParameter("passwd"));
   
	BoardDBBean dbPro = BoardDBBean.getInstance();
        int check = dbPro.updateArticle(article);	//메소드 실행결과 x의값이 반환됨

        request.setAttribute("pageNum", pageNum);
        request.setAttribute("check", check);

        return "/MVC/updatePro.jsp";
    }
}




