package Controller.KhachHang;

import java.io.IOException;
import java.sql.Date; // Lưu ý: Dùng java.sql.Date cho JDBC
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhachHangDAO;
import model.NNVKhachHang;

@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Lấy dữ liệu từ form đăng ký
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");
        String matKhau = request.getParameter("matKhau");

        // Ngày đăng ký (lấy thời gian hiện tại)
        Date ngayDangKy = new Date(System.currentTimeMillis());

        NNVKhachHangDAO khachHangDAO = new NNVKhachHangDAO();

        // Kiểm tra email đã tồn tại chưa
        if (khachHangDAO.kiemTraEmailTonTai(email)) {
            request.setAttribute("error", "Email này đã được đăng ký!");
            request.getRequestDispatcher("dangky.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng khách hàng mới
        NNVKhachHang khachHangMoi = new NNVKhachHang(0, hoTen, email, soDienThoai, matKhau, ngayDangKy);

        // Thêm vào database
        boolean isRegistered = khachHangDAO.dangKyKhachHang(khachHangMoi);

        if (isRegistered) {
            response.sendRedirect("Frontend/NNVHoiVien.jsp?message=DangKyThanhCong");
        } else {
            request.setAttribute("error", "Có lỗi xảy ra, vui lòng thử lại!");
            request.getRequestDispatcher("dangky.jsp").forward(request, response);
        }
    }
}
