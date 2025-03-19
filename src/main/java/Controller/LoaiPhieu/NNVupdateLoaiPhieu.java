package Controller.LoaiPhieu;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVLoaiPhieuDAO;
import model.LoaiPhieu;

@WebServlet("/Backend/LoaiPhieu/NNVupdateLoaiPhieu")
public class NNVupdateLoaiPhieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVLoaiPhieuDAO loaiPhieuDao;

    public void init() {
        loaiPhieuDao = new NNVLoaiPhieuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maLP = Integer.parseInt(request.getParameter("maLP"));
        LoaiPhieu loaiPhieu = loaiPhieuDao.getLoaiPhieuByMaLP(maLP);
        request.setAttribute("loaiPhieu", loaiPhieu);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/LoaiPhieu/NNVupdateLoaiPhieu.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maLP = Integer.parseInt(request.getParameter("maLP"));
        String tenLP = request.getParameter("tenLP");

        LoaiPhieu loaiPhieu = new LoaiPhieu(maLP, tenLP);
        loaiPhieuDao.updateLoaiPhieu(loaiPhieu);

        response.sendRedirect("NNVlistLoaiPhieu.jsp");
    }
}
