package DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NguyenLieu;

public class NNVNguyenLieuDAO extends CoffeDAO {

    // Thêm nguyên liệu mới
    public void addNguyenLieu(NguyenLieu nl) {
        String query = "INSERT INTO NguyenLieu (TenNL, DVT, DonGia, SL) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nl.getTenNL());
            stmt.setString(2, nl.getDvt());
            stmt.setBigDecimal(3, new BigDecimal(nl.getDonGia()));
            stmt.setBigDecimal(4, new BigDecimal(nl.getSl()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa nguyên liệu theo MaNL
    public void deleteNguyenLieu(int maNL) {
        String query = "DELETE FROM NguyenLieu WHERE MaNL = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNL);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nguyên liệu
    public List<NguyenLieu> getAllNguyenLieu() {
        List<NguyenLieu> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NguyenLieu";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToNguyenLieu(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy nguyên liệu theo mã
    public NguyenLieu getNguyenLieuById(int maNL) {
        String query = "SELECT * FROM NguyenLieu WHERE MaNL = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNL);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToNguyenLieu(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin nguyên liệu
    public void updateNguyenLieu(NguyenLieu nl) {
        String query = "UPDATE NguyenLieu SET TenNL = ?, DVT = ?, DonGia = ?, SL = ? WHERE MaNL = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nl.getTenNL());
            stmt.setString(2, nl.getDvt());
            stmt.setBigDecimal(3, new BigDecimal(nl.getDonGia()));
            stmt.setBigDecimal(4, new BigDecimal(nl.getSl()));
            stmt.setInt(5, nl.getMaNL());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Chuyển đổi từ ResultSet -> NguyenLieu
    private NguyenLieu mapResultSetToNguyenLieu(ResultSet rs) throws SQLException {
        return new NguyenLieu(
                rs.getInt("MaNL"),
                rs.getString("TenNL"),
                rs.getString("DVT"),
                rs.getBigDecimal("DonGia").floatValue(),
                rs.getBigDecimal("SL").floatValue()
        );
    }
}