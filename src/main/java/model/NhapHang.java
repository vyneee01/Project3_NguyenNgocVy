package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class NhapHang {
    private int maNH;
    private Timestamp ngayNhap;
    private int maNCC;
    private int maNV;
    private BigDecimal tongTien;
    private String ghiChu;

    public NhapHang(int maNH, Timestamp ngayNhap, int maNCC,int maNV, BigDecimal tongTien, String ghiChu) {
        this.maNH = maNH;
        this.ngayNhap = ngayNhap;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    // Getters & Setters
    public int getMaNH() { return maNH; }
    public void setMaNH(int maNH) { this.maNH = maNH; }
    
    public Timestamp getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(Timestamp ngayNhap) { this.ngayNhap = ngayNhap; }

    public int getMaNCC() { return maNCC; }
    public void setMaNCC(int maNCC) { this.maNCC = maNCC; }

    public BigDecimal getTongTien() { return tongTien; }
    public void setTongTien(BigDecimal tongTien) { this.tongTien = tongTien; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
    public int getMaNV() { 
        return maNV; 
    }
}
