package Controller.PhanQuyen;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVPhanQuyenDAO;
import model.PhanQuyen;

@WebServlet("/Backend/PhanQuyen/NNVaddPhanQuyen")
public class NNVaddPhanQuyen extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVPhanQuyenDAO phanQuyenDao;

    public void init() {
        phanQuyenDao = new NNVPhanQuyenDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String tenQuyen = request.getParameter("tenQuyen");
        float mucLuong = Float.parseFloat(request.getParameter("mucLuong"));
        String dvt = request.getParameter("dvt");

        PhanQuyen newPhanQuyen = new PhanQuyen(0, tenQuyen, mucLuong, dvt); // ID sẽ được tự động sinh
        phanQuyenDao.addPhanQuyen(newPhanQuyen);

        // Chuyển hướng đến danh sách phân quyền sau khi thêm mới
        response.sendRedirect("NNVlistPhanQuyen.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển đến trang thêm mới phân quyền
        RequestDispatcher dispatcher = request.getRequestDispatcher("NNVaddPhanQuyen.jsp");
        dispatcher.forward(request, response);
    }
}
