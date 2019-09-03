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
                <h1 class="page-header">Cadastro de Setores</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formTarefa" action="${linkTo[EsporteController].salvar}" method="post">
                    <input type="hidden" name="esporte.id" value="${esporte.id}">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="nome-esporte">Nome: </label>
                            <input id="nome-esporte" class="form-control" minlength="3" name="esporte.nome"
                                   type="text" required value="${esporte.nome}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descricao-esporte">Descrição: </label>
                            <input id="descricao-esporte" class="form-control" name="esporte.descricao" type="text" value="${esporte.descricao}">
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
