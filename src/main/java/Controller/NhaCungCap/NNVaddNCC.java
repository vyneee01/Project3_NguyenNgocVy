package Controller.NhaCungCap;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNCCDAO;
import model.NhaCungCap;

@WebServlet("/Backend/NhaCungCap/NNVaddNCC")
public class NNVaddNCC extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNCCDAO nhaCungCapDao;

    public void init() {
        nhaCungCapDao = new NNVNCCDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String tenNCC = request.getParameter("tenNCC");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        float congNo = Float.parseFloat(request.getParameter("congNo"));
        String ghiChu = request.getParameter("ghiChu");

        NhaCungCap ncc = new NhaCungCap(0, sdt, tenNCC, diaChi, congNo, ghiChu);
        nhaCungCapDao.addNhaCungCap(ncc);

        response.sendRedirect("NNVlistNCC.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addNCC.jsp");
        dispatcher.forward(request, response);
    }
}
