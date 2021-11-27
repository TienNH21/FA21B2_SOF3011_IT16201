package servlets.auth;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entities.User;
import models.RegisterUser;
import utils.JpaUtil;

//@MultipartConfig()
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public RegisterServlet() {
        super();

        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/register.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String nganh = request.getParameter("chuyen_nganh");
//		String gt = request.getParameter("gioi_tinh");
//		String[] cnMongMuon = request.getParameterValues("cn_mong_muon");
//		Part avatar = request.getPart("avatar");
//		
//		RegisterUser user = new RegisterUser();
//		try {
//			BeanUtils.populate(user, request.getParameterMap());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		// https://stackoverflow.com/a/12160863
//		String filename = "/static/files/" + avatar.getSubmittedFileName();
//		String filePath = request.getServletContext().getRealPath(filename);
//		File storage = new File(filePath);
//		if(!storage.exists()) {
//			storage.mkdirs();
//		}
//		
//		avatar.write(filePath);
//		doGet(request, response);
		
		User u = new User();
		try {
			BeanUtils.populate(u, request.getParameterMap());
			u.setAdmin((byte) 0);
			u = this.userDAO.insert(u);
			System.out.println( "---" + u.getId() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		response.sendRedirect( "/SOF3011_IT16201/login" );
		
		doGet(request, response);
	}
}
