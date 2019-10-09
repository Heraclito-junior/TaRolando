<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 08/10/2019
  Time: 03:38
  To change this template use File | Settings | File Templates.
--%>
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
<%--                            <div class="col-md-12">--%>
<%--                                <div class="form-group col-md-6">--%>
<%--                                    <label for="nome-espaco">Nome </label>--%>
<%--                                    <input id="nome-espaco"--%>
<%--                                           class="form-control" minlength="5" name="espaco.nome"--%>
<%--                                           type="text" required value="${espaco.nome}" disabled>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="row">--%>
<%--                                <a class="btn btn-primary" href="${linkTo[AtividadeController].form}?id=${espaco.id}">--%>
<%--                                    Cadastrar Atividade</a>--%>
<%--                            </div>--%>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">${espaco.nome}</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                            <%--                <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[EsporteController].form}">Cadastrar</a>--%>
                        <div class="tabela-servicos">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Ações</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${atividades}" var="atividade">
                                    <tr>
                                        <td>${atividade.nome}</td>
                                        <td>
                                            <a title="Detalhar" href="${linkTo[AtividadeController].visualizar}?idAtividade=${atividade.id}">
                                                <i class="fa fa-eye fa-lg" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                <!-- Modal REMOVER -->
                                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
                                            </div>
                                            <div class="modal-body">
                                                Deseja realmente excluir este item?
                                            </div>
                                            <div class="modal-footer">
                                                <a  href="" class="btn btn-primary btn-remover">Sim</a>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <button href="" class="btn btn-default"
                        onclick="history.back(1)">Voltar</button>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

