<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



            <form action="LogoutForm.do" method="post" align="right">
                <div class="12u$">
                    <ul class="actions">
                        <li><input value="Logout" class="button special" type="submit"/></li>
                        <li><input type="hidden" name="acao" value="R"></li>
                    </ul>
                </div>
            </form>

        </header>
        <section id="banner">
            <section id="three" class="wrapper style4 special">
                <div class="container">
                    <header class="major">
                        <h2>${msg} <c:out value="${usuario.nome}" /></h2>
                        <h3>O que deseja fazer?</h3><br/>
                    </header>
                </div>
                <div class="container 50%">
                    <div class="row uniform">
                        <form action="alterarUsuario.jsp" method="post">
                            <div class="12u$">
                                <ul class="actions">
                                    <li><input value="Minha Conta" class="special big" type="submit"></li>
                                </ul>
                            </div>
                        </form>
                        <form action="incluirReserva.jsp" method="post">
                            <div class="12u$">
                                <ul class="actions">
                                    <li><input value="Nova Reserva" class="special big" type="submit"/></li>
                                </ul>
                            </div>
                        </form>
                        <form action="consultarReserva.jsp" method="post">
                            <div class="12u$">
                                <ul class="actions">
                                    <li><input value="Minhas Reservas" class="special big" type="submit"></li>
                                </ul>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
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