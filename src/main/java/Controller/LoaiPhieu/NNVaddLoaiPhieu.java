package Controller.LoaiPhieu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVLoaiPhieuDAO;
import model.LoaiPhieu;

@WebServlet("/Backend/LoaiPhieu/NNVaddLoaiPhieu")
public class NNVaddLoaiPhieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVLoaiPhieuDAO loaiPhieuDao;

    public void init() {
        loaiPhieuDao = new NNVLoaiPhieuDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String tenLP = request.getParameter("tenLP");

        LoaiPhieu loaiPhieu = new LoaiPhieu(0, tenLP);
        loaiPhieuDao.addLoaiPhieu(loaiPhieu);

        response.sendRedirect("NNVlistLoaiPhieu.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addLoaiPhieu.jsp").forward(request, response);
    }
}
