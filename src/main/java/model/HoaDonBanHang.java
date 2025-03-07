package model;

import java.util.List;

public class HoaDonBanHang {
    private String maHDBH;
    private String gioVao;
    private String gioRa;
    private String maNV;
    private String maBan;
    private List<ChiTietBanHang> chiTietBanHangList;

    public HoaDonBanHang() {}

    public HoaDonBanHang(String maHDBH, String gioVao, String gioRa, String maNV, String maBan, List<ChiTietBanHang> chiTietBanHangList) {
        this.maHDBH = maHDBH;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.maNV = maNV;
        this.maBan = maBan;
        this.chiTietBanHangList = chiTietBanHangList;
    }

    public float tinhTongTien() {
        float tongTien = 0;
        for (ChiTietBanHang chiTiet : chiTietBanHangList) {
            tongTien += chiTiet.tinhThanhTien();
        }
        return tongTien;
    }

    // Getter và Setter
    public String getMaHDBH() { return maHDBH; }
    public void setMaHDBH(String maHDBH) { this.maHDBH = maHDBH; }
    public String getGioVao() { return gioVao; }
    public void setGioVao(String gioVao) { this.gioVao = gioVao; }
    public String getGioRa() { return gioRa; }
    public void setGioRa(String gioRa) { this.gioRa = gioRa; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getMaBan() { return maBan; }
    public void setMaBan(String maBan) { this.maBan = maBan; }
    public List<ChiTietBanHang> getChiTietBanHangList() { return chiTietBanHangList; }
    public void setChiTietBanHangList(List<ChiTietBanHang> chiTietBanHangList) { this.chiTietBanHangList = chiTietBanHangList; }
}
