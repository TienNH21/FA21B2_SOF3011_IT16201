package servlets.lab3;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig()
@WebServlet("/Bai1Upload")
public class Bai1Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Bai1Upload() {
        super();
    }

    protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/lab3/form.jsp")
    		.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("/files");
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}

		Part photo = request.getPart("photo_file");
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());

		Part doc = request.getPart("doc_file");
		File docFile = new File(dir, doc.getSubmittedFileName());
		doc.write(docFile.getAbsolutePath());

		request.setAttribute("img", photoFile);
		request.setAttribute("doc", docFile);
		
		request.getRequestDispatcher("/views/lab3/result.jsp")
			.forward(request, response);
	}

}
