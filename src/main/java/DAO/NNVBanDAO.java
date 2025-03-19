package DAO;

import model.Ban;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVBanDAO extends CoffeDAO {

    // Thêm bàn mới
    public void addBan(Ban ban) {
        String query = "INSERT INTO Ban (TrangThai, MaKV) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setBoolean(1, ban.isTrangThai());
            stmt.setInt(2, ban.getMaKV());

            stmt.executeUpdate();

            // Lấy ID tự động tăng và gán vào đối tượng
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ban.setMaBan(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật bàn
    public void updateBan(Ban ban) {
        String query = "UPDATE Ban SET TrangThai = ?, MaKV = ? WHERE MaBan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, ban.isTrangThai());
            stmt.setInt(2, ban.getMaKV());
            stmt.setInt(3, ban.getMaBan());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa bàn
    public void deleteBan(int maBan) {
        String query = "DELETE FROM Ban WHERE MaBan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maBan);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả bàn
    public List<Ban> getAllBan() {
        List<Ban> danhSach = new ArrayList<>();
        String query = "SELECT * FROM Ban";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToBan(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin bàn theo mã bàn
    public Ban getBanByMaBan(int maBan) {
        String query = "SELECT * FROM Ban WHERE MaBan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maBan);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBan(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> Ban
    private Ban mapResultSetToBan(ResultSet rs) throws SQLException {
        return new Ban(
            rs.getInt("MaBan"),
            rs.getBoolean("TrangThai"),
            rs.getInt("MaKV")
        );
    }
}
