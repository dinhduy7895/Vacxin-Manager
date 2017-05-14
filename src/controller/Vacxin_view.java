package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Vacxin;
import model.bo.BenhBo;
import model.bo.VacxinBo;

/**
 * Servlet implementation class Vacxin_view
 */
@WebServlet("/Vacxin_view")
public class Vacxin_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacxin_view() {
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
		BenhBo benhBo = new BenhBo();
		ArrayList<String> tenBenh = benhBo.getListBenhByName(id);
		if(vacxin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("getVacxin", vacxin);
			session.setAttribute("tenBenh", tenBenh);
			
			RequestDispatcher rd = request.getRequestDispatcher("vacxin/view.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/Vacxin_index");
			rd.forward(request, response);
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
