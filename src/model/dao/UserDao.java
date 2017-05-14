package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;

	

public class UserDao {
	private static Database db = new Database();
	private Connection conn = null ;
	private ResultSet rs ;
	private Statement st ;
	private PreparedStatement pst ;
	public UserDao(){
		conn = db.getConnection();
	}
	public User isValidUSer(String name, String pass){
		conn = db.getConnection();
		User user = null;
		String query = "Select * from users where username = '" + name + "' and password = '"+pass+"'";
		System.out.println("sql "+query);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getInt("role"));			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public boolean isExist(String username){
		conn = db.getConnection();
		User user = new User();
		int count = 0;
		String query = "Select count(*) from users where username = '" + username + "'";
		System.out.println("sql "+query);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				 count = rs.getInt(1);
			}
			if(count==1) return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public User register(String username,String name,String pass,int role){
		conn = db.getConnection();
		User user = new User();
		int check = 0;
		int count = 0;
		String query = "INSERT into users (username,password,name,role) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, pass);
			pst.setString(3, name);
			pst.setInt(4, role);
			check = pst.executeUpdate();
			user.setName(name);
			user.setRole(role);
			user.setUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check > 0)
		return user;
		else
		return user=null;
	}
	public ArrayList<User> getListUsers(){
		conn = db.getConnection();
		ArrayList<User> listUsers = new ArrayList<User>();
		User user ;
		String query = "Select * from users";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getInt("role"));
				listUsers.add(user);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listUsers;
	}
	public User getUser(int id){
		conn = db.getConnection();
		User user =null;
		String query = "Select * from users where id  = ?";
		try{
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getInt("role"));
				}
		} catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	public boolean update(int id,String username,String pass,String name,int role){
		conn = db.getConnection();
		int check = 0;
		int count = 0;
		String query = "Update users SET username=? ,password=? , name=? , role = ?  where id=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, pass);
			pst.setString(3, name);
			pst.setInt(4, role);
			pst.setInt(5, id);

			check = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check > 0)
		return true;
		else
		return false;
	}
	public boolean delete(int id){
		conn = db.getConnection();
		int check = 0;
		int count = 0;
		String query = "DELETE from users  where id=?";
		try {
			pst = conn.prepareStatement(query);
		
			pst.setInt(1, id);

			check = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check > 0)
		return true;
		else
		return false;
	}
	public ArrayList<User> search(String username, String name, int role){
		conn = db.getConnection();
		ArrayList<User> listUsers = new ArrayList<User>();
		User user ;
		String query = "Select * from users where username LIKE '%"+username+"%' and name LIKE '%"+name+"%'";  
		if(role !=0 )query =query+ "and role ='"+role+"'";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getInt("role"));
				listUsers.add(user);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return listUsers;
	}
}
