var APP_PARCO = {
    saveParco: function () {

        var nP = $("#nomeParco").val();

        var parco = {
            nomeParco: nP
        };

        $.post({
            url: "/parchiregionalitest/parco/insertparco.htm",
            ContentType: "application/x-www-form-urlencoded; charset=UTF-8",
            Accepts: "application/json",
            data: parco,
            success: function (data) {
                var obj = JSON.parse(data);
                $("#risAggiuntaParco").html("Aggiunto: " + obj.nomeParco);
            },
            error: function () {
                $("#risAggiuntaParco").html("error");
            }
        });
    },
    onClick: function () {
        $("#salvaParco").on('click', APP_PARCO.saveParco);
    },
    populateDropdown: function () {
        $.ajax({
            url: "/parchiregionalitest/parco/findparchi.htm",
            method: "GET",
            ContentType: "application/json; charset=UTF-8",
            Accepts: "application/json; charset=UTF-8",
            cache: false,
            timeout: 100000,
            success: function (data) {
                var obj = JSON.parse(data);
                $.each(obj, function (key, value) {
                    $("#selezionaParco").append("<option value=" + value.nomeParco + ">" + value.nomeParco + "</option>");
                });
            },
            error: function () {
                alert("ERROR");
            }
        });
    },
    loginParco: function () {
        var nP = $('#selezionaParco :selected').text();
        document.cookie = "session=" + nP;
        location.href = 'visualizza.html';
    },
    onClickBtnParco: function () {
        $("#btnParco").on('click', APP_PARCO.loginParco);
    }
};

$(document).ready(function () {
    APP_PARCO.onClick();
    APP_PARCO.populateDropdown();
    APP_PARCO.onClickBtnParco();
});