package com.br.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.EmprestimoDaoImpl;
import com.br.Dao.GenericDaoException;
import com.br.Models.Emprestimo;

public class EmprestimoControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmprestimoControllers() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			EmprestimoDaoImpl eDao = new EmprestimoDaoImpl();
			if ("emprestar".equals(cmd)) {
				Emprestimo e = new Emprestimo();
				e.setIdLivro(Integer.parseInt(request.getParameter("IDLIVRO")));
				e.setIdUsuario(Integer.parseInt(request.getParameter("IDUSER")));
				eDao.adiciona(e);
			}
		} catch (GenericDaoException e) {
			e.printStackTrace();
		}

		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./emprestimo.jsp");
	}
}
