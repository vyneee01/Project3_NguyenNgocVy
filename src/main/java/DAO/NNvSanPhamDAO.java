package DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

public class NNvSanPhamDAO extends CoffeDAO {

    // Thêm sản phẩm mới
    public void addSanPham(SanPham sp) {
        String query = "INSERT INTO SanPham (TenSP, Anh, DVT, DonGia, MaNhomSP) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(true); // Đảm bảo lệnh INSERT có hiệu lực ngay

            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getAnh());
            stmt.setString(3, sp.getDvt());
            stmt.setBigDecimal(4, new BigDecimal(sp.getDonGia()));

            if (sp.getMaNhomSP() == null || sp.getMaNhomSP().isEmpty()) {
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, Integer.parseInt(sp.getMaNhomSP()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm theo MaSP
    public void deleteSanPham(int maSP) {
        String query = "DELETE FROM SanPham WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSP);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        List<SanPham> danhSach = new ArrayList<>();
        String query = "SELECT * FROM SanPham";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToSanPham(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy sản phẩm theo mã
    public SanPham getSanPhamById(int maSP) {
        String query = "SELECT * FROM SanPham WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToSanPham(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin sản phẩm
    public void updateSanPham(SanPham sp) {
        String query = "UPDATE SanPham SET TenSP = ?, Anh = ?, DVT = ?, DonGia = ?, MaNhomSP = ? WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getAnh());
            stmt.setString(3, sp.getDvt());
            stmt.setBigDecimal(4, new BigDecimal(sp.getDonGia()));

            if (sp.getMaNhomSP() == null || sp.getMaNhomSP().isEmpty()) {
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, Integer.parseInt(sp.getMaNhomSP()));
            }

            stmt.setInt(6, Integer.parseInt(sp.getMaSP()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách sản phẩm thuộc nhóm cụ thể
    public List<SanPham> getSanPhamByNhomSP(int maNhomSP) {
        List<SanPham> danhSach = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE MaNhomSP = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNhomSP);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToSanPham(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy sản phẩm bán chạy (giá = 50.000)
    public List<SanPham> getBestSellersByPrice() {
        List<SanPham> bestSellers = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE DonGia = 50000";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                bestSellers.add(mapResultSetToSanPham(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bestSellers;
    }

    // Chuyển đổi từ ResultSet -> SanPham
    private SanPham mapResultSetToSanPham(ResultSet rs) throws SQLException {
        return new SanPham(
                rs.getString("MaSP"),
                rs.getString("TenSP"),
                rs.getString("Anh"),
                rs.getString("DVT"),
                rs.getBigDecimal("DonGia").floatValue(),
                rs.getString("MaNhomSP")
        );
    }
}
