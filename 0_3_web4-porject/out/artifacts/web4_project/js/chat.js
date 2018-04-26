/*
$(document).ready(function(){
    $("#start-chat").click(function(){
        $("#chat-field").show();
        $("#start-chat").hide();
    });
});

$(document).ready(function() {
    $("#send").click(function(){
        $message = document.getElementById("message").value;
        $.post("Controller?action=Message", {message:$message}, function(data) {
            var newParagraph = $('<p />').text(data);
            $('#chat-venster').append(newParagraph);
        });
    });
});
*/
