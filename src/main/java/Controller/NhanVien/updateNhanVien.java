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

@WebServlet("/Backend/NhanVien/updateNhanVien")
public class updateNhanVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO nhanVienDao;

    public void init() {
        nhanVienDao = new CoffeDAO();
    }

    // GET: Lấy thông tin nhân viên và hiển thị trong form sửa
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNV = request.getParameter("maNV");
        NhanVien nhanVien = nhanVienDao.getNhanVienByMaNV(maNV);
        request.setAttribute("nhanVien", nhanVien);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NhanVien/updateNhanVien.jsp");
        dispatcher.forward(request, response);

    }

    // POST: Cập nhật thông tin nhân viên vào cơ sở dữ liệu
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        // Tạo đối tượng NhanVien và gọi phương thức updateNhanVien
        NhanVien nhanVien = new NhanVien(maNV, ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
        nhanVienDao.updateNhanVien(nhanVien);

        // Chuyển hướng về trang danh sách nhân viên
        response.sendRedirect("listNhanVien.jsp");
    }
}
