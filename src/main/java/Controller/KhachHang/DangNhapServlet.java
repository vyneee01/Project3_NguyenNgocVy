package Controller.KhachHang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NNVKhachHangDAO;
import model.NNVKhachHang;

@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        NNVKhachHangDAO khachHangDAO = new NNVKhachHangDAO();
        NNVKhachHang khachHang = khachHangDAO.kiemTraDangNhap(email, password);

        if (khachHang != null) {
            // Đăng nhập thành công -> Lưu vào session
            HttpSession session = request.getSession();
            session.setAttribute("khachHang", khachHang);
            
            // Chuyển hướng về trang chính
            response.sendRedirect("Frontend/NNVHome.jsp");
        } else {
            // Sai email/mật khẩu -> Quay lại trang đăng nhập với thông báo lỗi
            request.setAttribute("error", "Sai email hoặc mật khẩu!");
            request.getRequestDispatcher("NNVHoiVien.jsp").forward(request, response);
        }
    }
}
