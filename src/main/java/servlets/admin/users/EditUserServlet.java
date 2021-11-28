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

@WebServlet("/admin/users/edit")
public class EditUserServlet extends HttpServlet {
	private UserDAO userDAO;
       
    public EditUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter( "id" );
		int id = Integer.parseInt(idStr);
		User user = this.userDAO.findById(id);
		// TODO: check null
		request.setAttribute("user", user);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		try {
			BeanUtils.populate(u, request.getParameterMap());
			this.userDAO.update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/admin/users" );
	}

}
