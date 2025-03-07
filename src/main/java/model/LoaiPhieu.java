package model;

public class LoaiPhieu {
    private String maLP;
    private String tenLP;

    public LoaiPhieu() {}
    public LoaiPhieu(String maLP, String tenLP) {
        this.maLP = maLP;
        this.tenLP = tenLP;
    }

    public String getMaLP() { return maLP; }
    public void setMaLP(String maLP) { this.maLP = maLP; }
    public String getTenLP() { return tenLP; }
    public void setTenLP(String tenLP) { this.tenLP = tenLP; }
}
