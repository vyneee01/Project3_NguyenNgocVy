package Controller.KhuVuc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVKhuVucDAO;
import model.KhuVuc;

@WebServlet("/Backend/KhuVuc/NNVupdateKhuVuc")
public class NNVupdateKhuVuc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVKhuVucDAO khuVucDao;

    public void init() {
        khuVucDao = new NNVKhuVucDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maKV = Integer.parseInt(request.getParameter("maKV"));
        KhuVuc khuVuc = khuVucDao.getKhuVucByMaKV(maKV);
        request.setAttribute("khuVuc", khuVuc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/KhuVuc/NNVupdateKhuVuc.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maKV = Integer.parseInt(request.getParameter("maKV"));
        String tenKV = request.getParameter("tenKV");
        boolean trangThai = request.getParameter("trangThai") != null;

        KhuVuc khuVuc = new KhuVuc(maKV, tenKV, trangThai);
        khuVucDao.updateKhuVuc(khuVuc);

        response.sendRedirect("NNVlistKhuVuc.jsp");
    }
}
