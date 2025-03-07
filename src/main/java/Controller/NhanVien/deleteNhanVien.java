package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoffeDAO;

@WebServlet("/Backend/NhanVien/deleteNhanVien")
public class deleteNhanVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO nhanVienDao;

    public void init() {
        nhanVienDao = new CoffeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNV = request.getParameter("maNV");
        nhanVienDao.deleteNhanVien(maNV); // Gọi phương thức xóa trong DAO

        // Chuyển hướng về trang danh sách nhân viên
        response.sendRedirect("listNhanVien.jsp");
    }
}
