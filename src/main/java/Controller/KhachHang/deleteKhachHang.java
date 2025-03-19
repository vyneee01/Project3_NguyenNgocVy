package Controller.KhachHang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhachHangDAO;

@WebServlet("/Backend/KhachHang/deleteKhachHang")
public class deleteKhachHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhachHangDAO khachHangDao;

    public void init() {
        khachHangDao = new NNVKhachHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maKH = Integer.parseInt(request.getParameter("maKH"));
        khachHangDao.deleteKhachHang(maKH);

        response.sendRedirect("NNVlistKhachHang.jsp");
    }
}
