package Controller.NguyenLieu;

import DAO.NNVNguyenLieuDAO;
import model.NguyenLieu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Backend/NguyenLieu/NNVupdateNguyenLieu")
public class NNVupdateNguyenLieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNguyenLieuDAO nguyenLieuDAO;

    public void init() {
        nguyenLieuDAO = new NNVNguyenLieuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNL = Integer.parseInt(request.getParameter("maNL"));
        NguyenLieu nl = nguyenLieuDAO.getNguyenLieuById(maNL);
        request.setAttribute("nguyenLieu", nl);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/NguyenLieu/NNVupdateNguyenLieu.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int maNL = Integer.parseInt(request.getParameter("maNL"));
        String tenNL = request.getParameter("tenNL");
        String dvt = request.getParameter("dvt");
        double donGia = Double.parseDouble(request.getParameter("donGia"));
        double sl = Double.parseDouble(request.getParameter("sl"));
        NguyenLieu nguyenLieu = new NguyenLieu(maNL, tenNL, dvt, donGia, sl);
        nguyenLieuDAO.updateNguyenLieu(nguyenLieu);
        response.sendRedirect("NNVlistNguyenLieu.jsp");
    }
}
