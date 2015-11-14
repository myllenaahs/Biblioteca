import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cadastroServlet")
public class cadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public cadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String home = new String("index.html");
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		String usuario = request.getParameter("name");
		String senha = request.getParameter("senha");
		String nasc = request.getParameter("data");
		String genero = request.getParameter("genero");
		String cpf = request.getParameter("cpf");
		

		HttpSession session = request.getSession();
		session.setAttribute("user", usuario);
			

		dispatcher.forward(request, response);
	}

}
