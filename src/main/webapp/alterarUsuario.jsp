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
        <title>Altera��o de Usuario</title>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>
        <script src="js/funcoes.js"></script>
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
                    <li><a href="principal.jsp">Menu Principal</a></li>
                    
                </ul>
            </nav>
        </header>
        
        <section id="main" class="wrapper-special">
            <div class="container 50%">
            <br/>
                <div class="row">
            <h2>Meus Dados</h2>
            </div>
                <form action="ConsultarUsuarioForm.do" method="POST">
                    Informe o Login:
                    <input type="text" name="login" value="${usuario.login}"  required="required" /><br/>   
                    Nome:
                    <input type="text" name="nome" value="${retorno.nome}" disabled="disabled"/><br/>
                    Telefone:
                    <input type="text" value="${retorno.telefone}" name="telefone" onkeypress="formata_mascara(this,'## # ####-####');return Numero(event);"  placeholder="xx x xxxx-xxxx"  maxlength="14" disabled="disabled"/><br/>
                    Email:
                    <input type="text" name="email"  value="${retorno.email}" disabled="disabled"/><br/>  
                           
                    <input type="submit" value="Consultar Dados" />
                   
                </form>
            </div>
        </section>
        
        <section id="main" class="wrapper-special">
            <div class="container 50%">
            <br/>
                <div class="row">
            <h2>Altera��o de Dados</h2>
             <label style="color: green;">${aux}</label><br /><br />
            </div>
                <form action="AlterarUsuarioForm.do" method="POST">
                    Tipo de Usu�rios<br />
                 
                  
                  <input type="radio" name="rdbTipo" id="tipoVip" value="UsuarioVip"/>
                 <label for="tipoVip">Usu�rio Vip</label> <br />
                 
                 <input type="radio" name="rdbTipo" id="tipoNormal" value="UsuarioNormal"/>
                 <label for="tipoNormal">Usu�rio Normal</label> <br />
                
                   
                   Insira o seu  Login:
                    <input type="text" value="${usuario.login}" name="login" required="required" /><br/>
                   Novo  Nome:
                    <input type="text" value="${usuario.nome}" name="nome" required="required" /><br/>
                   Novo  Telefone:
                    <input type="text" value="${usuario.telefone}" required="required"  name="telefone" onkeypress="formata_mascara(this,'## # ####-####');return Numero(event);"  placeholder="xx x xxxx-xxxx"  maxlength="14"/><br/>
                    Novo Email:
                    <input type="text" value="${usuario.email}" name="email" required="required"  /><br/>    
                        
                    <input type="submit" value="Alterar Dados"   />
                    <input type="reset" value="Cancelar" />
                    
                </form>
            </div>
        </section>
        
        <section id="main" class="wrapper-special">
            <div class="container 50%">
            <br/>
                <div class="row">
            <h2>Exclus�o de Conta</h2>
            </div>
                <form action="ExcluirUsuarioForm.do" method="POST">
                
                    Informe o Login:
                    <input type="text" name="login" value="${usuario.login}" required="required" /><br/>          
                    <input type="submit" value="Excluir Conta" style="background-color: red;"/>
                    <input type="reset" value="Cancelar" />
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    
                    
                    
                    <a href="javascript:history.back(1);" class="button alt">Voltar</a>
                </form>
            </div>
        </section>
        
        <br/>
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
