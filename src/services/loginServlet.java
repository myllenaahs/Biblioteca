package services;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BancoDados;

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

		//
		BancoDados bd = new BancoDados();
		String home = "";
		HttpSession session = request.getSession();

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");


			String sql = "SELECT u.nome " + "FROM USUARIO u " + "WHERE u.nome='"
					+ nome + "'" + "AND u.senha='" + senha + "'";

			bd.abrirConexao();
			rs = bd.consultaBanco(sql);
			
			try {
				while (rs.next()) {
					
					if (rs == null) {
						aux = 0;
					} else {
						aux = 1;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			if (rs != null) {
				home = new String("boasVindas.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher(home);
				dispatcher.forward(request, response);
			}

			// Validação do usuário no BD
			if (aux == 1) {
				
				/*Cookie loginCookie = new Cookie("nome",nome);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
	            response.addCookie(loginCookie);*/
				HttpSession session2 = request.getSession();
				session2.setAttribute("nome", nome);
				RequestDispatcher dispatcher = request.getRequestDispatcher("boasVindas.jsp");
				dispatcher.forward(request, response);
			} else if (aux == 0) {

			}

			bd.fecharConexao();
	}

}
