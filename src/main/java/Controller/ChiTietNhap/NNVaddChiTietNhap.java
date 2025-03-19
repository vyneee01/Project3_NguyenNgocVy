package Controller.ChiTietNhap;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVChiTietNhapDAO;
import model.ChiTietNhap;

@WebServlet("/Backend/ChiTietNhap/addChiTietNhap")
public class NNVaddChiTietNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVChiTietNhapDAO chiTietNhapDao;

    public void init() {
        chiTietNhapDao = new NNVChiTietNhapDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maNH = Integer.parseInt(request.getParameter("maNH"));
        int maNL = Integer.parseInt(request.getParameter("maNL"));
        BigDecimal soLuong = new BigDecimal(request.getParameter("soLuong"));
        BigDecimal donGia = new BigDecimal(request.getParameter("donGia"));

        ChiTietNhap chiTietNhap = new ChiTietNhap(maNH, maNL, soLuong, donGia);
        chiTietNhapDao.addChiTietNhap(chiTietNhap);

        response.sendRedirect("NNVlistChiTietNhap.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addChiTietNhap.jsp").forward(request, response);
    }
}
