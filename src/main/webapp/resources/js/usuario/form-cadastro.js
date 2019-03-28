$(document).ready(function () {
    var urlCadastro = $('#urlCadastro').val();
    var confirm = 0;

    $('#btn-cadastrar').on('click', function (e) {
        e.preventDefault();
        if(confirm == 0) {
            confirm=1;
            fazerRequisicao();
        }
    });

    function toggleDisabled(elem){
        elem.disabled = !elem.disabled;
    }

    function fazerRequisicao() {
        inicarLoader();
        $.ajax({
            url: urlCadastro,
            type: 'POST',
            data: $('#form-cadastro').serialize()
        }).done(function (data) {
            exibirMensagem(data.mensagem);
            $('input').each(function () {
               $(this).val("");
            });
            confirm = 0;
            pararLoader();
        }).fail(function () {
            pararLoader();
        })
    }

    function inicarLoader() {
        $('#loader-cadastro').show();
        $('#btn-cadastrar').hide();
    }

    function pararLoader() {
        $('#loader-cadastro').hide();
        $('#btn-cadastrar').show();
    }

    var msg = $('#msgsSite').val();
    if(msg != null && msg != "" && msg != undefined) {
        exibirMensagem(msg);
    }



});

