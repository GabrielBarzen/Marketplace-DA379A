let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
});
function getPorperties() {
    $.ajax({url: "/sell/itemList", success: function(result){
            console.log(result)
        }});
}