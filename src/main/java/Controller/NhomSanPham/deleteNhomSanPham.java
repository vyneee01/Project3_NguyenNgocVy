package Controller.NhomSanPham;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNhomSanPhamDAO;

@WebServlet("/Backend/NhomSanPham/deleteNhomSanPham")
public class deleteNhomSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhomSanPhamDAO nhomSanPhamDao;

    public void init() {
        nhomSanPhamDao = new NNVNhomSanPhamDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNhomSP = request.getParameter("maNhomSP");
        nhomSanPhamDao.deleteNhomSanPham(maNhomSP);

        response.sendRedirect(request.getContextPath() + "/Backend/NhomSanPham/NNVlistNhomSanPham.jsp");
    }
}
