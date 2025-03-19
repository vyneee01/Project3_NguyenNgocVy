package Controller.LoaiPhieu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVLoaiPhieuDAO;

@WebServlet("/Backend/LoaiPhieu/NNVdeleteLoaiPhieu")
public class NNVdeleteLoaiPhieu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVLoaiPhieuDAO loaiPhieuDao;

    public void init() {
        loaiPhieuDao = new NNVLoaiPhieuDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maLP = Integer.parseInt(request.getParameter("maLP"));
        loaiPhieuDao.deleteLoaiPhieu(maLP);
        response.sendRedirect("NNVlistLoaiPhieu.jsp");
    }
}
