package mvc.action;

import mvc.control.ActionForward;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws IOException{
		System.out.println("IndexAction의 execute() 수행됨!");
		return new ActionForward("index.jsp", false);
	}

}
