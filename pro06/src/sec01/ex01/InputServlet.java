package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init �޼ҵ� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼ҵ� ȣ��");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : ��Ĺ ������ �ڵ������� HttpServletRequestŬ������ ��ü
		request.setCharacterEncoding("utf-8");
		//�� ���� ���۵� ��: getParameter()�̿�
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//���� name���� ���� �� ���۽� : getParameterValues() �̿�(�迭����)
		System.out.println("���̵� : " + user_id);
		System.out.println("��й�ȣ : " + user_pw);
		String [] subject = request.getParameterValues("subject");
		for (String str : subject) {
			System.out.println("���ð��� : " + str);
		}
	}

}




