<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 08/10/2019
  Time: 04:40
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
        <script src="${ctx}/resources/js/atleta/atleta.js"></script>
    </jsp:attribute>

    <jsp:body>
        <jsp:include page="/WEB-INF/jsp/errors/msgErrorCustominizada.jsp" />

        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center">Minhas Reservas</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="tabela-servicos">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Início</th>
                                        <th>Fim</th>
                                        <th>Pagamento</th>
                                        <th>Valor do Pagamento</th>
                                        <th>Ações</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${horarios}" var="horario">
                                        <tr>
                                            <td>${horario.horaInicio}</td>
                                            <td>${horario.horaFim}</td>
                                            <c:choose>
                                                <c:when test="${horario.pagamento.chave == 'Não Pago'}">
                                                    <td>Não Pago</td>
                                                    <td>0.0</td>
                                                </c:when>
                                                <c:when test="${horario.pagamento.chave == 'Pago Parcialmente'}">
                                                    <td>Pago Parcialmente</td>
                                                    <td>${horario.valorPago}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>Pago</td>
                                                    <td>100%</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <a title="Cancelar Reserva" href="#editarStatus"
                                                   url-status="${linkTo[HorarioController].editarStatus}?id=${horario.id}" data-toggle="modal">
                                                    <i class="fa fa-close fa-lg" aria-hidden="true"></i></a>
                                                <a title="Pagar" class="link-aceitar" href="#editarPagamento"
                                                   url-pagamento="${linkTo[HorarioController].editarPagamento}?id=${horario.id}" data-toggle="modal">
                                                    <i class="fa fa- fa-lg"></i></a>
                                                <c:choose>
                                                    <c:when test="${horario.evento == null}">
                                                        <a title="Integrar a Evento" class="link-integrar" href="#integrar-modal"
                                                           url-integrar="${linkTo[HorarioController].integrarAEvento}?idHorario=${horario.id}&idEvento="
                                                           data-toggle="modal"><i class="fa fa-chain fa-lg"></i></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a title="Desintegrar Evento" class="link-desintegrar" href="#desintegrar-modal"
                                                           url-desintegrar="${linkTo[HorarioController].desintegrarEvento}?id=${horario.id}"
                                                           data-toggle="modal"><i class="fa fa-chain-broken fa-lg"></i></a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <!-- Modal CANCELAR RESERVA -->
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


                                    <!-- Modal INTEGRAR RESERVA -->
                                    <div class="modal fade" id="integrar-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabelIntegrar">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="modalLabelIntegrar">Selecionar Evento</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <label for="evento_reservaId">Evento: </label>
                                                    <select type="text" class="form-control" id="evento_reservaId" placeholder="Escolha um evento para integrar"
                                                            name="idEvento">
                                                        <option value=""></option>
                                                        <c:forEach items="${eventos}" var="e">
                                                            <option value="${e.valor}">${e.chave}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="modal-footer">
                                                    <a id="btn-integrar" href="" class="btn btn-primary">Integrar</a>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Modal DESINTEGRAR RESERVA -->
                                    <div class="modal fade" id="desintegrar-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabelDesintegrar">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="modalLabelDesintegrar">Desintegrar Evento</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Você tem certeza que quer desintegrar o evento da reserva?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a id="btn-desintegrar" href="" class="btn btn-primary">Sim</a>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <button href="" class="btn btn-default"
                        onclick="history.back(1)">Voltar</button>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

