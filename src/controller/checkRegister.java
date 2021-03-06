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
 * Servlet implementation class checkRegister
 */
@WebServlet("/checkRegister")
public class checkRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession() ;
		String register = request.getParameter("register");
		if(register != null){
			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String rePass = request.getParameter("rePass");
			int role = Integer.parseInt(request.getParameter("role"));
			if(!pass.equals(rePass)){
				session.setAttribute("msg", "Password khong khop");
				response.sendRedirect("register.jsp");
			}			
			UserBo userBo = new UserBo();	
			if(userBo.isExist(username)){
				session.setAttribute("msg", "Username da ton tai");
				response.sendRedirect("register.jsp");
			}			User user = userBo.register(username, name, pass, role);
			if(user!=null){	
				session.setAttribute("user", user);		
				session.setAttribute("msg", "Them user moi thanh cong");
				RequestDispatcher rd = request.getRequestDispatcher("user_list");
				rd.forward(request, response);			
			}else{
				session.setAttribute("msg", "Khong the register");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp?error=khong the register");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
