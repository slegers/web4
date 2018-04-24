var xHRObject = new XMLHttpRequest();
var xHRObject2 = new XMLHttpRequest();

var webSocket;

window.onload = function (){
    loadStatus();
    loadFriends()
    webSocket = new WebSocket("ws://localhost:8082/socket");
}

function loadFriends(){
    xHRObject2.open("GET","Controller?action=GetFriends",true);
    xHRObject2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject2.onreadystatechange = getFriends;
    xHRObject2.send();
}

function loadStatus(){
    xHRObject.open("GET","Controller?action=GetStatus",true);
    xHRObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject.onreadystatechange = getData;
    xHRObject.send();
}

function addNewFriend(){
    var email = document.getElementById("email-input");
    var req = "email=" + encodeURIComponent(email.value);
    xHRObject2.open("POST","Controller?action=AddFriend",true);
    xHRObject2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject2.onreadystatechange = getFriends;
    xHRObject2.send(req);
}

function getFriends(){
    if(xHRObject2.status == 200){
        if(xHRObject2.readyState == 4){
            if(document.getElementById("friends-table") != null){
            var tableb = document.getElementById("friends-table");


            tableb.innerHTML = "";
           for (var i = 0; i < JSON.parse(xHRObject2.responseText).length; i++){
                var obj = JSON.parse(xHRObject2.responseText);[i];
                var row = tableb.insertRow(0);

                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);

                cell1.innerHTML = obj['firstName'] + " " + obj['lastName'];
                cell2.innerHTML = obj['status'];
            }
            setInterval("loadFriends()", 2000);
            }
        }
    }
}

function setNewStatus() {
    var status = document.getElementById("status-input");
    var st = "status=" + encodeURIComponent(status.value);
    xHRObject.open("POST","Controller?action=Status",true);
    xHRObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject.onreadystatechange = getData;
    xHRObject.send(st);
}

function getData(){
    if(xHRObject.status == 200 && xHRObject.readyState == 4){
        var response = xHRObject.responseText;
        if(document.getElementById("status-text") != null){
        var statusDiv = document.getElementById("status-text");
        var statusPar = statusDiv.childNodes[0];
        if (statusPar == null) {
            statusPar = document.createElement('p');
            statusPar.id = "quoteText";
            var statusText = document.createTextNode(response);
            statusPar.appendChild(statusText);
            statusDiv.appendChild(statusPar);
        }
        else {
            var quoteText = document.createTextNode(response);
            statusPar.removeChild(statusPar.childNodes[0]);
            statusPar.appendChild(quoteText);
        }
        setInterval("loadStatus()", 2000);
    }
    }
}


function openSocket(){
    send();
    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };
}

function send() {
    var naam = document.getElementById("naam").value;
    var rating = document.getElementById("rating").value;
    var comment = document.getElementById("comment").value;

    var text = ' { "name" : "' + naam +
        '" , "score" : '  + rating +
        ', "comment" : "' + comment + '" }';
    webSocket.send(text);
}

function closeSocket(){
    webSocket.close();

}
function writeResponse(text){
    var messages = document.getElementById("topic-comments");
    messages.innerHTML = messages.innerText + "<br/>" + text;
}


