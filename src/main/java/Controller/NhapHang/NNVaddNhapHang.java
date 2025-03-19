package Controller.NhapHang;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNhapHangDAO;
import model.NhapHang;

@WebServlet("/Backend/NhapHang/addNhapHang")
public class NNVaddNhapHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhapHangDAO nhapHangDao;

    public void init() {
        nhapHangDao = new NNVNhapHangDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int maNCC = Integer.parseInt(request.getParameter("maNCC"));
        int maNV = Integer.parseInt(request.getParameter("maNV")); // Lấy mã nhân viên từ request
        BigDecimal tongTien = new BigDecimal(request.getParameter("tongTien"));
        String ghiChu = request.getParameter("ghiChu");

        NhapHang nhapHang = new NhapHang(0, new Timestamp(System.currentTimeMillis()), maNCC, maNV, tongTien, ghiChu);
        nhapHangDao.addNhapHang(nhapHang);

        response.sendRedirect("NNVlistNhapHang.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addNhapHang.jsp").forward(request, response);
    }
}
