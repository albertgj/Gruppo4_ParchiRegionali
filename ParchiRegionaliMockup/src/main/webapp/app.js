var APP = {
    pressioneTasto: function () {
        var par1 = $("#cognome").val();
        var jsPar = 'nome=' + par1;

        $.ajax({
            url: "/parchiregionali/findbyname.htm",
            method: "GET",
            contentType: "application/json;charset=UTF-8",
            accepts: {json: "application/json,text/javascript"},
            data: jsPar,
            cache: false,
            timeout: 100000,
            success: function (data, textStatus, jqXHR) {
                var obj = $.parseJSON(data);

                var s = "";

                $.each(obj, function (i, item) {
                    s += item.id + " " + item.nome + " " + item.parco.nomeParco + " " + item.specie.nomeSpecie + " " + item.specie.ordineAppartenenza.descrizione + '<br>';
                });

                $("#result").html(s);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus.toString());
            }
        });
    },
    onClick: function () {
        $("#btn").on('click', APP.pressioneTasto);
    },
    populateTable: function () {
        $.ajax({
            url: "/parchiregionali/findanimali.htm",
            method: "GET",
            contentType: "application/json;charset=UTF-8",
            accepts: {json: "application/json,text/javascript"},
            cache: false,
            timeout: 100000,
            success: function (data) {
                var obj = JSON.parse(data);
                var trHTML = "<tbody>";

                $("tr:has(td)").remove();
                $.each(obj, function (i, item) {
                    trHTML += '<tr><td>' + i + '</td><td>' + item.nome + '</td><td>' + item.parco.nomeParco + '</td><td>' + item.specie.nomeSpecie + '</td><td>' + item.specie.ordineAppartenenza.descrizione + '</td></tr>';
                });
                trHTML += "</tbody>";
                $('#animaliTable').append(trHTML);

            }
        });
    }
};


$(document).ready(function () {
    APP.onClick();
    APP.populateTable();
});

