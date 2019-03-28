var firepad;
var nomeUsuario;
function init() {
    //// Initialize Firebase.
    //// TODO: replace with your Firebase project configuration.
    var config = {
        apiKey: "AIzaSyB1lMxlPOcjFkOFycL2ej7pAcDciZ2hkfc",
        authDomain: "text-editor-f16fe.firebaseapp.com",
        databaseURL: "https://text-editor-f16fe.firebaseio.com"
    };
    firebase.initializeApp(config);

    // Create a random ID to use as our user ID (we must give this to firepad and FirepadUserList).


    //// Get Firebase Database reference.
    var firepadRef = getExampleRef();
    //// Create CodeMirror (with lineWrapping on).
    var codeMirror = CodeMirror(document.getElementById('firepad-container'), { lineWrapping: true });
    //// Create Firepad (with rich text toolbar and shortcuts enabled).
    var userId = Math.floor(Math.random() * 9999999999).toString();

    firepad = Firepad.fromCodeMirror(firepadRef, codeMirror,
        { richTextToolbar: true, richTextShortcuts: true, userId: userId });
    //// Create Firepad (with rich text features and our desired userId).

    var firepadUserList = FirepadUserList.fromDiv(firepadRef.child('users'),
        document.getElementById('userlist'), userId, nomeUsuario);

    //// Create FirepadUserList (with our desired userId).
    //// Initialize contents.
    firepad.on('ready', function() {
        if (firepad.isHistoryEmpty()) {
            firepad.setHtml(
            textoFirepad()
            );
        }

    });
    // An example of a complex custom entity.
    // firepad.registerEntity('checkbox', {
    //     render: function (info, entityHandler) {
    //         var inputElement = document.createElement('input');
    //         inputElement.setAttribute('type', 'checkbox');
    //         if(info.checked) {
    //             inputElement.checked = 'checked';
    //         }
    //         inputElement.addEventListener('click', function () {
    //             entityHandler.replace({checked:this.checked});
    //         });
    //         return inputElement;
    //     }.bind(this),
    //     fromElement: function (element) {
    //         var info = {};
    //         if(element.hasAttribute('checked')) {
    //             info.checked = true;
    //         }
    //         return info;
    //     },
    //     update: function (info, element) {
    //         if (info.checked) {
    //             element.checked = 'checked';
    //         } else {
    //             element.checked = null;
    //         }
    //     },
    //     export: function (info) {
    //         var inputElement = document.createElement('checkbox');
    //         if(info.checked) {
    //             inputElement.setAttribute('checked', true);
    //         }
    //         return inputElement;
    //     }
    // });


}
function setarTextAreaMetodologia() {
    var token = window.location.href.split('#')[1];

    $('#inputMetodologia').val(firepad.getHtml());
    // $('#inputMetodologia').val(firepad.getText());
    $('#inputToken').val(token);
}
// Helper to get hash from end of URL or generate a random one.
function getExampleRef() {
    var ref = firebase.database().ref();
    var hash = window.location.hash.replace(/#/g, '');
    if (hash) {
        ref = ref.child(hash);
    } else {
        ref = ref.push(); // generate unique location.
        window.location = window.location + '#' + ref.key; // add it as a hash to the URL.
    }
    if (typeof console !== 'undefined') {
        console.log('Firebase data: ', ref.toString());
    }
    return ref;
}

$(document).ready(function () {
    nomeUsuario = $('#nome-usuario').text();
    init();
    $('.CodeMirror-lines').click();
    $('.powered-by-firepad').remove();

});

function irPara(idTab) {
    $('.tabs').tabs('select',idTab);
}

function textoFirepad() {
    return "<ul>" +
    "<li><span style='font-size: 18px'>Objetivo geral</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>Ao final desta aula espera&nbsp;&nbsp;-se que o(s) aluno(s) esteja(m) apto(s) a…?</span>" +
    "</li>" +
    "</ul>" +
    "</ul>" +
    "<div><span style='font-size: 18px'></span><br/></div>" +
    "    <div><span style='font-size: 18px'></span><br/></div>" +
    "    <ul>" +
    "    <li><span style='font-size: 18px'>Objetivos especificos</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>" +
    "Para alcançar o objetivo geral, o(s) aluno(s) deve(m) aprender a ou sobre...</span>" +
    "</li>" +
    "</ul>" +
    "</ul>" +
    "<div><span style='font-size: 18px'></span><br/></div>" +
    "    <ul>" +
    "    <li><span style='font-size: 18px'>Metodologia</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>Descreva detalhadamente como executar os objetivos específicos (como se fosse um manual de instruções). Explicite quais recursos utilizar e como utilizá-los.</span>" +
    "</li>" +
    "</ul>" +
    "</ul>" +
    "<div><span style='font-size: 18px'></span><br/></div>" +
    "    <ul>" +
    "    <li><span style='font-size: 18px'>Avaliação</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>Como você pretende avaliar/verificar se o(s) aluno(s) alcançou(aram) o objetivo específico?</span>" +
    "</li>" +
    "</ul>" +
    "<li><span style='font-size: 18px'>Recursos</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>Quais os materiais você vai precisar para executar sua aula?</span></li>" +
    "</ul>" +
    "</ul>" +
    "<div><span style='font-size: 18px'></span><br/></div>" +
    "    <ul>" +
    "    <li><span style='font-size: 18px'>Referências</span></li>" +
    "<ul>" +
    "<li><span style='font-size: 18px'>Para que outro professor possa se preparar para executar sua proposta de aula, nos diga: De onde você tirou toda sua inspiração? (livros, revistas, sites, outros planos de aula)</span>" +
    "</li>" +
    "</ul>" +
    "</ul>" +
    "<div>&nbsp;</div>"
}