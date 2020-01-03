 /* Top Level - Main JS */

var SiteStartDate = '2020/01/03 12:00';
jQuery(window).load(function() {
	vertAlign($('#countdown_block'));
	vertAlign($('#demo_thumbs'));
});


jQuery(document).ready(function(){

	/* Flex Slider */
	if( $('#bg_slideshow').length > 0 ) {

		var slider = $('#bg_slideshow').flexslider({
			controlNav: true,
			directionNav: false,
			manualControls:  jQuery('#bg_slides_controls').length > 0 ? '#bg_slides_controls .slider_pages' : false,
			animationSpeed: 800,
			start: function(slider) {
				
			}
		});
 
		jQuery('.bg_slides_nav').click(function(){
			if( jQuery(this).attr('id') == 'bg_slides_next' ) {
				slider.flexslider('next');
			} else {
				slider.flexslider('prev');
			}
		});

	}

	if( $('#tab_contents').length > 0 ) {
		$('#tab_contents').flexslider({
			controlNav: true,
			directionNav: false,
			animationLoop: false,
			animationSpeed: 40,
			animation: 'slide',
			slideshow: false,
			manualControls: '#mainmenu li a'
		}).mCustomScrollbar({
			autoHideScrollbar: false,
			alwaysShowScrollbar: 2,
			mouseWheel: true
		});
	}

	if( $('#countdown').length > 0 ) {
		$('#countdown').countdown({
			until: new Date(SiteStartDate),
			format: 'DHMS'
		});
	}

	

});

