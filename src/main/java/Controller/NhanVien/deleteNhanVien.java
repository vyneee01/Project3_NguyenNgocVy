package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NNVNhanVienDAO;

@WebServlet("/Backend/NhanVien/deleteNhanVien")
public class deleteNhanVien extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NNVNhanVienDAO nhanVienDao;

    @Override
    public void init() throws ServletException {
        nhanVienDao = new NNVNhanVienDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNVStr = request.getParameter("maNV");

        if (maNVStr != null && !maNVStr.isEmpty()) {
            try {
                int maNV = Integer.parseInt(maNVStr);
                nhanVienDao.deleteNhanVien(maNV); // Xóa nhân viên

                // Chuyển hướng về danh sách nhân viên với thông báo thành công
                response.sendRedirect("NNVlistNhanVien.jsp?success=1");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("NNVlistNhanVien.jsp?error=invalid_id");
            }
        } else {
            response.sendRedirect("NNVlistNhanVien.jsp?error=missing_id");
        }
    }
}
