package Controller.KhachHang;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhachHangDAO;
import model.NNVKhachHang;

@WebServlet("/Backend/KhachHang/addKhachHang")
public class addKhachHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhachHangDAO khachHangDao;

    public void init() {
        khachHangDao = new NNVKhachHangDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Lấy dữ liệu từ form
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String hoTen = ho + " " + ten;
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        Date ngayDangKy = new Date(); // Lấy thời gian hiện tại

        // Tạo đối tượng khách hàng
        NNVKhachHang newKhachHang = new NNVKhachHang(0, hoTen, email, soDienThoai, matKhau, ngayDangKy);

        // Thêm khách hàng vào DB
        khachHangDao.addKhachHang(newKhachHang);

        // Chuyển hướng về danh sách khách hàng
        response.sendRedirect(request.getContextPath() + "/Backend/KhachHang/NNVlistKhachHang.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addKhachHang.jsp");
        dispatcher.forward(request, response);
    }
}
