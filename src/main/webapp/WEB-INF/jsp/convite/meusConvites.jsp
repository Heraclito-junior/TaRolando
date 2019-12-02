<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 05/10/2019
  Time: 04:34
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
        <script src="${ctx}/resources/js/convite/convite.js"></script>
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
                            "sSearch": "Pesquisar ",
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
                    <h1 class="page-header">Participação em Evento</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="panel-body" style="padding-top: 0px;">
<%--                <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[EsporteController].form}">Cadastrar</a>--%>
                <div class="tabela-servicos">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Organizador do Evento</th>
                            <th>Detalhar</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${convitesRecebidos}" var="convite">
                            <tr>
                                <td>${convite.id}</td>
                                <td>${convite.eventoAjudando.titulo}</td>
                                <td>
                                    <a href="${linkTo[AtletaController].perfil}?id=${convite.eventoAjudando.organizador.id}">
                                            ${convite.eventoAjudando.organizador.nome}
                                    </a>
                                </td>
                                <td>
                                    <a title="Detalhar" href="${linkTo[EventoController].detalhar}?id=${convite.eventoAjudando.id}">
                                        <i class="fa fa-eye fa-lg" aria-hidden="true"></i></a>
                                   
                                </td>
                            </tr>
                        </c:forEach>

                        

                        

                        </tbody>
                    </table>
                </div>
            </div>


    </jsp:body>
</tags:layoutSidebar>