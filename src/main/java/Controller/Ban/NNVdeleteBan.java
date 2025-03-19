package Controller.Ban;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVBanDAO;

@WebServlet("/Backend/Ban/NNVdeleteBan")
public class NNVdeleteBan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVBanDAO banDao;

    public void init() {
        banDao = new NNVBanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBan = Integer.parseInt(request.getParameter("maBan"));
        banDao.deleteBan(maBan);
        response.sendRedirect("NNVlistBan.jsp");
    }
}
