$(document).ready(function(){
    $("#header").load("header.html")
})

let username
let password
let email
let birthDate
let firstName
let lastName

function registerButtonPressed() {

    let usernameInput = document.getElementById('usernameInput').value;
    let passwordInput = document.getElementById('passwordInput').value;
    let emailInput = document.getElementById('emailInput').value;
    let birthDateInput = document.getElementById('birthDateInput').value;
    let firstNameInput = document.getElementById('firstNameInput').value;
    let lastNameInput = document.getElementById('lastNameInput').value;

    registerAccount(usernameInput, 
                    passwordInput,
                    emailInput,
                    birthDateInput,
                    firstNameInput,
                    lastNameInput);

}

function registerAccount(usernameInput, 
                        passwordInput,
                        emailInput,
                        birthDateInput,
                        firstNameInput,
                        lastNameInput) {

    console.log("reggar: " + usernameInput);

    let url = '/register?'  +
              'username='   + usernameInput  + '&' +
              'password='   + passwordInput  + '&' +
              'email='      + emailInput     + '&' +
              'birthdate='  + birthDateInput + '&' +
              'firstname='  + firstNameInput + '&' +
              'lastname='   + lastNameInput;

    $.ajax({url: url,
            method: "POST",
            success: loginSuccess,
            error: loginError
            });
}

function loginSuccess() {
    alert("DU ÄR NU REGGAD DITT SVIN")
    window.location.assign("/login.html");
}

function loginError() {
    alert('kunde inte skapa ett konto ::PPpPPPPppPPpp')
    window.location.assign("/registration.html");
}