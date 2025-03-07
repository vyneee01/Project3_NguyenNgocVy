package model;

public class NhaCungCap {
    private String maNCC;
    private String sdt;
    private String tenNCC;
    private String diaChi;
    private float congNo;
    private String ghiChu;

    public NhaCungCap() {}
    public NhaCungCap(String maNCC, String sdt, String tenNCC, String diaChi, float congNo, String ghiChu) {
        this.maNCC = maNCC;
        this.sdt = sdt;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.congNo = congNo;
        this.ghiChu = ghiChu;
    }

    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getTenNCC() { return tenNCC; }
    public void setTenNCC(String tenNCC) { this.tenNCC = tenNCC; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public float getCongNo() { return congNo; }
    public void setCongNo(float congNo) { this.congNo = congNo; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
