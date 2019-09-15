<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagTaRolando"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<c:set var="sucesso" value="success" />
<c:set var="error" value="error" />
<c:set var="advertencia" value="advertencia" />

<c:if test="${not empty mensagem}">
	<c:if test="${sucesso == mensagem.categoria}">
		<div class="alert alert-success">
			<h3>${mensagem.texto}</h3>
		</div>
	</c:if>
	<c:if test="${error == mensagem.categoria}">
		<div class="alert alert-danger">
			<strong>Tente Novamente</strong>

			<h3>${mensagem.texto}</h3>
		</div>
	</c:if>
	<c:if test="${advertencia == mensagem.categoria}">
		<div class="alert alert-warning">
			<strong>Tente Novamente</strong>
			<h3><strong>${mensagem.texto}</strong></h3>
		</div>
	</c:if>
</c:if>
