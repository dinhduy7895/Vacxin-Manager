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

import model.bean.Benh;
import model.bo.BenhBo;
import model.bo.VacxinBo;

/**
 * Servlet implementation class Vacxin_add
 */
@WebServlet("/Vacxin_add")
public class Vacxin_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacxin_add() {
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
		String create = request.getParameter("create");
		BenhBo benhBo = new BenhBo();
		ArrayList<Benh> listBenh = benhBo.getListBenh();
		session.setAttribute("listBenh", listBenh);
		if(create == null){
			response.sendRedirect("vacxin/create.jsp");
		}
		else{
			VacxinBo vacxinBo = new VacxinBo();
			String gia = request.getParameter("gia");
			String name = request.getParameter("name");
			String brand = request.getParameter("brand");
			String mota = request.getParameter("mota");
			String[] benh = request.getParameterValues("benh[]");
			
			int somui = Integer.parseInt(request.getParameter("somui"));
			boolean check  = vacxinBo.register(name,gia,mota,brand,somui,benh);
			
			if(check == true){	
				
				session.setAttribute("vacxin_msg", "Them moi thanh cong ");				
				RequestDispatcher rd = request.getRequestDispatcher("Vacxin_index");
				rd.forward(request, response);
			}else{
				session.setAttribute("vacxin_msg", "Them moi khong  thanh cong ");				
				RequestDispatcher rd = request.getRequestDispatcher("Vacxin_index");
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
