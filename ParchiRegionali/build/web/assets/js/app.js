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
                    trHTML += '<tr><td>' + i + '</td><td>' + item.nome + '</td><td>' + item.parco.nomeParco + '</td><td>' + item.specie.nomeSpecie + '</td><td>' + item.specie.ordineAppartenenza.descrizione + "</td><td>" + "<button onclick='alert(`Non implementato`)'>Mostra di più</button>" + '</td></tr>';
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

        var myJson = {
            nome: nomeAnimale,
            numeroFemmine: parseInt(nf),
            numeroMaschi: parseInt(nm),
            nCuccioliFemmine: parseInt(ncf),
            nCuccioliMaschi: parseInt(ncm),
            livelloSalute: parseInt(ls),
            rischioEstinzione: parseInt(re),
            annoPrimoAvvistamento: apv,
            parco: {
                nomeParco: np
            },
            specie: {
                nomeSpecie: ns,
                ordineAppartenenza: {
                    descrizione: desc
                }
            }
        };

        $.post({
            url: "/parchiregionali/insertanimale.htm",
            contentType: "application/json",
            data: JSON.stringify(myJson),
            cache: false,
            timeout: 100000,
            success: function (data) {
                var obj = JSON.parse(data);
                alert(obj);
                $("#apv").val("");
                $("#ls").val("");
                $("#ncf").val("");
                $("#numeroCuccioliMaschi").val("");
                $("#nomeAnimale").val("");
                $("#nf").val("");
                $("#nm").val("");
                $("#re").val("");
                $("#np").val("");
                $("#ns").val("");
                $("#desc").val("");
            },
            error: function () {
                alert("ERROR");

            }
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
                $("#risCercaAnimali").html("Nome: " + obj.nome + "<br>" + "Nome parco: " + obj.parco.nomeParco + "<br>" + "Nome specie: " + obj.specie.nomeSpecie + "<br>" + "Ordine Appartenenza: " + obj.specie.ordineAppartenenza.descrizione + "<br>" + "<button id=`clearAnimaliOutput` type=submit onClick=APP.cancellaOutput()>CANCELLA</button>");
            },
            error: function () {
                alert("ERROR");
            }
        });
    },
    cercaAnimaliClicked: function () {
        $("#cercaAnimali").on('click', APP.findAnimaleByName);
    },
    cancellaOutput: function () {
        $("#risCercaAnimali").html("");
    }
};


$(document).ready(function () {
    APP.checkPage();
    APP.cercaAnimaliClicked()();
    APP.btnAnimaleOnClick();
});

