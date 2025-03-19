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

@WebServlet("/Backend/NhomSanPham/addNhomSanPham")
public class addNhomSanPham extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhomSanPhamDAO nhomSanPhamDao;

    public void init() {
        nhomSanPhamDao = new NNVNhomSanPhamDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Lấy dữ liệu từ form
        String maNhomSP = request.getParameter("maNhomSP");
        String tenNhomSP = request.getParameter("tenNhomSP");

        // Tạo đối tượng nhóm sản phẩm
        NhomSanPham newNhomSP = new NhomSanPham(maNhomSP, tenNhomSP);

        // Thêm nhóm sản phẩm vào DB
        nhomSanPhamDao.addNhomSanPham(newNhomSP);

        // Chuyển hướng về danh sách nhóm sản phẩm
        response.sendRedirect(request.getContextPath() + "/Backend/NhomSanPham/NNVlistNhomSanPham.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addNhomSanPham.jsp");
        dispatcher.forward(request, response);
    }
}
