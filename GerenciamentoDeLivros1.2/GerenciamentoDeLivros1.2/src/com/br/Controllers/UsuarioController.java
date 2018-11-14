package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.GenericDaoException;
import com.br.Dao.UsuarioDao;
import com.br.Dao.UsuarioDaoImpl;
import com.br.Models.Usuario;

@WebServlet(urlPatterns = "/UsuarioControllers")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		String msg = null;
		HttpSession session = request.getSession();
		System.out.println("teste");
		try {
			UsuarioDaoImpl uDao = new UsuarioDaoImpl();
			if ("adiciona".equals(cmd)) {
				Usuario u = new Usuario();
				System.out.println(Integer.parseInt(request.getParameter("ID")));
				u.setId(Integer.parseInt(request.getParameter("ID")));
				u.setNome(request.getParameter("NOME"));
				u.setEmail(request.getParameter("EMAIL"));
				u.setTipo(Integer.parseInt(request.getParameter("TIPO")));
				u.setTelefone(request.getParameter("TELEFONE"));
				uDao.adiciona(u);
				session.setAttribute("LISTA", u);
				msg = "Usuario adicionado com sucesso!";
			} else if ("remover".equals(cmd)) {
				int id = Integer.parseInt(request.getParameter("ID"));
				uDao.remover(id);
			} else if ("editar".equals(cmd)) {
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(request.getParameter("ID")));
				u.setNome(request.getParameter("NOME"));
				u.setEmail(request.getParameter("EMAIL"));
				u.setTipo(Integer.parseInt(request.getParameter("TIPO")));
				u.setTelefone(request.getParameter("TELEFONE"));
				uDao.editar(u);
			} else if ("editar".equals(cmd)) {
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(request.getParameter("txtId")));
				u.setNome(request.getParameter("nome"));
				u.setEmail(request.getParameter("email"));
				u.setTelefone(request.getParameter("telefone"));
				u.setTipo(Integer.parseInt(request.getParameter("tipo")));
				uDao.editar(u);
				msg = "Usuario salvo com sucesso!";
			}
		} catch (GenericDaoException e) {
			msg = "Erro ao acessar o usuario.";
			e.printStackTrace();
		}
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./cadastroDeUsuario.jsp");
	}
}