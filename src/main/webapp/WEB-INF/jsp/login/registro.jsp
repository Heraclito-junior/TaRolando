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
                <h1 class="page-header" style="color: white;">Registro de Atleta</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form if="formAtividade" action="${linkTo[LoginController].salvar}" method="post">
                    <input type="hidden" name="atleta.id" value="${atleta.id}">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="nome-atleta">Nome: </label>
                            <input id="nome-atleta" class="form-control" minlength="5" name="atleta.nome"
                                   type="text" required value="${atleta.nome}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="sobrenome-atleta">Sobrenome: </label>
                            <input id="sobrenome-atleta" class="form-control" minlength="5" name="atleta.sobrenome"
                                   type="text" required value="${atleta.sobrenome}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="tipo_esporte">Esporte Favorito: </label>
                            <select type="text" class="form-control" id="tipo_esporte" placeholder="Esporte Favorito"
                                    name="atleta.esporteFavorito.id">
                                <option value=""></option>
                                <c:forEach items="${esportes}" var="t">
                                    <c:if test="${t.valor == atleta.esportePreferido.id}">
                                        <option value="${t.valor}" selected="true">${t.chave}</option>
                                    </c:if>
                                    <c:if test="${!(t.valor == atleta.esportePreferido.id)}">
                                        <option value="${t.valor}">${t.chave}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="email-atleta">Email: </label>
                            <input id="email-atleta" class="form-control" minlength="5" name="atleta.email"
                                   type="email" required value="${atleta.email}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="login_atleta">Login: </label>
                            <input id="login_atleta" class="form-control" minlength="5" name="atleta.login"
                                   type="text" required value="${atleta.login}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="senha_atleta">Senha: </label>
                            <input id="senha_atleta" class="form-control" minlength="6" name="atleta.senha"
                                   type="password" required value="${atleta.senha}">
                        </div>
                        <div class="row" style="margin-left: 0px;">
                            <div class="col-md-12">
                                <div class="form-group col-md-3" style="padding-left: 0px;">
                                    <label for="cep_atleta">CEP </label>
                                    <div class="input-group">
                                        <input id="cep_atleta" class="form-control cep" name="atleta.endereco.cep"
                                               type="text" value="${atleta.endereco.cep}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" onclick="buscarEndereco()"><i class="glyphicon glyphicon-search"></i></button>
                                        </span>
                                    </div><!-- /input-group -->
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="rua_atleta">Rua: </label>
                            <input id="rua_atleta" class="form-control rua" name="atleta.endereco.rua" required
                                   type="text" value="${atleta.endereco.rua}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="rua_atleta">Número: </label>
                            <input id="num_casa_atleta" class="form-control" name="atleta.endereco.numero"
                                   type="text" value="${atleta.endereco.numero}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fone_atleta">Telefone: </label>
                            <input id="fone_atleta" class="form-control" name="atleta.telefone"
                                   type="tel" value="${atleta.telefone}">
                        </div>
                        <div class="form-group col-md-1">
                            <button class="btn btn-primary" type="submit">Salvar</button>
                        </div>
                        <div class="form-group">
                            <a href="${linkTo[LoginController].form}" class="btn btn-default" type="submit">Voltar</a>
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

