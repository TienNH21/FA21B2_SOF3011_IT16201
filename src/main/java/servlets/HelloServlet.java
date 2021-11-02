package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet
{
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		response.getWriter()
			.append("Hello IT16201");
	}
}
