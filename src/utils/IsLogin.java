package utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;

public class IsLogin {
	public void isLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
		}
	}
}
