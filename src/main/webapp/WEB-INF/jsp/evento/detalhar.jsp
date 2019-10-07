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
                <h4 align="center">Detalhes do Evento</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="col-md-8">
                                <div class="form-group col-md-6">
                                    <label for="titulo-evento">Título </label>
                                    <input id="titulo-evento"
										class="form-control" minlength="5" name="evento.titulo"
										type="text" required value="${evento.titulo}" disabled>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="tipo_evento">Tipo de Atividade </label>
                                    <input id="tipo_evento"
										class="form-control" minlength="5" name="evento.titulo"
										type="text" required value="${evento.tipoEsporte.nome}"
										disabled>
                                    <!--  
                                    <select type="text" class="form-control" id="tipo_evento" placeholder="Tipo de Atividade"
                                            required disabled
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
                                    -->
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="dataInicio_evento">Data de Início</label>
                                    <input type="text"
										class="form-control datePicker" id="dataInicio_evento"
										value="${evento.dataInicio}" disabled placeholder="(Opcional)"
										readonly="readonly" name="evento.dataInicio" />
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="dataFinal_evento">Data Final</label>
                                    <input type="text"
										class="form-control datePicker" id="dataFinal_evento"
										value="${evento.dataFim}" disabled placeholder="(Opcional)"
										readonly="readonly" name="evento.dataFim" />
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="horario_inicio">Horário de Início </label>
                                    <input id="horario_inicio"
										class="form-control timePickerInicio" name="evento.horaInicio"
										type="time" value="${evento.horaInicio}" required disabled>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="horario_fim">Horário do Fim </label>
                                    <input id="horario_fim"
										class="form-control timePickerFim" name="evento.horaFim"
										type="time" value="${evento.horaFim}" required disabled>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="num_vagas_min">Mín. de Vagas </label>
                                    <input id="num_vagas_min"
										class="form-control" name="evento.numVagasMin" min="0"
										type="number" value="${evento.numVagasMin}" disabled>
                                </div>
                                <div
									class="form-group col-md-2 col-md-offset-2">
                                    <label for="num_vagas_max">Máx. de Vagas </label>
                                    <input id="num_vagas_max"
										class="form-control" name="evento.numVagasMax" min="0"
										type="number" value="${evento.numVagasMax}" disabled>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="localizacao">Localização </label>
                                    <input id="localizacao"
										class="form-control" name="evento.localizacao" disabled
										type="text"
										value="${evento.localizacao.rua}, ${evento.localizacao.numero},  ${evento.localizacao.cep}">
                                </div>
                                    <%--<div class="form-group col-md-4">--%>
                                    <%--<label for="latitude">Latitude: </label>--%>
                                    <%--<input id="latitude" class="form-control" name="evento.latitude" disabled--%>
                                    <%--type="text" value="${evento.latitude}">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group col-md-4">--%>
                                    <%--<label for="longitude">Longitude: </label>--%>
                                    <%--<input id="longitude" class="form-control" name="evento.longitude" disabled--%>
                                    <%--type="text" value="">--%>
                                    <%--</div>--%>
                                <div
									class="form-group col-md-12 text-center">
                                    <label for="descricao-evento">Descrição do Evento </label>
                                    <textarea id="descricao-evento"
										class="form-control" minlength="5" name="evento.descricao"
										rows="5" disabled required="true">${evento.descricao}</textarea>
                                </div>
                            </div>

                            <div class="col-md-4 order-md-2 mb-4">
                                <h4 class="text-center"
									style="margin-top: 0px; padding-top: 0px;">
                                    <a href="${linkTo[ChatController].chat}?id=${evento.chat.id}">Chat do Grupo</a><br>
                                    <c:if test="${usuarioLogado.isAdmin() or usuarioLogado.retornarUsuario() == evento.organizador.id}">
									<button class="btn btn-link"
												data-toggle="modal" data-target="#addAlerta">
												Adicionar Atleta
											</button>
									</c:if>
                                    <span class="text-muted bold">Atletas Participantes</span>
                                    <span
										class="badge badge-secondary badge-pill">${numParticipantes}</span>
                                    <c:if
										test="${atletaLogado.atleta.id == evento.organizador.id}">
                                        <span class="icon text-right">
                                            <button class="btn btn-link"
												data-toggle="modal" data-target="#addParticipante">
                                            <i class="fa fa-plus"></i>
											</button>
											
										</span>
                                    </c:if>
                                </h4>
                                <ul class="list-group mb-3">
                                    <c:forEach
										items="${evento.participantes}" var="participante">
                                        <input type="hidden"
											value="${participante.id}" name="atleta.id" />
                                        <li
											class="list-group-item justify-content-between"
											style="padding-left: 0px;">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <img
														class="img-circle"
														src="${ctx}/resources/imagens/icons_map/futebol.png"
														width="60px" height="60px" />
                                                </div>
                                                <div class="col-md-7">
                                                    <a href="">
                                                        <h4>${participante.nome}</h4>
                                                    </a>
                                                    <span
														class="badge badge-success badge-pill">Pendente</span>
                                                </div>
                                                <div class="col-md-2"
													style="margin-left: 0px; padding-left: 0px">
                                                    <button
														class="btn btn-link">
														<i class="fa fa-envelope"></i>
													</button>
													<c:if test="${usuarioLogado.isAdmin() or usuarioLogado.retornarUsuario() == evento.organizador.id}">
                                                    <form
														action="${ctx}/evento">
                                                    <a href="${linkTo[EventoController].deletarAtleta}?id=${evento.id}&login=${participante.login}" class="
															btnbtn-primary">remover</a>
                                                    </form>
                                                    </c:if>
                                                    
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <button href="" class="btn btn-default"
					onclick="history.back(1)">Voltar</button>
            </div>

            <!-- Large modal -->
            <div id="addParticipante" class="modal fade" role="dialog">
                <div class="modal-dialog">
