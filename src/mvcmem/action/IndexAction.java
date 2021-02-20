package mvcmem.action;

import mvcmem.control.ActionForward;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws IOException{
		return new ActionForward("index.jsp", false);
	}

}
