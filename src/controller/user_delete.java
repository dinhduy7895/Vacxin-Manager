package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.UserBo;

/**
 * Servlet implementation class user_delete
 */
@WebServlet("/user_delete")
public class user_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_delete() {
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
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		User user = null;
		UserBo userBo = new UserBo();
		user = userBo.getUser(id);
		if(user!=null){
			boolean check = false;
			check = userBo.delete(id);
			if(check == false ){
				response.sendRedirect("welcome.jsp");
			}
			else {
			RequestDispatcher rd = request.getRequestDispatcher("user_list");
			rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("welcome.jsp");
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
