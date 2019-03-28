$(document).ready(function () {
    var feedback;
    var idPlano = $('#planoDeAula-id').val();
    var urlValidacao = $('#url-revisao').val();

    $(document).on('click','#btn-reajuste', function (){
        feedback = $('#text-feedback').val();
        limparConteudo();
        $('#modal-revisao').append(htmlConfirmacaoReajuste());
    });

    $(document).on('click','#btn-enviar-aprovacao', function (){
        validarPlanoDeAula(idPlano,feedback,'VALIDADO');
    });

    $(document).on('click','#btn-enviar-reajuste', function (){
        validarPlanoDeAula(idPlano,feedback,'NECESSARIO_AJUSTE')
    });

    $(document).on('click','#btn-aprovacao', function (){
        feedback = $('#text-feedback').val();
        limparConteudo();
        $('#modal-revisao').append(htmlConfirmacaoAprovacao());
    });

    $(document).on('click','#btn-voltar', function (){
        limparConteudo();
        $('#modal-revisao').append(htmlConteudoModal());
    });

    function validarPlanoDeAula (idPlano,feedback,statusPlano) {
        var status = {
            valor: statusPlano
        }
        exibirMensagem("Enviando revisão.");
        $.ajax({
            url: urlValidacao,
            type: 'POST',
            data: {
                idPlano: idPlano,
                status: status,
                feedback: feedback
            }
        }).done(function (data) {
            exibirMensagem("Revisão realizada com sucesso.");
            limparConteudo();
            $('#btn-revisao').hide();
            $('#modal-revisao').append(htmlConteudoModal());
        }).fail(function () {
            exibirMensagem("Desculpe! Error ao enviar revisão :(");
        })
    }
});



function htmlConteudoModal () {
return "<div class='modal-content'>"
            +"<h4 class='center'>Avaliação de plano de aula</h4>"
            +"<div class='row'>"
            +"<div class='input-field col s12'>"
                +"<textarea id='text-feedback' class='materialize-textarea'></textarea>"
                +"<label for='text-feedback'>Descreva suas considerações sobre o plano de aula.</label>"
            +"</div>"
            +"</div>"
        +"</div>"
        +"<div class='modal-footer center'>"
            +"<button id='btn-reajuste' type='button' class='btn-flat orange-text'>Enviar para reajuste</button>"
            +"<button id='btn-aprovacao' type='button' class='btn-flat green-text'>Validar plano de aula</button>"
        +"</div>";
}

function htmlConfirmacaoReajuste() {
    return "<div class='modal-content'>"
                +"<div class='row'>"
                    +"<div class='col s12'>"
                        +"<h5>Tem certeza que deseja enviar este plano de aula para reajuste?</h5>"
                    +"</div>"
                +"</div>"
            +"</div>"
            +"<div class='row'>"
                +"<div class='col s12 center'>"
                    +"<div class='modal-footer'>"
                        +"<button id='btn-enviar-reajuste' type='button' class='btn-flat green-text modal-close'>Enviar</button>"
                        +"<button id='btn-voltar' type='button' class='btn-flat blue-text'>Voltar</button>"
                    +"</div>"
                +"</div>"
            +"</div>";
}

function htmlConfirmacaoAprovacao () {
    return "<div class='modal-content'>"
        +"<div class='row'>"
        +"<div class='col s12'>"
        +"<h5>Tem certeza que deseja validar este plano de aula?</h5>"
        +"</div>"
        +"</div>"
        +"</div>"
        +"<div class='row'>"
        +"<div class='col s12 center'>"
        +"<div class='modal-footer'>"
        +"<button id='btn-enviar-aprovacao' type='button' class='btn-flat green-text modal-close'>Enviar</button>"
        +"<button id='btn-voltar' type='button' class='btn-flat blue-text'>Voltar</button>"
        +"</div>"
        +"</div>"
        +"</div>";
}

function limparConteudo() {
    $('#modal-revisao').empty();
}
