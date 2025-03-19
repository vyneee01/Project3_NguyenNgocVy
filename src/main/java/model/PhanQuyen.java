package model;

public class PhanQuyen {
    private int maPQ; // Đổi kiểu dữ liệu từ String sang int
    private String tenQuyen;
    private float mucLuong;
    private String dvt;

    public PhanQuyen() {}

    public PhanQuyen(int maPQ, String tenQuyen, float mucLuong, String dvt) {
        this.maPQ = maPQ;
        this.tenQuyen = tenQuyen;
        this.mucLuong = mucLuong;
        this.dvt = dvt;
    }

    public int getMaPQ() { return maPQ; }
    public void setMaPQ(int maPQ) { this.maPQ = maPQ; }
    public String getTenQuyen() { return tenQuyen; }
    public void setTenQuyen(String tenQuyen) { this.tenQuyen = tenQuyen; }
    public float getMucLuong() { return mucLuong; }
    public void setMucLuong(float mucLuong) { this.mucLuong = mucLuong; }
    public String getDvt() { return dvt; }
    public void setDvt(String dvt) { this.dvt = dvt; }
}
