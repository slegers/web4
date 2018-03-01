var xHRObject = new XMLHttpRequest();

function setNewStatus() {
    var status = document.getElementById("status-input");
    var st = "status=" + status.value;
    xHRObject.open("POST","Controller?action=Status",true);
    xHRObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //xHRObject.onreadystatechange = getData;
    xHRObject.send(st);
}