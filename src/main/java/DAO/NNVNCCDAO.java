package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;

public class NNVNCCDAO extends CoffeDAO {

    // Thêm nhà cung cấp mới
    public void addNhaCungCap(NhaCungCap ncc) {
        String query = "INSERT INTO NhaCungCap (SDT, TenNCC, DiaChi, CongNo, GhiChu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ncc.getSdt());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getDiaChi());
            stmt.setFloat(4, ncc.getCongNo());
            stmt.setString(5, ncc.getGhiChu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa nhà cung cấp
    public void deleteNhaCungCap(int maNCC) {
        String query = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNCC);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin nhà cung cấp
    public void updateNhaCungCap(NhaCungCap ncc) {
        String query = "UPDATE NhaCungCap SET SDT = ?, TenNCC = ?, DiaChi = ?, CongNo = ?, GhiChu = ? WHERE MaNCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ncc.getSdt());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getDiaChi());
            stmt.setFloat(4, ncc.getCongNo());
            stmt.setString(5, ncc.getGhiChu());
            stmt.setInt(6, ncc.getMaNCC());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nhà cung cấp
    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhaCungCap";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToNCC(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin nhà cung cấp theo mã
    public NhaCungCap getNhaCungCapById(int maNCC) {
        String query = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNCC);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToNCC(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> NhaCungCap
    private NhaCungCap mapResultSetToNCC(ResultSet rs) throws SQLException {
        return new NhaCungCap(
                rs.getInt("MaNCC"),
                rs.getString("SDT"),
                rs.getString("TenNCC"),
                rs.getString("DiaChi"),
                rs.getFloat("CongNo"),
                rs.getString("GhiChu")
        );
    }
}
