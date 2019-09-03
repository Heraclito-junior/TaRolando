
// Funções para limpar datas de inicio e final do evento
function limparDataInicio() {
    console.log("aqui");
    $('#dataInicio_evento').val('');
}

function limparDataFinal() {
    $('#dataFinal_evento').val('');
}


$(document).ready( function () {

    var $timepickerInicio = $(this).find('.timePickerInicio');
    var $timepickerFim = $(this).find('.timePickerFim');

    // Métodos para gravar data após input perder o foco
    $('.timePickerInicio').blur( function () {
        $timepickerInicio.attr("value", $timepickerInicio.val());
    });

    $('.timePickerFim').blur( function () {
       $timepickerFim.attr("value", $timepickerFim.val());
    });

    // Método para realizar convite de Atleta
    $('#link_add_atleta').click( function () {
        var valorUrl = $(this).attr("url-remover");
        console.log(valorUrl);
        $('.btn-remover').attr("href", valorUrl);
    });
});