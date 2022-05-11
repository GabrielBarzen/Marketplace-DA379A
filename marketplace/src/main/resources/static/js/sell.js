let username;

$(document).ready(function(){
    $("#header").load("header.html");
    username = localStorage.getItem("username");
    getPorperties();
});

function getPorperties() {
    $.ajax({url: "/sell/itemList", success: function(result){
//            console.log(JSON.parse(result));
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
