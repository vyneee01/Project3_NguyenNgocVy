package DAO;

import model.KhuVuc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVKhuVucDAO extends CoffeDAO {

    // Thêm khu vực mới
    public void addKhuVuc(KhuVuc khuVuc) {
        String query = "INSERT INTO KhuVuc (TenKV, TrangThai) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, khuVuc.getTenKV());
            stmt.setBoolean(2, khuVuc.isTrangThai());

            stmt.executeUpdate();

            // Lấy ID tự động tăng và gán vào đối tượng
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    khuVuc.setMaKV(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin khu vực
    public void updateKhuVuc(KhuVuc khuVuc) {
        String query = "UPDATE KhuVuc SET TenKV = ?, TrangThai = ? WHERE MaKV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, khuVuc.getTenKV());
            stmt.setBoolean(2, khuVuc.isTrangThai());
            stmt.setInt(3, khuVuc.getMaKV());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa khu vực theo mã khu vực
    public void deleteKhuVuc(int maKV) {
        String query = "DELETE FROM KhuVuc WHERE MaKV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKV);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả khu vực
    public List<KhuVuc> getAllKhuVuc() {
        List<KhuVuc> danhSach = new ArrayList<>();
        String query = "SELECT * FROM KhuVuc";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToKhuVuc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy khu vực theo mã
    public KhuVuc getKhuVucByMaKV(int maKV) {
        String query = "SELECT * FROM KhuVuc WHERE MaKV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToKhuVuc(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> KhuVuc
    private KhuVuc mapResultSetToKhuVuc(ResultSet rs) throws SQLException {
        return new KhuVuc(
            rs.getInt("MaKV"),
            rs.getString("TenKV"),
            rs.getBoolean("TrangThai")
        );
    }
}
