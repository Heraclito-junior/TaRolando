$(document).ready( function () {
    var urlLogin = $('#btnConvidar').attr('url-convite');
    var valueLogin;
    var urlAlerta=$('#btnAlerta').attr('url-alerta');
    var valueAlerta;
    var urlParticipar=$('#btnParticipar').attr('url-participar');
    var valorDoacao;
    var contribuicaoLaboral;

    $('#btnConvidar').click( function () {
        valueLogin = $('#login_participante').val();
        var urlConvite = urlLogin + valueLogin;
        console.log("login:" + valueLogin);
        $('#btnConvidar').attr('href', urlConvite);
        console.log(urlConvite);
    });
    
    $('#btnAlerta').click( function () {
    	valueAlerta = $('#login_participanteAlerta').val();
        var urlNovo = urlAlerta + valueAlerta;
        console.log(urlNovo);
        $('#btnAlerta').attr('href', urlNovo);
    });
    
    $('#btnParticipar').click( function () {
    	valorDoacao = $('#valor_doacao').val();
    	contribuicaoLaboral = $('#contribuicao_laboral').val();
        var urlNovo = urlParticipar + valorDoacao + "&contribuicaoLaboral=" + contribuicaoLaboral;
        console.log(urlNovo);
        $('#btnParticipar').attr('href', urlNovo);
    });
    
    
});


