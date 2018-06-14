var x = new XMLHttpRequest();

window.onload = function (){
    loadPunt();
}

function loadPunt(){
    x.open("GET","Controller?action=GetPunten",true);
    x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    x.onreadystatechange = getPunten;
    x.send();
}

function addNewPoints(){
    var naam = document.getElementById("naam-input");
    var punt = document.getElementById("punt-input");
    var vak = document.getElementById("vak-input");

    var req = "naam=" + encodeURIComponent(naam.value) + "&punt=" + encodeURIComponent(punt.value) + "&vak=" + encodeURIComponent(vak.value);
    x.open("POST","Controller?action=AddPunt",true);
    x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    x.onreadystatechange = getPunten;
    x.send(req);
}

function getPunten(){
    if(x.status == 200){
        if(x.readyState == 4){
            if(document.getElementById("punten-table") != null){
                var tableb = document.getElementById("punten-table");
                tableb.innerHTML = "";
                for (var i = 0; i < JSON.parse(x.responseText).length; i++){
                    var obj = JSON.parse(x.responseText)[i];
                    var row = tableb.insertRow(0);

                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cel2 = row.insertCell(2);

                    cell1.innerHTML = obj['naam'];
                    cell2.innerHTML = obj['vak'];
                    cel2.innerHTML = obj['punt'];

                }
                setInterval("loadPunt()", 2000);
            }
        }
    }
}