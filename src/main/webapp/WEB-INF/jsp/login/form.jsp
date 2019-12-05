<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/resources/css/login/signin.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Tá Rolando! WEB</title>
</head>
<body style="background-color: #3498db;">
    <jsp:include page="/WEB-INF/jsp/errors/msgError.jsp"/>
    <div class="container">
        <c:set var="ctx" value="${pageContext.request.contextPath}"/>

        <div class="panel painel-sisint col-md-4 col-md-offset-4" style="margin-top:100px;">
            <div class="panel-heading" align="center">
                <img src="${ctx}/resources/imagens/titulo-tarolando.png" width="300px" alt="Imagem" style="margin-top: 16px; margin-left: -20px;"/>
            </div>
            <div class="panel-body" style="padding-bottom: 75px;">
                <form method="post" action="${linkTo[LoginController].login}">
                    <div class="input-group" style="margin-bottom: 8px;">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-atleta" type="text" class="form-control" name="atleta.login" placeholder="Login">
                    </div>
                    <div class="input-group" style="margin-bottom: 16px;">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="senha-atleta" type="password" class="form-control" name="atleta.senha" placeholder="Senha">
                    </div>
                        <button class="btn btn-primary btn-block" style="margin-bottom: 5px">Entrar</button>
                        <a href="${linkTo[LoginController].registro}" class="btn btn-primary btn-block">Registre-se</a>
                </form>
            </div>
        </div>
    </div>
    <script>
        $('.alert').fadeOut(3000);
    </script>
</body>
</html>

