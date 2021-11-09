package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
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
	) throws IOException, ServletException {
		String param = request.getParameter("name");
		String name = param == null ?
			"FPT Polytechnic" : param;
		
		request.setAttribute("myName", name);
		request.getRequestDispatcher("views/hello.jsp")
			.forward(request, response);
	}
	
	@Override
	public void init() {
		System.out.println("Init");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}
	
	@Override
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		System.out.println("Service");
		super.service(request, response);
	}
}
