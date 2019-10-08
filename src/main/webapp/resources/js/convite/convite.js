$(document).ready( function () {

    // Remoção do tipo de objeto escolhido ao clicar em botão REMOVER
    $('.link-aceitar').click( function () {
        var valorUrl = $(this).attr("url-aceitar");
        console.log(valorUrl);
        $('.btn-aceitar').attr("href", valorUrl);
    });
});