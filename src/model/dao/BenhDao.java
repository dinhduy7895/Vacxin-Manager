package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Benh;

	

public class BenhDao {
	private static Database db = new Database();
	private Connection conn = null ;
	private ResultSet rs ;
	private Statement st ;
	private PreparedStatement pst ;
	public BenhDao(){
		conn = db.getConnection();
	}

	public ArrayList<Benh> getListBenh(){
		conn = db.getConnection();
		ArrayList<Benh> listBenh = new ArrayList<Benh>();
		Benh benh;
		String query = "Select * from Benh";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				benh= new Benh(rs.getString("TenBenh"),rs.getString("MoTa"),rs.getInt("MaBenh"));
				listBenh.add(benh);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listBenh;
	}
	public List<Integer> getListBenhById(int MaVacXin){
		conn = db.getConnection();
		List<Integer> idBenh = new ArrayList<>();
		int count = 0 ;
		String query = "Select MaBenh from PhongBenh where MaVacXin = " + MaVacXin;
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				idBenh.add(rs.getInt("MaBenh"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return idBenh;
	}
	public ArrayList<String>  getListBenhByName(int MaVacXin){
		conn = db.getConnection();
		ArrayList<String> TenBenh = new ArrayList<String>();
		int count = 0 ;
		String query = "Select TenBenh from Benh where MaBenh in (Select MaBenh from PhongBenh where MaVacXin =' " + MaVacXin +"')";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				TenBenh.add(rs.getString("TenBenh"));

			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return TenBenh;
	}
	
}
