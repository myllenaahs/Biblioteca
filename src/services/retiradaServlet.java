package services;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BancoDados;

@WebServlet("/retiradaServlet")
public class retiradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public retiradaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	static String user = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost:3306/biblioteca";
	static Connection connection;
	static ResultSet rs, rs2;
	static int aux = 0;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BancoDados bd = new BancoDados();
		ResultSet rs;
		String sql;
		
		String home = new String("boasVindas.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		String titulo = request.getParameter("titulo");
		
		bd.abrirConexao();	
		sql = "DELETE FROM volume WHERE titulo = '" + titulo + "';";
		bd.alteraBanco(sql);
		bd.fecharConexao();
		
		dispatcher.forward(request, response);
		

	
	}

}
