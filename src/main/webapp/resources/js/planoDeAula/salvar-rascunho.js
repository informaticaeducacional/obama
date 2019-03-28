
$(document).ready(function(){
    var url = $('#salvar-rascunho').val();
    var urlCompartilhamento = $('#url-compartilharPlano').val();
    var $inputCoautor = $('#inputCoautores');
    $('#btn-salvarRascunho').on('click', function () {
        setarTextAreaMetodologia();
        fazerRequisicao();
    });

    function fazerRequisicao() {
        $.ajax({

            url: url,

            type: 'POST',

            data: $('#form-planoAula').serialize()

        }).done(function(data) {
            var valorId = data.jsonObject.id;
            $('input[name="planoDeAula.id"]').val(valorId);
            M.toast({html: 'Rascunho salvo com sucesso!'});
        }).fail(function() {
            alert("falha na requisição")
        });
    }

    $('#btnCompartilhar').on('click', function () {
        setarTextAreaMetodologia();
        compartilharPlanodeAula();
    });

    function compartilharPlanodeAula () {
        $.ajax({
            url: urlCompartilhamento,
            type: 'POST',
            data: $('#form-planoAula').serialize()

        }).done(function (data) {
            var valorId = data.id;
            $('input[name="planoDeAula.id"]').val(valorId);
            console.log(data);
                data.mensagens.forEach(function (value) {
                    if(value.mensagem != undefined){
                        M.toast({html: value.mensagem});
                    }
                });
            gerarInputsCoautores(data.coautores);

            exibirMensagem("Os emails válidos foram cadastrados com sucesso.");
        }).fail(function () {
            alert("Falha na requisição");
        });
    }


    function gerarInputsCoautores(coautores) {
        var contador =0;
        $inputCoautor.empty();
        coautores.forEach(function (coautor) {
            $inputCoautor.append("<input type='hidden' name='planoDeAula.coautores["+contador+"].id' value='"+coautor.id+"'/>");
            contador++;
        });
    }
});
