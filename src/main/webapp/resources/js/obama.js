// Script for OBAMA V2
$(document).ready(function () {
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();

    $('.sidenav').sidenav();

    $('.collapsible').collapsible();


    //Necessário para as imagens da página inicial
    $('.slider').slider();
    // $('#myTable').DataTable();

    //Escondendo o botão "ir para o topo" da página de busca de OA
    $("#bt-topo").fadeOut();//document.getElementById().style.visibility = "hidden";

    identificarCamposObrigatorios();
    $(".format-timestamp").each(function () {
        var formatoAtual = $(this).text();
        var formatado = moment(formatoAtual).format('DD/MM/YYYY');
        $(this).text(formatado);
    });

    //Necessário para o botão de informação na tela de listagem de plano de aula
    $('.tap-target').tapTarget();

});

function autoplay() {
    //Função que faz atotransição das imagens a cada 10 segundos
    $('.slider').slider('next');
    setTimeout(autoplay, 10000);
};


document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, {});
});

$(document).ready(function () {
    $('ul.tabs').tabs();
});


// Referente ao efeito parallax
$(document).ready(function () {
    $('.parallax').parallax();
});

function cadastro() {
    //Função que faz atotransição das imagens a cada 10 segundos
    document.getElementById("painel-login").style.opacity = 0.7;
    document.getElementById("painel-cadastro").style.opacity = 1;
};

function login() {
    //Função que faz atotransição das imagens a cada 10 segundos
    document.getElementById("painel-login").style.opacity = 1;
    document.getElementById("painel-cadastro").style.opacity = 0.7;
};


//Função que limpa o campo de busca da listagem de planos de aula
function init() {
    document.getElementById("formListaPlanosDeAula:textoBusca").value = "";
}

//$(document).ready(init);
//------------------------

$(document).ready(function () {
    //Buscar todoas as divs escondidas e com class= "loadmore", e mostra as 12 primeiras
    $("div[class*='loadmore']:hidden").slice(0, 12).show();

    $("#loadMore").on('click', function (e) {
        e.preventDefault();
        var nDivsEscondidas = $("div[class*='loadmore']:hidden").length;
        console.log("Divs ocultas: " + nDivsEscondidas);

        if (nDivsEscondidas > 0 && nDivsEscondidas < 12) {
            $("div[class*='loadmore']:hidden").slice(0, nDivsEscondidas).slideDown();

            $("#loadMore").hide();
        } else if (nDivsEscondidas == 0) {
            $("#load").fadeOut('slow');
            $("#loadMore").hide();
        } else {
            $("div[class*='loadmore']:hidden").slice(0, 12).slideDown();
        }

//        $('html,body').animate({
//            scrollTop: $(this).offset().top
//        }, 1500);

    });


});

window.onscroll = function () {
    if (window.pageYOffset >= 500) {
        $("#bt-topo").fadeIn();
    } else {
        $("#bt-topo").fadeOut();
    }
};


function identificarCamposObrigatorios() {
    var camposObrigatorios = document.getElementsByClassName("obrigatorio");
    for (var i = 0; i < camposObrigatorios.length; i++) {
        if (camposObrigatorios[i].textContent.indexOf('*') == -1) {
            camposObrigatorios[i].innerHTML = camposObrigatorios[i].textContent.concat('*');
        }
    }
}

$('.sidenav').mouseenter(function () {
    if ($('nav').width() > 990) {
        if ($('.sidenav').width() <= 58) {
            $('.li-control').show();
            $('#perfil-info-sm').hide();
            $('#perfil-info').show();
            $('.sidenav').animate({width: '300px'});
        }
    }
});

$('.sidenav').mouseleave(function () {
    if ($('nav').width() > 990) {
        if ($('.sidenav').width() <= 300) {
            $('.li-control').hide();
            $('#perfil-info').hide();
            $('#perfil-info-sm').show();
            var contador = 0;

            for (i = 0; i < 10; i++) {
                $('.collapsible').collapsible('close', i);
            }

            $('.sidenav').animate({width: '58px'});
        }
    }
});
