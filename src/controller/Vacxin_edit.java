package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Benh;
import model.bean.Vacxin;
import model.bo.BenhBo;
import model.bo.VacxinBo;

/**
 * Servlet implementation class Vacxin_edit
 */
@WebServlet("/Vacxin_edit")
public class Vacxin_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacxin_edit() {
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
		Vacxin vacxin = null;
		VacxinBo vacxinBo = new VacxinBo();
		vacxin = vacxinBo.getVacxin(id);
		BenhBo benhBo = new BenhBo();
		List<Integer> idBenh = benhBo.getListBenhById(id);
		ArrayList<Benh> listBenh = benhBo.getListBenh();
		if(vacxin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("getVacxin", vacxin);
			session.setAttribute("idBenh", idBenh);
			session.setAttribute("listBenh", listBenh);
			if(request.getParameter("update") == null){
			
			RequestDispatcher rd = request.getRequestDispatcher("vacxin/update.jsp");
			rd.forward(request, response);
			}
			else{
				System.out.println("vacxin !null");

				String gia = request.getParameter("gia");
				String name = request.getParameter("name");
				String brand = request.getParameter("brand");
				String mota = request.getParameter("mota");
				String benh[] = request.getParameterValues("benh[]");
				int somui = Integer.parseInt(request.getParameter("somui"));
				boolean check = false;
				check = vacxinBo.update(id,name,gia,mota,brand,somui,benh);
				System.out.println(check);
				if(check == false) {
					session.setAttribute("Vacxin_msg", "Update khong thanh cong");
					RequestDispatcher rd = request.getRequestDispatcher("vacxin/update.jsp?id="+id);
					rd.forward(request, response);
				}else{
					session.setAttribute("Vacxin_msg", "update Thanh cong");
					RequestDispatcher rd = request.getRequestDispatcher("Vacxin_index");
					rd.forward(request, response);
				}
			}
		}
		else {
			System.out.println("vacxin null");
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
