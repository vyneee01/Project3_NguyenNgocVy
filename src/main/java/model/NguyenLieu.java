package model;

public class NguyenLieu {
    private String maNL;
    private String tenNL;
    private String dvt;
    private float donGia;
    private float sl;

    public NguyenLieu() {}
    public NguyenLieu(String maNL, String tenNL, String dvt, float donGia, float sl) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.dvt = dvt;
        this.donGia = donGia;
        this.sl = sl;
    }

    public String getMaNL() { return maNL; }
    public void setMaNL(String maNL) { this.maNL = maNL; }
    public String getTenNL() { return tenNL; }
    public void setTenNL(String tenNL) { this.tenNL = tenNL; }
    public String getDvt() { return dvt; }
    public void setDvt(String dvt) { this.dvt = dvt; }
    public float getDonGia() { return donGia; }
    public void setDonGia(float donGia) { this.donGia = donGia; }
    public float getSl() { return sl; }
    public void setSl(float sl) { this.sl = sl; }
}
