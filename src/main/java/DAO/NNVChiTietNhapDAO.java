package DAO;

import model.ChiTietNhap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NNVChiTietNhapDAO extends CoffeDAO {

	public void addChiTietNhap(ChiTietNhap ct) {
	    String query = "INSERT INTO ChiTietNhap (MaNH, MaNL, SoLuong, DonGia) VALUES (?, ?, ?, ?)";

	    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, ct.getMaNH());
	        stmt.setInt(2, ct.getMaNL());
	        stmt.setDouble(3, ct.getSoLuong().doubleValue());
	        stmt.setDouble(4, ct.getDonGia().doubleValue());

	        stmt.executeUpdate();
	        System.out.println("Thêm chi tiết nhập thành công!");
	    } catch (SQLException e) {
	        System.err.println("Lỗi SQL: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


    // Lấy danh sách chi tiết nhập hàng theo mã nhập hàng
    public List<ChiTietNhap> getChiTietNhapByMaNH(int maNH) {
        List<ChiTietNhap> danhSach = new ArrayList<>();
        String query = "SELECT * FROM ChiTietNhap WHERE MaNH = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNH);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToChiTietNhap(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
 // Lấy tất cả chi tiết nhập hàng
    public List<ChiTietNhap> getAllChiTietNhap() {
        List<ChiTietNhap> danhSach = new ArrayList<>();
        String query = "SELECT CTN.*, NL.TenNL FROM ChiTietNhap CTN " +
                       "JOIN NguyenLieu NL ON CTN.MaNL = NL.MaNL";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ChiTietNhap ct = new ChiTietNhap(
                        rs.getInt("MaNH"),
                        rs.getInt("MaNL"),
                        rs.getBigDecimal("SoLuong"),
                        rs.getBigDecimal("DonGia")
                    );
                    ct.setMaNL(rs.getInt("MaNL")); // Lấy mã nguyên liệu
                    danhSach.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Xóa chi tiết nhập hàng
    public void deleteChiTietNhap(int maNH, int maNL) {
        String query = "DELETE FROM ChiTietNhap WHERE MaNH = ? AND MaNL = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNH);
            stmt.setInt(2, maNL);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Chuyển đổi từ ResultSet -> ChiTietNhap
    private ChiTietNhap mapResultSetToChiTietNhap(ResultSet rs) throws SQLException {
        return new ChiTietNhap(
            rs.getInt("MaNH"),
            rs.getInt("MaNL"),
            rs.getBigDecimal("SoLuong"),
            rs.getBigDecimal("DonGia")
        );
    }
}
