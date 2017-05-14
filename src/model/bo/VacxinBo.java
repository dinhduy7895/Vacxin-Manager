package model.bo;

import java.util.ArrayList;

import model.bean.Vacxin;
import model.dao.VacxinDao;

public class VacxinBo {
		VacxinDao vacxinDao = new VacxinDao();
//		public Vacxin	isValidVacxin(String name, String pass){
//			return vacxinDao.isValidUSer(name,pass);
//		}
//		public boolean isExist(String vacxinname){
//			return vacxinDao.isExist(vacxinname);
//		}
		public boolean register(String name,String gia,String mota, String brand, int somui, String[] benh) {
			return vacxinDao.register(name,gia,mota,brand,somui,benh);

		}
		public ArrayList<Vacxin> getListVacxin(){
			return vacxinDao.getListVacxin();
		}
		public Vacxin getVacxin(int id){
			return vacxinDao.getVacxin(id);
		}
		public boolean update(int id,String name,String gia,String mota, String brand, int somui,String[] benh){
			return vacxinDao.update(id,name,gia,mota,brand,somui,benh);
		}
		public boolean delete(int id){
			return vacxinDao.delete(id);
		}
		public ArrayList<Vacxin> search(String name,String gia,String mota, String brand, int somui){
			return vacxinDao.search(name,gia,mota,brand,somui);
		}
}
