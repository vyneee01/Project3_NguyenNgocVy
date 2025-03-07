package Controller.SanPham;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoffeDAO;

@WebServlet("/Backend/SanPham/deleteSanPham")
public class deleteSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO sanPhamDao;

    public void init() {
        sanPhamDao = new CoffeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSP = request.getParameter("maSP");
        sanPhamDao.deleteSanPham(maSP);

        response.sendRedirect("listSanPham.jsp");
    }
}
