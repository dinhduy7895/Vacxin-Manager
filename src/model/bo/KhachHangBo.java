package model.bo;

import java.util.ArrayList;

import model.bean.KhachHang;
import model.dao.KhachHangDao;

public class KhachHangBo {
		KhachHangDao KHDAo = new KhachHangDao();
		public ArrayList<KhachHang> getListKH(){
			return KHDAo.getListKH();
		}
		public ArrayList<KhachHang> getListHistoryKH(int maKH){
			return KHDAo.getListHistoryKH(maKH);
		}
		public ArrayList<KhachHang> getListPaymentKH(){
			return KHDAo.getListPaymentKH();
		}
}
