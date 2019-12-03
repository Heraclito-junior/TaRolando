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
        <jsp:include page="/WEB-INF/jsp/errors/msgError.jsp" />
    
        <input type="hidden" name="evento.id" value="${evento.id}">
        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center">Detalhes do Evento</h4>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <div class="row">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="titulo-evento">Título </label>
                                    <input id="titulo-evento"
										class="form-control" minlength="5" name="evento.titulo"
										type="text" required value="${evento.titulo}" disabled>
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
                                    <label for="num_vagas_min">Meta de Doações </label>
                                    <input id="num_vagas_min"
										class="form-control" name="evento.numVagasMin" min="0"
										type="number" value="${evento.metaDoacoes}" disabled>
                                </div>
                                <div
									class="form-group col-md-2 col-md-offset-2">
                                    <label for="num_vagas_max">Meta de Voluntários </label>
                                    <input id="num_vagas_max"
										class="form-control" name="evento.numVagasMax" min="0"
										type="number" value="${evento.metaVoluntarios}" disabled>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="localizacao">Localização </label>
                                    <input id="localizacao"
										class="form-control" name="evento.localizacao" disabled
										type="text"
										value="${evento.localizacao.rua}, ${evento.localizacao.numero},  ${evento.localizacao.cep}">
                            </div>
                        </div>
                    </div>
                </div>

                <button href="" class="btn btn-default"
					onclick="history.back(1)">Voltar</button>
					
				</div>
				<div>
				<c:if test="${usuarioLogado.retornarUsuario() == evento.organizador.id}">
					<form id="formAtividade" action="${linkTo[EventoController].criarAlerta}" method="post">

					
					<input type="hidden" name="id" value="${evento.id}" />
					
					
					<div class="form-group col-md-4">
                            <label for="login_participante">Mensagem:</label>
                                <input type="text" name="login"
							class="form-control" required value=""
							id="login_participanteAlerta"
							placeholder="Digite o login do Atleta" />
                        </div>
                        <div class="form-group col-md-4">
                        <label for="login_participante">  </label>
                	<button class="btn btn-primary" type="submit">Mandar Alerta</button>
                </div>
                                   
                                   
                    
                     
					</form>
					</c:if>
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
                            <h4 class="modal-title">Participar de Evento</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="valor_doacao">Valor de doação:</label>
                                <input type="text" name="valor"
									class="form-control" required value="" id="valor_doacao"
									placeholder="Digite aqui o valor a ser doado" />
                            </div>
                            <div class="form-group">
                                <label for="contribuicao_laboral">Contribuição laboral:</label>
                                <input type="text" name="laboral"
									class="form-control" required value="" id="contribuicao_laboral"
									placeholder="Descreva seu tipo de ajuda" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button"
								class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <a id="btnParticipar" href="#"
								url-participar="${linkTo[ConviteController].participar}?id=${evento.id}&login=${usuarioLogado.usuario.login}&valor="
								class="btn btn-primary">Participar</a>
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
                            <h4 class="modal-title">Adicionar Atleta2</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="login_participanteAlerta">Login do Atletasss:</label>
                                <input type="text" name="login"
									class="form-control" required value=""
									id="login_participanteAlerta"
									placeholder="Digite o login do Atleta" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button"
								class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <a id="btnAlerta" href="#"
								url-alerta="${linkTo[EventoController].criarAlerta}?id=${evento.id}&login="
								class="btn btn-primary">Convidar</a>
                        </div>
                    </div>
					<!-- /.modal-content -->
<%--                    </form>--%>
                </div>
				<!-- /.modal-dialog -->
            </div>
            
            
        </div>
    </jsp:body>
</tags:layoutSidebar>