var urlCadastro;
var usuario = {};
window.onLoadCallback = function() {

    gapi.load('auth2', function(){
        // Retrieve the singleton for the GoogleAuth library and set up the client.
        auth2 = gapi.auth2.init({
            client_id: '958066261726-lgsf0311h1k8j20h39ufu7a6bl74rrad.apps.googleusercontent.com'
        });
        attachSignin(document.getElementById('btn-google'));
    });
}

function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
            usuario.nome = googleUser.getBasicProfile().getName();
            usuario.email = googleUser.getBasicProfile().getEmail();
            entrarViaRS(usuario);
        }, function(error) {
            alert(JSON.stringify(error, undefined, 2));
        });
}

console.log("entrou");
function entrarViaRS(usuario){
    $('#tipo-rs').val('GOOGLE');
    $('#email-rs').val(usuario.email);
    $('#nome-rs').val(usuario.nome);
    $('#redeSocial').val(true);
    $('#form-rs').submit();
}