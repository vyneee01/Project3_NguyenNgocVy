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
//--- Phần của Nhân Viên
    public void addNhanVien(NhanVien nv) {
        String query = "INSERT INTO NhanVien (Ho, Ten, GioiTinh, SDT, CCCD, TrangThai, TaiKhoan, MatKhau, MaPQ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHo());
            stmt.setString(2, nv.getTen());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getCccd());
            stmt.setBoolean(6, nv.isTrangThai());
            stmt.setString(7, nv.getTaiKhoan());
            stmt.setString(8, nv.getMatKhau());

            // Kiểm tra nếu MaPQ null thì set NULL
            if (nv.getMaPQ() == null || nv.getMaPQ().isEmpty()) {
                stmt.setNull(9, Types.INTEGER);
            } else {
                stmt.setInt(9, Integer.parseInt(nv.getMaPQ()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Xóa nhân viên theo MaNV
    public void deleteNhanVien(String maNV) {
        String query = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNV);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String maNV = rs.getString("MaNV");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String sdt = rs.getString("SDT");
                String cccd = rs.getString("CCCD");
                boolean trangThai = rs.getBoolean("TrangThai");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String maPQ = rs.getString("MaPQ");

                // Tạo đối tượng NhanVien
                NhanVien nv = new NhanVien(maNV, ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
                danhSach.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy thông tin nhân viên theo MaNV
    public NhanVien getNhanVienByMaNV(String maNV) {
        String query = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String ho = rs.getString("Ho");
                    String ten = rs.getString("Ten");
                    boolean gioiTinh = rs.getBoolean("GioiTinh");
                    String sdt = rs.getString("SDT");
                    String cccd = rs.getString("CCCD");
                    boolean trangThai = rs.getBoolean("TrangThai");
                    String taiKhoan = rs.getString("TaiKhoan");
                    String matKhau = rs.getString("MatKhau");
                    String maPQ = rs.getString("MaPQ");

                    return new NhanVien(maNV, ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin nhân viên
    public void updateNhanVien(NhanVien nv) {
        String query = "UPDATE NhanVien SET Ho = ?, Ten = ?, GioiTinh = ?, SDT = ?, CCCD = ?, TrangThai = ?, TaiKhoan = ?, MatKhau = ?, MaPQ = ? WHERE MaNV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHo());
            stmt.setString(2, nv.getTen());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getCccd());
            stmt.setBoolean(6, nv.isTrangThai());
            stmt.setString(7, nv.getTaiKhoan());
            stmt.setString(8, nv.getMatKhau());

            // Kiểm tra nếu MaPQ null thì set NULL
            if (nv.getMaPQ() == null || nv.getMaPQ().isEmpty()) {
                stmt.setNull(9, Types.INTEGER);
            } else {
                stmt.setInt(9, Integer.parseInt(nv.getMaPQ()));
            }

            stmt.setInt(10, Integer.parseInt(nv.getMaNV())); // MaNV là INT
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public NhanVien checkLogin(String username, String password) {
        NhanVien nv = null;
        String sql = "SELECT * FROM NhanVien WHERE taiKhoan = ? AND matKhau = ?";
        
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nv = new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("ho"),
                        rs.getString("ten"),
                        rs.getBoolean("gioiTinh"),
                        rs.getString("sdt"),
                        rs.getString("cccd"),
                        rs.getBoolean("trangThai"),
                        rs.getString("taiKhoan"),
                        rs.getString("matKhau"),
                        rs.getString("maPQ")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
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

    public PhanQuyen getPhanQuyenById(String maPQ) {
        String query = "SELECT * FROM PhanQuyen WHERE MaPQ = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maPQ);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenQuyen = rs.getString("TenQuyen");
                    float mucLuong = rs.getFloat("MucLuong");
                    String dvt = rs.getString("DVT");

                    return new PhanQuyen(maPQ, tenQuyen, mucLuong, dvt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<PhanQuyen> getAllPhanQuyen() {
        List<PhanQuyen> danhSachPQ = new ArrayList<>();
        String query = "SELECT * FROM PhanQuyen";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maPQ = rs.getString("MaPQ");
                String tenQuyen = rs.getString("TenQuyen");
                float mucLuong = rs.getFloat("MucLuong");
                String dvt = rs.getString("DVT");

                // Tạo đối tượng PhanQuyen và thêm vào danh sách
                PhanQuyen pq = new PhanQuyen(maPQ, tenQuyen, mucLuong, dvt);
                danhSachPQ.add(pq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachPQ;
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


    public NhaCungCap getNhaCungCapById(String maNCC) {
        String query = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNCC);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String sdt = rs.getString("SDT");
                    String tenNCC = rs.getString("TenNCC");
                    String diaChi = rs.getString("DiaChi");
                    float congNo = rs.getFloat("CongNo");
                    String ghiChu = rs.getString("GhiChu");

                    return new NhaCungCap(maNCC, sdt, tenNCC, diaChi, congNo, ghiChu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> danhSachNCC = new ArrayList<>();
        String query = "SELECT * FROM NhaCungCap";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNCC = rs.getString("MaNCC");
                String sdt = rs.getString("SDT");
                String tenNCC = rs.getString("TenNCC");
                String diaChi = rs.getString("DiaChi");
                float congNo = rs.getFloat("CongNo");
                String ghiChu = rs.getString("GhiChu");

                // Tạo đối tượng NhaCungCap và thêm vào danh sách
                NhaCungCap ncc = new NhaCungCap(maNCC, sdt, tenNCC, diaChi, congNo, ghiChu);
                danhSachNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNCC;
    }
    public NguyenLieu getNguyenLieuById(String maNL) {
        String query = "SELECT * FROM NguyenLieu WHERE MaNL = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNL);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenNL = rs.getString("TenNL");
                    String dvt = rs.getString("DVT");
                    float donGia = rs.getFloat("DonGia");
                    float sl = rs.getFloat("SL");

                    return new NguyenLieu(maNL, tenNL, dvt, donGia, sl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NguyenLieu> getAllNguyenLieu() {
        List<NguyenLieu> danhSachNL = new ArrayList<>();
        String query = "SELECT * FROM NguyenLieu";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNL = rs.getString("MaNL");
                String tenNL = rs.getString("TenNL");
                String dvt = rs.getString("DVT");
                float donGia = rs.getFloat("DonGia");
                float sl = rs.getFloat("SoLuong");

                // Tạo đối tượng NguyenLieu và thêm vào danh sách
                NguyenLieu nl = new NguyenLieu(maNL, tenNL, dvt, donGia, sl);
                danhSachNL.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNL;
    }
    
    public LoaiPhieu getLoaiPhieuById(String maLP) {
        String query = "SELECT * FROM LoaiPhieu WHERE MaLP = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maLP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenLP = rs.getString("TenLP");

                    return new LoaiPhieu(maLP, tenLP);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<LoaiPhieu> getAllLoaiPhieu() {
        List<LoaiPhieu> danhSachLP = new ArrayList<>();
        String query = "SELECT * FROM LoaiPhieu";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maLP = rs.getString("MaLP");
                String tenLP = rs.getString("TenLP");

                // Tạo đối tượng LoaiPhieu và thêm vào danh sách
                LoaiPhieu lp = new LoaiPhieu(maLP, tenLP);
                danhSachLP.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachLP;
    }
    public KhuVuc getKhuVucById(String maKV) {
        String query = "SELECT * FROM KhuVuc WHERE MaKV = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maKV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenKV = rs.getString("TenKV");
                    String trangThai = rs.getString("TrangThai");

                    return new KhuVuc(maKV, tenKV, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<KhuVuc> getAllKhuVuc() {
        List<KhuVuc> danhSachKV = new ArrayList<>();
        String query = "SELECT * FROM KhuVuc";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maKV = rs.getString("MaKV");
                String tenKV = rs.getString("TenKV");
                String trangThai = rs.getString("TrangThai");

                // Tạo đối tượng KhuVuc và thêm vào danh sách
                KhuVuc kv = new KhuVuc(maKV, tenKV, trangThai);
                danhSachKV.add(kv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKV;
    }
    public ChamCong getChamCongById(String maCC) {
        String query = "SELECT * FROM ChamCong WHERE MaCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maCC);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String ngayCong = rs.getString("NgayCong");
                    String maNV = rs.getString("MaNV");

                    return new ChamCong(maCC, ngayCong, maNV);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<ChamCong> getAllChamCong() {
        List<ChamCong> danhSachCC = new ArrayList<>();
        String query = "SELECT * FROM ChamCong";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maCC = rs.getString("MaCC");
                String ngayCong = rs.getString("NgayCong");
                String maNV = rs.getString("MaNV");

                // Tạo đối tượng ChamCong và thêm vào danh sách
                ChamCong cc = new ChamCong(maCC, ngayCong, maNV);
                danhSachCC.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachCC;
    }
    public Ban getBanById(String maBan) {
        String query = "SELECT * FROM Ban WHERE MaBan = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maBan);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    boolean trangThai = rs.getBoolean("TrangThai");
                    String maKV = rs.getString("MaKV");

                    return new Ban(maBan, trangThai, maKV);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Ban> getAllBan() {
        List<Ban> danhSachBan = new ArrayList<>();
        String query = "SELECT * FROM Ban";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maBan = rs.getString("MaBan");
                boolean trangThai = rs.getBoolean("TrangThai");
                String maKV = rs.getString("MaKV");

                // Tạo đối tượng Ban
                Ban ban = new Ban(maBan, trangThai, maKV);
                danhSachBan.add(ban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachBan;
    }
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}


}
