package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.Benh;
import model.dao.BenhDao;

public class BenhBo {
		BenhDao benhDao = new BenhDao();
//		public Vacxin	isValidVacxin(String name, String pass){
//			return vacxinDao.isValidUSer(name,pass);
//		}
//		public boolean isExist(String vacxinname){
//			return vacxinDao.isExist(vacxinname);
//		}
		
		public ArrayList<Benh> getListBenh(){
			return benhDao.getListBenh();
		}
		public List<Integer> getListBenhById(int id){
			return benhDao.getListBenhById(id);
		}
		public ArrayList<String>  getListBenhByName(int id){
			return benhDao.getListBenhByName(id);
		}
}
