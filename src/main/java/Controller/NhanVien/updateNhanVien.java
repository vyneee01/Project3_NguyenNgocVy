package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.NNVNhanVienDAO;
import DAO.NNVPhanQuyenDAO;
import model.NhanVien;

@WebServlet("/Backend/NhanVien/updateNhanVien")
public class updateNhanVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhanVienDAO nhanVienDao;
    private NNVPhanQuyenDAO phanQuyenDao;

    public void init() {
        nhanVienDao = new NNVNhanVienDAO();
        phanQuyenDao = new NNVPhanQuyenDAO();
    }

    // GET: Hiển thị thông tin nhân viên cần chỉnh sửa
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int maNV = Integer.parseInt(request.getParameter("maNV"));
            NhanVien nhanVien = nhanVienDao.getNhanVienByMaNV(maNV);

            if (nhanVien == null) {
                response.sendRedirect("NNVlistNhanVien.jsp");
                return;
            }

            request.setAttribute("nhanVien", nhanVien);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NhanVien/updateNhanVien.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("NNVlistNhanVien.jsp");
        }
    }

    // POST: Cập nhật thông tin nhân viên
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int maNV = Integer.parseInt(request.getParameter("maNV"));
            String ho = request.getParameter("ho");
            String ten = request.getParameter("ten");
            boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
            String sdt = request.getParameter("sdt");
            String cccd = request.getParameter("cccd");
            boolean trangThai = Boolean.parseBoolean(request.getParameter("trangThai"));
            String taiKhoan = request.getParameter("taiKhoan");
            String matKhau = request.getParameter("matKhau");
            int maPQ = Integer.parseInt(request.getParameter("maPQ"));

            // Cập nhật nhân viên
            NhanVien nhanVien = new NhanVien(maNV, ho, ten, gioiTinh, sdt, cccd, trangThai, taiKhoan, matKhau, maPQ);
            nhanVienDao.updateNhanVien(nhanVien);

            // Chuyển hướng về danh sách nhân viên
            response.sendRedirect("NNVlistNhanVien.jsp");
        } catch (NumberFormatException e) {
            response.getWriter().println("Lỗi: Dữ liệu đầu vào không hợp lệ!");
        }
    }
}
