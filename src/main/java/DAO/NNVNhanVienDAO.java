package DAO;

import model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVNhanVienDAO extends CoffeDAO {

    // Thêm nhân viên mới
    public void addNhanVien(NhanVien nv) {
        String query = "INSERT INTO NhanVien (Ho, Ten, GioiTinh, SDT, CCCD, TrangThai, TaiKhoan, MatKhau, MaPQ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHo());
            stmt.setString(2, nv.getTen());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getCccd());
            stmt.setBoolean(6, nv.isTrangThai());
            stmt.setString(7, nv.getTaiKhoan());
            stmt.setString(8, nv.getMatKhau());

            // Kiểm tra nếu MaPQ null thì set NULL
            if (nv.getMaPQ() == 0) {
                stmt.setNull(9, Types.INTEGER);
            } else {
                stmt.setInt(9, nv.getMaPQ());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa nhân viên theo MaNV
    public void deleteNhanVien(int maNV) {
        String query = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNV);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                    rs.getInt("MaNV"),
                    rs.getString("Ho"),
                    rs.getString("Ten"),
                    rs.getBoolean("GioiTinh"),
                    rs.getString("SDT"),
                    rs.getString("CCCD"),
                    rs.getBoolean("TrangThai"),
                    rs.getString("TaiKhoan"),
                    rs.getString("MatKhau"),
                    rs.getInt("MaPQ")
                );
                danhSach.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin nhân viên theo MaNV
    public NhanVien getNhanVienByMaNV(int maNV) {
        String query = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NhanVien(
                        rs.getInt("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getBoolean("GioiTinh"),
                        rs.getString("SDT"),
                        rs.getString("CCCD"),
                        rs.getBoolean("TrangThai"),
                        rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getInt("MaPQ")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin nhân viên
    public void updateNhanVien(NhanVien nv) {
        String query = "UPDATE NhanVien SET Ho = ?, Ten = ?, GioiTinh = ?, SDT = ?, CCCD = ?, TrangThai = ?, TaiKhoan = ?, MatKhau = ?, MaPQ = ? WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHo());
            stmt.setString(2, nv.getTen());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getCccd());
            stmt.setBoolean(6, nv.isTrangThai());
            stmt.setString(7, nv.getTaiKhoan());
            stmt.setString(8, nv.getMatKhau());

            // Kiểm tra nếu MaPQ null thì set NULL
            if (nv.getMaPQ() == 0) {
                stmt.setNull(9, Types.INTEGER);
            } else {
                stmt.setInt(9, nv.getMaPQ());
            }

            stmt.setInt(10, nv.getMaNV()); // MaNV là INT
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kiểm tra đăng nhập nhân viên
    public NhanVien checkLogin(String username, String password) {
        NhanVien nv = null;
        String sql = "SELECT * FROM NhanVien WHERE TaiKhoan = ? AND MatKhau = ?";
        
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nv = new NhanVien(
                        rs.getInt("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getBoolean("GioiTinh"),
                        rs.getString("SDT"),
                        rs.getString("CCCD"),
                        rs.getBoolean("TrangThai"),
                        rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getInt("MaPQ")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
}
