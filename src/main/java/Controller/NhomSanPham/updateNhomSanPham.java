package Controller.NhomSanPham;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNhomSanPhamDAO;
import model.NhomSanPham;

@WebServlet("/Backend/NhomSanPham/updateNhomSanPham")
public class updateNhomSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhomSanPhamDAO nhomSanPhamDao;

    public void init() {
        nhomSanPhamDao = new NNVNhomSanPhamDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNhomSP = request.getParameter("maNhomSP");
        NhomSanPham nhomSP = nhomSanPhamDao.getNhomSanPhamById(maNhomSP);
        request.setAttribute("nhomSP", nhomSP);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NhomSanPham/updateNhomSanPham.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maNhomSP = request.getParameter("maNhomSP");
        String tenNhomSP = request.getParameter("tenNhomSP");

        NhomSanPham nhomSP = new NhomSanPham(maNhomSP, tenNhomSP);
        nhomSanPhamDao.updateNhomSanPham(nhomSP);

        response.sendRedirect(request.getContextPath() + "/Backend/NhomSanPham/NNVlistNhomSanPham.jsp");
    }
}
