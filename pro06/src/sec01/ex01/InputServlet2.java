package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		request.setCharacterEncoding("utf-8");
		//html���� ������ name���� Enumeration(�迭)Ÿ������ �޾� ����.
		Enumeration enu = request.getParameterNames();
		//Enumeration ��ü�� ���� 1�� �̻��̸� true, �ƴϸ� false ��ȯ
		while (enu.hasMoreElements()) {
			//enu�� name���� ���� name���� ���ʴ�� �Ѱ�����������
			String name = (String) enu.nextElement();
			//������ name������ value��������(���� �̸��� ���� ���� ���� ��츦 ���� �迭��ü�� ������)
			String [] values = request.getParameterValues(name);
			for (String value : values) {
				//�Ӽ�(name)���� value ���
				System.out.println("name = "+ name + ", value = " + value);
			}
		}
	}

}
