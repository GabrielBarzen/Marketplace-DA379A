
let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    updateCart();
});

function updateCart() {

    $.ajax({url: "/cart/show?username="+localStorage.getItem("username"), success: function(result) {
            console.log(JSON.parse(result));
            let cart = JSON.parse(result);
            console.log(cart);
            if (cart.id != undefined) {
                listCart(cart);
            }
        }});
}

function listCart(cart) {
    let cartValues = [];
    currentCart = cart.id;
    cartValues[0] = cart.id;
    cartValues[1] = cart.name;
    cartValues[2] = cart.price;
    cartValues[3] = cart.date;
    cartValues[4] = cart.status;
    cartValues[5] = cart.product;
    cartValues[6] = cart.dateOfMake;
    cartValues[7] = cart.type;
    cartValues[8] = cart.color;
    cartValues[9] = cart.condition;
    cartValues[10] = cart.productStatus;
    cartValues[11] = cart.seller;

    let cartTable = document.getElementById("cartTable");

    let htmlString = "<tr>" +
        "<tbody id=temp>";
    for (let i = 0; i < cartValues.length; i++) {
        htmlString += "<td>"+cartValues[i]+"</td>"
    }
    console.log(cartValues[0]);
    htmlString +="<td><input type=\"button\" value=\"Remove from cart\" onclick='removeCartItem()'></td>"
    htmlString +="<td><input type=\"button\" value=\"Buy\" onclick = 'checkOutCart()'></td>"
    htmlString += "</tr>" +
        "</tbody>";

    cartTable.innerHTML += htmlString;
}

let currentCart;

function removeCartItem() {
    console.log("Removing cart " + currentCart)
    $.ajax({url: "/cart/remove?uuid="+currentCart, success: function(result){
            document.getElementById("temp").innerHTML = "";
            location.reload();
        }});


}
function checkOutCart() {
    console.log("Checking cart " + currentCart)
    $.ajax({url: "/cart/buy?uuid="+currentCart , success: function(result){
            document.getElementById("temp").innerHTML = "";
            location.reload();
        }});
}

