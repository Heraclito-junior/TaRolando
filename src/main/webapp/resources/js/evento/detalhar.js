$(document).ready( function () {
    var urlLogin = $('#btnConvidar').attr('url-convite');
    var valueLogin;
    var urlAlerta=$('#btnAlerta').attr('url-alerta');
    var valueAlerta;
    $('#btnConvidar').click( function () {
        valueLogin = $('#login_participante').val();
        var urlConvite = urlLogin + valueLogin;
        console.log("login:" + valueLogin);
        $('#btnConvidar').attr('href', urlConvite);
    })
    
    $('#btnAlerta').click( function () {
    	valueAlerta = $('#login_participanteAlerta').val();
        var urlNovo = urlAlerta + valueAlerta;
        console.log("login:" + valueAlerta);
        $('#btnAlerta').attr('href', urlNovo);
    })
    
    
});


