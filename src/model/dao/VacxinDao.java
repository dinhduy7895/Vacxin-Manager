package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Vacxin;

public class VacxinDao {
	private static Database db = new Database();
	private Connection conn = null;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;

	public VacxinDao() {
		conn = db.getConnection();
	}

	// public Vacxin isValMaVacxinUSer(String name, String pass){
	// conn = db.getConnection();
	// Vacxin vacxin = null;
	// String query = "Select * from vacxins where vacxinname = '" + name + "'
	// and password = '"+pass+"'";
	// System.out.println("sql "+query);
	// try {
	// st = conn.createStatement();
	// rs = st.executeQuery(query);
	// while(rs.next()){
	// vacxin = new
	// Vacxin(rs.getInt("MaVacxin"),rs.getString("vacxinname"),rs.getString("password"),rs.getString("name"),rs.getInt("role"));
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return vacxin;
	// }
	// public boolean isExist(String vacxinname){
	// conn = db.getConnection();
	// Vacxin vacxin = new Vacxin();
	// int count = 0;
	// String query = "Select count(*) from vacxins where vacxinname = '" +
	// vacxinname + "'";
	// System.out.println("sql "+query);
	// try {
	// st = conn.createStatement();
	// rs = st.executeQuery(query);
	// while(rs.next()){
	// count = rs.getInt(1);
	// }
	// if(count==1) return true;
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return false;
	// }
	public boolean register(String name, String gia, String mota, String brand, int somui, String[] benh) {
		conn = db.getConnection();
		int check = 0;
		int count = 0;
		String query = "INSERT into Vacxin (TenVacxin,SoMui,MoTa,GiaVacXin,TenHang) VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, name);
			pst.setInt(2, somui);
			pst.setString(3, mota);
			pst.setString(4, gia);
			pst.setString(5, brand);
			check = pst.executeUpdate();
			System.out.println("check ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check > 0) {
			try {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					long lastId = rs.getLong(1);

					query = "INSERT into PhongBenh (MaVacXin,MaBenh,GhiChu) VALUES (?,?,?)";

					pst = conn.prepareStatement(query);
					for (int i = 0; i < benh.length; i++) {
						pst.setLong(1, lastId);
						pst.setInt(2, Integer.valueOf(benh[i]));
						pst.setString(3, "Done");
						int temp = pst.executeUpdate();
						System.out.println(temp);
					}
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return true;
		} else
			return false;
	}

	public ArrayList<Vacxin> getListVacxin() {
		conn = db.getConnection();
		ArrayList<Vacxin> listVacxin = new ArrayList<Vacxin>();
		Vacxin vacxin;
		String query = "Select * from Vacxin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				vacxin = new Vacxin(rs.getInt("MaVacxin"), rs.getString("TenVacxin"), rs.getInt("SoMui"),
						rs.getString("MoTa"), rs.getString("GiaVacxin"), rs.getString("TenHang"));
				listVacxin.add(vacxin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listVacxin;
	}

	public Vacxin getVacxin(int MaVacxin) {
		conn = db.getConnection();
		Vacxin vacxin = null;
		String query = "Select * from Vacxin where MaVacxin  = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, MaVacxin);
			rs = pst.executeQuery();
			while (rs.next()) {

				vacxin = new Vacxin(rs.getInt("MaVacxin"), rs.getString("TenVacxin"), rs.getInt("SoMui"),
						rs.getString("MoTa"), rs.getString("GiaVacxin"), rs.getString("TenHang"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vacxin;
	}

	public boolean update(int MaVacxin, String name, String gia, String mota, String brand, int somui, String[] benh) {
		conn = db.getConnection();
		int check = 0;
		int count = 0;
		String query = "Update Vacxin SET TenVacxin=? ,SoMui=? , MoTa=? , GiaVacxin = ?, TenHang = ?  where MaVacxin=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, somui);
			pst.setString(3, mota);
			pst.setString(4, gia);
			pst.setString(5, brand);
			pst.setInt(6, MaVacxin);

			check = pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check > 0) {
			query = "DELETE from PhongBenh where MaVacxin=?";
			try {
				pst = conn.prepareStatement(query);

				pst.setInt(1, MaVacxin);

				check = pst.executeUpdate();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (check > 0) {
				query = "INSERT into PhongBenh (MaVacXin,MaBenh,GhiChu) VALUES (?,?,?)";

				try {
					pst = conn.prepareStatement(query);
					for (int i = 0; i < benh.length; i++) {
						pst.setInt(1, MaVacxin);
						pst.setInt(2, Integer.valueOf(benh[i]));
						pst.setString(3, "Done");
						int temp = pst.executeUpdate();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else return false;
		} else return false;

	}

	public boolean delete(int MaVacxin) {
		conn = db.getConnection();
		int check = 0;
		int count = 0;
		String query = "DELETE from PhongBenh  where MaVacxin=?";
		try {
			pst = conn.prepareStatement(query);

			pst.setInt(1, MaVacxin);

			check = pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 query = "DELETE from Vacxin  where MaVacxin=?";
		try {
			pst = conn.prepareStatement(query);

			pst.setInt(1, MaVacxin);

			check = pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (check > 0)
			return true;
		else
			return false;
	}

	public ArrayList<Vacxin> search(String name, String gia, String mota, String brand, int somui) {
		conn = db.getConnection();
		ArrayList<Vacxin> listVacxins = new ArrayList<Vacxin>();
		Vacxin vacxin;
		String query = "Select * from Vacxin where TenVacxin LIKE '%" + name + "%' and MoTa LIKE '%" + mota
				+ "%'and TenHang LIKE '%" + brand + "%'";
		if (somui != -1)
			query = query + "and SoMui ='" + somui + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				vacxin = new Vacxin(rs.getInt("MaVacxin"), rs.getString("TenVacxin"), rs.getInt("SoMui"),
						rs.getString("MoTa"), rs.getString("GiaVacxin"), rs.getString("TenHang"));
				listVacxins.add(vacxin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listVacxins;
	}
}
