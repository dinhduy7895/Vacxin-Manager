package model.bean;

public class Vacxin {
	private String name;
	private String gia;
	private String brand;
	private String mota;
	private int somui;
	private int MaVacxin;
	public Vacxin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vacxin(int MaVacxin,String name, int somui, String mota, String gia, String brand) {
		super();
		this.name = name;
		this.gia = gia;
		this.brand = brand;
		this.mota = mota;
		this.somui = somui;
		this.MaVacxin = MaVacxin;
	}
	public int getMaVacxin() {
		return MaVacxin;
	}
	public void setMaVacxin(int MaVacxin) {
		this.MaVacxin = MaVacxin;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getSoMui() {
		return somui;
	}
	public void setSoMui(int somui) {
		this.somui = somui;
	}
}
