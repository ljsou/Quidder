/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    console.log("hola!");
    var toggle = true;
    var gIndex;
    var tagme = false;
    var consulting = true;
    /*
     * Esta función monitorea el elemento 'li' para identificar los click sobres los mismos
     */
    $("#all-resources li").click(function(event) {

        if (consulting) {
            var hrefIframe = $(this).find(".resourceUrl").val();
            var hrefImage = $(this).find(".resourceImageAddress").val();
            //console.log(href);
            $("#image-overview").attr('src', hrefImage);
            $("#resource-iframe").attr('src', hrefIframe);
        }
        /*
         * Cuando se hace click sobre la imagen con esta clase 'view-resource' se lanza el popup de visualización, cuando se cierra la ventanda se 
         * se pone en true la bandera toggle para que puede seguir funcionando el 'tagging_box'.
         */
        $(this).find(".view-resource").fancybox({
            afterClose: function() {
                //console.log("fechou!");
                toggle = true;
            }
        });
        /*
         * Esta función garantiza que el 'tagging-box' no será desplegado
         */
        $(this).find(".view-resource").click(function() {
            $(this).find(".comodin").hide();
            toggle = false;
        });
        
        /*
         * Esta función permite obtener los identificadores de los 'li' sobres los cuales se hizo click y 
         * a su despliega el 'tagging-box'
         */
        if (toggle) {

            var index = $(this).prevAll().length;
            event.preventDefault();
            gIndex = "tagging-box-" + index;
            console.log(gIndex);

            /**
             * esta parte permite manejar el toggler del comodin. Al hacer click en tag-me lo despliega y oculta. 
             */
            if (tagme) {                
                if (!$(this).find(".comodin").hasClass(gIndex)) {
                    $(this).find(".comodin").addClass(gIndex);
                    $(this).find(".comodin").slideDown();
                    tagme = false;
                    consulting = false;
                } else {
                    $(this).find(".comodin").slideUp();
                    $(this).find(".comodin").removeClass(gIndex);
                    tagme = false;                    
                }
            }
        }

    });

    $(".tagme").click(function(event) {
        event.preventDefault();
        tagme = true;
    });
});
    