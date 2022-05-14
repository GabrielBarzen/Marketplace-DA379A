let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    showNotifications();
    getPorperties();
});


let currentNotificationsInTable = [];
let numNotifications = 0;

function showNotifications() {
    $.ajax({url: "/notifications/show?username=" + username, success: function(result){
            let unparsedJson = result;
            numProducts = 0;
            const jsonObject = JSON.parse(unparsedJson);

            currentOffersInTable = jsonObject;
            for (let i = 0; i < jsonObject.length; i++) {
                addNotificationToTable(jsonObject[i]);
            }
        }});
}

let notifications = 0;

function addNotificationToTable(jsonObject) {
    let notificationColumns = [];
    notificationColumns[0] = jsonObject.date;
    notificationColumns[1] = jsonObject.notificationMessage;

    var notificationsTable = document.getElementById("notifications-table");

    var htmlToAdd = "<tr>" + "<tbody id = temp>";
    for (let i = 0; i < notificationColumns.length; i++) {
        htmlToAdd += "<td>"+notificationColumns[i]+"</td>"
    }

    notificationsTable.innerHTML += htmlToAdd;
}

function getPorperties() {
    $.ajax({url: "/notifications/itemList", success: function(result){
//            console.log(JSON.parse(result));
            var json = JSON.parse(result);

            parseListTypes(json.types);

            console.log(json.types)

        }});
}

function parseListTypes(types) {
    for (var i = 0; i < types.length; i++){
        var option = document.createElement('option');
        option.value = types[i];
        option.innerHTML = types[i];
        document.getElementById('typeInput').appendChild(option);
    }
}
