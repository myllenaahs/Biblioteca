package services;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BancoDados;

@WebServlet("/consultaServlet")
public class consultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public consultaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoDados bd = new BancoDados();
		ArrayList <Volume> volumes = new ArrayList<Volume>();
		Volume vol = new Volume();	
		
		String titulo = request.getParameter("titulo");
		
		//Consulta JDBC
		bd.abrirConexao();
		String sql = "SELECT * FROM volume WHERE titulo = '" + titulo + "'";
		ResultSet rs = bd.consultaBanco(sql);
		
		try {
			while (rs.next()){
				vol.setVolume(rs.getString("titulo"), rs.getString("tipo_volume"), rs.getString("descricao"), 
						rs.getString("editora"), rs.getString("autor"), 
						rs.getString("ano"), rs.getInt("paginas"));
				volumes.add(vol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.fecharConexao();
		
		
		//inclusão na session
		HttpSession session = request.getSession();
		session.setAttribute("volumesList", volumes);
		

		String home = "exibeVolumes.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);
		dispatcher.forward(request, response);
	}
}
