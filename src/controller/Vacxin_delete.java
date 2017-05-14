package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Vacxin;
import model.bo.VacxinBo;

/**
 * Servlet implementation class Vacxin_delete
 */
@WebServlet("/Vacxin_delete")
public class Vacxin_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacxin_delete() {
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
		Vacxin vacxin = null;
		VacxinBo vacxinBo = new VacxinBo();
		vacxin = vacxinBo.getVacxin(id);
		HttpSession session = request.getSession();
		if(vacxin!=null){
			boolean check = false;
			check = vacxinBo.delete(id);
			if(check == false ){
				session.setAttribute("Vacxin_msg", "Xoa that bai");
				response.sendRedirect("vacxin/index.jsp");
			}
			else {
			session.setAttribute("Vacxin_msg", "Xoa thanh cong");
			RequestDispatcher rd = request.getRequestDispatcher("Vacxin_index");
			rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("vacxin/index.jsp");
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
