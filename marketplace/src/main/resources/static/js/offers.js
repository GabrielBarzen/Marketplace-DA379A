let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
});