$(document).ready( function () {

    var urlEventoIntegrar = $('.link-integrar').attr("url-integrar");
    var valueEventoId;
    var valueUrl;

    $('#evento_reservaId').change( function () {
        valueEventoId = $('#evento_reservaId').val();
        var urlIntegracao = urlEventoIntegrar + valueEventoId;
        // console.log("login:" + valueEventoId);
        $('#btn-integrar').attr('href', urlIntegracao);
    });

    $('.link-desintegrar').click( function () {
        valueUrl = $(this).attr('url-desintegrar');
        // console.log(valueUrl);
        $('#btn-desintegrar').attr('href', valueUrl);
    });

});