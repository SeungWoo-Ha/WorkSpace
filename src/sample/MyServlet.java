package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    try{
	    	out.println("<html><head><title>My First Servlet</title></head></html><body>");
	        out.println("<h2>My First Servlet File</h2><hr color = 'red'><br>");
	        out.println("<p align = 'center'>지금은 ");
	        out.println(new java.util.Date());
	        out.println(" 입니다.</p></body></html>");
	    }finally{
	        out.close();
	    }
	}
}
