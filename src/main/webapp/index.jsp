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
<title>Sistema de Reservas</title>
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

<body class="landing">
			<header id="header">
				<h1>Livraria XPTO - Sistema de Reservas de Livros On-Line</h1>
				<nav id="nav">
					<ul>
						<li><a href="usuario.jsp">Cadastre-se</a></li>
						<li><a href="livro.jsp">Livros</a></li>
					</ul>
				</nav>
			</header>
			<section id="banner">
			<section id="three" class="wrapper style3 special">
				<div class="container">
					<header class="major">
						<h2>Acessar sistema para fazer reservas</h2><br/>
						<h1><label style="color: red;">${msg1}</label></h1>
						<h1><label style="color: green;">${aux}</label></h1>
						<h1><label style="color: green">${msg2}</label></h1>
                                                <h1><label style="color: red;">${excluir}</label></h1><br />
						
					</header>
				</div>
				<div class="container 50%">
					<form action="loginForm.do" method="post">
					<input type="hidden" name="acao" value="V">
						<div class="row uniform">
							<div class="6u 12u$(small)">
								<input name="login" value="${user.login }" id="name" required="required"  placeholder="Login" type="text">
							</div>
							<div class="6u$ 12u$(small)">
								<input name="senha" value="${user.senha }"id="senha" required="required"  placeholder="Senha" type="password">
							</div>
							<div class="12u$">
								<ul class="actions">
									<li><input value="Logar" class="special big" type="submit"></li>
								</ul>
								<ul class="actions">
								<li>Esqueceu sua senha ? <a href="esqueceuSenha.jsp"> Clique aqui</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</section>
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