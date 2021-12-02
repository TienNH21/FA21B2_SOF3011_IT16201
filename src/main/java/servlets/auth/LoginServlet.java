package servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;
	
	public LoginServlet() {
		this.userDAO = new UserDAO();
	}
	
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		Cookie c;
		Cookie[] dsCookie = request.getCookies();
		
		boolean checkCookieTonTai = false;
		if (dsCookie != null) {
			for (Cookie cookie : dsCookie) {
				if (cookie.getName().equals("so_lan_login")) {
					checkCookieTonTai = true;
				}
			}
		}

		if (checkCookieTonTai == false) {
			c = new Cookie("so_lan_login", "0");
			c.setMaxAge(1*60*60);
			c.setPath("/");
			response.addCookie(c);
		}
		
		request.getRequestDispatcher("/views/auth/login.jsp")
			.forward(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String email = request.getParameter("email"),
			password = request.getParameter("password");
		
		User user = this.userDAO.login(email, password);
		
		if (user == null) {
			doGet(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("/SOF3011_IT16201/admin/users");
		}
	}
}
