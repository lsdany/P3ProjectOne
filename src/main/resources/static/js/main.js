'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var counterArea = document.querySelector("#counterArea");
var cardArea = document.querySelector("#cardArea");

var stompClient = null;
var username = null;


var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server and create deck
    stompClient.send("/app/game.add",
        {},
        JSON.stringify({sender: username, type: 'JOINING'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

//esta es la funcion que solicita la carta
function sendMessage(event) {



    //var messageContent = messageInput.value.trim();

    if(stompClient) {
        var chatMessage = {
            sender: username,
            //content: messageInput.value,
            content: 'CARTA',
            //turno: playerTurn,
            type: 'IN_CHAT'
        };

        stompClient.send("/app/game.send", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {

    // var elementos = counterArea.getElementsByTagName('label');
    // console.log("Elementos: "+elementos.);
    //counterArea.removeAttribute('id');
    //counterArea.getC



    var message = JSON.parse(payload.body);

    console.log("Mensajes obtenido" + message);

    var messageElement = document.createElement('li');
    var counterLabel = document.createElement('label');
    counterLabel.setAttribute('id','countLabel');

    var imageElement = document.createElement('img');
    imageElement.setAttribute('id', 'cardImg');
    imageElement.setAttribute('src','images/1R.jpg');
    imageElement.setAttribute('width', '163');
    imageElement.setAttribute('height', '208');


    if(message.type === 'JOINING') {

        //uniendose al juego

        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVING') {

        //dejando el juego

        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {

        //mensaje

        var elemToRemove = document.getElementById("countLabel");
        if(elemToRemove)
            counterArea.removeChild(elemToRemove);


        messageElement.classList.add('chat-message');
        counterLabel.classList.add('game-count');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);

        var countText = document.createTextNode(message.turno);
        counterLabel.appendChild(countText);


    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.cardPair.colour);
    textElement.appendChild(messageText);
    messageElement.appendChild(textElement);

    counterArea.appendChild(counterLabel);
    cardArea.appendChild(imageElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;

}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
