package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBo;

/**
 * Servlet implementation class checkLogin
 */
@WebServlet("/checkLogin")
public class checkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("login");
		if(submit!=null){
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			
			UserBo userBo = new UserBo();
			User user  = userBo.isValidUser(username, pass);
			if(user != null) {
				HttpSession session = request.getSession() ;
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("user_list");
				rd.forward(request, response);
				
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/login-error.jsp");
				rd.forward(request, response);
			}
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
