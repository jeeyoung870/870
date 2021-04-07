package board;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import java.util.*;

public class BoardDBBean {   
    private static BoardDBBean instance = new BoardDBBean();
   
    public static BoardDBBean getInstance() {
        return instance;
    }
    
   //객체 한 개를 돌려가면 쓸 수 있는 싱글턴 형식(private제한자로 DAO안에서만 쓸 수 있게 만듬)
    private BoardDBBean() {
    }
    
    private Connection getConnection() throws Exception {
	String jdbcDriver = "jdbc:apache:commons:dbcp:pool";         
        return DriverManager.getConnection(jdbcDriver);
    }
    
    //writeProAction에서 사용하는 메소드
    public void insertArticle(BoardDataBean article) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
	ResultSet rs = null;

	int num=article.getNum();	//제목글이라면 0, 답변글이라면 !=0. 답글달려는 글의 num(!= 0)
	int ref=article.getRef();	//제목글의 그룹번호(제목글의 num과 같은값)
	int re_step=article.getRe_step();
	int re_level=article.getRe_level();
	int number=0;	//새로 등록할 제목글의 글번호(num) / 답글의 그룹번호(ref)
        String sql="";

        try {
            conn = getConnection();
            //num중에 가장 큰 번호(마지막으로 쓴 글번호)를 구함
            pstmt = conn.prepareStatement("select max(num) from board");
            rs = pstmt.executeQuery();

	    if (rs.next())   //마지막 글번호 + 1 == 지금 insert할 글번호
	      number=rs.getInt(1)+1;
	    else   //글이 하나도 없으면,(max값이 없는경우)
	      number=1;
  
	    if (num!=0){ 	//답글일경우, re_step> ? : 답글달려는글 아래 있는글들은 전부 re_step+1시킨다(빈자리에 새글의 re_step을 낑겨주기 위해)
	      //같은 level중에서는 새 글의 re_step값이 가장 작다.
	      sql="update board set re_step=re_step+1 where ref= ? and re_step> ?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, ref);
	      pstmt.setInt(2, re_step);
	      pstmt.executeUpdate();
	      //등록할 답글의 re_step과 re_level설정
	      re_step=re_step+1;	//원글re_step+1
	      re_level=re_level+1;	//원글re_level+1
	    }else{  //제목글일경우
		      ref=number;
	      re_step=0;
	      re_level=0;
	    }
           
	    //새글을 board에 insert하기
        sql = "insert into board(num,writer,email,subject,passwd,reg_date,";
	    sql+="ref,re_step,re_level,content,ip) values(board_num.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getWriter());
            pstmt.setString(2, article.getEmail());
            pstmt.setString(3, article.getSubject());
            pstmt.setString(4, article.getPasswd());
            pstmt.setTimestamp(5, article.getReg_date());
            pstmt.setInt(6, ref);
            pstmt.setInt(7, re_step);
            pstmt.setInt(8, re_level);
            pstmt.setString(9, article.getContent());
            pstmt.setString(10, article.getIp());

            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
	    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    
   //전체 글 수 가져오는 메소드(select count(*) from board)
    public int getArticleCount() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select count(*) from board");
            rs = pstmt.executeQuery(); //전체 레코드 갯수 가져옴

            if (rs.next()) {
            	//커서가 가지고온 레코드의 첫번째 컬럼의 값 가져오기
               x= rs.getInt(1);
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return x;//글갯수 리턴
    }

public int getArticleCount(int n, String searchKeyword) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		//설정한 0, 1, 2 인덱스별로 검색할 컬럼 설정
		String[] column_name = {"writer","subject","content"};
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			//searchKeyword를 포함하는 레코드 개수 구하기
			pstmt = conn.prepareStatement("select count (*) from board where "+column_name[n]+" like '%"+searchKeyword+"%'");
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return x; //검색한 글 개수 리턴
	}
    //검색키워드 없을때, 첫ㅂ너째 글번호, 마지막 글번호 받아서 실행하는 메소드
    public List<BoardDataBean> getArticles(int start, int end) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardDataBean> articleList=null;
        try {
            conn = getConnection();
           
            //from절(인라인뷰)/rownum:가상번호
            pstmt = conn.prepareStatement(
            "select *  " +
            "from (select num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip,readcount,rownum r " +
            "from (select * " +
            "from board order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                articleList = new ArrayList<BoardDataBean>(end);
                do{
                //레코드의 컬럼값을 BoardDataBean객체에 저장해 list에 담기
                  BoardDataBean article= new BoardDataBean();
                  article.setNum(rs.getInt("num"));
                  article.setWriter(rs.getString("writer"));
                  article.setEmail(rs.getString("email"));
                  article.setSubject(rs.getString("subject"));
                  article.setPasswd(rs.getString("passwd"));
                  article.setReg_date(rs.getTimestamp("reg_date"));
                  article.setReadcount(rs.getInt("readcount"));
                  article.setRef(rs.getInt("ref"));
                  article.setRe_step(rs.getInt("re_step"));
                  article.setRe_level(rs.getInt("re_level"));
                  article.setContent(rs.getString("content"));
                  article.setIp(rs.getString("ip"));
 
                  articleList.add(article);
                }while(rs.next());
            }//if
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return articleList;
    }
    
