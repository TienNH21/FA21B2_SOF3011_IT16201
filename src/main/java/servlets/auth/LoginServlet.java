package servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/login.jsp")
			.forward(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		System.out.println("LoginServlet@doPost");
		String email = request.getParameter("email"),
			password = request.getParameter("password");
		
		System.out.println(email + "---" + password);
	}
}
