package model;

public class NguyenLieu {
    private int maNL;
    private String tenNL;
    private String dvt;
    private double donGia;
    private double sl;

    // Constructor không tham số
    public NguyenLieu() {
    }

    // Constructor đầy đủ tham số
    public NguyenLieu(int maNL, String tenNL, String dvt, double donGia, double sl) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.dvt = dvt;
        this.donGia = donGia;
        this.sl = sl;
    }

    // Getter và Setter
    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(double sl) {
        this.sl = sl;
    }
}