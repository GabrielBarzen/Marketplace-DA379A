
let url = "http://localhost:8080";

$(document).ready(function(){
    $("#header").load("header.html");
    refreshProducts();
});

let currentProducts = [];
let numProducts = 0;

function refreshProducts() {
    $.ajax({url: url + "/products", success: function(result){
            let unparsedJson = result;
            numProducts = 0;
            const jsonObject = JSON.parse(unparsedJson);
            console.log(jsonObject);
            currentProducts = jsonObject;
            for (let i = 0; i < jsonObject.length; i++) {
                addProductToProductTable(jsonObject[i]);
                console.log(jsonObject[i])
            }
        }});
}

function addProductToProductTable(jsonObject) {
    let productAttributes = [];
    productAttributes[0] = jsonObject.id;
    productAttributes[1] = jsonObject.name;
    productAttributes[2] = jsonObject.price;
    productAttributes[3] = jsonObject.date;
    productAttributes[4] = jsonObject.type;
    productAttributes[5] = jsonObject.color;
    productAttributes[6] = jsonObject.condition;
    productAttributes[7] = jsonObject.status;
    productAttributes[8] = jsonObject.seller;

    var productsTable = document.getElementById("products");

    var htmlString = "<tr>" +
        "<tbody id = temp>";
    for (let i = 0; i < productAttributes.length; i++) {
        htmlString += "<td>"+productAttributes[i]+"</td>"
    }
    console.log(productAttributes[0]);
    htmlString +="<td><input type=\"button\" value=\"add to cart\" onclick=\"addItemToCart("+numProducts++ +")\"></td>"
    htmlString += "</tr>" +
        "</tbody>";

    productsTable.innerHTML += htmlString;


}

function addItemToCart(productIDX) {
    console.log("buying : " + currentProducts[productIDX].id);
    let currentUUIDToBuy = currentProducts[productIDX].id;
    $.ajax({url: "/products/buy?productID=" + currentUUIDToBuy + "&username="+localStorage.getItem("username"), success: function(result){
        }});
}