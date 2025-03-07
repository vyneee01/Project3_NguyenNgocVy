package model;

public class ChiTietNhapHang implements ChiTietHoaDon {
    private String maCTNH;
    private float sl;
    private String maLP;
    private String maSP;
    private String maNL;
    private String maHDNH;
    private float donGia; // Đơn giá của nguyên liệu nhập


    public ChiTietNhapHang() {}
    public ChiTietNhapHang(String maCTNH, int sl, String maHDNH, String maNL, float donGia) {
        this.maCTNH = maCTNH;
        this.sl = sl;
        this.maHDNH = maHDNH;
        this.maNL = maNL;
        this.donGia = donGia;
    }
    @Override
    public float tinhThanhTien() {
        return sl * donGia; // Số lượng * đơn giá nhập
    }

    public String getMaCTNH() { return maCTNH; }
    public void setMaCTNH(String maCTNH) { this.maCTNH = maCTNH; }
    public float getSl() { return sl; }
    public void setSl(float sl) { this.sl = sl; }
    public String getMaLP() { return maLP; }
    public void setMaLP(String maLP) { this.maLP = maLP; }
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    public String getMaNL() { return maNL; }
    public void setMaNL(String maNL) { this.maNL = maNL; }
    public String getMaHDNH() { return maHDNH; }
    public void setMaHDNH(String maHDNH) { this.maHDNH = maHDNH; }
    public float getDonGia() { return donGia; }
    public void setDonGia(float donGia) { this.donGia = donGia; }
}