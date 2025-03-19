package Controller.Ban;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVBanDAO;
import model.Ban;

@WebServlet("/Backend/Ban/NNVaddBan")
public class NNVaddBan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVBanDAO banDao;

    public void init() {
        banDao = new NNVBanDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        boolean trangThai = request.getParameter("trangThai") != null;
        int maKV = Integer.parseInt(request.getParameter("maKV"));

        Ban ban = new Ban(0, trangThai, maKV);
        banDao.addBan(ban);

        response.sendRedirect("NNVlistBan.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addBan.jsp").forward(request, response);
    }
}
