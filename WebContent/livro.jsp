<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>Livros</title>
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
						
						<li><a href="livro.jsp">Livros</a></li>
						
						
					</ul>
				</nav>
			</header>
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>Livros</h2>
						<p>Àrea destinada para consultas, inserções, alterações e exclusões de livros.</p>
					</header>
						<section>
							<div class="row">
								<div class="3u 6u(2) 12u$(3)">
									<ul class="actions vertical">
										<li><a href="incluirLivro.jsp" target="_self" class="button alt fit">INSERIR</a></li>
										<li><a href="alterarLivro.jsp" class="button alt fit">ALTERAR</a></li>
										<li><a href="excluirLivro.jsp" class="button alt fit">EXCLUIR</a></li>
										<li>
										<form action="ConsultarLivroForm.do" method="POST">
										<input type="submit" value="Lista de Livros"  class="button alt fit" />
										</form>
										</li>
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