package Controller.ChamCong;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVChamCongDAO;
import model.ChamCong;

@WebServlet("/Backend/ChamCong/NNVaddChamCong")
public class NNVaddChamCong extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVChamCongDAO chamCongDao;

    public void init() {
        chamCongDao = new NNVChamCongDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maNV = Integer.parseInt(request.getParameter("maNV"));
        Timestamp ngayCong = new Timestamp(System.currentTimeMillis()); // Lấy thời gian hiện tại

        ChamCong chamCong = new ChamCong(0, ngayCong, maNV);
        chamCongDao.addChamCong(chamCong);

        response.sendRedirect("NNVlistChamCong.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addChamCong.jsp").forward(request, response);
    }
}
