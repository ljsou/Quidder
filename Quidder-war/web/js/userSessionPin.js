/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



var options = {};
options.login = true;
LoginRadius_SocialLogin.util.ready(function() {
    $ui = LoginRadius_SocialLogin.lr_login_settings;
    $ui.interfacesize = "";
    $ui.apikey = "9c191d9f-ee99-4823-806e-d2dcac34fe1b";
    $ui.callback = "";
    $ui.lrinterfacecontainer = "interfacecontainerdiv";
    LoginRadius_SocialLogin.init(options);
});


LoginRadiusSDK.onlogin = Successfullylogin;
function Successfullylogin() {
    console.log("Successfullylogin...");
    LoginRadiusSDK.getUserprofile(function(data) {
        console.log(data);
        document.getElementById('user-session-pin').value = JSON.stringify(data);
        document.getElementById('user-session-pin-button').click();
    });
    return false;
}
;
