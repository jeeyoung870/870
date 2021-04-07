package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response)throws Throwable {
        //제목글일경우
        int num=0,ref=1,re_step=0,re_level=0; 
        try{ 
         //파라미터로 전달된 num이 null이 아니라면(답글일경우. 제목글의 num값을 갖고오기 때문에!)
          if(request.getParameter("num")!=null){
		 num=Integer.parseInt(request.getParameter("num"));
		 ref=Integer.parseInt(request.getParameter("ref"));
		 re_step=Integer.parseInt(request.getParameter("re_step"));
		 re_level=Integer.parseInt(request.getParameter("re_level"));
	   }
	}catch(Exception e){e.printStackTrace();}
	
		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);

		return "/MVC/writeForm.jsp";
	}
}