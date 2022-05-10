let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    getPorperties();
});

function getPorperties() {
    $.ajax({url: "/sell/itemList", success: function(result){
            console.log(JSON.parse(result));

        }});
}