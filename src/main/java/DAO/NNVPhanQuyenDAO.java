package DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PhanQuyen;

public class NNVPhanQuyenDAO extends CoffeDAO {

    // Thêm phân quyền mới
    public void addPhanQuyen(PhanQuyen phanQuyen) {
        String query = "INSERT INTO PhanQuyen (TenQuyen, MucLuong, DVT) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, phanQuyen.getTenQuyen());
            stmt.setBigDecimal(2, BigDecimal.valueOf(phanQuyen.getMucLuong()));
            stmt.setString(3, phanQuyen.getDvt());

            stmt.executeUpdate();
            
            // Lấy ID tự động tăng và gán vào đối tượng
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    phanQuyen.setMaPQ(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin phân quyền
    public void updatePhanQuyen(PhanQuyen phanQuyen) {
        String query = "UPDATE PhanQuyen SET TenQuyen = ?, MucLuong = ?, DVT = ? WHERE MaPQ = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, phanQuyen.getTenQuyen());
            stmt.setBigDecimal(2, BigDecimal.valueOf(phanQuyen.getMucLuong()));
            stmt.setString(3, phanQuyen.getDvt());
            stmt.setInt(4, phanQuyen.getMaPQ()); // Đổi từ setString -> setInt

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa phân quyền theo mã phân quyền
    public void deletePhanQuyen(int maPQ) {
        String query = "DELETE FROM PhanQuyen WHERE MaPQ = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maPQ); // Đổi từ setString -> setInt
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả phân quyền
    public List<PhanQuyen> getAllPhanQuyen() {
        List<PhanQuyen> danhSach = new ArrayList<>();
        String query = "SELECT * FROM PhanQuyen";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToPhanQuyen(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy phân quyền theo mã phân quyền
    public PhanQuyen getPhanQuyenByMaPQ(int maPQ) {
        String query = "SELECT * FROM PhanQuyen WHERE MaPQ = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maPQ); // Đổi từ setString -> setInt
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPhanQuyen(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> PhanQuyen
    private PhanQuyen mapResultSetToPhanQuyen(ResultSet rs) throws SQLException {
        return new PhanQuyen(
            rs.getInt("MaPQ"), // Đổi từ rs.getString -> rs.getInt
            rs.getString("TenQuyen"),
            rs.getFloat("MucLuong"),
            rs.getString("DVT")
        );
    }
}
