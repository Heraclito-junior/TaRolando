<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 02/10/2019
  Time: 04:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <h1 class="page-header text-center">Meus Espaços</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">

                <div class="row">
                    <c:choose>
                        <c:when test="${espacos.size() == 0}">
                            <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[EspacoController].form}">Cadastrar</a>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${espacos}" var="espaco">
                                <div class="col-sm-6 col-md-4">
                                    <div class="thumbnail">
                                        <img src="${ctx}/resources/imagens/icons_map/surf.png" width="200px" alt="Estabelecimento">
                                        <div class="caption">
                                            <h3>${espaco.nome}</h3>
                                            <p>Rua das Dunas, Natal-RN, Nova Descoberta, 1550, 590100-100</p>
                                            <p class="text-center btn-block">
                                                <a href="${linkTo[EspacoController].detalhar}?id=${espaco.id}"
                                                   class="btn btn-primary btn-block" role="button">Entrar</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

