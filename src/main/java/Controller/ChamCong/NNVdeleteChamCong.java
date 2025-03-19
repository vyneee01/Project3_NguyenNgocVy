package Controller.ChamCong;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVChamCongDAO;

@WebServlet("/Backend/ChamCong/NNVdeleteChamCong")
public class NNVdeleteChamCong extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVChamCongDAO chamCongDao;

    public void init() {
        chamCongDao = new NNVChamCongDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maCC = Integer.parseInt(request.getParameter("maCC"));
        chamCongDao.deleteChamCong(maCC);
        response.sendRedirect("NNVlistChamCong.jsp");
    }
}
