<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layoutSidebar>
    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/typeahead/typeahead.bundle.js"></script>
        <script src="${ctx}/resources/js/init.js"></script>
        <script src="${ctx}/resources/js/endereco/cep.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editar Perfil</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formAtividade" action="${linkTo[AtletaController].salvar}" method="post">
                    <input type="hidden" name="atleta.id" value="${atleta.id}">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="nome-atleta">Nome </label>
                            <input id="nome-atleta" class="form-control" minlength="5" name="atleta.nome"
                                   type="text" required value="${atleta.nome}" disabled>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="sobrenome-atleta">Sobrenome </label>
                            <input id="sobrenome-atleta" class="form-control" minlength="5" name="atleta.sobrenome"
                                   type="text" required value="${atleta.sobrenome}" disabled>
                        </div>
                            <%--<div class="form-group col-md-4 text-center">--%>
                            <%--<label for="tipo_esporte">Tipo de Esporte </label>--%>
                            <%--<div style="padding: 0px 60px">--%>
                            <%--<a id="tipo_esporte" data-toggle="modal" href="#modalEsporte"--%>
                            <%--class="form-control btn btn-primary">Escolher</a>--%>
                            <%--</div>--%>
                        <div class="form-group col-md-4">
                            <label for="tipo_esporte">Esporte Preferido </label>
                            <select type="text" class="form-control" id="tipo_esporte" placeholder="Esporte Preferido"
                                    name="atleta.esportePreferido.id" disabled>
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
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>