    //검색 index와 검색키워드로 해당글 찾아서 그 리스트 리턴
    public List getArticles(int start, int end, int n, String searchKeyword) throws Exception
   	{
   		Connection conn = null;
   		PreparedStatement pstmt = null;
   		ResultSet rs = null;
   		List articleList = null;
   		//설정한 0, 1, 2 인덱스별로 검색할 컬럼 설정
   		String[] column_name = {"writer","subject","content"};
   		
   		try
   		{
   			conn = getConnection();
   			
   			String sql = "select num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip,readcount,r "	
   						+ "from (select num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip,readcount,rownum r "
   						+"from (select num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip,readcount "
   						+"from board order by ref desc, re_step asc) where "+column_name[n]+" like '%"+searchKeyword+"%' order by ref desc, re_step asc ) where r >= ? and r <= ?";
   			
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setInt(1, start);
   			pstmt.setInt(2,	end);
   			
   			rs = pstmt.executeQuery();
   			
   			if(rs.next())
   			{
   				articleList = new ArrayList(end);
   				
   				do{
   					BoardDataBean article = new BoardDataBean();
   					
   					article.setNum(rs.getInt("num"));
   					article.setWriter(rs.getString("writer"));
   					article.setEmail(rs.getString("email"));
   					article.setSubject(rs.getString("subject"));
   					article.setPasswd(rs.getString("passwd"));
   					article.setReg_date(rs.getTimestamp("reg_date"));
   					article.setReadcount(rs.getInt("readcount"));
   					article.setRef(rs.getInt("ref"));
   					article.setRe_step(rs.getInt("re_step"));
   					article.setRe_level(rs.getInt("re_level"));
   					article.setContent(rs.getString("content"));
   					article.setIp(rs.getString("ip"));
   					
   					
   					articleList.add(article);
   				}while(rs.next());
   				
   			}
   			
   		}
   		catch(Exception ex)
   		{
   			ex.printStackTrace();
   		}
   		finally
   		{
   			if(rs != null) try {rs.close();} catch(SQLException ex){}
   			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
   			if(conn != null) try {conn.close();} catch(SQLException ex){}
   		}
   		
   		return articleList;
   	}

    public BoardDataBean getArticle(int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardDataBean article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            //해당번호의 레코드를 찾아서 조회수 +1
            "update board set readcount=readcount+1 where num = ?");
            pstmt.setInt(1, num);
	    pstmt.executeUpdate(); //해당글의 조회수를 +1시킴

            pstmt = conn.prepareStatement(
            "select * from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new BoardDataBean();
                article.setNum(rs.getInt("num"));
                article.setWriter(rs.getString("writer"));
                article.setEmail(rs.getString("email"));
                article.setSubject(rs.getString("subject"));
                article.setPasswd(rs.getString("passwd"));
                article.setReg_date(rs.getTimestamp("reg_date"));
                article.setReadcount(rs.getInt("readcount"));
                article.setRef(rs.getInt("ref"));
                article.setRe_step(rs.getInt("re_step"));
                article.setRe_level(rs.getInt("re_level"));
                article.setContent(rs.getString("content"));
                article.setIp(rs.getString("ip"));    
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return article;	//변ㄱ경된 객체를 리턴
    }

    public BoardDataBean updateGetArticle(int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardDataBean article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new BoardDataBean();
                article.setNum(rs.getInt("num"));
                article.setWriter(rs.getString("writer"));
                article.setEmail(rs.getString("email"));
                article.setSubject(rs.getString("subject"));
                article.setPasswd(rs.getString("passwd"));
                article.setReg_date(rs.getTimestamp("reg_date"));
                article.setReadcount(rs.getInt("readcount"));
                article.setRef(rs.getInt("ref"));
                article.setRe_step(rs.getInt("re_step"));
                article.setRe_level(rs.getInt("re_level"));
                article.setContent(rs.getString("content"));
                article.setIp(rs.getString("ip"));    
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return article;
    }

    public int updateArticle(BoardDataBean article) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;

        String dbpasswd="";
        String sql="";
        int x=-1;	//경우의 수 -> 비번 틀린경우 : 0, 맞아서 수정된 경우 : 1
        try {
            conn = getConnection();
           
	    pstmt = conn.prepareStatement("select passwd from board where num = ?");
            pstmt.setInt(1, article.getNum());
            rs = pstmt.executeQuery();
    //기존의 passwd와 새로 입력된 passwd비교해서 같으면 x=1, 다르면 x=0
	if(rs.next()){
	    dbpasswd= rs.getString("passwd");
	    if(dbpasswd.equals(article.getPasswd())){
		sql="update board set writer=?,email=?,subject=?,passwd=?";
		sql+=",content=? where num=?";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, article.getWriter());
                pstmt.setString(2, article.getEmail());
                pstmt.setString(3, article.getSubject());
                pstmt.setString(4, article.getPasswd());
                pstmt.setString(5, article.getContent());
		pstmt.setInt(6, article.getNum());  //getNum : 글번호
                pstmt.executeUpdate();
		x= 1;
	    }else{
		x= 0;
	    }
	  }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
	    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	 return x;
    }
   
    //글번호와 비밀번호 인자를 받아 해당 글 지우는 메소드
    public int deleteArticle(int num, String passwd) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;   //경우의수
        try {
	    conn = getConnection();

            pstmt = conn.prepareStatement(
            "select passwd from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
		dbpasswd= rs.getString("passwd");
		//db에 저장된 비번과 입력받은 비번이 같다면,
		if(dbpasswd.equals(passwd)){
			//삭제하기
		    pstmt = conn.prepareStatement("delete from board where num=?");
                    pstmt.setInt(1, num);
                    pstmt.executeUpdate();
		    x= 1; 
		}else
		    x= 0; 
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return x;
    }
}