package Services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import DAO.*;
import Entidades.*;
/**
 * Servlet implementation class ConsultaServlet
 */
@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ResultSet rs;
       
    public ConsultaServlet() {
        super();
        
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneralDAO bd = new GeneralDAO();
		
		ArrayList <Volumes> volumes = new ArrayList<Volumes>();
		Volumes vol = new Volumes();	
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
	}

	

}
