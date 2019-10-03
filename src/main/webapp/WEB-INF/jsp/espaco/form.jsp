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
                <h1 class="page-header">Cadastro de Espaço</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formTarefa" action="${linkTo[EspacoController].salvar}" method="post">
                    <input type="hidden" name="espaco.id" value="${espaco.id}">
                    <input type="hidden" name="espaco.proprietario.id" value="${espaco.proprietario.id}">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nome-espaco">Nome: </label>
                            <input id="nome-espaco" class="form-control" minlength="3" name="espaco.nome"
                                   type="text" required value="${espaco.nome}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descricao-espaco">Descrição: </label>
                            <input id="descricao-espaco" class="form-control" name="espaco.descricao" type="text" value="${espaco.descricao}">
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

