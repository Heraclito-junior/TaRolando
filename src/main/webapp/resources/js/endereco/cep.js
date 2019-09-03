function buscarEndereco() {
    var cep = $('.cep').val();
    console.log(cep);
    $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep },
        function(result){
            if( result.status!=1 ){
                console.log($('.rua').val());
                alert(result.message || "Houve um erro desconhecido");
                return;
            }

            $('.rua').val(result.address);
            // $('input#bairro_usuario').val(result.district);
            // $('#cidade_usuario').val(result.city);
            // $('#estado_usuario').val(result.state);
            console.log($('.rua').val());
        });
}

$(document).ready( function () {

});