package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoffeDAO;
import model.NhanVien;

@WebServlet("/Backend/NhanVien/addNhanVien")
public class addNhanVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO nhanVienDao;

    public void init() {
        nhanVienDao = new CoffeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
        String maNV = request.getParameter("maNV");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        String sdt = request.getParameter("sdt");
        String cccd = request.getParameter("cccd");
        boolean trangThai = Boolean.parseBoolean(request.getParameter("trangThai"));
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");
        String maPQ = request.getParameter("maPQ");

        // Tạo đối tượng NhanVien và gọi phương thức addNhanVien
        NhanVien newNhanVien = new NhanVien(maNV, ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
        nhanVienDao.addNhanVien(newNhanVien);

        // Chuyển hướng về trang danh sách nhân viên
        response.sendRedirect("listNhanVien.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng tới trang thêm nhân viên
        RequestDispatcher dispatcher = request.getRequestDispatcher("addNhanVien.jsp");
        dispatcher.forward(request, response);
    }
}
