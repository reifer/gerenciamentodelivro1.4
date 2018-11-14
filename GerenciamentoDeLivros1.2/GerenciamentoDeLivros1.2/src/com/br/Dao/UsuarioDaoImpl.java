package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con;

	public UsuarioDaoImpl() throws GenericDaoException {
		try {
			System.out.println("Chegou aqui 1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e1) {
			throw new GenericDaoException(e1);
		}
	}

	@Override
	public void adiciona(Usuario u) throws GenericDaoException {
		System.out.println("Chegou aqui 2");
		String sql = "INSERT INTO usuario VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getEmail());
			stmt.setInt(4, u.getTipo());
			stmt.setString(5, u.getTelefone());
			System.out.println("Chegou aqui 3");
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Usuario pesquisarPorId(int id) throws GenericDaoException {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setTelefone(rs.getString("telefone"));
				u.setTipo(rs.getInt("tipo"));
				// System.out.println(rs.getString("id"));

			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return u;
	}

	@Override
	public List<Usuario> getAllUser() throws GenericDaoException {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT id, nome FROM usuario ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Usuario s = new Usuario();
				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nome"));
				lista.add(s);
			}
		} catch (SQLException e) {
			throw new GenericDaoException(e);
		}
		return lista;
	}

	@Override
	public void editar(Usuario u) throws GenericDaoException {
		String sql = "UPDATE usuario SET nome = ?, email = ?, tipo= ?, telefone = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setInt(3, u.getTipo());
			stmt.setString(4, u.getTelefone());
			stmt.setInt(5, u.getId());
			// stmt.setBoolean(5, u.getTipo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void remover(int id) throws GenericDaoException {
		String sql = "DELETE FROM usuario WHERE id = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Usuario login(String user, String pass) throws GenericDaoException {
		String sql = "SELECT * FROM usuario WHERE email like ? AND senha like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			Usuario u = new Usuario();
			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			return u;
		} catch (SQLException e) {
			throw new GenericDaoException(e);
		}
	}
}