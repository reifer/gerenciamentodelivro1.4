<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="com.br.Models.Usuario, com.br.Dao.UsuarioDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="./css/style.css" rel="stylesheet" />
	<link rel="stylesheet" href="./css/bootstrap.min.css" />
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastro de Usuario</title>
</head>

<body class="backgroundImage">
	<%
		/* UsuarioDaoImpl uDao = new UsuarioDaoImpl();
		List<Usuario> listUsuario = uDao.getAll(); */
		Usuario usuarioAtual = new Usuario();
	%>
    <form class="formCadastro" class="formCadastro" action="./UsuarioControllers" method="post">
        <div class="form-group">
            <h1>Cadastro de Usuario</h1>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Usuarios</label>
            <select name="ID" value="<%=usuarioAtual.getId() %>)" class="inputCadastro custom-select">
                <option value="0"></option>
                <option value="1">Joãzinho da silva</option>
                <option value="2">Angela de las flores</option>
                <option value="3">NÃ£o consegue nÃo moises</option>
            </select>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Nome</label>
            <input type="text" value="<%=usuarioAtual.getNome() %>" name="NOME" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Tipo</label>
            <select name="TIPO" value="<%=usuarioAtual.getTipo() %>" class="inputCadastro custom-select">
                    <option value="0"></option>
                    <option value="1">aluno</option>
                    <option value="2">funcionario</option>
                </select>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Email</label>
            <input type="text" value="<%=usuarioAtual.getEmail() %>" name="EMAIL" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">telefone</label>
            <input type="text" value="<%=usuarioAtual.getTelefone() %>" name="TELEFONE" class="form-control inputCadastro">
        </div>
        <div class="btnPosition">
        <%-- <%
				if (usuarioAtual.getId() == 0) {
			%> --%>
            <button type="submit" name="cmd" value="adiciona" class="btn btn-primary">Salvar</button>
            <%-- <%
				} else {
			%> --%>
            <button type="submit" name="cmd" value="remover" class="btn btn-danger">Deletar</button>
            <%-- <%
				}
			%> --%>
            <button type="submit" name="cmd" value="editar" class="btn btn-danger">Alterar</button>
        </div>
    </form>
</body>

</html>