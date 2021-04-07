package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	private static final float USD_RATE = 1104.70f;
	private static final float JPY_RATE = 10.113f;
	private static final float CNY_RATE = 163.30f;
	private static final float GBP_RATE = 1444.35f;
	private static final float EUR_RATE = 1295.97f;

	//private static final long serialVersionUID = 1L;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init method call");
	}
	
	//선택한 외화로 원화를 환산하는 메소드
	private static String calculate(float won, String operator) {
		String result = null;
		if (operator.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		}else if (operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		}else if (operator.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		}else if (operator.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		}else if (operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//getWriter()메소드로 출력스트림인 PrintWriter객체생성
		PrintWriter pw = response.getWriter();
		//name값이 command인 수행할 요청을 받아옴
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		//최초 요청시 command가 null이면 계산기화면을, calculate이면 계산결과 출력. 
		if (command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font sixe=10>변환 결과</font><br>");
			pw.print("<html><font size=10>"+ result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		//원화입력후 다시 서블릿 calc요청
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc'  /> ");
		pw.print("원화 : <input type='text' name='won' size=10  /> ");
		//셀렉트박스에서 선택된 값을 operator로 전송
		pw.print("<select name='operator' >");
		pw.print("<option vlaue='dollar'>달러</option>");
		pw.print("<option vlaue='en'>엔화</option>");
		pw.print("<option vlaue='wian'>위안</option>");
		pw.print("<option vlaue='pound'>파운드</option>");
		pw.print("<option vlaue='euro'>유로</option>");
		pw.print("</select>");
		//화면에는 보이지 않지만, value에는 값이 저장되어 잇음.
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.print("<input type='submit' value='변환' />");
		pw.print("</form>");
		pw.print("</html>");
		pw.close();
	}

}
