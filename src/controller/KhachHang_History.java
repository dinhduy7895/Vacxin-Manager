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

import model.bean.KhachHang;
import model.bo.KhachHangBo;

/**
 * Servlet implementation class KhachHang_History
 */
@WebServlet("/KhachHang_History")
public class KhachHang_History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHang_History() {
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
		ArrayList<KhachHang> listKhachHang = null;
		KhachHangBo kHBo = new KhachHangBo();
		listKhachHang = kHBo.getListHistoryKH(id);
		HttpSession session = request.getSession() ;
		session.setAttribute("listKhachHang", listKhachHang);
		RequestDispatcher rd = request.getRequestDispatcher("khach-hang/history.jsp");
		rd.forward(request, response);
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
