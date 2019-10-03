$(document).ready( function () {

    var myJSON;

    console.log($('#chatID').val());

    $('#message').keypress(function(event) {
        var keycode = event.keyCode || event.which;
        if(keycode == '13') {
            if ($('#message').val() != "") {


                $('#btnChatSubmit').trigger('click');

                // var psconsole = $('#incomingMsgOutput');
                // var loginUser = $('#atletaLogadoID').val();
                // var date = new Date();
                // var msgDate = date.getDay()+"/"+date.getMonth()+"/"+date.getFullYear()+" "+date.getHours()+":"+date.getMinutes();
                // var message = $('#message').val();
                // var msg = loginUser + "-" + msgDate + "-" + message;
                // var idChat = $('#chatID').val();
                // console.log("mensagem: "+ msg);
                //
                // msg = idChat+"-"+loginUser+"-"+msgDate+"-"+message;
                //
                // sendMessage(msg);
                // psconsole.scrollTop(psconsole[0].scrollHeight - psconsole.height());
                // $('#message').val("");
            }
        }
    });

});

function sendMessage(msg) {



    // console.log(msg);
    // var ctxo = $('#ctx').val();
    // var url = ctxo + "chat/sendMessage";
    //
    // console.log(url);
    //
    // $.ajax({
    //     url: url,
    //     type: 'POST',
    //     data: msg
    // }).done(function (data) {
    //     console.log("OK ");
    //     console.log(data);
    //
    // }).fail(function (jqXHR, textStatus, errorThrown) {
    //     console.log("Erro");
    //     alert("O serviço não foi salvo!");
    // });

}