package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class DeleteProAction implements CommandAction {

    public String requestPro( HttpServletRequest request,
        HttpServletResponse response) throws Throwable {
    	//input 타입이 password일 경우 무조건 영타입력으로 전달됨(굳이 utf-8안해도됨)
        request.setCharacterEncoding("UTF-8");

        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        String passwd = request.getParameter("passwd");
   
        BoardDBBean dbPro = BoardDBBean.getInstance();
        int check = dbPro.deleteArticle(num, passwd);

        
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("check", check);

        return "/MVC/deletePro.jsp";
    }
}
