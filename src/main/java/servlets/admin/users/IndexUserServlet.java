package servlets.admin.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entities.User;

@WebServlet("/admin/users")
public class IndexUserServlet extends HttpServlet {
	private UserDAO userDAO;
	
	public IndexUserServlet() {
		this.userDAO = new UserDAO();
	}
	
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> list = this.userDAO.findAll();
		
		request.setAttribute("listUser", list);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}
}
