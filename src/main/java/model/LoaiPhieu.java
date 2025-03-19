package model;

public class LoaiPhieu {
    private int maLP;      // Mã loại phiếu (INT, khóa chính, tự động tăng)
    private String tenLP;  // Tên loại phiếu (VARCHAR)

    // Constructor mặc định
    public LoaiPhieu() {
    }

    // Constructor có tham số
    public LoaiPhieu(int maLP, String tenLP) {
        this.maLP = maLP;
        this.tenLP = tenLP;
    }

    // Getter và Setter
    public int getMaLP() {
        return maLP;
    }

    public void setMaLP(int maLP) {
        this.maLP = maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }
}
