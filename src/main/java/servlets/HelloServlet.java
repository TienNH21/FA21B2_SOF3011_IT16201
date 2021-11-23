package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		
		ArrayList<String> dssv = new ArrayList<String>();
		dssv.add("Lê Văn Hai");
		dssv.add("Nguyễn Trung Hiếu");
		dssv.add("Dương Tấn Minh");
		dssv.add("Nguyễn Văn Phúc");
		dssv.add("Phan Hà Quân");
		dssv.add("Bùi Trường Sinh");
		dssv.add("Vũ Xuân Tân");
		
		request.setAttribute("dssv", dssv);
		request.setAttribute("myName", name);
		request.setAttribute("diem", 0);
		
		request.setAttribute("view", "/views/hello.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
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
