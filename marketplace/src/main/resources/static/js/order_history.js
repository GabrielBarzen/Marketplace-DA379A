$(document).ready(function(){
    $("#header").load("/header.html");
    user = localStorage.getItem('username')
    updateOrderHistory(user,-1, -1);
});

const d = new Date();
let ms = d.getMilliseconds();

let user;

function searchByDateButton() {
    let startDateInput = document.getElementById("startDateInput").value;
    let endDateInput = document.getElementById("endDateInput").value;

    let startDate = new Date(startDateInput);

    let endDate = new Date(endDateInput);

    updateOrderHistory(user, startDate.getTime(), endDate.getTime())
}

function updateOrderHistory(username, startDate, endDate) {
    $("#temp").remove();
    $("#orderProductsTable tbody tr").remove();
    console.log(startDate);
    console.log(endDate);
    if(isNaN(startDate)) {
        startDate = -1;
    }
    if(isNaN(endDate)) {
        endDate = -1;
    }

    $.ajax({url: "/order-history/show?username="+username+"&beginDate="+startDate+"&endDate="+endDate+"", success: function(result){
            let unparsedJson = result;
            const jsonObject = JSON.parse(unparsedJson);
            console.log(jsonObject);
            for (let i = 0; i < jsonObject.length; i++) {
                addOrderAndProductToHistoryTable(jsonObject[i]);
            }

        }});
}


function addOrderAndProductToHistoryTable(orderAndProduct) {
    let tableValues = [];
    tableValues[0]  = orderAndProduct.id;
    tableValues[1]  = orderAndProduct.name;
    tableValues[2]  = orderAndProduct.price;
    tableValues[3]  = orderAndProduct.date;
    tableValues[4]  = orderAndProduct.status;
    tableValues[5]  = orderAndProduct.product;
    tableValues[6]  = orderAndProduct.dateOfMake;
    tableValues[7]  = orderAndProduct.type;
    tableValues[8]  = orderAndProduct.color;
    tableValues[9]  = orderAndProduct.condition;
    tableValues[10] = orderAndProduct.productStatus;
    tableValues[11] = orderAndProduct.seller;

    let orderAndProductTable = document.getElementById("orderProductsTable");

    let htmlString = "<tr>" +
        "<tbody id=temp>";
    for (let i = 0; i < tableValues.length; i++) {
        htmlString += "<td>"+tableValues[i]+"</td>"
    }
    console.log(tableValues[0]);

    htmlString += "</tr>" +
        "</tbody>";

    orderAndProductTable.innerHTML += htmlString;
}