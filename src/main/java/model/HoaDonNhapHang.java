package model;

import java.util.List;

public class HoaDonNhapHang {
    private String maHDNH;
    private String ngayNhap;
    private String maNV;
    private String maNCC;
    private List<ChiTietNhapHang> chiTietNhapHangList;

    public HoaDonNhapHang() {}
    public HoaDonNhapHang(String maHDNH, String ngayNhap, String maNV, String maNCC,List<ChiTietNhapHang> chiTietNhapHangList) {
        this.maHDNH = maHDNH;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.chiTietNhapHangList=chiTietNhapHangList;
    }
    public float tinhTongTien() {
        float tongTien = 0;
        for (ChiTietNhapHang chiTiet : chiTietNhapHangList) {
            tongTien += chiTiet.tinhThanhTien();
        }
        return tongTien;
    }
    public String getMaHDNH() { return maHDNH; }
    public void setMaHDNH(String maHDNH) { this.maHDNH = maHDNH; }
    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }
}