package Controller.KhachHang;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhachHangDAO;
import model.NNVKhachHang;

@WebServlet("/Backend/KhachHang/updateKhachHang")
public class updateKhachHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhachHangDAO khachHangDao;

    public void init() {
        khachHangDao = new NNVKhachHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maKH = Integer.parseInt(request.getParameter("maKH"));
        NNVKhachHang khachHang = khachHangDao.getKhachHangById(maKH);
        request.setAttribute("khachHang", khachHang);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhachHang/updateKhachHang.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maKH = Integer.parseInt(request.getParameter("maKH"));
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");

        // Lấy mật khẩu hiện có từ DB để không ghi đè lên nó
        NNVKhachHang existingKhachHang = khachHangDao.getKhachHangById(maKH);
        String matKhau = existingKhachHang.getMatKhau();  

        Date ngayDangKy = existingKhachHang.getNgayDangKy(); // Không cập nhật ngày đăng ký

        NNVKhachHang khachHang = new NNVKhachHang(maKH, hoTen, email, soDienThoai, matKhau, ngayDangKy);
        khachHangDao.updateKhachHang(khachHang);

        response.sendRedirect(request.getContextPath() + "/Backend/KhachHang/NNVlistKhachHang.jsp");
    }
}
