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
	
	//������ ��ȭ�� ��ȭ�� ȯ���ϴ� �޼ҵ�
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
		//getWriter()�޼ҵ�� ��½�Ʈ���� PrintWriter��ü����
		PrintWriter pw = response.getWriter();
		//name���� command�� ������ ��û�� �޾ƿ�
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		//���� ��û�� command�� null�̸� ����ȭ����, calculate�̸� ����� ���. 
		if (command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font sixe=10>��ȯ ���</font><br>");
			pw.print("<html><font size=10>"+ result + "</font><br>");
			pw.print("<a href='/pro06/calc'>ȯ�� ����</a>");
			return;
		}
		
		pw.print("<html><title>ȯ�� ����</title>");
		pw.print("<font size=5>ȯ�� ����</font><br>");
		//��ȭ�Է��� �ٽ� ���� calc��û
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc'  /> ");
		pw.print("��ȭ : <input type='text' name='won' size=10  /> ");
		//����Ʈ�ڽ����� ���õ� ���� operator�� ����
		pw.print("<select name='operator' >");
		pw.print("<option vlaue='dollar'>�޷�</option>");
		pw.print("<option vlaue='en'>��ȭ</option>");
		pw.print("<option vlaue='wian'>����</option>");
		pw.print("<option vlaue='pound'>�Ŀ��</option>");
		pw.print("<option vlaue='euro'>����</option>");
		pw.print("</select>");
		//ȭ�鿡�� ������ ������, value���� ���� ����Ǿ� ����.
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.print("<input type='submit' value='��ȯ' />");
		pw.print("</form>");
		pw.print("</html>");
		pw.close();
	}

}
