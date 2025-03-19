package Controller.KhuVuc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhuVucDAO;
import model.KhuVuc;

@WebServlet("/Backend/KhuVuc/NNVaddKhuVuc")
public class NNVaddKhuVuc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhuVucDAO khuVucDao;

    public void init() {
        khuVucDao = new NNVKhuVucDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String tenKV = request.getParameter("tenKV");
        boolean trangThai = request.getParameter("trangThai") != null;

        KhuVuc khuVuc = new KhuVuc(0, tenKV, trangThai);
        khuVucDao.addKhuVuc(khuVuc);

        response.sendRedirect("NNVlistKhuVuc.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addKhuVuc.jsp").forward(request, response);
    }
}
