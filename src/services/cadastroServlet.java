package services;
import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BancoDados;

@WebServlet("/cadastroServlet")
public class cadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int aux = 0;
	BancoDados bd = new BancoDados();

	public cadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String home = new String("index.html");
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		String usuario = request.getParameter("name");
		String senha = request.getParameter("senha");
		String nasc = request.getParameter("data");
		String genero = request.getParameter("genero");
		String cpf = request.getParameter("cpf");

		bd.abrirConexao();
		
		String sql = "INSERT INTO usuario (CPF, nome, senha, data_nasc, genero) "
				+ "VALUES ('"+ cpf + "','" + usuario + "','"
				+ senha + "','" + nasc + "','" + genero + "')";


		bd.alteraBanco(sql);			
		bd.fecharConexao();
		

		HttpSession session = request.getSession();
		session.setAttribute("name", usuario);

		dispatcher.forward(request, response);
	}

}
