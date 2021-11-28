package servlets.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entities.User;

@WebServlet("/admin/users/delete")
public class DeleteUserServlet extends HttpServlet {
	private UserDAO userDAO;
       
    public DeleteUserServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User user = this.userDAO.findById(id);
		this.userDAO.delete(user);
		
		response.sendRedirect( request.getContextPath() + "/admin/users" );
	}
}
