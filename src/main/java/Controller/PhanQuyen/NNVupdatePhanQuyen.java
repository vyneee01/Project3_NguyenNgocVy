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

@WebServlet("/Backend/PhanQuyen/NNVupdatePhanQuyen")
public class NNVupdatePhanQuyen extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVPhanQuyenDAO phanQuyenDao;

    public void init() {
        phanQuyenDao = new NNVPhanQuyenDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maPQ = Integer.parseInt(request.getParameter("maPQ"));
        PhanQuyen phanQuyen = phanQuyenDao.getPhanQuyenByMaPQ(maPQ);
        request.setAttribute("phanQuyen", phanQuyen);

        // Chuyển đến trang cập nhật phân quyền
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Backend/PhanQuyen/NNVupdatePhanQuyen.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int maPQ = Integer.parseInt(request.getParameter("maPQ"));
        String tenQuyen = request.getParameter("tenQuyen");
        float mucLuong = Float.parseFloat(request.getParameter("mucLuong"));
        String dvt = request.getParameter("dvt");

        PhanQuyen phanQuyen = new PhanQuyen(maPQ, tenQuyen, mucLuong, dvt);
        phanQuyenDao.updatePhanQuyen(phanQuyen);

        // Chuyển hướng đến danh sách phân quyền sau khi cập nhật
        response.sendRedirect("NNVlistPhanQuyen.jsp");
    }
}
