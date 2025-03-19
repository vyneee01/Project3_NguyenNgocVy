package Controller.ChamCong;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVChamCongDAO;
import model.ChamCong;

@WebServlet("/Backend/ChamCong/NNVupdateChamCong")
public class NNVupdateChamCong extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVChamCongDAO chamCongDao;

    public void init() {
        chamCongDao = new NNVChamCongDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maCC = Integer.parseInt(request.getParameter("maCC"));
        ChamCong chamCong = chamCongDao.getChamCongById(maCC);
        request.setAttribute("chamCong", chamCong);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/ChamCong/NNVupdateChamCong.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maCC = Integer.parseInt(request.getParameter("maCC"));
        int maNV = Integer.parseInt(request.getParameter("maNV"));
        Timestamp ngayCong = Timestamp.valueOf(request.getParameter("ngayCong"));

        ChamCong chamCong = new ChamCong(maCC, ngayCong, maNV);
        chamCongDao.updateChamCong(chamCong);

        response.sendRedirect("NNVlistChamCong.jsp");
    }
}
