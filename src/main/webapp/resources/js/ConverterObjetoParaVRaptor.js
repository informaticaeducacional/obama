/*
 * Copyright© set/2015 - Logique Sistemas®.
 * All rights reserved
 */
/**
 * Responsável por converter um Object do Jquery
 * em um formato que é esperado pelo VRaptor.
 *
 * Formato Jquery Object:
 *                      Usuario :   {
 *                                      nome : Logique,
 *                                      sobrenome: Sistemas
 *                                  }
 * Formato esperado do VRaptor: {
 *                                usuario.nome : Logique
 *                                usuario.sobrenome : Sistemas
 *                              }
 * Created by victor on 06/10/15.
 */

(function ($) {

    var metodos = {

        montarObjetoArray : function (nomeVariavel, objetoArray, permitirNulos) {
            var retorno = {};

            $.each(objetoArray, function(key, value) {
                var novaChave = nomeVariavel + "["+key+"]";
                var objAppend;

                if ($.isArray(value)) {
                    objAppend = metodos.montarObjetoArray(novaChave, value, permitirNulos);
                } else {
                    objAppend = metodos.montarObjeto(novaChave, value, permitirNulos);
                }

                retorno = $.extend(retorno, objAppend);
            });

            return retorno;
        },

        montarObjeto : function(nomeVariavel, objeto, permitirNulos) {
            var retorno = {};

            if (objeto instanceof Object) {

                $.each(objeto, function(key, value) {
                    var objAppend;
                    var novaChave = nomeVariavel + "." + key;

                    if ($.isArray(value)) {
                        objAppend = metodos.montarObjetoArray(novaChave, value, permitirNulos);
                    } else {
                        objAppend = metodos.montarObjeto(novaChave, value, permitirNulos);
                    }

                    retorno = $.extend(retorno, objAppend);
                });

            } else {
                if (objeto != null || permitirNulos) {
                    retorno[nomeVariavel] = objeto;
                }

            }

            return retorno;
        }

    };


    $.ConverterObjetoParaVraptor = function (nomeVariavel, objeto, converterNulos) {
        var permitirNulos = converterNulos == null ? true : converterNulos;

        var objetoConvertido;
        if ($.isArray(objeto)) {
            objetoConvertido = metodos.montarObjetoArray(nomeVariavel, objeto, permitirNulos);
        } else {
            objetoConvertido = metodos.montarObjeto(nomeVariavel, objeto, permitirNulos);
        }

        return objetoConvertido;
    }
})(jQuery);