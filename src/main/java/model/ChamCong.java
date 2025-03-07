package model;

public class ChamCong {
    private String maCC;
    private String ngayCong;
    private String maNV;

    public ChamCong() {}
    public ChamCong(String maCC, String ngayCong, String maNV) {
        this.maCC = maCC;
        this.ngayCong = ngayCong;
        this.maNV = maNV;
    }

    public String getMaCC() { return maCC; }
    public void setMaCC(String maCC) { this.maCC = maCC; }
    public String getNgayCong() { return ngayCong; }
    public void setNgayCong(String ngayCong) { this.ngayCong = ngayCong; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
}