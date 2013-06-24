/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



$(function() {
    $(function() {
        $('.scroll-pane').jScrollPane({
            horizontalGutter: 5,
            verticalGutter: 5,
            'showArrows': false
        });
    });

//    $('.jScrollPaneDrag').hide();
//    $('.jScrollPaneTrack').hide();
    $('.jScrollPaneContainer').mouseenter(function() {
        $('.jScrollPaneDrag').stop(true, true).fadeIn('slow');
        $('.jScrollPaneTrack').stop(true, true).fadeIn('slow');
    });
    $('.jScrollPaneContainer').mouseleave(function() {
        $('.jScrollPaneDrag').stop(true, true).fadeOut('slow');
        $('.jScrollPaneTrack').stop(true, true).fadeOut('slow');
    });
});

