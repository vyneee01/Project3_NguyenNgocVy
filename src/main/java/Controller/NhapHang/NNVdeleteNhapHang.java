package Controller.NhapHang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNhapHangDAO;

@WebServlet("/Backend/NhapHang/deleteNhapHang")
public class NNVdeleteNhapHang extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhapHangDAO nhapHangDao;

    public void init() {
        nhapHangDao = new NNVNhapHangDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNH = Integer.parseInt(request.getParameter("maNH"));
        nhapHangDao.deleteNhapHang(maNH);
        response.sendRedirect("NNVlistNhapHang.jsp");
    }
}
