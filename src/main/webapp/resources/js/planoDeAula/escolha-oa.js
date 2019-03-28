/**
 * Utilizado no passo 1 do cadastro de plano de aula para controlar os OAs adicionados
 */

$(document).ready(function () {
    var objetosAprendizagem = [];
    //Atualiza o array caso haja objetos no plano de aula
    $(".inputsOAs").each(function () {
        var valor = $(this).val();
        objetosAprendizagem.push(valor);
    });

    $('#textoBusca').on('keyup', function (event) {
        event.preventDefault();
        var texto = $(this).val();
        var contador = contadorContains(texto);
        console.log(contador);
    });

    function gerarInputsHidden() {
        $('#div-inputsOAs').empty();
        var contador = 0;
        objetosAprendizagem.forEach(function (id) {
            $('#div-inputsOAs').append("<input class='inputs-oa' type='hidden' name='planoDeAula.objetosAprendizagem["+contador+"].id' value='"+id+"'/>");
            contador = contador+1;
        });
    }

    $(document).on('click','.btn-adicionar', function () {
        var objetoAprendizagem = {};
        objetoAprendizagem.id = $(this).attr('oa-id');
        objetoAprendizagem.nome = $(this).attr('oa-nome');
        objetosAprendizagem.push(objetoAprendizagem.id);
        $('#row-'+objetoAprendizagem.id).remove();
        $('#selecionados').prepend(gerarLinhaDeTabela(objetoAprendizagem,true));
        gerarInputsHidden();
        console.log(objetosAprendizagem);
    });

    $(document).on('click','.btn-remover-oa', function (event) {
        console.log("remover");
        // event.preventDefault();
        var objetoAprendizagem = {};
        objetoAprendizagem.id = $(this).attr('oa-id');
        objetoAprendizagem.nome = $(this).attr('oa-nome');
        removerDoArray(objetoAprendizagem.id);
        $('#row-'+objetoAprendizagem.id).remove();
        $('#selecao-oa').prepend(gerarLinhaDeTabela(objetoAprendizagem,false));
        console.log(objetosAprendizagem);
        gerarInputsHidden();
    });


    function removerDoArray(id) {
        console.log(id);
        var indexDoOA = objetosAprendizagem.indexOf(id);
        console.log('Index do OA' + indexDoOA);
        if(indexDoOA > -1) {
            objetosAprendizagem.splice(indexDoOA,1);
        }
    }

    function gerarLinhaDeTabela(oa, adicionar) {
        var linhaSelecao = "<tr id='row-"+oa.id+"'>"
            +"<td class='nome-objeto'>"+oa.nome+"</td>"
            +"<td>"
            +"<button id='btnAdicionar"+oa.id+"' class='btn btn-table-oa btn-adicionar' oa-id='"+oa.id+"' oa-nome='"+oa.nome+"' type='button' title='Adicionar'>"
            +"<i class='material-icons'>add</i>"
            +"</button>"
            +"</td>"
            +"</tr>";
        var linhaSelecionado = "<tr id='row-"+oa.id+"'>"
            +"<td class='nome-objeto'>"+oa.nome+"</td>"
            +"<td>"
            +"<button id='btnRemover"+oa.id+"' class='btn btn-table-oa btn-remover-oa' oa-id='"+oa.id+"' oa-nome='"+oa.nome+"' type='button' title='Remover'>"
            +"<i class='material-icons'>delete</i>"
            +"</button>"
            +"</td>"
            +"</tr>";

        if(adicionar == true) {
            return linhaSelecionado;
        } else {
            return linhaSelecao;
        }
    }

    function contadorContains(texto) {
        texto = texto.toLowerCase();
        var contador = 0;
        $('.nome-objeto').each(function () {
            var valorAtual = $(this).text().toLowerCase();
            console.log(texto+ "  "+ valorAtual);
            if(valorAtual.includes(texto)) {
                contador = contador + 1;
                $(this).parent().show();
            } else  {
                $(this).parent().hide();
            }
        });
        return contador;
    }
});
