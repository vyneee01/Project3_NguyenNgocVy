package model;

public class KhuVuc {
    private String maKV;
    private String tenKV;
    private String trangThai;

    public KhuVuc() {}
    public KhuVuc(String maKV, String tenKV, String trangThai) {
        this.maKV = maKV;
        this.tenKV = tenKV;
        this.trangThai = trangThai;
    }

    public String getMaKV() { return maKV; }
    public void setMaKV(String maKV) { this.maKV = maKV; }
    public String getTenKV() { return tenKV; }
    public void setTenKV(String tenKV) { this.tenKV = tenKV; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
