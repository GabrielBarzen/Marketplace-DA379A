$(document).ready(function(){
    $("#header").load("/header.html");
});



function loginButtonPressed() {
    let usernameInput = document.getElementById("usernameInput");
    let passwordInput = document.getElementById("passwordInput");
    loginUser(usernameInput.value, passwordInput.value);
}

function loginUser(username, password) {
    console.log("logging in : " + username + " with password : " + password);
    $.ajax({url: "/login?username="+username+"&password=" + password,
        method: "POST",
        headers: {"Accept": "application/json"},
        });
}