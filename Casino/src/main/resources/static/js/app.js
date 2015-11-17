/**
 * Created by Apc1 on 09/11/2015.
 */

var stompClient = null;
var authenticated = false;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(message){
            showMessage(JSON.parse(message.body).text);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showMessage(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}

function setAuthenticateConnected(authenticateConnected){
    document.getElementById('authenticateConnect').disabled = authenticateConnected;
    document.getElementById('authenticateDisconnect').disabled = !authenticateConnected;
}

function authenticateConnect() {
    disconnect();
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(message){
            showMessage(JSON.parse(message.body).text);
        });

        stompClient.subscribe('/user/queue/big.wins', function (message) {
            showMessage(JSON.parse(message.body).text);
        });
    });
}

function authenticateDisconnect() {
    setAuthenticateConnected(false);
    console.log("Logged Out");
}

jQuery(document).ready(function ($) {
    $('#loginForm').submit(function (event) {
        event.preventDefault();
        var data = 'username=' + $('#username').val() + "&password=" + $('#password').val();
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/login'
        }).done(function(data, textStatus, jqXHR) {
//                    var preLoginInfo = JSON.parse($.cookie('dashboard.pre.login.request'));
//                    window.location = preLoginInfo.url;
            authenticated = true;
            authenticateConnect();
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert('Booh! Wrong credentials, try again!');
        });
    });
});
