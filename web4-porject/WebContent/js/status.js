var xHRObject = new XMLHttpRequest();

window.onload = function(){
    xHRObject.open("GET","Controller?action=GetStatus",true);
    xHRObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xHRObject.onreadystatechange = getData;
    xHRObject.send();
}

function setNewStatus() {
    var status = document.getElementById("status-input");
    var st = "status=" + status.value;
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

    }
}