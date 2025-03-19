package Controller.KhuVuc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhuVucDAO;

@WebServlet("/Backend/KhuVuc/NNVdeleteKhuVuc")
public class NNVdeleteKhuVuc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhuVucDAO khuVucDao;

    public void init() {
        khuVucDao = new NNVKhuVucDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maKV = Integer.parseInt(request.getParameter("maKV"));
        khuVucDao.deleteKhuVuc(maKV);
        response.sendRedirect("NNVlistKhuVuc.jsp");
    }
}
