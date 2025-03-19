package Controller.NhaCungCap;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.NNVNCCDAO;

@WebServlet("/Backend/NhaCungCap/NNVdeleteNCC")
public class NNVdeleteNCC extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNCCDAO nccDao;

    public void init() {
        nccDao = new NNVNCCDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNCC = Integer.parseInt(request.getParameter("maNCC"));
        nccDao.deleteNhaCungCap(maNCC);
        response.sendRedirect("NNVlistNCC.jsp");
    }
}
