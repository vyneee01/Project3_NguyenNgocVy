package Controller.NhanVien;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NhanVien;
import DAO.CoffeDAO; // Đổi từ NhanVienDAO thành CoffeDAO

@WebServlet("/Backend/NhanVien/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra nếu đã đăng nhập
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/Backend/NNVtrangchu.jsp");
            return;
        }

        // Gọi DAO để kiểm tra đăng nhập
        CoffeDAO dao = new CoffeDAO();
        NhanVien nv = dao.checkLogin(username, password);

        if (nv != null) {
            // Lưu nhân viên vào session
            session = request.getSession();
            session.setAttribute("user", nv);

            // Chuyển hướng về trang chủ
            response.sendRedirect(request.getContextPath() + "/Backend/trangchu.jsp");
        } else {
            // Đăng nhập thất bại, quay về trang đăng nhập
            request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/Backend/login.jsp").forward(request, response);
        }
    }
}
