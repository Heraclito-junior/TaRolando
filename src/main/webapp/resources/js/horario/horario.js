$(document).ready( function () {

    $('.link-reservar').click( function () {
        var valorUrl = $(this).attr("url-reservar");
        console.log(valorUrl);
        $('.btnReservar').attr("href", valorUrl);
    });
});