<%--                    <form action="${linkTo[EventoController].convidarAtleta}?id=${evento.id}&login=${atleta.login}" method="post">--%>
                        <input type="hidden" name="id"
						value="${evento.id}" />
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
                            <h4 class="modal-title">Adicionar Atleta</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="login_participante">Login do Atleta:</label>
                                <input type="text" name="login"
									class="form-control" required value="" id="login_participante"
									placeholder="Digite o login do Atleta" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button"
								class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <a id="btnConvidar" href="#"
								url-convite="${linkTo[EventoController].convidarAtleta}?id=${evento.id}&login="
								class="btn btn-primary">Convidar</a>
                        </div>
                    </div>
					<!-- /.modal-content -->
<%--                    </form>--%>
                </div>
				<!-- /.modal-dialog -->
            </div>
            
             <!-- Large modal -->
            <div id="addAlerta" class="modal fade" role="dialog">
                <div class="modal-dialog">
<%--                    <form action="${linkTo[EventoController].convidarAtleta}?id=${evento.id}&login=${atleta.login}" method="post">--%>
                        <input type="hidden" name="id"
						value="${evento.id}" />
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
                            <h4 class="modal-title">Adicionar Atleta</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="login_participante">Login do Atleta:</label>
                                <input type="text" name="login"
									class="form-control" required value="" id="login_participanteAlerta"
									placeholder="Digite o login do Atleta" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button"
								class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <a id="btnAlerta" href="#"
								url-alerta="${linkTo[EventoController].convidarAtleta}?id=${evento.id}&login="
								class="btn btn-primary">Convidar</a>
                        </div>
                    </div>
					<!-- /.modal-content -->
<%--                    </form>--%>
                </div>
				<!-- /.modal-dialog -->
            </div>
            
            
            </form>
        </div>
    </jsp:body>
</tags:layoutSidebar>