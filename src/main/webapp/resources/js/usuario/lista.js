var url = $('#url-atualizacao').val();
var form = 'form-';
var linguagem = {
    "sEmptyTable": "Nenhum resultado encontrado",
    "sInfo": "_START_ até _END_ de _TOTAL_ resultados",
    "sInfoEmpty": "",
    "sInfoFiltered": "(Filtrados de _MAX_ resultados)",
    "sInfoPostFix": "",
    "sInfoThousands": ".",
    "sLengthMenu": "",
    "sLoadingRecords": "Carregando...",
    "sProcessing": "Processando...",
    "sZeroRecords": "Nenhum resultado encontrado",
    "sSearch": "Pesquisar",
    "oPaginate": {
        "sNext": "Próximo",
        "sPrevious": "Anterior",
        "sFirst": "Primeiro",
        "sLast": "Último"
    },
    "oAria": {
        "sSortAscending": ": Ordenar colunas de forma ascendente",
        "sSortDescending": ": Ordenar colunas de forma descendente"
    }
};

$('input').on('change', function () {
    var valor = $(this).val();
    var id = $(this).attr('usuario-id');
    console.log('Modificando perfil para: ' + valor + ' usuario de id: ' + id);
    atualizarUsuario(id);

});

function atualizarUsuario(id) {
    $.ajax({
        url: url,
        type: 'POST',
        data: $('#form-'+id).serialize()
    }).done(function (data) {
        exibirMensagem('Perfil atualizado');
    }).fail(function () {

    })
}


    $('.table').dataTable({
        "dom": '<<"row table-row"<"table-col-left"l><"table-col-right"f>><t>ip>',
        language:linguagem
    });
