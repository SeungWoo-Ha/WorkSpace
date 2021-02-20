package sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycle() {
        System.out.println("LifeCycle�� ������ ȣ���...");
       
    }
    
	@Override
	//LifeServlet�� �ʱ�ȭ �۾��� ���
	//Servlet��ü ������ �� �ѹ� ����
	public void init() throws ServletException {
		System.out.println("init() ȣ��...");;
	}

	@Override
	//LifeServlet ��ü�� WAS���� �Ҹ�� �� ����
	public void destroy() {
		System.out.println("destroy()ȣ�� ��....");
	}

    @Override
    //Ŭ���̾�Ʈ�� �����û�� ���������� ȣ��
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() ȣ���....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
