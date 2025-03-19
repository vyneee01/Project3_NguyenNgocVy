package Controller.NguyenLieu;

import DAO.NNVNguyenLieuDAO;
import model.NguyenLieu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Backend/NguyenLieu/NNVaddNguyenLieu")
public class NNVaddNguyenLieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNguyenLieuDAO nguyenLieuDAO;

    public void init() {
        nguyenLieuDAO = new NNVNguyenLieuDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String tenNL = request.getParameter("tenNL");
        String dvt = request.getParameter("dvt");
        double donGia = Double.parseDouble(request.getParameter("donGia"));
        double sl = Double.parseDouble(request.getParameter("sl"));

        NguyenLieu nguyenLieu = new NguyenLieu(0, tenNL, dvt, donGia, sl);
        nguyenLieuDAO.addNguyenLieu(nguyenLieu);

        response.sendRedirect("NNVlistNguyenLieu.jsp");
    }
}
