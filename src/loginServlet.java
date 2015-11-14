import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		String home = new String("boasVindas.jsp");		
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		String usuario = request.getParameter("user");
		String senha = request.getParameter("senha");
		
		//Validação do usuário no BD
		if (usuario.equals("Myllena") && senha.equals("123")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", usuario);
			dispatcher.forward(request, response);
		} else if (usuario.equals("admin") && senha.equals("admin")){
			response.sendRedirect("adminResources.html");
		}
	}

}
