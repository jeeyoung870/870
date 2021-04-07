package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ContentAction implements CommandAction {//�۳��� ó��

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response)throws Throwable {
       
        int num = Integer.parseInt(request.getParameter("num"));//글번호
        String pageNum = request.getParameter("pageNum");//페이지번호

        BoardDBBean dbPro = BoardDBBean.getInstance();//DBó��
        BoardDataBean article =  dbPro.getArticle(num);//�ش� �۹�ȣ�� ���� �ش� ���ڵ�
 
        //request객체에 저장
        request.setAttribute("num", num);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("article", article);
       
        return "/MVC/content.jsp";	//포워딩
    }
}
