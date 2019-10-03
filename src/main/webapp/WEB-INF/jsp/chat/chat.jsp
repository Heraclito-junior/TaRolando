<%--
  Created by IntelliJ IDEA.
  User: pique
  Date: 14/09/2019
  Time: 22:29
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
        <link href="${ctx}/resources/css/chat/geral.css" rel="stylesheet"/>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/dataTables/datatables.js"><c:out value=""/></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.html5.js"><c:out value=""/></script>
<%--        <script src="${ctx}/resources/js/chat/chat.js"></script>--%>
        <script src="${ctx}/resources/js/chat/wsclient.js"><c:out value=""/></script>
    </jsp:attribute>

    <jsp:body>
        <div class="panel painel-sisint">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Chat de ${atletaLogado.atleta.nome}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="panel-body" style="padding-top: 0px;">

                <div id="messages" style="width: 75%;">

                </div>

<%--                <div class="form-group">--%>
<%--                    <textarea id="incomingMsgOutput" class="form-control" rows="10" cols="20" disabled="disabled"></textarea>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <c:forEach items="${chat.mensagens}" var="mensagem">--%>
<%--                        <div class="container-chat">--%>
<%--                                &lt;%&ndash;                            <img src="#" alt="Avatar" style="width: 100%;">&ndash;%&gt;--%>
<%--                            <p>${mensagem.atleta.nome}</p>--%>
<%--                            <p>${mensagem.mensagem}</p>--%>
<%--                            <span class="time-right">${mensagem.dataEnvio}</span>--%>
<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                        <div class="container-chat">--%>
<%--                            <p></p>--%>
<%--                            <p></p>--%>
<%--                            <span class="time-right"></span>--%>
<%--                        </div>--%>
<%--                </div>--%>


<%--                <form id="formChat" action="${linkTo[ChatController].sendMessage}?idChat=${chat.id}" method="post">--%>
                    <input id="atletaLogadoID" type="hidden" value="${atletaLogado.atleta.id}" />
                    <input id="atletaLogadoNome" type="hidden" value="${atletaLogado.atleta.nome}" />
                    <input id="chatID" type="hidden" name="chat.id" value="${chat.id}" />
<%--                    <input id="chatID" type="hidden" name="mensagem.chat" value="${chat}" />--%>
<%--                    <input id="atletaLogado" type="hidden" name="chat.evento.id" value="${chat.evento.id}" />--%>
<%--                    <input id="atletaLogadoID" type="hidden" value="${atletaLogado.atleta.id}" />--%>



                <div class="form-group">
                    <input id="message" class="form-control" type="text"/>
                </div>
<%--                    <div class="form-group">--%>
<%--                        <input id="message" class="form-control" type="text" name="mensagem.mensagem" value="${mensagem.mensagem}"/>--%>
<%--                        <button id="btnChatSubmit" type="submit" hidden>OK</button>--%>
<%--                    </div>--%>
<%--                </form>--%>

            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

