package model;

public class Ban {
    private String maBan;
    private boolean trangThai;
    private String maKV;

    public Ban() {}
    public Ban(String maBan, boolean trangThai, String maKV) {
        this.maBan = maBan;
        this.trangThai = trangThai;
        this.maKV = maKV;
    }

    public String getMaBan() { return maBan; }
    public void setMaBan(String maBan) { this.maBan = maBan; }
    public boolean isTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { this.trangThai = trangThai; }
    public String getMaKV() { return maKV; }
    public void setMaKV(String maKV) { this.maKV = maKV; }
}
