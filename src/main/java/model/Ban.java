package model;

public class Ban {
    private int maBan;
    private boolean trangThai;
    private int maKV;

    // Constructor không tham số
    public Ban() {
    }

    // Constructor có tham số
    public Ban(int maBan, boolean trangThai, int maKV) {
        this.maBan = maBan;
        this.trangThai = trangThai;
        this.maKV = maKV;
    }

    // Getter và Setter
    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaKV() {
        return maKV;
    }

    public void setMaKV(int maKV) {
        this.maKV = maKV;
    }


}
