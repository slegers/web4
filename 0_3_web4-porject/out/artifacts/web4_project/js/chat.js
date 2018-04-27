
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

$(document).ready(function(friend_id) {
   $userId = document.getElementById("userId").value;
    $.ajax({
        type: "GET",
        url: "/Controller?action=GetChatMessages&id="+$userId,
        dataType: "text",
        success: function(json){
            var obj = JSON.parse(json);
            alert(obj.length);
            //$("#chat-venster").remove();
            for (var i = 0; i < obj.length; i++){
                $('#chat-venster').append('<div class="container"> <p><b>' + obj["\""+i+ "\""]["person"] + '</b>' + obj["\""+i+ "\""]["message"] + '</p> <span class="time-right">' + obj["\""+i+ "\""]['time'] +'</span> </div>');
            }
        },
        error: function() {
            alert("An error occurred while getting a new quote ...");
        }
    });
});

