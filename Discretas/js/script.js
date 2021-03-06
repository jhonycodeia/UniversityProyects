$(document).ready(function() {
	$('.menu li:has(ul)').click(function() {
		
		if($(this).hasClass('activado'))
		{
			$(this).removeClass('activado');
			$(this).children('ul').slideUp();
		}
		else
		{
			$('.menu li ul').slideUp();
			$('.menu li').removeClass('activado');
			$(this).addClass('activado');
			$(this).children('ul').slideDown();
		}
	});
	$('ul').click(function(p){
		p.stopPropagation();
	});
	
	$('#video').click(function(){
		$('.contenedor #menu-video').slideToggle();
		$('.menu li').removeClass('activado');
		$('.menu li').children('ul').slideUp();
		$('.contenedor #menu-contenido').slideUp();
  		$('.contenedor #menu-herramienta').slideUp();
		
	});
	
	$('#contenido').click(function(){
		$('.contenedor #menu-contenido').slideToggle();
		$('.menu li').removeClass('activado');
		$('.menu li').children('ul').slideUp();
		$('.contenedor #menu-video').slideUp();
  		$('.contenedor #menu-herramienta').slideUp();
    	
	});
	
	$('#herramienta').click(function(){
		$('.contenedor #menu-herramienta').slideToggle();
		$('.menu li').removeClass('activado');
		$('.menu li').children('ul').slideUp();
		$('.contenedor #menu-video').slideUp();
  		$('.contenedor #menu-contenido').slideUp();
		
	});
	
	
});