package model;

import java.util.Date;

public class NNVKhachHang {
    private int maKH;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String matKhau;
    private Date ngayDangKy;

    // Constructor không tham số
    public NNVKhachHang() {}

    // Constructor đầy đủ
    public NNVKhachHang(int maKH, String hoTen, String email, String soDienThoai, String matKhau, Date ngayDangKy) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.ngayDangKy = ngayDangKy;
    }

    // Getter và Setter
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }


}
