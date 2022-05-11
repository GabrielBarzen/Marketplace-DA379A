$(document).ready(function(){
    changeLoggedInLabel();
});


function changeLoggedInLabel() {
    var username = localStorage.getItem('username');

    if (username != undefined) {
        document.getElementById('logged-in-label').innerHTML = 'Logged in as user: ' + username;
        document.getElementById('login-link').innerHTML = "Logout"
        document.getElementById('login-link').onclick = function() {
            logout();
        }

        $("#cart-link").show();
        $("#offers-link").show();
        $("#sell-link").show();

    } else {
        $("#cart-link").hide();
        $("#offers-link").hide();
        $("#sell-link").hide();
    }
}

function logout() {
    localStorage.clear();
    document.getElementById('logged-in-label').innerHTML = "Not logged in";
    document.getElementById('login-link').innerHTML = "Login";
    document.getElementById('login-link').onclick = function() {}

}
