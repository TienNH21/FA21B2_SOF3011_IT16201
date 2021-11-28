package servlets.admin.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entities.User;

@WebServlet("/admin/users/create")
public class CreateUserServlet extends HttpServlet {
	private UserDAO userDAO;
	
	public CreateUserServlet() {
		this.userDAO = new UserDAO();
	}
	
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		User u = new User();
		try {
			BeanUtils.populate(u, request.getParameterMap());
			u = this.userDAO.insert(u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect( request.getContextPath() + "/admin/users" );
	}
}
