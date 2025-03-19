package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NNVKhachHang;

public class NNVKhachHangDAO extends CoffeDAO {

	public void addKhachHang(NNVKhachHang kh) {
        String query = "INSERT INTO KhachHang (HoTen, Email, SoDienThoai, MatKhau, NgayDangKy) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(true); // Đảm bảo lệnh INSERT có hiệu lực ngay

            stmt.setString(1, kh.getHoTen());
            stmt.setString(2, kh.getEmail());
            stmt.setString(3, kh.getSoDienThoai());
            stmt.setString(4, kh.getMatKhau());
            stmt.setTimestamp(5, new Timestamp(kh.getNgayDangKy().getTime())); // Chuyển Date thành Timestamp

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa khách hàng theo MaKH
    public void deleteKhachHang(int maKH) {
        String query = "DELETE FROM KhachHang WHERE MaKH = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKH);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả khách hàng
    public List<NNVKhachHang> getAllKhachHang() {
        List<NNVKhachHang> danhSach = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maKH = rs.getInt("MaKH");
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                String soDienThoai = rs.getString("SoDienThoai");
                String matKhau = rs.getString("MatKhau");
                Date ngayDangKy = new Date(rs.getTimestamp("NgayDangKy").getTime());

                NNVKhachHang kh = new NNVKhachHang(maKH, hoTen, email, soDienThoai, matKhau, ngayDangKy);
                danhSach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public NNVKhachHang getKhachHangById(int maKH) {
        String query = "SELECT * FROM KhachHang WHERE MaKH = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, maKH);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new NNVKhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("SoDienThoai"),
                    rs.getString("MatKhau"),
                    rs.getDate("NgayDangKy")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateKhachHang(NNVKhachHang kh) {
        String query = "UPDATE KhachHang SET HoTen = ?, Email = ?, SoDienThoai = ? WHERE MaKH = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, kh.getHoTen());
            stmt.setString(2, kh.getEmail());
            stmt.setString(3, kh.getSoDienThoai());
            stmt.setInt(4, kh.getMaKH());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy khách hàng theo email (để kiểm tra đăng nhập)
    public NNVKhachHang getKhachHangByEmail(String email) {
        String query = "SELECT * FROM KhachHang WHERE Email = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int maKH = rs.getInt("MaKH");
                    String hoTen = rs.getString("HoTen");
                    String soDienThoai = rs.getString("SoDienThoai");
                    String matKhau = rs.getString("MatKhau");
                    Date ngayDangKy = new Date(rs.getTimestamp("NgayDangKy").getTime());

                    return new NNVKhachHang(maKH, hoTen, email, soDienThoai, matKhau, ngayDangKy);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public NNVKhachHang kiemTraDangNhap(String email, String password) {
        NNVKhachHang khachHang = null;
        String sql = "SELECT * FROM khachhang WHERE email = ? AND matkhau = ?";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    khachHang = new NNVKhachHang(
                        rs.getInt("maKH"),
                        rs.getString("hoTen"),
                        rs.getString("email"),
                        rs.getString("soDienThoai"),
                        rs.getString("matKhau"),
                        rs.getDate("ngayDangKy")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }
    public boolean kiemTraEmailTonTai(String email) {
        String sql = "SELECT * FROM KhachHang WHERE email = ?";
        
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Nếu có bản ghi -> Email đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean dangKyKhachHang(NNVKhachHang khachHang) {
        String sql = "INSERT INTO KhachHang (hoTen, email, soDienThoai, matKhau, ngayDangKy) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, khachHang.getHoTen());
            ps.setString(2, khachHang.getEmail());
            ps.setString(3, khachHang.getSoDienThoai());
            ps.setString(4, khachHang.getMatKhau());
            ps.setDate(5, new Date(System.currentTimeMillis()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
