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
                <form id="formTarefa" action="${linkTo[AtividadeEspacoController].salvar}" method="post">
                    <input type="hidden" name="atividadeEspaco.id" value="${atividadeEspaco.id}">
                    <input type="hidden" name="atividadeEspaco.espaco.id" value="${espaco.id}">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nome-atividadeEspaco">Nome: </label>
                            <input id="nome-atividadeEspaco" class="form-control" minlength="3" name="atividadeEspaco.nome"
                                   type="text" required value="${atividadeEspaco.nome}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descricao-atividadeEspaco">Descrição: </label>
                            <input id="descricao-atividadeEspaco" class="form-control" name="atividadeEspaco.descricao" type="text" value="${atividadeEspaco.descricao}">
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


