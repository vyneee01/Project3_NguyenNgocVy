package model;

public class KhuVuc {
    private int maKV;
    private String tenKV;
    private boolean trangThai;

    public KhuVuc() {
    }

    public KhuVuc(int maKV, String tenKV, boolean trangThai) {
        this.maKV = maKV;
        this.tenKV = tenKV;
        this.trangThai = trangThai;
    }

    public int getMaKV() {
        return maKV;
    }

    public void setMaKV(int maKV) {
        this.maKV = maKV;
    }

    public String getTenKV() {
        return tenKV;
    }

    public void setTenKV(String tenKV) {
        this.tenKV = tenKV;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhuVuc{" +
                "maKV=" + maKV +
                ", tenKV='" + tenKV + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
