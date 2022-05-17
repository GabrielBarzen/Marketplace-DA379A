let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    showOffers();
});


let currentOffersInTable = [];
let numProducts = 0;

function showOffers() {
    $.ajax({url: "/offers/show?username=" + username, success: function(result){
            let unparsedJson = result;
            numProducts = 0;
            const jsonObject = JSON.parse(unparsedJson);

            currentOffersInTable = jsonObject;
            for (let i = 0; i < jsonObject.length; i++) {
                addOfferToTable(jsonObject[i]);
            }
        }});
}

let products = 0;

function addOfferToTable(jsonObject) {
    let offerColumns = [];
    offerColumns[0] = jsonObject.orderID;
    offerColumns[1] = jsonObject.productID;
    offerColumns[2] = jsonObject.productName;
    offerColumns[3] = jsonObject.price;
    offerColumns[4] = jsonObject.status;
    offerColumns[5] = jsonObject.buyerUsername;

    var offersTable = document.getElementById("offers-table");

    var htmlToAdd = "<tr>" + "<tbody id = temp>";
    for (let i = 0; i < offerColumns.length; i++) {
        htmlToAdd += "<td>"+offerColumns[i]+"</td>"
    }

    htmlToAdd +="<td><input type=\"button\" value=\"Accept offer\" onclick =\" + acceptOffer(" + products + ")\"></td>"
    htmlToAdd +="<td><input type=\"button\" value=\"Decline offer\" onclick =\" + declineOffer(" + products++ + ")\"></td>"
    htmlToAdd += "</tr>" + "</tbody>";


    offersTable.innerHTML += htmlToAdd;
}

function acceptOffer(productIDX) {
    var offerUUIDToAccept = currentOffersInTable[productIDX].orderID;

    $.ajax({url: "/offers/accept?orderid=" + offerUUIDToAccept,
            method: "PUT",
            cache: false,
            success: function (){
                window.location.reload()
            }
        });


}

function declineOffer(productIDX) {
    var offerUUIDToDecline = currentOffersInTable[productIDX].orderID;

    $.ajax({url: "/offers/decline?orderid=" + offerUUIDToDecline,
            method: "PUT",
            cache: false,
            success: function (){
                window.location.reload()
            }
        });


}
