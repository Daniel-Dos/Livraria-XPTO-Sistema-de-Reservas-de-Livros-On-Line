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
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Consulta de Reservas</title>
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
            <h1>Livraria XPTO - Sistema de Reservas de Livros On-Line</h1>
            <nav id="nav">
                <ul>
                    <li><a href="alterarUsuario.jsp">Minha Conta</a></li>
                    <li><a href="incluirReserva.jsp">Nova Reserva</a></li>
                    <li><a href="principal.jsp">Menu Principal</a></li>
                    
                </ul>
            </nav>
        </header>
        <section id="main" class="wrapper-special">
            <div class="container 50%">
            <br/>
                <div class="row">
            <h2>Consultar Minhas Reservas</h2>
            </div>
                <form action="ConsultarReservaForm.do" method="POST">
                    Informe o Login:
                    <input type="text" name="login" required="required" /><br/>          
                    <input type="submit" value="Consultar Reserva" />
                    <input type="reset" value="Cancelar"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:history.back(1);" class="button alt">Voltar</a>
                </form>
            </div>
        </section>
        

         <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
