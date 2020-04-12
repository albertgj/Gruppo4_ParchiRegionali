var APP = {
    populateAnimaliTable: function () {
        $.ajax({
            url: "/parchiregionalitest/findall.htm",
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
                    trHTML += '<tr><td>' + i + '</td><td>' + item.nome + '</td><td>' + item.parco.nomeParco + '</td><td>' + item.specie.nomeSpecie + '</td><td>' + item.specie.ordineAppartenenza.descrizione + "</td><td>" + "<button onclick='alert(`Non implementato`)'>Cancella</button>" + '</td></tr>';
                });
                trHTML += "</tbody>";
                $('#animaliTable').append(trHTML);

            },
            error: function () {
                $("#result").html("ERROR");
            }
        });
    },
    checkPage: function () {
        var href = document.location.href;
        var lastPathSegment = href.substr(href.lastIndexOf('/') + 1);
        if (lastPathSegment === 'animali.html') {
            APP.populateAnimaliTable();
        }
    },
    addAnimale: function () {
        var apv = $("#apv").val();
        var ls = $("#ls").val();
        var ncf = $("#ncf").val();
        var ncm = $("#numeroCuccioliMaschi").val();
        var nomeAnimale = $("#nomeAnimale").val();
        var nf = $("#nf").val();
        var nm = $("#nm").val();
        var re = $("#re").val();
        var np = $("#np").val();
        var ns = $("#ns").val();
        var desc = $("#desc").val();

        $("#formAnimali").submit(function (e) {
            e.preventDefault();
            $.ajax({
                url: "/parchiregionalitest/insertanimale.htm",
                type: "POST",
                dataType: 'x-www-form-urlencoded',
                headers: {
                    'Accept': 'application/json;application/x-www-form-urlencoded',
                    'Content-Type': 'application/json;application/x-www-form-urlencoded'
                },
                data: {annoPrimoAvvistamento: apv, livelloSalute: ls, nCuccioliFemmine: ncf, nCuccioliMaschi: ncm, nome: nomeAnimale, numeroFemmine: nf, numeroMaschi: nm, rischioEstinzione: re, parco: {nomeParco: np}, specie: {nomeSpecie: ns, ordineAppartenenza: {descrizione: desc}}},
                cache: false,
                timeout: 100000,
                success: function (data) {
                    var obj = JSON.parse(data);
                    $("#result").html("AGGIUNTO ANIMALE");
                },
                error: function () {
                    $("#result").html("ERROR");
                }
            });
        });

    },
    btnAnimaleOnClick: function () {
        $("#btnAnimale").on('click', APP.addAnimale);
    },
    findAnimaleByName: function () {
        var casella = $("#casellaTestoAnimale").val();
        var jsPar1 = 'nome=' + casella;

        $.ajax({
            url: "/parchiregionalitest/findbyname.htm",
            method: "GET",
            contentType: "application/json;charset=UTF-8",
            accepts: {json: "application/json,text/javascript"},
            data: jsPar1,
            cache: false,
            timeout: 100000,
            success: function (data) {
                var obj = JSON.parse(data);
                alert(obj.nome);
            },
            error: function () {
                alert("ERROR");
            }
        });
    },
    cercaAnimaliClicked: function () {
        $("#cercaAnimali").on('click', APP.findAnimaleByName);
    }
};


$(document).ready(function () {
    APP.checkPage();
    APP.cercaAnimaliClicked()();
    APP.btnAnimaleOnClick();
});

