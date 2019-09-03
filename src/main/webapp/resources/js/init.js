/**
 * Created by jotape 07/12/2018
 */

$(document).ready(function () {

    // Transforma o fomrato de DATAS
    $(".datePicker").datepicker({
        format: "dd/mm/yyyy"
    });

    // Recebe uma data e transforma ela para o modo brasileiro
    $(".date-column").each(function () {
        var data =  $(this).text();
        data = moment(data, 'YYYY-MM-DD').format('DD/MM/YYYY');
        $(this).text(data);
    });

    // Remoção do tipo de objeto escolhido ao clicar em botão REMOVER
    $('.link-remover').click( function () {
        var valorUrl = $(this).attr("url-remover");
        console.log(valorUrl);
        $('.btn-remover').attr("href", valorUrl);
    });

    $('.alert').fadeOut(7000);
});





