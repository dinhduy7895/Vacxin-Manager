package model.bean;

public class KhachHang {
	private int MaKH;
	private String HoTen;
	private String Sdt;
	private String DiaChiKH;
	private String NgaySinh;
	private String GioiTinh;
	private String TenBenh;
	private int MaVacXin;
	private String TenVacxin;
	private int SoMui;
	private String Money;
	
	
	
	public KhachHang(int maKH, String hoTen, String money) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		Money = money;
	}
	public KhachHang(int maKH, String hoTen, String tenBenh, int maVacXin, String tenVacxin,int soMui) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		TenBenh = tenBenh;
		MaVacXin = maVacXin;
		SoMui = soMui;
		TenVacxin = tenVacxin;
	}
	
	public String getTenVacxin() {
		return TenVacxin;
	}
	public void setTenVacxin(String tenVacxin) {
		TenVacxin = tenVacxin;
	}
	public KhachHang(int maKH, String hoTen, String sdt, String diaChiKH, String ngaySinh, String gioiTinh) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		Sdt = sdt;
		DiaChiKH = diaChiKH;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenBenh() {
		return TenBenh;
	}

	public void setTenBenh(String tenBenh) {
		TenBenh = tenBenh;
	}

	public int getMaVacXin() {
		return MaVacXin;
	}

	public void setMaVacXin(int maVacXin) {
		MaVacXin = maVacXin;
	}

	public int getSoMui() {
		return SoMui;
	}

	public void setSoMui(int soMui) {
		SoMui = soMui;
	}

	public String getMoney() {
		return Money;
	}

	public void setMoney(String money) {
		Money = money;
	}

	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getDiaChiKH() {
		return DiaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		DiaChiKH = diaChiKH;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	
	
}
