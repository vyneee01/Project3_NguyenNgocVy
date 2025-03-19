package Controller.Ban;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVBanDAO;
import model.Ban;

@WebServlet("/Backend/Ban/NNVupdateBan")
public class NNVupdateBan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVBanDAO banDao;

    public void init() {
        banDao = new NNVBanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBan = Integer.parseInt(request.getParameter("maBan"));
        Ban ban = banDao.getBanByMaBan(maBan);
        request.setAttribute("ban", ban);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/Ban/NNVupdateBan.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maBan = Integer.parseInt(request.getParameter("maBan"));
        boolean trangThai = request.getParameter("trangThai") != null;
        int maKV = Integer.parseInt(request.getParameter("maKV"));

        Ban ban = new Ban(maBan, trangThai, maKV);
        banDao.updateBan(ban);

        response.sendRedirect("NNVlistBan.jsp");
    }
}
