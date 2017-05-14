package model.bo;

import java.util.ArrayList;

import model.bean.User;
import model.dao.UserDao;

public class UserBo {
		UserDao userDao = new UserDao();
		public User	isValidUser(String name, String pass){
			return userDao.isValidUSer(name,pass);
		}
		public boolean isExist(String username){
			return userDao.isExist(username);
		}
		public User register(String username,String name,String pass, int role){
			return userDao.register(username,name,pass,role);
		}
		public ArrayList<User> getListUsers(){
			return userDao.getListUsers();
		}
		public User getUser(int id){
			return userDao.getUser(id);
		}
		public boolean update(int id,String username,String pass, String name,int role ){
			return userDao.update(id,username,pass,name,role);
		}
		public boolean delete(int id){
			return userDao.delete(id);
		}
		public ArrayList<User> search(String username, String name, int role){
			return userDao.search(username,name,role);
		}
}
