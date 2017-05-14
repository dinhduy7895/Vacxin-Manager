package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bo.KhachHangBo;

/**
 * Servlet implementation class KhachHang_Payment
 */
@WebServlet("/KhachHang_Payment")
public class KhachHang_Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHang_Payment() {
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
		
		ArrayList<KhachHang> listKhachHang = null;
		KhachHangBo kHBo = new KhachHangBo();
		listKhachHang = kHBo.getListPaymentKH();
		System.out.println(listKhachHang.get(0).getMaKH()+" "+listKhachHang.get(0).getHoTen()+" "+listKhachHang.get(0).getMoney());
		HttpSession session = request.getSession() ;
		session.setAttribute("listKhachHang", listKhachHang);
		response.sendRedirect("khach-hang/payment.jsp");

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
