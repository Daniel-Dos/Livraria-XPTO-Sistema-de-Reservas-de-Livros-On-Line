<%--

    Copyright © 2017 Daniel Dias (daniel.dias.analistati@gmail.com)

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
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>Reservas</title>
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
				<h1><a href="index.jsp">Livraria XPTO - Sistema de Reservas de Livros On-Line</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="usuario.jsp">Usu�rios</a></li>
						<li><a href="livro.jsp">Livros</a></li>
						<li><a href="reserva.jsp">Reservas</a></li>
						<li><a href="index.jsp" class="button special">Fazer Logoff</a></li>
					</ul>
				</nav>
			</header>
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>Reservas</h2>
						<p>�rea destinada para consultas, inser��es, altera��es e exclus�es de reservas.</p>
					</header>
						<section>
							<div class="row">
								<div class="3u 6u(2) 12u$(3)">
									<ul class="actions vertical">
										<li><a href="incluirReserva.jsp" class="button alt fit">INSERIR</a></li>
										<li><a href="alterarReserva.jsp"" class="button alt fit">ALTERAR</a></li>
										<li><a href="excluirReserva.jsp"" class="button alt fit">EXCLUIR</a></li>
										<li><a href="consultarReserva.jsp"" class="button alt fit">CONSULTAR</a></li>
									</ul>
								</div>
							</div>
						</section>
				</div>
			</section>
			<footer id="footer">
				<div class="container">
					<div class="row">
							<ul class="copyright">
                        <li>Curso: P�s-Gradua��o em JAVA</li>
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