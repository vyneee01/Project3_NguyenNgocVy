package Controller.NhanVien;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoffeDAO;
import DAO.NNVNhanVienDAO;
import DAO.NNVPhanQuyenDAO;
import model.NhanVien;
import model.PhanQuyen;

@WebServlet("/Backend/NhanVien/addNhanVien")
public class addNhanVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhanVienDAO nhanVienDao;
    private NNVPhanQuyenDAO phanQuyenDao;

    public void init() {
        nhanVienDao = new NNVNhanVienDAO();
        phanQuyenDao = new NNVPhanQuyenDAO();
    }

    // 🟢 Xử lý GET: Hiển thị form + Lấy danh sách phân quyền
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<PhanQuyen> danhSachPQ = phanQuyenDao.getAllPhanQuyen();
    	System.out.println("🔹 Số lượng phân quyền lấy được: " + danhSachPQ.size()); // Debug log
    	request.setAttribute("danhSachPQ", danhSachPQ);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NhanVien/addNhanVien.jsp");
        dispatcher.forward(request, response);
    }

    // 🟢 Xử lý POST: Thêm nhân viên mới vào database
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        String sdt = request.getParameter("sdt");
        String cccd = request.getParameter("cccd");
        boolean trangThai = Boolean.parseBoolean(request.getParameter("trangThai"));
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");
        int maPQ = Integer.parseInt(request.getParameter("maPQ")); // Lấy Mã PQ từ dropdown

        // Tạo đối tượng Nhân Viên và thêm vào DB
        NhanVien newNhanVien = new NhanVien(ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
        nhanVienDao.addNhanVien(newNhanVien);

        // Chuyển hướng về danh sách nhân viên
        response.sendRedirect("NNVlistNhanVien.jsp");
    }
}
