<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 07/10/2019
  Time: 21:39
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

        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center">Detalhes da Atividade</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="nome-atividade">Nome </label>
                                    <input id="nome-atividade"
                                           class="form-control" minlength="5" name="atividade.nome"
                                           type="text" required value="${atividade.nome}" disabled>
                                </div>
                            </div>
                            <div class="row">
                                <a class="btn btn-primary" href="#horariosModal" data-toggle="modal">
                                    Cadastrar Horários</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">${atividade.nome}</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                            <%--                <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[EsporteController].form}">Cadastrar</a>--%>
                        <div class="tabela-servicos">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Início</th>
                                    <th>Fim</th>
                                    <th>Status</th>
                                    <th>Ações</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${horarios}" var="horario">
                                    <tr>
                                        <td>${horario.horaInicio}</td>
                                        <td>${horario.horaFim}</td>
                                        <c:choose>
                                            <c:when test="${horario.disponivel}">
                                                <td>Disponível</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>Reservado</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>
                                            <a title="Editar Status" href="#editarStatus"
                                                url-status="${linkTo[HorarioController].editarStatus}?id=${horario.id}" data-toggle="modal">
                                                <i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
                                            <a title="Editar Pagamento" class="link-aceitar" href="#editarPagamento"
                                               url-pagamento="${linkTo[HorarioController].editarPagamento}?id=${horario.id}" data-toggle="modal">
                                                <i class="fa fa- fa-lg"></i></a>
                                            <a title="Remover" class="link-remover" href="#delete-modal"
                                               url-remover="${linkTo[HorarioController].remover}?id=${horario.id}&idAtividade=${atividade.id}"
                                               data-toggle="modal"><i class="fa fa-trash fa-lg"></i></a>
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

                                <!-- MODAL HORARIOS -->
                                <div class="modal fade" id="horariosModal" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h2 class="modal-title text-center">Cadastro de Horário</h2>
                                            </div>
                                            <form action="${linkTo[HorarioController].salvar}" method="post">
                                                <input type="hidden" name="idAtividade" value="${atividade.id}" />
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="form-group col-md-3">
                                                            <label for="horario_inicio">Horário de Início </label>
                                                            <input id="horario_inicio" class="form-control timePickerInicio" name="horaInicio"
                                                                   type="time" value="${horario.horaInicio}" required>
                                                        </div>
                                                        <div class="form-group col-md-3">
                                                            <label for="horario_fim">Horário do Fim </label>
                                                            <input id="horario_fim" class="form-control timePickerFim" name="horaFim"
                                                                   type="time" value="${horario.horaFim}" required>
                                                        </div>
                                                            <%--                                                    <div class="form-group col-md-3">--%>
                                                            <%--                                                        <label class="control-label col-sm-2" for="status-pagamento">Status</label>--%>
                                                            <%--                                                        <div class="col-md-12">--%>
                                                            <%--                                                            <select type="text" class="form-control" id="status-pagamento"--%>
                                                            <%--                                                                    placeholder="Status do Pagamento"--%>
                                                            <%--                                                                    required="true"--%>
                                                            <%--                                                                    name="horario.statusPagamento">--%>
                                                            <%--                                                                <option value=""></option>--%>
                                                            <%--                                                                <c:forEach items="${statusPagamento}" var="s">--%>
                                                            <%--                                                                    <c:if test="${s.valor == horario.statusPagamento.valor}">--%>
                                                            <%--                                                                        <option value="${s.valor}" selected="true">${s.chave}</option>--%>
                                                            <%--                                                                    </c:if>--%>
                                                            <%--                                                                    <c:if test="${!(s.valor == horario.statusPagamento.valor)}">--%>
                                                            <%--                                                                        <option value="${s.valor}">${s.chave}</option>--%>
                                                            <%--                                                                    </c:if>--%>
                                                            <%--                                                                </c:forEach>--%>
                                                            <%--                                                            </select>--%>
                                                            <%--                                                        </div>--%>
                                                            <%--                                                    </div>--%>
<%--                                                    </div>--%>
                                                        <%--                                                <div class="row">--%>
                                                        <%--                                                    <div class="form-group col-md-4">--%>
                                                        <%--                                                        <label>Horário Disponível?--%>
                                                        <%--                                                            <div style="margin-left: 16px; float: right;">--%>
                                                        <%--                                                                <input type="checkbox" name="horario.disponivel" value="${horario.disponivel}"/>--%>
                                                        <%--                                                            </div>--%>
                                                        <%--                                                        </label>--%>
                                                        <%--                                                    </div>--%>
                                                        <%--                                                    <div class="form-group col-md-4">--%>
                                                        <%--                                                        <label>Tempo Utilizado?--%>
                                                        <%--                                                            <div style="margin-left: 16px; float: right;">--%>
                                                        <%--                                                                <input type="checkbox" name="horario.realizado" value="${horario.realizado}"/>--%>
                                                        <%--                                                            </div>--%>
                                                        <%--                                                        </label>--%>
                                                        <%--                                                    </div>--%>
                                                        <%--                                                </div><!-- /modal-row-->--%>
                                                    </div>
                                                </div><!-- /modal-body -->
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    <button id="btnSalvarHorario" type="submit" class="btn btn-primary">
                                                        Salvar
                                                    </button>
                                                </div>

                                            </form>

                                        </div> <!-- /modal-content -->
                                    </div> <!-- /modal-dialog -->
                                </div> <!-- /modal -->

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
