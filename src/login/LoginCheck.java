package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request,
									HttpServletResponse response)
										throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		StringBuffer sql = new StringBuffer();
		sql.append("select pass from LOGIN ");
		sql.append("where ID = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpwd;
		
		try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1",
						"mytest","mytest");
			  pstmt = con.prepareStatement(sql.toString());
			  pstmt.setString(1, id);
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) {
				  dbpwd = rs.getString("PASS");
				  if(dbpwd.equals(pwd)) {
					  HttpSession session = request.getSession();
					  session.setAttribute("user", id);
				  }else {
					  System.err.println("��й�ȣ ����");
				  }
			  }else {
				  System.err.println("���̵� �������� �ʽ��ϴ�.");
			  }
				
		  }catch(SQLException e) {
			  System.err.println("������ ���̽� ���� ����: ������ ����");
		  }catch(ClassNotFoundException e) {
			  System.err.println("����̹� �ε� ����");
		  }finally {
			  try {if(rs != null)rs.close();}catch(SQLException e) {}
			  try {if(pstmt != null)pstmt.close();}catch(SQLException e) {}
			  try {if(con != null)con.close();}catch(SQLException e){}
		  }
		response.sendRedirect("Login");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

}
