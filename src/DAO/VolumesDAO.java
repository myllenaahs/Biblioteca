package DAO;

import java.sql.SQLException;
import java.sql.Statement;

import Entidades.*;

public class VolumesDAO {
	
	GeneralDAO bd = new GeneralDAO ();
	

	public void insereVolumes(Volumes v) {

		try {

			bd.abrirConexao();
			Statement st = GeneralDAO.connection.createStatement();
			
			String sql = "INSERT INTO volume (tipo_volume, titulo, descricao, editora, "
					+ "autor, ano, paginas) "
					+ "VALUES ('"+ v.getTipo() + "','" + v.getTitulo() + "','"
					+ v.getDescricao() + "','" + v.getEditora() + "','" + v.getAutor() + 
					"','" + v.getAno() + "'," + v.getPaginas() + ")";
			
			st.executeUpdate(sql);
			st.close();			
			bd.fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		}

	}

}
