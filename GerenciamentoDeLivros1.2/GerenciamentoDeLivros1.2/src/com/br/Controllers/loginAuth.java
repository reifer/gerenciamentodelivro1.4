package com.br.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.Dao.GenericDaoException;
import com.br.Dao.UsuarioDao;
import com.br.Dao.UsuarioDaoImpl;
import com.br.Models.Usuario;

@WebServlet(urlPatterns = "/login")
public class loginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		
		response.sendRedirect("./home.jsp");

		/*try {
			UsuarioDao uDao = new UsuarioDaoImpl();
			Usuario lista = uDao.login(user, pass);
			System.out.println(lista);
			response.sendRedirect("./home.jsp");
		} catch (GenericDaoException e) {
			e.printStackTrace();
		}*/
	}
}
