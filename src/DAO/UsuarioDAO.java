package DAO;

import java.sql.*;

import Entidades.*;

public class UsuarioDAO {

	GeneralDAO bd = new GeneralDAO();

	static int aux = 0;
	static ResultSet rs;

	public UsuarioDAO() {
	}

	// Método para consulta de usuários no BD
	public boolean consultaUser(Usuario user) {

		bd.abrirConexao();

		System.out.print("Consulta SQL" + user.getLogin() + " "
				+ user.getSenha());

		String sql = "SELECT u.nome " + "FROM USUARIO u " + "WHERE u.nome='"
				+ user.getLogin() + "'" + "AND u.senha='" + user.getSenha()
				+ "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs == null) {
					aux = 0;
				} else {
					aux = 1;
				}
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		}

		bd.fecharConexao();

		if (aux == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void insereUsuario(Cliente cliente) {

		try {

			bd.abrirConexao();
			Statement st = GeneralDAO.connection.createStatement();

			String sql = "INSERT INTO usuario (CPF, nome, senha, data_nasc, genero) "
					+ "VALUES ('"
					+ cliente.getCPF()
					+ "','"
					+ cliente.getLogin()
					+ "','"
					+ cliente.getSenha()
					+ "','"
					+ cliente.getData() + "','" + cliente.getSexo() + "')";

			st.executeUpdate(sql);
			st.close();
			bd.fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		}

	}
}
