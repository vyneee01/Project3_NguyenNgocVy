package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChamCong;

public class NNVChamCongDAO extends CoffeDAO {

    // Lấy dữ liệu chấm công theo ID
    public ChamCong getChamCongById(int maCC) {
        String query = "SELECT * FROM ChamCong WHERE MaCC = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maCC);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Timestamp ngayCong = rs.getTimestamp("NgayCong");
                    int maNV = rs.getInt("MaNV");

                    return new ChamCong(maCC, ngayCong, maNV);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy danh sách toàn bộ chấm công
    public List<ChamCong> getAllChamCong() {
        List<ChamCong> danhSachCC = new ArrayList<>();
        String query = "SELECT * FROM ChamCong";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int maCC = rs.getInt("MaCC");
                Timestamp ngayCong = rs.getTimestamp("NgayCong");
                int maNV = rs.getInt("MaNV");

                ChamCong cc = new ChamCong(maCC, ngayCong, maNV);
                danhSachCC.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachCC;
    }

    // Thêm mới một bản ghi chấm công
    public boolean addChamCong(ChamCong chamCong) {
        String query = "INSERT INTO ChamCong (NgayCong, MaNV) VALUES (?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, chamCong.getNgayCong());
            stmt.setInt(2, chamCong.getMaNV());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa bản ghi chấm công
    public boolean deleteChamCong(int maCC) {
        String query = "DELETE FROM ChamCong WHERE MaCC = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maCC);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 // Cập nhật thông tin chấm công
    public boolean updateChamCong(ChamCong chamCong) {
        String query = "UPDATE ChamCong SET NgayCong = ?, MaNV = ? WHERE MaCC = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, chamCong.getNgayCong());
            stmt.setInt(2, chamCong.getMaNV());
            stmt.setInt(3, chamCong.getMaCC());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
