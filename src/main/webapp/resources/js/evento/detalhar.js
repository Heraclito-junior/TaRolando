$(document).ready( function () {
    var urlLogin = $('#btnConvidar').attr('url-convite');
    var valueLogin;
    var urlAlerta=$('#btnAlerta').attr('url-alerta');
    var valueAlerta;
    var urlParticipar=$('#btnParticipar').attr('url-participar');
    var valorDoacao;
    var contribuicaoLaboral;
    var urlConvidar=$('#btnConvidar').attr('url-convidar');

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

    $('#btnConvidar').click( function () {
        var nomeConvidado = $('#nome_convidado').val();
        var emailConvidado = $('#email_convidado').val();
        var grupo = $('#grupoConvidado').val()
        var urlNovo = urlConvidar + nomeConvidado + "&email=" + emailConvidado + "&grupo=" + grupo;
        console.log(urlNovo);
        $('#btnConvidar').attr('href', urlNovo);
    });
    
    
});


