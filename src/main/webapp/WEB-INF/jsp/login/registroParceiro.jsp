<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 25/09/2019
  Time: 03:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
    <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="${ctx}/resources/plugins/dataPicker/dataPicker-bootstrap.js"></script>
    <script src="${ctx}/resources/plugins/typeahead/typeahead.bundle.js"></script>
    <script src="${ctx}/resources/js/init.js"></script>
    <script src="${ctx}/resources/js/endereco/cep.js"></script>
    <script>
        if ($(".datePicker").val()) {
            var data = moment($(".datePicker").val(), "YYYY-MM-DD").format("DD/MM/YYYY");
            $(".datePicker").val(data);
            console.log($(".datePicker").val());
        }
    </script>
    <title>Tá Rolando! WEB</title>
</head>
<body style="background-color: #3498db;">
<jsp:include page="/WEB-INF/jsp/errors/msgErrorCustominizada.jsp"/>
<div class="container">
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="color: white;">Registro de Parceiro</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="panel painel-sisint">
        <div class="panel-body">
            <form if="formParceiro" action="${linkTo[LoginController].salvarParceiro}" method="post">
                <input type="hidden" name="parceiro.id" value="${parceiro.id}">
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="nome-parceiro">Nome: </label>
                        <input id="nome-parceiro" class="form-control" minlength="5" name="parceiro.nome"
                               type="text" required value="${parceiro.nome}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="sobrenome-parceiro">Sobrenome: </label>
                        <input id="sobrenome-parceiro" class="form-control" minlength="5" name="parceiro.sobrenome"
                               type="text" required value="${parceiro.sobrenome}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="email-parceiro">Email: </label>
                        <input id="email-parceiro" class="form-control" minlength="5" name="parceiro.email"
                               type="email" required value="${parceiro.email}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="login_parceiro">Login: </label>
                        <input id="login_parceiro" class="form-control" minlength="5" name="parceiro.login"
                               type="text" required value="${parceiro.login}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="senha_parceiro">Senha: </label>
                        <input id="senha_parceiro" class="form-control" minlength="6" name="parceiro.senha"
                               type="password" required value="${parceiro.senha}">
                    </div>
<%--                    <div class="row" style="margin-left: 0px;">--%>
<%--                        <div class="col-md-12">--%>
<%--                            <div class="form-group col-md-3" style="padding-left: 0px;">--%>
<%--                                <label for="cep_parceiro">CEP </label>--%>
<%--                                <div class="input-group">--%>
<%--                                    <input id="cep_parceiro" class="form-control cep" name="parceiro.endereco.cep"--%>
<%--                                           type="text" value="${parceiro.endereco.cep}">--%>
<%--                                    <span class="input-group-btn">--%>
<%--                                            <button class="btn btn-default" type="button" onclick="buscarEndereco()"><i class="glyphicon glyphicon-search"></i></button>--%>
<%--                                        </span>--%>
<%--                                </div><!-- /input-group -->--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group col-md-8">--%>
<%--                        <label for="rua_parceiro">Rua: </label>--%>
<%--                        <input id="rua_parceiro" class="form-control rua" name="parceiro.endereco.rua" required--%>
<%--                               type="text" value="${parceiro.endereco.rua}">--%>
<%--                    </div>--%>
<%--                    <div class="form-group col-md-2">--%>
<%--                        <label for="rua_parceiro">Número: </label>--%>
<%--                        <input id="num_casa_parceiro" class="form-control" name="parceiro.endereco.numero"--%>
<%--                               type="text" value="${parceiro.endereco.numero}">--%>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="fone_parceiro">Telefone: </label>
                        <input id="fone_parceiro" class="form-control" name="parceiro.telefone"
                               type="tel" value="${parceiro.telefone}">
                    </div>
                    <div class="form-group col-md-1">
                        <button class="btn btn-primary" type="submit">Salvar</button>
                    </div>
                    <div class="form-group">
                        <a href="${linkTo[LoginController].formParceiro}" class="btn btn-default" type="submit">Voltar</a>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $('.alert').fadeOut(3000);
</script>
</body>
</html>


