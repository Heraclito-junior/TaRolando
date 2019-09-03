$(document).ready( function () {
    var urlLogin = $('#btnConvidar').attr('url-convite');
    var valueLogin;

    $('#btnConvidar').click( function () {
        valueLogin = $('#login_participante').val();
        var urlConvite = urlLogin + valueLogin;
        console.log("login:" + valueLogin);
        $('#btnConvidar').attr('href', urlConvite);
    })
});


