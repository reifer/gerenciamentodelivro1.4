package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Emprestimo;
import com.br.Models.Livro;

public class EmprestimoDaoImpl implements EmprestimoDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con;

	public EmprestimoDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Emprestimo e) throws GenericDaoException {
		String sql = "INSERT INTO emprestimo (id, idlivro, idUsuario)" + "VALUES (?, ?, ?)";

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, e.getIdLivro());
			pstmt.setInt(3, e.getIdUsuario());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
	}

	@Override
	public List<Livro> pesquisaPorAluno(int id) throws GenericDaoException {
		List<Livro> lista = new ArrayList<>();
		String sql = "SELECT t2.* FROM emprestimo as t1 INNER JOIN livros as t2 ON "
				+ "t1.idlivro = t2.id  WHERE idAluno = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Livro l = new Livro();
				l.setId(rs.getInt("id"));
				l.setNome(rs.getString("NOME"));
				l.setAutor(rs.getString("AUTOR"));
				l.setEditora(rs.getString("EDITORA"));
				l.setGenero(rs.getString("GENERO"));
				lista.add(l);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}

		return lista;
	}

}
