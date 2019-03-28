
$(document).ready(function(){
    var objetoDeAprendizagem = {}
    var urlBase = '/objetosAprendizagem/opcoesDescritores';
    var $inputTexto = $('input[name="dadosDaBusca.texto"]');
    var $inputIdNivelEnsino = $('select[name="dadosDaBusca.idNivelEnsino"]');
    var $inputIdTemaConteudo = $('select[name="dadosDaBusca.idTemaConteudo"]');
    var $inputIdDescritor = $('select[name="dadosDaBusca.idDescritor"]');
    var $inputIdTipoVisualizacao = $('select[name="dadosDaBusca.idTipoVisualizacao"]');
    var listaOA = [];

    $inputIdNivelEnsino.on('change', function () {
        var valorNivel = $inputIdNivelEnsino.val();
        if(valorNivel == null || valorNivel == "" || valorNivel == undefined) {
            valorNivel = 0;
        }
        var valorTema = $inputIdTemaConteudo.val()
        if(valorTema === null || valorTema == "" || valorTema == undefined) {
            valorTema = 0;
        }
        console.log("nivel:" +valorNivel + "tema" + valorTema);
        var novaUrl = urlBase + '/nivelEnsino/' + valorNivel + '/temaConteudo/'+ valorTema;

        fazerRequisicao(novaUrl)

    });

    $inputIdTemaConteudo.on('change',function () {
        var novaUrl = urlBase + '/nivelEnsino/' + $inputIdNivelEnsino.val() + '/temaConteudo/'+ $inputIdTemaConteudo.val();
        fazerRequisicao(novaUrl);
    });

    function modificarOptionsDescritores(data) {
        $('#descritor').empty();
        $('#descritor').append(
        "<option value='' disabled selected>Selecione o descritor</option>"
        );
        data.forEach(function (value) {
            $('#descritor').append(
                "<option value='"+value.id+"'>"+value.nivelEnsino.denominacaoAbreviada+" - "+value.codigo+" - "+value.descricao+"</option>"
            )
        })
    }


    function fazerRequisicao(url) {
        $.ajax({
            url: url,
            type: 'GET'
        }).done(function (data) {
            M.FormSelect.getInstance($('#descritor')).destroy();
            modificarOptionsDescritores(data);
            $('select').formSelect();
        }).fail(function () {

        });
    }


});




function limparCardRow() {
    console.log("Limpar row")
    $('#cards-row').empty();
}
