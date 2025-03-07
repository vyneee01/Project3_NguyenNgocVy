package model;

public class NhomSanPham {

	private String maNhomSP;
    private String tenNhomSP;

    public NhomSanPham() {}
    public NhomSanPham(String maNhomSP, String tenNhomSP) {
        this.maNhomSP = maNhomSP;
        this.tenNhomSP = tenNhomSP;
    }

    public String getMaNhomSP() { return maNhomSP; }
    public void setMaNhomSP(String maNhomSP) { this.maNhomSP = maNhomSP; }
    public String getTenNhomSP() { return tenNhomSP; }
    public void setTenNhomSP(String tenNhomSP) { this.tenNhomSP = tenNhomSP; }
}
