$(document).ready(function () {

    var urlBase = $('#url-base').val();
    var mapDescritores = new Map();

    $nivelSelect = $('select[name="nivelObjeto"]');
    $temaSelect = $('select[name="temaObjeto"]');
    $descritorSelect = $('#descritor-select');
    $btnAddDescritor = $('#btn-add-descritor');

    $btnAddDescritor.on('click', function () {
        var descritorId = $descritorSelect.val();
        if (!(descritorId == null || descritorId == "" || descritorId == undefined)) {
            var textoSelecionado = $('#descritor-select').children(':selected').text();
            mapDescritores.set(descritorId, textoSelecionado);
            atualizarLista();
        }
    });

    $nivelSelect.on('change', function () {
        var nivel = $nivelSelect.val();
        var tema = $temaSelect.val();
        if (nivel == null || nivel == "" || nivel == undefined) {
            nivel = 0;
        }
        if (tema === null || tema == "" || tema == undefined) {
            tema = 0;
        }
        var url = urlBase + 'objetosAprendizagem/todosDescritores/' + 'nivelEnsino/' + nivel + '/temaConteudo/' + tema;
        fazerRequisicao(url);
    });

    $temaSelect.on('change', function () {
        var nivel = $nivelSelect.val();
        var tema = $temaSelect.val();
        if (nivel == null || nivel == "" || nivel == undefined) {
            nivel = 0;
        }
        if (tema === null || tema == "" || tema == undefined) {
            tema = 0;
        }
        var url = urlBase + 'objetosAprendizagem/todosDescritores/' + 'nivelEnsino/' + nivel + '/temaConteudo/' + tema;
        fazerRequisicao(url);
    });

    function modificarOptionsDescritores(data) {
        $descritorSelect.empty();
        $descritorSelect.append(
            "<option value='' disabled selected>Selecione o descritor</option>"
        );
        data.forEach(function (value) {
            $('#descritor-select').append(
                "<option value='" + value.id + "'>" + value.nivelEnsino.denominacaoAbreviada + " - " + value.codigo + " - " + value.descricao + "</option>"
            )
        })
    }


    function fazerRequisicao(url) {
        $.ajax({
            url: url,
            type: 'GET'
        }).done(function (data) {
            modificarOptionsDescritores(data);
        }).fail(function () {

        });
    }

    function adicionarInputsDescritores(key, valor, i) {
        $('#inputsDescritores').append("<input name='objetoAprendizagem.descritores[" + i + "].id' type='hidden' value='" + key + "' />");
        $('#collection-descritores').append(
            "<li class='collection-item'><div>" + valor + "<a href='#!' class='secondary-content btns-cancel' item-key='" + key + "'><i class='material-icons'>cancel</i></a></div></li>");

    }

    function atualizarLista() {
        limparInputsEListas();
        var i = 0;
        mapDescritores.forEach(function (value, key) {
            console.log(key + " = " + value);
            adicionarInputsDescritores(key, value, i);
            i++;
        }, mapDescritores)
    }

    $(document).on('click', '.btns-cancel', function () {
        console.log("entrou");
        var key = $(this).attr('item-key');
        mapDescritores.delete(key);
        atualizarLista();
    });

    function limparInputsEListas() {
        $('#inputsDescritores').empty();
        $('#collection-descritores').empty();
    }
});
