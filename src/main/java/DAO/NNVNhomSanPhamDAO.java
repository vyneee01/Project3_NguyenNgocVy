package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhomSanPham;

public class NNVNhomSanPhamDAO extends CoffeDAO {
    
    // Thêm nhóm sản phẩm
    public void addNhomSanPham(NhomSanPham nsp) {
        String query = "INSERT INTO NhomSanPham (MaNhomSP, TenNhomSP) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nsp.getMaNhomSP());
            stmt.setString(2, nsp.getTenNhomSP());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa nhóm sản phẩm theo MaNhomSP
    public void deleteNhomSanPham(String maNhomSP) {
        String query = "DELETE FROM NhomSanPham WHERE MaNhomSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNhomSP);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nhóm sản phẩm
    public List<NhomSanPham> getAllNhomSanPham() {
        List<NhomSanPham> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhomSanPham";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String maNhomSP = rs.getString("MaNhomSP");
                String tenNhomSP = rs.getString("TenNhomSP");
                NhomSanPham nsp = new NhomSanPham(maNhomSP, tenNhomSP);
                danhSach.add(nsp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy nhóm sản phẩm theo MaNhomSP
    public NhomSanPham getNhomSanPhamById(String maNhomSP) {
        String query = "SELECT * FROM NhomSanPham WHERE MaNhomSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNhomSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenNhomSP = rs.getString("TenNhomSP");
                    return new NhomSanPham(maNhomSP, tenNhomSP);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật nhóm sản phẩm
    public void updateNhomSanPham(NhomSanPham nsp) {
        String query = "UPDATE NhomSanPham SET TenNhomSP = ? WHERE MaNhomSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nsp.getTenNhomSP());
            stmt.setString(2, nsp.getMaNhomSP());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
