package model;

public class ChiTietBanHang implements ChiTietHoaDon {
    private String maCTBH;
    private int sl;
    private String maHDBH;
    private String maSP;
    private float donGia; // Thêm đơn giá để dễ tính toán

    public ChiTietBanHang() {}

    public ChiTietBanHang(String maCTBH, int sl, String maHDBH, String maSP, float donGia) {
        this.maCTBH = maCTBH;
        this.sl = sl;
        this.maHDBH = maHDBH;
        this.maSP = maSP;
        this.donGia = donGia;
    }
    @Override
    public float tinhThanhTien() {
        return sl * donGia;
    }
    

    // Getter và Setter
    public String getMaCTBH() { return maCTBH; }
    public void setMaCTBH(String maCTBH) { this.maCTBH = maCTBH; }
    public int getSl() { return sl; }
    public void setSl(int sl) { this.sl = sl; }
    public String getMaHDBH() { return maHDBH; }
    public void setMaHDBH(String maHDBH) { this.maHDBH = maHDBH; }
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    public float getDonGia() { return donGia; }
    public void setDonGia(float donGia) { this.donGia = donGia; }
}
