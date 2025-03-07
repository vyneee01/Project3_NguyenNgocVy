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

@WebServlet("/Backend/SanPham/addSanPham")
public class addSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoffeDAO sanPhamDao;

    public void init() {
        sanPhamDao = new CoffeDAO();
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

        SanPham newSanPham = new SanPham(maSP, tenSP, anh, dvt, donGia, maNhomSP);
        sanPhamDao.addSanPham(newSanPham);

        response.sendRedirect("listSanPham.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addSanPham.jsp");
        dispatcher.forward(request, response);
    }
}
