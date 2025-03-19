package DAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ban;
import model.ChamCong;
import model.KhuVuc;
import model.LoaiPhieu;
import model.NguyenLieu;
import model.NhaCungCap;
import model.NhanVien;
import model.NhomSanPham;
import model.PhanQuyen;
import model.SanPham;

@WebServlet("/CoffeDAO")
public class CoffeDAO extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/project3_nguyenngocvy_2210900086"; 
    private String username = "root"; 
    private String password = ""; 

    public Connection connect() throws SQLException {
        try {
            // Đăng ký Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }

    public List<SanPham> getSanPhamByMaNhom(String maNhom) {
        List<SanPham> products = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE MaNhomSP = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
             // Đặt tham số cho truy vấn
             stmt.setString(1, maNhom);
             
             try (ResultSet rs = stmt.executeQuery()) {
                 while (rs.next()) {
                     String maSP = rs.getString("MaSP");
                     String tenSP = rs.getString("TenSP");
                     String anh = rs.getString("Anh");
                     String dvt = rs.getString("DVT");
                     float donGia = rs.getFloat("DonGia");
                     String maNhomSP = rs.getString("MaNhomSP");
                     
                     // Tạo đối tượng SanPham và thêm vào danh sách
                     SanPham sp = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
                     products.add(sp);
                 }
             }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return products;
    }


// ---Phần của Sản Phẩm
    public void addSanPham(SanPham sp) {
        String query = "INSERT INTO SanPham (TenSP, Anh, DVT, DonGia, MaNhomSP) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getAnh());
            stmt.setString(3, sp.getDvt());
            stmt.setFloat(4, sp.getDonGia());

            if (sp.getMaNhomSP() == null || sp.getMaNhomSP().isEmpty()) {
                stmt.setNull(5, Types.VARCHAR);
            } else {
                stmt.setString(5, sp.getMaNhomSP());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm theo MaSP
    public void deleteSanPham(String maSP) {
        String query = "DELETE FROM SanPham WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maSP);
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
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String anh = rs.getString("Anh");
                String dvt = rs.getString("DVT");
                float donGia = rs.getFloat("DonGia");
                String maNhomSP = rs.getString("MaNhomSP");

                SanPham sp = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
                danhSach.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public List<SanPham> getBestSellersByPrice() {
        List<SanPham> bestSellers = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE DonGia = 50000";  // Lọc sản phẩm có giá 50.000 VND
        try (Connection conn = connect(); 
             PreparedStatement stmt = conn.prepareStatement(query); 
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                // Lấy thông tin sản phẩm từ kết quả truy vấn
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String anh = rs.getString("Anh");
                String dvt = rs.getString("DVT");
                float donGia = rs.getFloat("DonGia");
                String maNhomSP = rs.getString("MaNhomSP");

                // Tạo đối tượng SanPham và thêm vào danh sách
                SanPham sp = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
                bestSellers.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bestSellers;  // Trả về danh sách sản phẩm có giá 50.000 VND
    }
    public List<SanPham> getALLCoffe() {
        List<SanPham> products = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE MaNhomSP = ?";
        try (Connection conn = connect(); 
             PreparedStatement stmt = conn.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery()){
        		
         
                 while (rs.next()) {
                     String maSP = rs.getString("MaSP");
                     String tenSP = rs.getString("TenSP");
                     String anh = rs.getString("Anh");
                     String dvt = rs.getString("DVT");
                     float donGia = rs.getFloat("DonGia");
                     String maNhomSP = rs.getString("MaNhomSP");
                     // Tạo đối tượng SanPham
                     SanPham sp = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
                     products.add(sp);
                 
             }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return products;
    }

    // Lấy sản phẩm theo MaSP
    public SanPham getSanPhamById(String maSP) {
        String query = "SELECT * FROM SanPham WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenSP = rs.getString("TenSP");
                    String anh = rs.getString("Anh");
                    String dvt = rs.getString("DVT");
                    float donGia = rs.getFloat("DonGia");
                    String maNhomSP = rs.getString("MaNhomSP");

                    return new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật sản phẩm
    public void updateSanPham(SanPham sp) {
        String query = "UPDATE SanPham SET TenSP = ?, Anh = ?, DVT = ?, DonGia = ?, MaNhomSP = ? WHERE MaSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getAnh());
            stmt.setString(3, sp.getDvt());
            stmt.setFloat(4, sp.getDonGia());

            if (sp.getMaNhomSP() == null || sp.getMaNhomSP().isEmpty()) {
                stmt.setNull(5, Types.VARCHAR);
            } else {
                stmt.setString(5, sp.getMaNhomSP());
            }

            stmt.setString(6, sp.getMaSP());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public NhomSanPham getNhomSanPhamById(String maNhomSP) {
        String query = "SELECT * FROM NhomSanPham WHERE MaNhomSP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNhomSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenNhomSP = rs.getString("TenNhomSP");

                    return new NhomSanPham(maNhomSP, tenNhomSP);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NhomSanPham> getAllNhomSanPham() {
        List<NhomSanPham> danhSachNhomSP = new ArrayList<>();
        String query = "SELECT * FROM NhomSanPham";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNhomSP = rs.getString("MaNhomSP");
                String tenNhomSP = rs.getString("TenNhomSP");

                // Tạo đối tượng NhomSanPham và thêm vào danh sách
                NhomSanPham nhomSP = new NhomSanPham(maNhomSP, tenNhomSP);
                danhSachNhomSP.add(nhomSP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNhomSP;
    }


	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}


}
