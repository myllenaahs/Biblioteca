package Services;

import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

import DAO.GeneralDAO;
import DAO.UsuarioDAO;
import Entidades.Usuario;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ResultSet rs;
	static int aux = 0;

	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Usuario user = new Usuario();
		GeneralDAO bd = new GeneralDAO(); //criando conexão com a classe geral do BD
		UsuarioDAO usuario = new UsuarioDAO();

		String home = new String("boasVindas.jsp");
		//Recuperando valores do formulário
		user.setLogin(request.getParameter("nome"));
		user.setSenha(request.getParameter("senha"));

		// Validação do Usuário admin no BD
		if (user.getLogin().equals("admin") && user.getSenha().equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("nome", user.getLogin());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("adminResources.html");
			dispatcher.forward(request, response);
		} else //validação dos usuários gerais
			if (usuario.consultaUser(user) == true) {
			HttpSession session = request.getSession();
			session.setAttribute("nome", user.getLogin());
			RequestDispatcher dispatcher = request.getRequestDispatcher(home);
			dispatcher.forward(request, response);
		}

		
	}

}
