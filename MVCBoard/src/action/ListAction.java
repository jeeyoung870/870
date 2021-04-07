package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ListAction implements CommandAction {

    public String requestPro(HttpServletRequest request,
        HttpServletResponse response)throws Throwable {
       
    	request.setCharacterEncoding("UTF-8");
        String pageNum = request.getParameter("pageNum");

        if (pageNum == null) {
        	//페이지넘버가 지정안됐다면 1번째 페이지 보여주기
            pageNum = "1";
        }
           
        //search파라미터로 전달된 값이 있다면 해당목록 검색
    	String search = request.getParameter("search");	
    	int searchn = 0;
    	//검색내용이 없다면,
        if(search == null) {
    		search = "";
    	} else {
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}

        
        
        int pageSize = 5;	//한 페이지에서 보여줄 글의 수
        int currentPage = Integer.parseInt(pageNum);	//요청한 페이지번호
        int startRow = (currentPage - 1) * pageSize + 1;	//첫번째 글번호
        int endRow = currentPage * pageSize;	//마지막 글번호
        int count = 0;	//전체 글 수
        int number=0;	//글제목 앞에 보여지는 가상번호(실제 글번호랑은 관계x)

        List<BoardDataBean> articleList = null;
        BoardDBBean dbPro = BoardDBBean.getInstance();
        
        if(search.equals("") || search == null)
    		count = dbPro.getArticleCount();	//전체 목록 가져오기 - 전체 글수
    	else
    		count = dbPro.getArticleCount(searchn,search);	//검색 목록 - 조건에 맞는 글 수 꺼내오기
       //글이 있다면, 페이지에서 보여줄 글들을 가져오기
        if (count > 0) {
        	if(search.equals("") || search == null){
    			articleList = dbPro.getArticles(startRow, endRow);
        	}else{
    			articleList = dbPro.getArticles(startRow, endRow, searchn, search);  
        	}
        } else {
            articleList = Collections.EMPTY_LIST;
        }

        //현재페이지에서 맨 위(첫번째) 글번호(가상번호)를 구하는 코드
        number = count-(currentPage-1)*pageSize;
     
        //view에서 사용할 데이터를 전부 request/session에 저장
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("startRow", startRow);
        request.setAttribute("endRow", endRow);
        request.setAttribute("count", count);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("number", number);
        request.setAttribute("articleList", articleList);
       
        return "/MVC/list.jsp";//view 정보 - WebContent 하위 경로부터..
        //리턴값을 가지고 controller로 돌아간다
    }
}













