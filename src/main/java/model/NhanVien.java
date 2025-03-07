package model;

public class NhanVien {
    private String maNV;
    private String ho;
    private String ten;
    private boolean gioiTinh;
    private String sdt;
    private String cccd;
    private boolean trangThai;
    private String taiKhoan;
    private String matKhau;
    private String maPQ;

    public NhanVien() {}
    public NhanVien(String maNV, String ho, String ten, boolean gioiTinh, String sdt, String cccd, boolean trangThai, String taiKhoan, String matKhau, String maPQ) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.cccd = cccd;
        this.trangThai = trangThai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maPQ = maPQ;
    }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public boolean isGioiTinh() { return gioiTinh; }
    public void setGioiTinh(boolean gioiTinh) { this.gioiTinh = gioiTinh; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }
    public boolean isTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { this.trangThai = trangThai; }
    public String getTaiKhoan() { return taiKhoan; }
    public void setTaiKhoan(String taiKhoan) { this.taiKhoan = taiKhoan; }
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public String getMaPQ() { return maPQ; }
    public void setMaPQ(String maPQ) { this.maPQ = maPQ; }
}
