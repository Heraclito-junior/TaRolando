<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagTaRolando" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<tags:layoutSidebar>
    <jsp:attribute name="cabecalho">

    </jsp:attribute>

	<jsp:attribute name="rodape">
<%--		<script src="${ctx}/resources/js/maps_google/maps.js"></script>--%>
		<%--		<script>--%>
		<%--            var url = "${ctx}/inicio/listaEventos";--%>
		<%--            var idEvento;--%>
		<%--            var marker;--%>
		<%--            var infoWindow;--%>
		<%--            var iconBase = '${ctx}/resources/imagens/icons_map/';--%>
		<%--            var map;--%>
		<%--			function myMap() {--%>
		<%--				console.log(iconBase);--%>
		<%--				var natal = {lat: -5.8265678, lng:-35.2138971};--%>
		<%--				map = new google.maps.Map(--%>
		<%--						document.getElementById('map'),--%>
		<%--						{ 	zoom: 12,--%>
		<%--							center: natal,--%>
		<%--							mapTypeId: 'roadmap',--%>
		<%--                            title: 'Uluru!'--%>
		<%--						});--%>
		<%--				infoWindow = new google.maps.InfoWindow({--%>

		<%--                });--%>

		<%--				$.ajax({--%>
		<%--					dataType: 'json',--%>
		<%--					type: 'GET',--%>
		<%--					url: url--%>
		<%--				}).done(function (data) {--%>
		<%--					data.forEach(function (dado) {--%>
		<%--                        idEvento = dado.id;--%>
		<%--                        var pos = {lat: parseFloat(dado.latitude), lng: parseFloat(dado.longitude)};--%>
		<%--                        var iconPath = iconBase + dado.tipoEsporte + '.png';--%>

		<%--                        marker = new google.maps.Marker(--%>
		<%--                            {   position: pos,--%>
		<%--                                map: map,--%>
		<%--                                icon: iconPath,--%>
		<%--                                animation: google.maps.Animation.DROP--%>
		<%--                            });--%>

		<%--                        // markers.push(marker);--%>

		<%--                        // for (var i = 0; i < markers.length; i++) {--%>
		<%--                        //     markers[i].addListener('click', function () {--%>
		<%--                        //         infoWindow.setContent("Esporte selecionado!");--%>
		<%--                        //     })--%>
		<%--                        // }--%>

		<%--                        marker.addListener('click', function () {--%>

		<%--                        })--%>

		<%--                        marker.addListener('mouseover', function () {--%>
		<%--                           toggleBounce();--%>
		<%--                           infoWindow.setContent("Esporte selecionado!");--%>
		<%--                           infoWindow.open(marker.position, marker);--%>
		<%--                        });--%>
		<%--                        marker.addListener('mouseout', function () {--%>
		<%--                            toggleStopBounce();--%>
		<%--                            infoWindow.close();--%>
		<%--                        });--%>

		<%--                    }).fail(function () {--%>

		<%--                    }).always(function () {--%>

		<%--                    });--%>
		<%--			    });--%>
		<%--            }--%>

		<%--            function toggleBounce() {--%>
		<%--                marker.setAnimation(google.maps.Animation.BOUNCE);--%>
		<%--            }--%>
		<%--            function toggleStopBounce() {--%>
		<%--                marker.setAnimation(null);--%>
		<%--            }--%>
		<%--		</script>--%>
		<%--		<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">--%>
		<%--		</script>--%>
		<%--		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOUNrqormKT0ZCkQEivVp0N0G1eTo_Lg4&callback=myMap"></script>--%>
    </jsp:attribute>
	<jsp:body>
		<div class="panel painel-sisint">
			<div class="panel-body">
				<c:forEach items="${espacos}" var="espaco">
					<div class="col-xs-4 col-md-2">
						<a href="${linkTo[EspacoController].visualizar}?id=${espaco.id}" class="thumbnail">
							<img src="${ctx}/resources/imagens/estabelecimentos/estabelecimento.png" alt="estabelecimento"
								 class="">
						</a>
						<div class="caption text-center">
							<h4>${espaco.nome}</h4>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</jsp:body>
</tags:layoutSidebar>
