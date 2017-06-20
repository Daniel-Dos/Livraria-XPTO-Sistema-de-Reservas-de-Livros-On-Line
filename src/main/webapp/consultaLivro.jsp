<%--

    Copyright Â© 2017 Daniel Dias (daniel.dias.analistati@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@page import="modelos.Livro"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Livros</title>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-xlarge.css" />
</noscript>
</head>
<body>
	<header id="header">
		<h1>
			<a href="index.jsp">Livraria XPTO - Sistema de Reservas de Livros On-Line</a>
		</h1>
		<nav id="nav">
			<ul>
				<li><a href="livro.jsp">Livros</a></li>
			</ul>
		</nav>
	</header>
	<section id="main" class="wrapper">
		<div class="container 50% ">
			${aux}<br /> <br /> <br />
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<h2 style="text-align: center">LIVRO</h2>
						<tr>
							<th>Codigo</th>
							<th>Nome</th>
							<th>Autor</th>
							<th>Descriï¿½ï¿½o</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${retorno}" var="lista">
							<tr>
								<td><c:out value="${lista.codigo}" /></td>
								<td><c:out value="${lista.nome}" /></td>
								<td><c:out value="${lista.autor}" /></td>
								<td><c:out value="${lista.descricao}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="javascript:self.print();" class="button alt fit">Imprimir Relatorio</a>
			</div>
			<br /> <br /> <br /> <br /> <br /> <a
				href="javascript:history.back(1);" class="button special">Voltar</a>
		</div>
	</section>
	<br />
	<br />
	<br />
	<br />
	<footer id="footer">
		<div class="container">
			<div class="row">
				<ul class="copyright">
					<li>Curso: Pós-Graduação em JAVA</li>
                        <li>Disciplina: Sistemas para Web e Componentes JEE e Frameworks</li><br />
                        <li>Copyright &copy; Daniel Dias dos Santos 2016</li>
                        <li>
                                <a href="https://www.facebook.com/DanielDias.D.Santos" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="https://github.com/Daniel-Dos" target="_blank" class="btn-social btn-outline"><i class="fa fa-fw fa-github"></i></a>
                            </li>
                            <li>
                                <a href="http://br.linkedin.com/in/danieldiassantos" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                            </li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>