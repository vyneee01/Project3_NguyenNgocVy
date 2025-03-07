package model;

public class PhanQuyen {
    private String maPQ;
    private String tenQuyen;
    private float mucLuong;
    private String dvt;

    public PhanQuyen() {}
    public PhanQuyen(String maPQ, String tenQuyen, float mucLuong, String dvt) {
        this.maPQ = maPQ;
        this.tenQuyen = tenQuyen;
        this.mucLuong = mucLuong;
        this.dvt = dvt;
    }

    public String getMaPQ() { return maPQ; }
    public void setMaPQ(String maPQ) { this.maPQ = maPQ; }
    public String getTenQuyen() { return tenQuyen; }
    public void setTenQuyen(String tenQuyen) { this.tenQuyen = tenQuyen; }
    public float getMucLuong() { return mucLuong; }
    public void setMucLuong(float mucLuong) { this.mucLuong = mucLuong; }
    public String getDvt() { return dvt; }
    public void setDvt(String dvt) { this.dvt = dvt; }
}