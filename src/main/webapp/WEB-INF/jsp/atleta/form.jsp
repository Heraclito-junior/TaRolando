<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layoutSidebar>
    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/typeahead/typeahead.bundle.js"></script>
        <script src="${ctx}/resources/js/init.js"></script>
        <script src="${ctx}/resources/js/endereco/cep.js"></script>
        <script>
            if ($(".datePicker").val()) {
                var data = moment($(".datePicker").val(), "YYYY-MM-DD").format("DD/MM/YYYY");
                $(".datePicker").val(data);
                console.log($(".datePicker").val());
            }
        </script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Registro de Atleta</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formAtividade" action="${linkTo[AtletaController].salvar}" method="post">
                    <input type="hidden" name="atleta.id" value="${atleta.id}">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="nome-atleta">Nome </label>
                            <input id="nome-atleta" class="form-control" minlength="5" name="atleta.nome"
                                   type="text" required value="${atleta.nome}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="sobrenome-atleta">Sobrenome </label>
                            <input id="sobrenome-atleta" class="form-control" minlength="5" name="atleta.sobrenome"
                                   type="text" required value="${atleta.sobrenome}">
                        </div>
                        <%--<div class="form-group col-md-4 text-center">--%>
                            <%--<label for="tipo_esporte">Tipo de Esporte </label>--%>
                            <%--<div style="padding: 0px 60px">--%>
                                <%--<a id="tipo_esporte" data-toggle="modal" href="#modalEsporte"--%>
                                        <%--class="form-control btn btn-primary">Escolher</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group col-md-4">
                            <label for="tipo_esporte">Esporte Preferido </label>
                            <select type="text" class="form-control" id="tipo_esporte" placeholder="Esporte Preferido"
                                    name="atleta.esportePreferido.id">
                                <option value=""></option>
                                <c:forEach items="${esportes}" var="t">
                                    <c:if test="${t.valor == atleta.esportePreferido.id}">
                                        <option value="${t.valor}" selected="true">${t.chave}</option>
                                    </c:if>
                                    <c:if test="${!(t.valor == atleta.esportePreferido.id)}">
                                        <option value="${t.valor}">${t.chave}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="login_atleta">Login </label>
                            <input id="login_atleta" class="form-control" minlength="5" name="atleta.login"
                                   type="text" required value="${atleta.login}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="senha_atleta">Senha </label>
                            <input id="senha_atleta" class="form-control" minlength="5" name="atleta.senha"
                                   type="password" required value="${atleta.senha}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="tipo_atleta">Tipo</label>
                            <select required class="form-control" id="tipo_atleta" name="atleta.tipoAtleta" type="text">
                                <option value=""></option>
                                <c:forEach items="${tipoAtleta}" var="tipo">
                                    <option value="${tipo.valor}">${tipo.chave}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="row" style="margin-left: 0px;">
                            <div class="col-md-12">
                                <div class="form-group col-md-3" style="padding-left: 0px;">
                                    <label for="cep_atleta">CEP </label>
                                    <div class="input-group">
                                        <input id="cep_atleta" class="form-control cep" name="atleta.endereco.cep"
                                               type="text" value="${atleta.endereco.cep}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" onclick="buscarEndereco()"><i class="glyphicon glyphicon-search"></i></button>
                                        </span>
                                    </div><!-- /input-group -->
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="rua_atleta">Rua </label>
                            <input id="rua_atleta" class="form-control rua" name="atleta.endereco.rua"
                                   type="text" value="${atleta.endereco.rua}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="numero_atleta">Número </label>
                            <input id="numero_atleta" class="form-control" name="atleta.endereco.numero"
                                   type="text" value="${atleta.endereco.numero}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fone_atleta">Teledone Celular </label>
                            <input id="fone_atleta" class="form-control" name="atleta.telefone"
                                   type="tel" value="${atleta.telefone}">
                        </div>
                        <div class="form-group col-md-2">
                            <button class="btn btn-primary" type="submit">Salvar</button>
                        </div>
                    </div>
                </form>
                <div id="modalEsporte" class="modal fade bs-example-modal-lg"role="dialog">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">Escolha um ou vários esportes de sua preferência</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-md-2">
                                            <c:forEach items="${esportes}" var="t">--%>
                                                <c:if test="${t.valor == atleta.esportePreferido.id}">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type=""> Futebol
                                                        </label>
                                                    </div>
                                                    <option value="${t.valor}" selected="true">${t.chave}</option>
                                                </c:if>
                                                <c:if test="${!(t.valor == atleta.esportePreferido.id)}">
                                                    <option value="${t.valor}">${t.chave}</option>
                                                </c:if>
                                            </c:forEach>
                                            <div class="checkbox">
                                                <label>
                                                    <input type=""> Futebol
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Check me out
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

