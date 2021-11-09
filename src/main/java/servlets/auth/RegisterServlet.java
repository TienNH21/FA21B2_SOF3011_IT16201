package servlets.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
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
		String name = request.getParameter("name");
		String nganh = request.getParameter("chuyen_nganh");
		String gt = request.getParameter("gioi_tinh");
		String[] cnMongMuon = request.getParameterValues("cn_mong_muon");
		
		System.out.println(name);
		System.out.println(nganh);
		System.out.println(gt);
		for (int i = 0; i < cnMongMuon.length; i++) {
			System.out.println(cnMongMuon[i]);
		}
	}

}
