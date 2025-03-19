package DAO;

import model.LoaiPhieu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVLoaiPhieuDAO extends CoffeDAO {

    // Thêm loại phiếu mới
    public void addLoaiPhieu(LoaiPhieu loaiPhieu) {
        String query = "INSERT INTO LoaiPhieu (TenLP) VALUES (?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, loaiPhieu.getTenLP());

            stmt.executeUpdate();
            
            // Lấy ID tự động tăng và gán vào đối tượng
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    loaiPhieu.setMaLP(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin loại phiếu
    public void updateLoaiPhieu(LoaiPhieu loaiPhieu) {
        String query = "UPDATE LoaiPhieu SET TenLP = ? WHERE MaLP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, loaiPhieu.getTenLP());
            stmt.setInt(2, loaiPhieu.getMaLP());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa loại phiếu theo mã loại phiếu
    public void deleteLoaiPhieu(int maLP) {
        String query = "DELETE FROM LoaiPhieu WHERE MaLP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maLP);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả loại phiếu
    public List<LoaiPhieu> getAllLoaiPhieu() {
        List<LoaiPhieu> danhSach = new ArrayList<>();
        String query = "SELECT * FROM LoaiPhieu";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToLoaiPhieu(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy loại phiếu theo mã
    public LoaiPhieu getLoaiPhieuByMaLP(int maLP) {
        String query = "SELECT * FROM LoaiPhieu WHERE MaLP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maLP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToLoaiPhieu(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> LoaiPhieu
    private LoaiPhieu mapResultSetToLoaiPhieu(ResultSet rs) throws SQLException {
        return new LoaiPhieu(
            rs.getInt("MaLP"),
            rs.getString("TenLP")
        );
    }
}
