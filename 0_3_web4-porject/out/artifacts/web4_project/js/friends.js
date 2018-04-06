var xHRObject = new XMLHttpRequest();
var xHRObject2 = new XMLHttpRequest();
window.onload = function (){
    loadStatus();
    loadFriends()
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
    var req = "email=" +encodeURIComponent(email.value);
    xHRObject2.open("POST","Controller?action=AddFriend",true);
    xHRObject2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject2.onreadystatechange = getFriends;
    xHRObject2.send(req);
}

function getFriends(){
    if(xHRObject2.status == 200){
        if(xHRObject2.readyState == 4){
            var serverResponse = JSON.parse(xHRObject2.responseText);
            var tableb = document.getElementById("friends-table");
            tableb.innerHTML = "";
           for (var i = 0; i < serverResponse.length; i++){
                var obj = serverResponse[i];
                var row = tableb.insertRow(0);

                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);

                cell1.innerHTML = obj['firstName'] + " " + obj['lastName'];
                cell2.innerHTML = obj['status'];
            }
        }
    }
    setTimeout("loadFriends()", 2000);
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
        setTimeout("loadStatus()", 1000);

    }
}