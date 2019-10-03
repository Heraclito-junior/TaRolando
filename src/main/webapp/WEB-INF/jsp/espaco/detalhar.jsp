<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 03/10/2019
  Time: 04:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagTaRolando"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<tags:layoutSidebar>
	<jsp:attribute name="cabecalho">

    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/dataTables/datatables.js">
            <c:out value=""/>
        </script>
        <script
                src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.html5.js">
            <c:out value=""/>
        </script>
        <script
                src="${ctx}/resources/plugins/moment/date-time-moment.js"></script>
        <script src="${ctx}/resources/js/evento/detalhar.js"></script>
    </jsp:attribute>

    <jsp:body>
        <jsp:include page="/WEB-INF/jsp/errors/msgErrorCustominizada.jsp" />

        <input type="hidden" name="evento.id" value="${evento.id}">
        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center">Detalhes do Espaço</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="col-md-8">
                                <div class="form-group col-md-6">
                                    <label for="nome-espaco">Nome </label>
                                    <input id="nome-espaco"
                                           class="form-control" minlength="5" name="espaco.nome"
                                           type="text" required value="${espaco.nome}" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <a class="btn btn-primary" href="${linkTo[AtividadeEspacoController].form}?id=${espaco.id}">
                                Cadastrar Atividade</a>
                        </div>
                    </div>
                </div>

                <button href="" class="btn btn-default"
                        onclick="history.back(1)">Voltar</button>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>
