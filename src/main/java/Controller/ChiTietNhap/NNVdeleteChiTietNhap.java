package Controller.ChiTietNhap;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVChiTietNhapDAO;

@WebServlet("/Backend/ChiTietNhap/deleteChiTietNhap")
public class NNVdeleteChiTietNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVChiTietNhapDAO chiTietNhapDao;

    public void init() {
        chiTietNhapDao = new NNVChiTietNhapDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNH = Integer.parseInt(request.getParameter("maNH"));
        int maNL = Integer.parseInt(request.getParameter("maNL"));
        chiTietNhapDao.deleteChiTietNhap(maNH, maNL);
        response.sendRedirect("NNVlistChiTietNhap.jsp");
    }
}
