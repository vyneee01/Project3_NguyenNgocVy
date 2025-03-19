package Controller.PhanQuyen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVPhanQuyenDAO;

@WebServlet("/Backend/PhanQuyen/NNVdeletePhanQuyen")
public class NNVdeletePhanQuyen extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVPhanQuyenDAO phanQuyenDao;

    public void init() {
        phanQuyenDao = new NNVPhanQuyenDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maPQ = Integer.parseInt(request.getParameter("maPQ"));
        phanQuyenDao.deletePhanQuyen(maPQ);

        // Chuyển hướng đến danh sách phân quyền sau khi xóa
        response.sendRedirect("NNVlistPhanQuyen.jsp");
    }
}
