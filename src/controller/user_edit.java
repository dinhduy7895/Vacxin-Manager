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
 * Servlet implementation class user_edit
 */
@WebServlet("/user_edit")
public class user_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_edit() {
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
		User user = null;
		UserBo userBo = new UserBo();
		user = userBo.getUser(id);
		if(user!=null){
			HttpSession session = request.getSession();
			request.setAttribute("getUser", user);
			if(request.getParameter("update") == null){
			
			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp?id="+id);
			rd.forward(request, response);
			}
			else{
				String username = request.getParameter("username");
				String name = request.getParameter("name");
				String pass = request.getParameter("pass");
				int role = Integer.parseInt(request.getParameter("role"));
				boolean check = false;
				check = userBo.update(id,username,pass,name,role);
				if(check == false) {
					session.setAttribute("msg", "Update khong thanh cong");
					RequestDispatcher rd = request.getRequestDispatcher("/update.jsp?id="+id);
					rd.forward(request, response);
				}else{
					session.setAttribute("msg", "update Thanh cong");
					RequestDispatcher rd = request.getRequestDispatcher("user_list");
					rd.forward(request, response);
				}
			}
		}
		else {
			response.sendRedirect("user_list.jsp");
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
