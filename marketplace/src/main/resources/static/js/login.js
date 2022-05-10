$(document).ready(function(){
    $("#header").load("/header.html");
});

let username;

function loginButtonPressed() {
    let usernameInput = document.getElementById("usernameInput");
    let passwordInput = document.getElementById("passwordInput");
    loginUser(usernameInput.value, passwordInput.value);
}

function loginUser(usernameInput, passwordInput) {

    username = usernameInput;
    console.log("logging in : " + usernameInput + " with password : " + passwordInput);
    $.ajax({url: "/login?username="+usernameInput+"&password=" + passwordInput,
        method: "POST",
        success: loginSuccess,
        error: loginError
        });
}

function loginSuccess() {
    console.log("fuck you" + username)
    localStorage.setItem("username", username);
}

function loginError() {
    console.log("fuck me")
}