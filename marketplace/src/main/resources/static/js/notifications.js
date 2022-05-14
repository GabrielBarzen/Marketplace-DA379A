let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    showNotifications();
    console.log('lollll')
});


let currentNotificationsInTable = [];
let numNotifications = 0;

function showNotifications() {
    $.ajax({url: "/notifications/show?username=" + username, success: function(result){
            let unparsedJson = result;
            numProducts = 0;
            const jsonObject = JSON.parse(unparsedJson);

            console.log(jsonObject)
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

    // htmlToAdd +="<td><input type=\"button\" value=\"Accept offer\" onclick =\" + acceptOffer(" + products + ")\"></td>"
    // htmlToAdd +="<td><input type=\"button\" value=\"Decline offer\" onclick =\" + declineOffer(" + products++ + ")\"></td>"
    // htmlToAdd += "</tr>" + "</tbody>";


    notificationsTable.innerHTML += htmlToAdd;
}

// function acceptOffer(productIDX) {
//     var offerUUIDToAccept = currentOffersInTable[productIDX].orderID;

//     $.ajax({url: "/offers/accept?orderid=" + offerUUIDToAccept, 
//             method: "PUT"
//         });

//     window.location.reload()
// }

// function declineOffer(productIDX) {
//     var offerUUIDToDecline = currentOffersInTable[productIDX].orderID;

//     $.ajax({url: "/offers/decline?orderid=" + offerUUIDToDecline, 
//             method: "PUT"
//         });

//     window.location.reload()
// }
