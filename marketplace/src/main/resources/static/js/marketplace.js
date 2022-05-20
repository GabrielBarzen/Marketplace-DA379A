
let url = "http://localhost:8080";

$(document).ready(function(){
    $("#header").load("header.html");
    refreshProducts();
    getProperties();
});

let currentProducts = [];
let numProducts = 0;
let productObject;

function refreshProducts() {
    $.ajax({url: url + "/products",
            success: function(result){
            let unparsedJson = result;
            numProducts = 0;
            const jsonObject = JSON.parse(unparsedJson);
            productObject = jsonObject;
            console.log(jsonObject);
            currentProducts = jsonObject;
            for (let i = 0; i < jsonObject.length; i++) {
                addProductToProductTable(jsonObject[i]);
                console.log(jsonObject[i])
            }
        },
            error: function () {
                window.alert("Cannot buy own product");
            }
    });
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

function getProperties() {
    $.ajax({url: "/sell/itemList", success: function(result){

            var json = JSON.parse(result);

            console.log(json.conditions[4]);

            parseListCondition(json.conditions);
            parseListTypes(json.types);

            console.log(json.conditions)
            console.log(json.colors)
            console.log(json.types)
            document.getElementById("priceMax").value = 99999;
            document.getElementById("priceMin").value = 0;

        }});
}

function parseListCondition(conditions) {
    for (var i = 0; i < conditions.length; i++){
        var option = document.createElement('option');
        option.value = conditions[i];
        option.innerHTML = conditions[i];
        document.getElementById('conditionInput').appendChild(option);
    }
    var option = document.createElement('option');
    option.value = "None";
    option.innerHTML = "None";
    document.getElementById("conditionInput").appendChild(option)
    document.getElementById("conditionInput").value = "None";
}

function parseListTypes(types) {
    for (var i = 0; i < types.length; i++){
        var option = document.createElement('option');
        option.value = types[i];
        option.innerHTML = types[i];
        document.getElementById('typeInput').appendChild(option);

    }
    var option = document.createElement('option');
    option.value = "None";
    option.innerHTML = "None";
    document.getElementById("typeInput").appendChild(option)
    document.getElementById("typeInput").value = "None";
}

function addItemToCart(productIDX) {
    console.log("buying : " + currentProducts[productIDX].id);
    let currentUUIDToBuy = currentProducts[productIDX].id;
    $.ajax({url: "/products/buy?productID=" + currentUUIDToBuy + "&username="+localStorage.getItem("username"), success: function(result){
        },
        error: function () {
            window.alert("Could not buy own product");
        }});
}

function applyFilter() {

    $("#products tbody tr").remove();
    let chosenType = document.getElementById("typeInput").value;
    let chosenCondition = document.getElementById("conditionInput").value;
    let chosenPriceMax = document.getElementById("priceMax").value;
    let chosenPriceMin = document.getElementById("priceMin").value;

    for (let i = 0; i < productObject.length; i++) {
        if(productObject[i].type === chosenType || chosenType === "None") {
            if(productObject[i].condition === chosenCondition || chosenCondition === "None") {
                if (productObject[i].price <= chosenPriceMax && productObject[i].price >= chosenPriceMin) {
                    addProductToProductTable(productObject[i]);
                    console.log(productObject[i])
                }
            }
        }
    }
}