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

var options = {

}

$(document).ready(function () {
    $('.tabela-planoDeAula').DataTable({
        language:linguagem,
        columnDefs: [
            {
                targets: [ 3 ],
                orderable: false,
                "bLengthChange": false
            }
        ]
    });
    $('.tabela-planoDeAula2').DataTable({
        language:linguagem,
        columnDefs: [
            {
                targets: [ 3 ],
                orderable: false,
                "bLengthChange": false
            }
        ]
    });

    $('.tabela-selecao').DataTable({scrollY: 600,
        paging: false, language:linguagem, searching: false});
});

