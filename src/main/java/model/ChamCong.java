package model;

import java.sql.Timestamp;

public class ChamCong {
    private int maCC;
    private Timestamp ngayCong;
    private int maNV;

    // Constructor không tham số
    public ChamCong() {}

    // Constructor đầy đủ tham số
    public ChamCong(int maCC, Timestamp ngayCong, int maNV) {
        this.maCC = maCC;
        this.ngayCong = ngayCong;
        this.maNV = maNV;
    }

    // Getter và Setter
    public int getMaCC() {
        return maCC;
    }

    public void setMaCC(int maCC) {
        this.maCC = maCC;
    }

    public Timestamp getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(Timestamp ngayCong) {
        this.ngayCong = ngayCong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
}
