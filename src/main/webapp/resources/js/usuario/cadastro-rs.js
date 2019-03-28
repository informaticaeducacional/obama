window.fbAsyncInit = function () {
    FB.init({
        appId: '332860430481329',
        xfbml: true,
        version: 'v2.12'
    });
    FB.AppEvents.logPageView();

    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });

};

function statusChangeCallback(response) {
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
    } else {
        // The person is not logged into your app or we are unable to tell.
    }
}

function processarInformacoes(){
    FB.api('/me', {fields: 'name, email'}, function(response) {
        $('#tipo-rs').val('FACEBOOK');
        $('#email-rs').val(response.email);
        $('#nome-rs').val(response.name);
        $('#redeSocial').val(true);
        $('#form-rs').submit();

    });
}

function logar(){
    FB.login(function (response) {
        if (response.status === 'connected') {
            processarInformacoes();
        } else {
            // The person is not logged into this app or we are unable to tell.
        }
    }, {scope: 'public_profile,email'});
}

$('#btn-facebook').on('click', function () {
    logar();
})

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));