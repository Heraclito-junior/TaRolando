<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 08/10/2019
  Time: 03:48
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
        <script src="${ctx}/resources/js/horario/horario.js"></script>
    </jsp:attribute>

    <jsp:body>
        <jsp:include page="/WEB-INF/jsp/errors/msgErrorCustominizada.jsp" />

        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center">Tabela de Horários Livre</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
<%--                            <div class="col-md-12">--%>
<%--                                <div class="form-group col-md-6">--%>
<%--                                    <label for="nome-atividade">Nome </label>--%>
<%--                                    <input id="nome-atividade"--%>
<%--                                           class="form-control" minlength="5" name="atividade.nome"--%>
<%--                                           type="text" required value="${atividade.nome}" disabled>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="row">--%>
<%--                                <a class="btn btn-primary" href="#horariosModal" data-toggle="modal">--%>
<%--                                    Cadastrar Horários</a>--%>
<%--                            </div>--%>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">${atividade.nome}</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <div class="tabela-servicos">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Início</th>
                                    <th>Fim</th>
                                    <th>Ações</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${horarios}" var="horario">
                                    <tr>
                                        <td>${horario.horaInicio}</td>
                                        <td>${horario.horaFim}</td>
                                        <td>
                                            <a title="Reservar" href="#reservarModal" class="link-reservar"
                                               url-reservar="${linkTo[HorarioController].reservar}?idHorario=${horario.id}&idAtleta=${usuarioLogado.usuario.id}"
                                               data-toggle="modal">Reservar</a>
<%--                                            <a title="Editar Pagamento" class="link-aceitar" href="#editarPagamento"--%>
<%--                                               url-pagamento="${linkTo[HorarioController].editarPagamento}?id=${horario.id}" data-toggle="modal">--%>
<%--                                                <i class="fa fa- fa-lg"></i></a>--%>
<%--                                            <a title="Remover" class="link-remover" href="#delete-modal"--%>
<%--                                               url-remover="${linkTo[HorarioController].remover}?id=${horario.id}&idAtividade=${atividade.id}"--%>
<%--                                               data-toggle="modal"><i class="fa fa-trash fa-lg"></i></a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>

                                <!-- Modal RESERVAR -->
                                <div class="modal fade" id="reservarModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="modalLabel">Reserva de Horário</h4>
                                            </div>
                                            <div class="modal-body">
                                                Você confirma a reserva de horário?
                                            </div>
                                            <div class="modal-footer">
                                                <a href="" class="btn btn-primary btnReservar">Sim</a>
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

