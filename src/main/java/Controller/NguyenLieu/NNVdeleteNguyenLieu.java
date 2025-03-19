package Controller.NguyenLieu;

import DAO.NNVNguyenLieuDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Backend/NguyenLieu/NNVdeleteNguyenLieu")
public class NNVdeleteNguyenLieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNguyenLieuDAO nguyenLieuDAO;

    public void init() {
        nguyenLieuDAO = new NNVNguyenLieuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNL = Integer.parseInt(request.getParameter("maNL"));
        nguyenLieuDAO.deleteNguyenLieu(maNL);
        response.sendRedirect("NNVlistNguyenLieu.jsp");
    }
}
