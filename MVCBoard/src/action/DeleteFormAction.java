package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {//�ۻ��� ��

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response) throws Throwable {

        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");

        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("num", num);
        request.setAttribute("pageNum", pageNum);

        return "/MVC/deleteForm.jsp";
    }
}