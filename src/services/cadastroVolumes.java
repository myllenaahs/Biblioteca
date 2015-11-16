package services;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BancoDados;

@WebServlet("/cadastroVolumes")
public class cadastroVolumes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
     
    public cadastroVolumes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BancoDados bd = new BancoDados();
		
		String home = new String("boasVindas.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		String pag = request.getParameter("paginas");
		String ano = request.getParameter("ano");
		String editora = request.getParameter("editora");
		
		bd.abrirConexao();
		
		String sql = "INSERT INTO volume (tipo_volume, titulo, descricao, editora, "
				+ "autor, ano, paginas) "
				+ "VALUES ('"+ tipo + "','" + titulo + "','"
				+ descricao + "','" + editora + "','" + autor + 
				"','" + ano + "'," + pag + ")";

		bd.alteraBanco(sql);			
		bd.fecharConexao();
		

		dispatcher.forward(request, response);
	}

}
