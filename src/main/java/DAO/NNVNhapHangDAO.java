package DAO;

import model.NhapHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVNhapHangDAO extends CoffeDAO {

    // Thêm mới một nhập hàng
	public void addNhapHang(NhapHang nhapHang) {
        String sql = "INSERT INTO NhapHang (NgayNhap, MaNCC, MaNV, TongTien, GhiChu) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, nhapHang.getNgayNhap());
            stmt.setInt(2, nhapHang.getMaNCC());
            stmt.setInt(3, nhapHang.getMaNV()); // Thêm mã nhân viên
            stmt.setBigDecimal(4, nhapHang.getTongTien());
            stmt.setString(5, nhapHang.getGhiChu());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật nhập hàng
	public void updateNhapHang(NhapHang nhapHang) {
	    String sql = "UPDATE NhapHang SET NgayNhap = ?, MaNCC = ?, MaNV = ?, TongTien = ?, GhiChu = ? WHERE MaNH = ?";

	    try (Connection conn = connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setTimestamp(1, nhapHang.getNgayNhap());
	        stmt.setInt(2, nhapHang.getMaNCC());
	        stmt.setInt(3, nhapHang.getMaNV()); // Cập nhật mã nhân viên
	        stmt.setBigDecimal(4, nhapHang.getTongTien());
	        stmt.setString(5, nhapHang.getGhiChu());
	        stmt.setInt(6, nhapHang.getMaNH());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


    // Xóa nhập hàng
    public void deleteNhapHang(int maNH) {
        String query = "DELETE FROM NhapHang WHERE MaNH = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNH);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nhập hàng
    public List<NhapHang> getAllNhapHang() {
        List<NhapHang> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhapHang";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToNhapHang(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin nhập hàng theo mã nhập hàng
    public NhapHang getNhapHangByMaNH(int maNH) {
        String query = "SELECT * FROM NhapHang WHERE MaNH = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNH);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToNhapHang(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chuyển đổi từ ResultSet -> NhapHang
    private NhapHang mapResultSetToNhapHang(ResultSet rs) throws SQLException {
        return new NhapHang(
            rs.getInt("MaNH"),
            rs.getTimestamp("NgayNhap"),
            rs.getInt("MaNCC"),
            rs.getInt("MaNV"),  // Thêm MaNV vào đây
            rs.getBigDecimal("TongTien"),
            rs.getString("GhiChu")
        );
    }
}
