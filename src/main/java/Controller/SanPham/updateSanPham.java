package Controller.SanPham;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoffeDAO;
import model.SanPham;

@WebServlet("/Backend/SanPham/updateSanPham")
public class updateSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO sanPhamDao;

    public void init() {
        sanPhamDao = new CoffeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSP = request.getParameter("maSP");
        SanPham sanPham = sanPhamDao.getSanPhamById(maSP);
        request.setAttribute("sanPham", sanPham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/SanPham/updateSanPham.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maSP = request.getParameter("maSP");
        String tenSP = request.getParameter("tenSP");
        String anh = request.getParameter("anh");
        String dvt = request.getParameter("dvt");
        float donGia = Float.parseFloat(request.getParameter("donGia"));
        String maNhomSP = request.getParameter("maNhomSP");

        SanPham sanPham = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
        sanPhamDao.updateSanPham(sanPham);

        response.sendRedirect("NNVlistSanPham.jsp");
    }
}
