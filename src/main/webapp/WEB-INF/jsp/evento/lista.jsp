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
        <script>
            $(document).ready(function () {
                $.fn.dataTable.moment('DD/MM/YYYY');

                $('.table').DataTable( {
                    pageLength:25,
                    "language":
                        {
                            "sEmptyTable": "Nenhum registro encontrado",
                            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                            "sInfoPostFix": "",
                            "sInfoThousands": ".",
                            "sLengthMenu": "_MENU_ resultados por página",
                            "sLoadingRecords": "Carregando...",
                            "sProcessing": "Processando...",
                            "sZeroRecords": "Nenhum registro encontrado",
                            "sSearch": "Pesquisar",
                            "oPaginate": {
                                "sNext": "Próximo",
                                "sPrevious": "Anterior",
                                "sFirst": "Primeiro",
                                "sLast": "Último"
                            },
                            "oAria": {
                                "sSortAscending": ": Ordenar colunas de forma ascendente",
                                "sSortDescending": ": Ordenar colunas de forma descendente"
                            }
                        }
                } );
            });
        </script>
    </jsp:attribute>

    <jsp:body>
        <div class="panel painel-sisint">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Todos os Eventos e Atividades</h2>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[EventoController].form}">Cadastrar</a>
                <div class="tabela-servicos">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Título</th>
                            <th>Tipo de <br>Atividade</th>
                            <th>Data do Evento</th>
                            <th>Horário <br> Inicial</th>
                            <th>Horário <br> Final</th>
                            <th>Num de<br>Vagas</th>
                            <th>Organizador</th>
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${eventos}" var="evento">
                            <tr>
                                <td>${evento.titulo}</td>
                                <td>${evento.tipoEsporte.nome}</td>
                                <td>${evento.dataInicio}</td>
                                <td>${evento.horaInicio}</td>
                                <td>${evento.horaFim}</td>
                                <td>${evento.numVagasMax}</td>
                                <td>${evento.organizador.nome}</td>
                                <td>
                                    <a title="Detalhar" href="${linkTo[EventoController].detalhar}?id=${evento.id}">
                                        <i class="fa fa-eye fa-lg" aria-hidden="true"></i></a>
                                    <c:if test="${atletaLogado.isAdmin() or atletaLogado.atleta.id == evento.organizador.id}">
                                        <a title="Remover" class="link-remover" href="#delete-modal"
                                           url-remover="${linkTo[EventoController].remover}?id=${evento.id}" data-toggle="modal">
                                            <i class="fa fa-trash fa-lg"></i></a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>

                        <!-- Modal REMOVER -->
                        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="modalLabel">Excluir Evento</h4>
                                    </div>
                                    <div class="modal-body">
                                        Deseja realmente excluir este evento?
                                    </div>
                                    <div class="modal-footer">
                                        <a href="" class="btn btn-primary btn-remover">Sim</a>
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
    </jsp:body>
</tags:layoutSidebar>
