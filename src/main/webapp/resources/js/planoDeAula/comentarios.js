

$(document).ready(function () {
    moment.locale('pt-br');
   var $formComentario = $('#formComentario');
   var $formFeedback = $('#formFeedback');
   var urlGenerica =  $('#urlSalvarComentario').val();
   var urlValidar =  $('#urlValidar').val();
   var urlReajustar =  $('#urlReajuste').val();

   $('#btnSalvarComentario').on('click',function () {
       salvarComentario(urlGenerica,"",$formComentario);
   });

    $('#comentar-planoDeAula').on('click',function () {
        salvarComentario(urlGenerica,"",$formFeedback);
    });

    $('#valida-planoDeAula').on('click',function () {
        exibirMensagem("click")
        salvarComentario(urlValidar,"Plano de aula validado.",$formFeedback);
    });

    $('#reajuste-planoDeAula').on('click',function () {
        salvarComentario(urlReajustar,"Plano de aula enviado para reajuste.",$formFeedback);
    });


   function salvarComentario(url,msg,$form) {
       $.ajax({
           url: url,
           type: 'POST',
           data: $form.serialize()

       }).done(function (data) {
           if(msg != ""){
            exibirMensagem(msg);
           }
       }).fail(function () {
            exibirMensagem("Falha na requisição");
       });
   }
   $('.format-date').each(function () {
      var texto = $(this).text();
      var textoFormatado = moment(texto).format('DD/MM/YYYY HH:mm');
      var dataAgora = moment(textoFormatado, 'DD/MM/YYYY HH:mm').fromNow();
      $(this).text(dataAgora);
   });

});