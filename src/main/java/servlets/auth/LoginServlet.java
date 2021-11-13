package servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		Cookie[] dsCookie = request.getCookies();
		int soLanLogin = 0;
		for (Cookie cookie : dsCookie) {
			if (cookie.getName().equals("so_lan_login")) {
				soLanLogin = Integer.parseInt( cookie.getValue() );
				soLanLogin++;
				
				cookie.setValue(soLanLogin + "");
				response.addCookie(cookie);
			}
		}
		
		if (soLanLogin >= 3) {
			System.out.println("Đăng nhập thất bại quá nhiều. Vui lòng đợi 5 phút!");
		}

		String email = request.getParameter("email"),
			password = request.getParameter("password");
		
		System.out.println(email + "---" + password);
		doGet(request, response);
	}
}
