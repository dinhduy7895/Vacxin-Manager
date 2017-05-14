package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Vacxin;
import model.bo.VacxinBo;

/**
 * Servlet implementation class Vacxin_search
 */
@WebServlet("/Vacxin_search")
public class Vacxin_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacxin_search() {
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
		
		String gia = request.getParameter("gia");
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String mota = request.getParameter("mota");
		int somui;
		if(request.getParameter("somui") == "") somui = -1;
		else somui = Integer.parseInt(request.getParameter("somui"));
		ArrayList<Vacxin> listVacxin = null;
		VacxinBo vacxinBo = new VacxinBo();
		listVacxin = vacxinBo.search(name,gia,mota,brand,somui);
		System.out.println(listVacxin);
		HttpSession session = request.getSession() ;
		session.setAttribute("listVacxin", listVacxin);
		response.sendRedirect("vacxin/index.jsp");
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
