
$(document).ready(function(){
    $("#start-chat").click(function(){
        $("#chat-field").show();
        $("#start-chat").hide();
    });
});

$(document).ready(function() {
    $("#send").click(function(){
        $message = document.getElementById("message").value;
        $userId = document.getElementById("userId").value;
        var o = '${userId}';
        $.post("Controller?action=SendMessage", {message:$message, id:$userId}, function(data) {
            var obj = JSON.parse(data);
            $('#chat-venster').append('<div class="container"> <p><b>' + obj["name"] + '</b>' + obj["message"] + '</p> <span class="time-right">' + obj['time'] +'</span> </div>');
        });
    });
});

$(document).ready(test = function() {
    getChatMessages();
});

function getChatMessages() {
    $userId = document.getElementById("userId").value;
    $.ajax({
        type: "GET",
        url: "/Controller?action=GetChatMessages&id=" + $userId,
        dataType: "text",
        success: function (json) {
            var obj = JSON.parse(json);
            $("#chat-venster").empty();
            for (var i = 0; i < Object.keys(obj).length; i++) {
                $('#chat-venster').append('<div class="container"> <p><b>' + obj[i]["person"] + ': </b>' + obj[i]["message"] + '</p> <span class="time-right">' + obj[i]['time'] + '</span> </div>');
            }
            setTimeout(getChatMessages, 2000);

        },
        error: function () {
            alert("An error occurred while getting a new quote ...");
        }
    });

}