package model;

import java.math.BigDecimal;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String anh;
    private String dvt;
    private float donGia;
    private String maNhomSP;

    public SanPham() {}
    public SanPham(String maSP, String tenSP, String anh, String dvt, float donGia, String maNhomSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.anh = anh;
        this.dvt = dvt;
        this.donGia = donGia;
        this.maNhomSP = maNhomSP;
    }
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public String getAnh() { return anh; }
    public void setAnh(String anh) { this.anh = anh; }
    public String getDvt() { return dvt; }
    public void setDvt(String dvt) { this.dvt = dvt; }
    public float getDonGia() { return donGia; }
    public void setDonGia(float donGia) { this.donGia = donGia; }
    public String getMaNhomSP() { return maNhomSP; }
    public void setMaNhomSP(String maNhomSP) { this.maNhomSP = maNhomSP; }
}