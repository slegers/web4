
$(document).ready(function(){
    $("#start-chat").click(function(){
        $("#chat-field").show();
        $("#start-chat").hide();
    });
});

$(document).ready(function() {
    $("#send").click(function(){
        $message = document.getElementById("message").value;
        $.post("Controller?action=SendMessage", {message:$message}, function(data) {
            var obj = JSON.parse(data);
            $('#chat-venster').append('<div class="container"> <p>' + obj["message"] + '</p> <span class="time-right">' + obj['time'] +'</span> </div>');
        });
    });
});

