var APP_ANIMALE = {
    getParco: function () {
        var nomeParco = document.cookie.substr(8);

        return nomeParco;
    },
    salvaAnimale: function () {
        //ANIMALE
        var primoAvvistamento = $("#apv").val();
        var livelloSalute = $("#ls").val();
        var nCuccioliFemmine = $("#ncf").val();
        var nCuccioliMaschi = $("#numeroCuccioliMaschi").val();
        var nomeAnimale = $("#nomeAnimale").val();
        var numeroFemmine = $("#nf").val();
        var numeroMaschi = $("#nm").val();
        var rischioEstinzione = $("#re").val();
        //PARCO
        var nomeParco = APP_ANIMALE.getParco();
        //SPECIE
        var nomeSpecie = $("#ns").val();
        //ORDINE APPARTENENZA
        var descrizione = $("#desc").val();


        var animale = {
            annoPrimoAvvistamento: primoAvvistamento,
            livelloSalute: livelloSalute,
            nCuccioliFemmine: nCuccioliFemmine,
            nCuccioliMaschi: nCuccioliMaschi,
            nome: nomeAnimale,
            numeroFemmine: numeroFemmine,
            numeroMaschi: numeroMaschi,
            rischioEstinzione: rischioEstinzione,
            nomeParco: nomeParco,
            nomeSpecie: nomeSpecie,
            descrizione: descrizione
        };

        $.post({
            url: "/parchiregionalitest/animale/insertanimale.htm",
            ContentType: "application/x-www-form-urlencoded; charset=UTF-8",
            Accepts: "application/json",
            data: animale,
            success: function (data) {
                var obj = JSON.parse(data);

            },
            error: function () {

            }
        });
    },
    onClickSaveAnimale: function () {
        $("#btnAnimale").on('click', APP_ANIMALE.salvaAnimale);
    },
    populateAnimaliTable: function () {
        $.ajax({
            url: "/parchiregionalitest/animale/findallanimali.htm",
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
    findAnimaleByName: function () {
        var casella = $("#casellaTestoAnimale").val();
        var jsPar1 = 'nome=' + casella;

        $.ajax({
            url: "/parchiregionalitest/animale/findanimalebyname.htm",
            method: "GET",
            contentType: "application/json;charset=UTF-8",
            accepts: {json: "application/json,text/javascript"},
            data: jsPar1,
            cache: false,
            timeout: 100000,
            success: function (data) {
                var obj = JSON.parse(data);
                $("#risCercaAnimali").html("Nome: " + obj.nome + "<br>" + "Nome parco: " + obj.parco.nomeParco + "<br>" + "Nome specie: " + obj.specie.nomeSpecie + "<br>" + "Ordine Appartenenza: " + obj.specie.ordineAppartenenza.descrizione + "<br>" + "<button id=`clearAnimaliOutput` type=submit onClick=APP_ANIMALE.cancellaOutput()>CANCELLA</button>");
            },
            error: function () {
                alert("ERROR");
            }
        });
    },
    cercaAnimaliClicked: function () {
        $("#cercaAnimali").on('click', APP_ANIMALE.findAnimaleByName);
    },
    cancellaOutput: function () {
        $("#risCercaAnimali").html("");
    }
};

$(document).ready(function () {
    APP_ANIMALE.onClickSaveAnimale();
    APP_ANIMALE.populateAnimaliTable();
    APP_ANIMALE.cercaAnimaliClicked();
});