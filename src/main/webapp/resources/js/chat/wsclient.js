var webSocket  = null;
/**
 * Event handler for clicking on button "Connect"
 */
function onConnectClick() {
    openWSConnection();
}
/**
 * Event handler for clicking on button "Disconnect"
 */
function onDisconnectClick() {
    webSocket.close();
}
/**
 * Open a new WebSocket connection using the given parameters
 */
function openWSConnection() {
    var webSocketURL = null;
    /* webSocketURL = protocol + "://" + hostname + ":" + port + endpoint; */
    console.log($('#chatID').val());
    webSocketURL = "ws://localhost:8080/tarolando/websocket";
    console.log("openWSConnection::Connecting to: " + webSocketURL);
    try {
        webSocket = new WebSocket(webSocketURL);
        webSocket.onopen = function(openEvent) {
            console.log("WebSocket OPEN: " + openEvent.isTrusted);
            // document.getElementById("btnSend").disabled       = false;
            // document.getElementById("btnConnect").disabled    = true;
            // document.getElementById("btnDisconnect").disabled = false;
            // document.getElementById("message").disabled = false;
        };
        webSocket.onclose = function (closeEvent) {
            console.log("WebSocket CLOSE: " + JSON.stringify(closeEvent, null, 4));
            // document.getElementById("btnSend").disabled       = true;
            // document.getElementById("btnConnect").disabled    = false;
            // document.getElementById("btnDisconnect").disabled = true;
        };
        webSocket.onerror = function (errorEvent) {
            console.log("WebSocket ERROR: " + JSON.stringify(errorEvent, null, 4));
        };
        webSocket.onmessage = function (messageEvent) {
            console.log("origin:" + messageEvent.origin);
            console.log(messageEvent);

            var msgArray = messageEvent.data.split("-", 5);
            var username = msgArray[2];
            var msgDate = msgArray[3];
            var finalMsg = msgArray[4];

            var spanContainer = "";
            var spanTime = "";
            var textSide = "";
            if (username == ($('#atletaLogadoNome').val())){
                console.log("cinza");
                spanContainer = "turquose-chat";
                spanTime = "time-left";
                textSide = "right";

            } else {
                console.log("dark");
                spanContainer = "darker-chat";
                spanTime = "time-right";
                textSide = "left";
            }

            var wsMsg = messageEvent.data;
            console.log("WebSocket MESSAGE: " + wsMsg);
            if (wsMsg.indexOf("error") > 0) {
                $('#messages').append(
                    "<div class='form-group'>" +
                        "<div class='form-control "+spanContainer+"'>" +
                            "<span class='"+spanTime+"'>"+ msgDate +"</span>" +
                            "<span>"+ wsMsg.error +"</span>" +
                        "</div>" +
                    "</div>"
                );
            } else {
                $('#messages').append(
                    "<div class='form-group'>" +
                        "<span>"+ username +"</span>" +
                        "<div class='form-control "+spanContainer+"'>" +
                            // "<img src='#' alt='Avatar' style='width:100%'>" +
                            "<span class='"+spanTime+"'>"+ msgDate +"</span>" +
                            "<span class='"+textSide+"'>"+ finalMsg +"</span>" +
                        "</div>" +
                    "</div>"
                );
            }
        };
    } catch (exception) {
        console.error(exception);
    }
}
/**
 * Send a message to the WebSocket server
 */
function onSendClick() {
    if (webSocket.readyState != WebSocket.OPEN) {
        console.error("webSocket is not open: " + webSocket.readyState);
        return;
    }
    // var message[] = $('#message').val().split()
    var chatID = $('#chatID').val();
    var loginUserID = $('#atletaLogadoID').val();
    var loginUser = $('#atletaLogadoNome').val();
    var date = new Date();
    var day = "";
    var month = "";
    var hours = "";
    var minutes = "";
    if (date.getDay() < 10){
        day = "0"+date.getDay();
    } else {
       day = date.getDay();
    }
    if (date.getMonth() < 10) {
        month = "0"+date.getMonth();
    } else {
       month = date.getMonth();
    }
    if (date.getHours() < 10) {
        hours = "0"+date.getHours();
    } else {
       hours = date.getHours();
    }
    if (date.getMinutes() < 10) {
        minutes = "0"+date.getMinutes();
    } else {
       minutes = date.getMinutes();
    }

    var msgDate = day+"/"+month+"/"+date.getFullYear()+" "+hours+":"+minutes;
    var message = $('#message').val();
    var msg = chatID + "-" + loginUserID + "-" + loginUser + "-" + msgDate + "-" + message;
    console.log("mensagem: "+ msg);
    webSocket.send(msg);
}


$(document).ready( function () {
    onConnectClick();

    $('#message').keypress(function(event) {
        var keycode = event.keyCode || event.which;
        if(keycode == '13') {
            if ($('#message').val() != "") {
                onSendClick();
                $('#message').val("");
            }
        }
    });
});