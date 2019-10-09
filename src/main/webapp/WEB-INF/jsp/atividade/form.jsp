<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 03/10/2019
  Time: 04:28
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 03/10/2019
  Time: 04:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layoutSidebar>
    <jsp:attribute name="cabecalho">
    </jsp:attribute>
    <jsp:attribute name="rodape">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Cadastro de Atividade</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formTarefa" action="${linkTo[AtividadeController].salvar}" method="post">
                    <input type="hidden" name="atividade.id" value="${atividade.id}">
                    <input type="hidden" name="atividade.espaco.id" value="${espaco.id}">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nome-atividade">Nome: </label>
                            <input id="nome-atividade" class="form-control" minlength="3" name="atividade.nome"
                                   type="text" required value="${atividade.nome}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descricao-atividade">Descrição: </label>
                            <input id="descricao-atividade" class="form-control" name="atividade.descricao" type="text" value="${atividade.descricao}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="tipo_esporte">Esporte Favorito: </label>
                            <select type="text" class="form-control" id="tipo_esporte" placeholder="Esporte Favorito"
                                    name="atividade.esporte.id">
                                <option value=""></option>
                                <c:forEach items="${esportes}" var="t">
                                    <c:if test="${t.valor == atividade.esporte.id}">
                                        <option value="${t.valor}" selected="true">${t.chave}</option>
                                    </c:if>
                                    <c:if test="${!(t.valor == atividade.esporte.id)}">
                                        <option value="${t.valor}">${t.chave}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div>
                        <button class="btn btn-primary" type="submit">Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>


