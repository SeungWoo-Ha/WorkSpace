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
        System.out.println("LifeCycle의 생성자 호출됨...");
       
    }
    
	@Override
	//LifeServlet의 초기화 작업을 담당
	//Servlet객체 생성시 단 한번 수행
	public void init() throws ServletException {
		System.out.println("init() 호출...");;
	}

	@Override
	//LifeServlet 객체가 WAS에서 소멸될 때 수행
	public void destroy() {
		System.out.println("destroy()호출 됨....");
	}

    @Override
    //클라이언트의 연결요청이 있을때마다 호출
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출됨....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
