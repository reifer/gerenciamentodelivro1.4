<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.br.Models.Livro, com.br.Models.Usuario, com.br.Dao.LivroDaoImpl, com.br.Dao.UsuarioDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprestimo</title>
</head>

<body class="backgroundImage">
	<%
		/* LivroDaoImpl lDao = new LivroDaoImpl();
		List<Livro> listLivro = lDao.getAll();
		UsuarioDaoImpl UDao = new UsuarioDaoImpl();
		List<Usuario> listUsuario = uDao.getAll(); */
	%>
	<form class="formCadastro">
		<div class="form-group">
			<h1>Emprestimo</h1>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Alunos</label> <select name="" id=""
				class="inputCadastro custom-select">
				<option value="0"></option>
				<%-- <% for (Usuario u : listUsuario) { %>
				<option value="<%=u.getId()%>"><%=u.getNome()%></option>
				<% } %> --%>
				<option value="1">Jãozinho da silva</option>
				<option value="2">Angela de las flores</option>
				<option value="3">Não consegue né moises</option>
			</select>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Livro</label> <select name="" id=""
				class="inputCadastro custom-select">
				<option value="0"></option>
				<%-- <% for (Livro l : listLivro) { %>
				<option value="<%=l.getId()%>"><%=l.getNome()%></option>
				<% } %> --%>
				<option value="1">As cronicas de narnia</option>
				<option value="2">Harry potter</option>
				<option value="3">percy jackson</option>
			</select>
		</div>
		<div class="btnPosition">
			<button type="submit" name="cmd" value="emprestar" class="btn btn-primary">Emprestar</button>
		</div>
	</form>
</body>

</html>