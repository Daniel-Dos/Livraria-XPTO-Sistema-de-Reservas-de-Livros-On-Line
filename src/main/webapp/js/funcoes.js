/**
 *  funçoes para formulario
 */


function formata_mascara(campo_passado,mascara){
	  
	var campo = campo_passado.value.length;
	var saida = mascara.substring(0,1);
	var texto = mascara.substring(campo);
	if(texto.substring(0,1) != saida){
		 campo_passado.value += texto.substring(0,1);
		
	}
	
	//aceitar somente numero
	
		function Numero(e){
			navegador = /msie/i.test(navigator.userAgent);
			if(navegador)
				var tecla = event.keyCode;
			else
				var tecla = e.which;
			if(tecla > 47 && tecla < 58)
				return true;
			else
				{
				if(tecla != 8)
					return false;
				else
					return true;
				}
		}
}