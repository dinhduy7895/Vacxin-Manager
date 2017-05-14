package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.KhachHang;

	

public class KhachHangDao {
	private static Database db = new Database();
	private Connection conn = null ;
	private ResultSet rs ;
	private Statement st ;
	private PreparedStatement pst ;
	public KhachHangDao(){
		conn = db.getConnection();
	}

	public ArrayList<KhachHang> getListKH(){
		conn = db.getConnection();
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		KhachHang KH;
		String query = "Select * from KhachHang";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				KH = new KhachHang(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				listKhachHang.add(KH);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listKhachHang;
	}
	public ArrayList<KhachHang> getListHistoryKH(int maKH){
		conn = db.getConnection();
		ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		int count = 0 ;
		String query = "SELECT DISTINCT KhachHang.MaKH, KhachHang.HoTen, Benh.TenBenh,Vacxin.MaVacxin,Vacxin.TenVacxin,Vacxin.SoMui from KhachHang "
				+ "INNER JOIN LichSuTiemPhong ON LichSuTiemPhong.MaKH = KhachHang.MaKH"
				+ " INNER JOIN Vacxin on Vacxin.MaVacxin = LichSuTiemPhong.MaVacxin "
				+ "INNER JOIN PhongBenh on PhongBenh.MaVacxin = Vacxin.MaVacxin "
				+ "INNER JOIN Benh ON Benh.MaBenh = PhongBenh.MaBenh where KhachHang.MaKH = " + maKH;
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				listKhachHang.add(new KhachHang(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6)));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listKhachHang;
	}
	public ArrayList<KhachHang>  getListPaymentKH(){
		conn = db.getConnection();
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		int count = 0 ;
		String query =" SELECT KhachHang.MaKH, KhachHang.HoTen, Sum(Vacxin.GiaVacxin) AS payment FROM KhachHang "
				+ "INNER JOIN LichSuTiemPhong on KhachHang.MaKH = LichSuTiemPhong.MaKH "
				+ "INNER JOIN Vacxin on Vacxin.MaVacxin = LichSuTiemPhong.MaVacxin "
				+ "GROUP BY KhachHang.HoTen,KhachHang.MaKH  ORDER BY payment DESC";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				listKhachHang.add(new KhachHang(rs.getInt(1),rs.getString(2),rs.getString(3)));

			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listKhachHang;
	}
	
}
