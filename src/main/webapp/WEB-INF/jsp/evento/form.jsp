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
        <script src="${ctx}/resources/js/evento/evento.js"></script>
        <script src="${ctx}/resources/js/endereco/cep.js"></script>
        <script>
            var icon_geolocation = '${ctx}/resources/imagens/icons_map/you_here.png';
            var your_marker, markerEvento;
            var map, infoWindow;
            function initMap() {
                var natal = {lat: -5.8265678, lng:-35.2138971};
                map = new google.maps.Map(document.getElementById('map_canvas'), {
                    center: natal,
                    zoom: 14,
                    disableDoubleClickZoom: true
                });

                markerEvento = new google.maps.Marker({position: natal, map: map, draggable: true});
                infoWindow = new google.maps.InfoWindow;

                // Try HTML5 geolocation.
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        map.setCenter(pos);
                        your_marker = new google.maps.Marker({position: pos, map: map, icon: icon_geolocation});

                        your_marker.addListener('click', function () {
                            infoWindow.setContent('Sua Localização');
                            infoWindow.setPosition((this).getPosition());
                            infoWindow.open(map);
                        });
                    }, function() {
                        handleLocationError(true, infoWindow, map.getCenter());
                    });
                } else {
                    // Browser doesn't support Geolocation
                    handleLocationError(false, infoWindow, map.getCenter());
                }

                map.addListener('click', function(e) {
                    var pos = {
                        lat: e.latLng.lat(),
                        lng: e.latLng.lng()
                    };
                    markerEvento.setPosition(pos);
                    var geocoder = new google.maps.Geocoder;

                    var latitude = pos.lat;
                    var longitude = pos.lng;

                    $('#evento_lat').val(e.latLng.lat());
                    $('#evento_lng').val(e.latLng.lng());

                    console.log($('#evento_lat').val());
                    console.log($('#evento_lng').val());

                    document.getElementById('confirmAddress').addEventListener('click', function() {
                        console.log("e dentro do listener?");
                        geocodeLatLng(geocoder);
                    });

                });
            }

            function geocodeLatLng(geocoder) {

                var latlng = {lat: parseFloat($('#evento_lat').val()), lng: parseFloat($('#evento_lng').val())};
                geocoder.geocode({'location': latlng}, function(results, status) {
                    if (status === 'OK') {
                        if (results[0]) {
                            console.log("Aqui pai");
                            $('#localizacao').val(results[0].formatted_address);
                        } else {
                            window.alert('No results found');
                        }
                    } else {
                        window.alert('Geocoder failed due to: ' + status);
                    }
                });
            }

            function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                infoWindow.setPosition(pos);
                infoWindow.setContent(browserHasGeolocation ?
                    'Error: The Geolocation service failed.' :
                    'Error: Your browser doesn\'t support geolocation.');
                infoWindow.open(map);
            }
        </script>
		<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOUNrqormKT0ZCkQEivVp0N0G1eTo_Lg4&callback=initMap"></script>
        <%--<script src="https://maps.googleapis.com/maps/api/geocode?key=AIzaSyCl_ds22Kok23HlKR-DotiMymK3X8eypmI"></script>--%>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Novo Evento</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="panel painel-sisint">
            <div class="panel-body">
                <form id="formAtividade" action="${linkTo[EventoController].salvar}" method="post">
                    <input type="hidden" name="evento.id" value="${evento.id}">
                    <input id="evento_lat" type="hidden" name="evento.latitude" value="${evento.latitude}">
                    <input id="evento_lng" type="hidden" name="evento.longitude" value="${evento.longitude}">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="titulo-evento">Título </label>
                            <input id="titulo-evento" class="form-control" minlength="5" name="evento.titulo"
                                   type="text" required value="${evento.titulo}">
                        </div>

                        
                        <div class="form-group col-md-2">
                            <label for="num_vagas_min">Meta de Doações </label>
                            <input id="num_vagas_min" class="form-control" name="evento.metaDoacoes" min="0"
                                   type="number" value="${evento.metaDoacoes}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="num_vagas_max">Meta de Voluntários </label>
                            <input id="num_vagas_max" class="form-control" name="evento.metaVoluntarios" min="0"
                                   type="number" value="${evento.metaVoluntarios}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="horario_inicio">Horário de Início </label>
                            <input id="horario_inicio" class="form-control timePickerInicio" name="evento.horaInicio"
                                   type="time" value="${evento.horaInicio}" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="horario_fim">Horário do Fim </label>
                            <input id="horario_fim" class="form-control timePickerFim" name="evento.horaFim"
                                   type="time" value="${evento.horaFim}" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dataInicio_evento">Data de Início</label>
                            <button type="button" data-dismiss="modal" class="close">
                                <span onclick="limparDataInicio()">&times;</span>
                            </button>
                            <input type="text" class="form-control datePicker" id="dataInicio_evento"
                                   value="${evento.dataInicio}"
                                   placeholder="(Opcional)" readonly="readonly" name="evento.dataInicio"/>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dataFinal_evento">Data Final</label>
                            <button type="button" data-dismiss="modal" class="close">
                                <span onclick="limparDataFinal()">&times;</span>
                            </button>
                            <input type="text" class="form-control datePicker" id="dataFinal_evento"
                                   value="${evento.dataFim}"
                                   placeholder="(Opcional)" readonly="readonly" name="evento.dataFim"/>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="localizacao">Localização </label>
                            <div class="input-group">
                                <input id="localizacao" class="form-control" name="evento.localizacao.rua"
                                       type="text" value="${evento.localizacao.rua}">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" data-toggle="modal" data-target="#modalEndereco">Go!</button>
                              </span>
                            </div><!-- /input-group -->
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
                        <div class="form-group col-md-8">
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

                <!-- Large modal -->
                <div id="modalEndereco" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">Escolha uma posição no Mapa:  </h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12 modal_body_map">
                                        <div class="location-map" id="location-map">
                                            <div style="width: 100%; height: 400px;" id="map_canvas"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="confirmAddress" type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div>
            </div>
        </div>
    </jsp:body>
</tags:layoutSidebar>

