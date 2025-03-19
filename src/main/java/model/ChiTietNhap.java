package model;

import java.math.BigDecimal;

public class ChiTietNhap {
    private int maNH;
    private int maNL;
    private BigDecimal soLuong;
    private BigDecimal donGia;

    public ChiTietNhap(int maNH, int maNL, BigDecimal soLuong, BigDecimal donGia) {
        this.maNH = maNH;
        this.maNL = maNL;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Getter và Setter
    public int getMaNH() {
        return maNH;
    }

    public void setMaNH(int maNH) {
        this.maNH = maNH;
    }

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public BigDecimal getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(BigDecimal soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

}