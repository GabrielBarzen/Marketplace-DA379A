let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    getPorperties();
});

function submitButton() {
    let productName = document.getElementById("productNameInput").value;
    let price = document.getElementById("priceInput").value;
    let dateOfMakeInput = document.getElementById("dateOfMakeInput").value;
    let dateOfMake = new Date(dateOfMakeInput);
    let type = document.getElementById("typeInput").value;
    let color = document.getElementById("colorInput").value;
    let condition = document.getElementById("conditionInput").value;
    $.ajax({url: "/sell/product?" +
            "seller=" + username +
            "&name=" + productName +
            "&price=" + price +
            "&dateOfMake=" + dateOfMake.getTime() +
            "&type=" + type +
            "&color=" + color +
            "&condition=" + condition,
        success: function(){
            window.location.assign("/marketplace.html");
        }

    });
}

function cancelButton() {
    window.location.assign("/marketplace.html");
}




function getPorperties() {
    $.ajax({url: "/sell/itemList", success: function(result){

            var json = JSON.parse(result);

            console.log(json.conditions[4]);

            parseListCondition(json.conditions);
            parseListColors(json.colors);
            parseListTypes(json.types);

            console.log(json.conditions)
            console.log(json.colors)
            console.log(json.types)

        }});
}

function parseListCondition(conditions) {
    for (var i = 0; i < conditions.length; i++){
        var option = document.createElement('option');
        option.value = conditions[i];
        option.innerHTML = conditions[i];
        document.getElementById('conditionInput').appendChild(option);
    }
}

function parseListColors(colors) {
    for (var i = 0; i < colors.length; i++){
        var option = document.createElement('option');
        option.value = colors[i];
        option.innerHTML = colors[i];
        document.getElementById('colorInput').appendChild(option);
    }
}

function parseListTypes(types) {
    for (var i = 0; i < types.length; i++){
        var option = document.createElement('option');
        option.value = types[i];
        option.innerHTML = types[i];
        document.getElementById('typeInput').appendChild(option);
    }
}
