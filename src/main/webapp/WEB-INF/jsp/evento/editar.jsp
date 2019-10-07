<%--
  Created by IntelliJ IDEA.
  User: jotapesousa
  Date: 11/12/18
  Time: 04:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layoutSidebar>
    <jsp:attribute name="cabecalho">

    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/dataTables/datatables.js"><c:out value=""/></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.html5.js"><c:out value=""/></script>
        <script src="${ctx}/resources/plugins/moment/date-time-moment.js"></script>
    </jsp:attribute>

    <jsp:body>
            <div class="panel painel-sisint">
                <div class="panel-heading">
                    <h4 align="center">Detalhes do Evento</h4>
                </div>
                <div class="panel-body" style="padding-top: 0px;">
                    <div class="row">
                        <div class="panel">
                            <div class="panel-body">
                                <form id="formEvento" action="${linkTo[EventoController].modificar}" method="post">
                                    <input type="hidden" name="evento.id" value="${evento.id}"/>
                                    <div class="col-md-8">
                                        <div class="form-group col-md-6">
                                            <label for="titulo-evento">Título </label>
                                            <input id="titulo-evento" class="form-control" minlength="5" name="evento.titulo"
                                                   type="text" required value="${evento.titulo}" >
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="tipo_evento">Tipo de Atividade </label>
                                            <select type="text" class="form-control" id="tipo_evento" placeholder="Tipo de Atividade"
                                                    required
                                                    name="evento.tipoEsporte.id">
                                                <option value=""></option>
                                                <c:forEach items="${esportes}" var="e">
                                                    <c:if test="${e.valor == evento.tipoEsporte.id}">
                                                        <option value="${e.valor}" selected="true">${e.chave}</option>
                                                    </c:if>
                                                    <c:if test="${!(e.valor == evento.tipoEsporte.id)}">
                                                        <option value="${e.valor}">${e.chave}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dataInicio_evento">Data de Início</label>
                                            <input type="text" class="form-control datePicker" id="dataInicio_evento"
                                                   value="${evento.dataInicio}"
                                                   placeholder="(Opcional)" readonly="readonly" name="evento.dataInicio"/>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dataFinal_evento">Data Final</label>
                                            <input type="text" class="form-control datePicker" id="dataFinal_evento"
                                                   value="${evento.dataFim}"
                                                   placeholder="(Opcional)" readonly="readonly" name="evento.dataFim"/>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="horario_inicio">Horário de Início </label>
                                            <input id="horario_inicio" class="form-control timePickerInicio" name="evento.horaInicio"
                                                   type="time" value="${evento.horaInicio}" required >
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="horario_fim">Horário do Fim </label>
                                            <input id="horario_fim" class="form-control timePickerFim" name="evento.horaFim"
                                                   type="time" value="${evento.horaFim}" required >
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="num_vagas_min">Mín. de Vagas </label>
                                            <input id="num_vagas_min" class="form-control" name="evento.numVagasMin" min="0"
                                                   type="number" value="${evento.numVagasMin}" >
                                        </div>
                                        <div class="form-group col-md-2 col-md-offset-2">
                                            <label for="num_vagas_max">Máx. de Vagas </label>
                                            <input id="num_vagas_max" class="form-control" name="evento.numVagasMax" min="0"
                                                   type="number" value="${evento.numVagasMax}" >
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="localizacao">Localização </label>
                                            <input id="localizacao" class="form-control" name="evento.localizacao"
                                                   type="text" value="${evento.localizacao.rua}, ${evento.localizacao.numero},  ${evento.localizacao.cep}">
                                        </div>
                                            <%--<div class="form-group col-md-4">--%>
                                            <%--<label for="latitude">Latitude: </label>--%>
                                            <%--<input id="latitude" class="form-control" name="evento.latitude" --%>
                                            <%--type="text" value="${evento.latitude}">--%>
                                            <%--</div>--%>
                                            <%--<div class="form-group col-md-4">--%>
                                            <%--<label for="longitude">Longitude: </label>--%>
                                            <%--<input id="longitude" class="form-control" name="evento.longitude" --%>
                                            <%--type="text" value="">--%>
                                            <%--</div>--%>
                                        <div class="form-group col-md-12 text-center" >
                                            <label for="descricao-evento">Descrição do Evento </label>
                                            <textarea id="descricao-evento" class="form-control" minlength="5"
                                                      name="evento.descricao" rows="5"
                                                      required="true" >${evento.descricao}</textarea>
                                        </div>
                                    </div>
                                    <div class="panel">
                       					<button class="btn btn-primary" type="submit">Salvar</button>
                   					 </div>
                                </form>
                                <div class="col-md-4 order-md-2 mb-4">
                                    <h4 class="text-center" style="margin-top: 0px; padding-top: 0px;">
                                        <span class="text-muted bold">Atletas Participantes</span>
                                        <span class="badge badge-secondary badge-pill">${numParticipantes}</span>
                                        <c:if test="${atletaLogado.atleta.id == evento.organizador.id}">
                                            <span class="icon text-right">
                                                <button class="btn btn-link" data-toggle="modal" data-target="#addParticipante">
                                                <i class="fa fa-plus"></i></button></span>
                                        </c:if>
                                    </h4>
                                    <ul class="list-group mb-3">
                                        <c:forEach items="${participantes}" var="participante">
                                            <li class="list-group-item justify-content-between" style="padding-left: 0px;">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <img class="img-circle" src="${ctx}/resources/imagens/icons_map/futebol.png"
                                                             width="60px" height="60px"/>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <h4>${participante.nome}</h4>
                                                        <span class="badge badge-success badge-pill">Pendente</span>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <button class="btn btn-link"><i class="fa fa-envelope"></i></button>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="list-group-item d-flex justify-content-between">
                                                <div>
                                                    <h6 class="my-0">Nome do produto</h6>
                                                    <small class="text-muted">Breve descrição</small>
                                                </div>
                                                <span class="text-muted">R$12</span>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <button href="" class="btn btn-default" onclick="history.back(1)">Voltar</button>
                </div>

                <!-- Large modal -->
                <div id="addParticipante" class="modal fade"role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">Adicionar Atleta</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="nome_atleta">Nome do Atleta </label>
                                    <input id="nome_atleta" class="form-control" minlength="5" name="atleta.nome"
                                           type="text" required value="" placeholder="Digite o nome do Atleta">
                                </div>
                                <div class="form-group">
                                    <label for="login_participante">Login:</label>
                                    <input type="login" name="tarefa.titulo" class="form-control" required
                                           value=""
                                           id="login_participante" placeholder="Digite o login do Atleta">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                <a href="" class="btn btn-primary btn_convidar">Convidar</a>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div>
            </div>
    </jsp:body>
</tags:layoutSidebar>