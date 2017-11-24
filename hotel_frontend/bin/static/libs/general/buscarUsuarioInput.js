var buscarUsuarioNumeroRucOnKeypressInput = function(event) {
	var keyCode = window.event ? event.keyCode : event.which;
	if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57) ) {
		return true;
	}


	else if (keyCode == 13) {
		//buscarColaboradorNumeroRegistroOnChangeInput(event);
		event.srcElement.blur();
		return false;
	}
	else {
		return false;
	}
}

var buscarUsuarioNumeroRucOnChangeInput = function(event) {
	
	if (typeof buscarUsuarioInputService != "undefined") {
		
		hideElement(buscarUsuarioInputService.idDivError);
		if (typeof buscarUsuarioInputService.buscarUsuarioBefore != "undefined") {
			buscarUsuarioInputService.buscarUsuarioBefore();
		}
		if (trimText(getUpperCaseValueInputText(buscarUsuarioInputService.idNumeroRuc)).length == 11) {
			
			setTimeout(function(){
				$.ajax({
					url: contextPathUrl + "/usuarios/obtenerUsuarioIqbf.htm",
					type: "post",
					dataType: "json",
					cache: false,
					data: {
						"parmNumRuc": getUpperCaseValueInputText(buscarUsuarioInputService.idNumeroRuc)
						
					},
					beforeSend: function() {
						if (typeof buscarUsuarioInputService.idDivScreenBlock != "undefined") {
							showModalElement(buscarUsuarioInputService.idDivScreenBlock);
						}
						if (typeof buscarUsuarioInputService.idDivLoading != "undefined") {
							showElement(buscarUsuarioInputService.idDivLoading);
						}
					},
					complete: function() {
						if (typeof buscarUsuarioInputService.idDivLoading != "undefined") {
							hideElement(buscarUsuarioInputService.idDivLoading);
						}
						if (typeof buscarUsuarioInputService.idDivScreenBlock != "undefined") {
							hideModalElement(buscarUsuarioInputService.idDivScreenBlock);
						}
					},
					success: function(result) {
						var usuarioIQBFVO = result.usuarioIQBFVO;
						if (typeof buscarUsuarioInputService.buscarUsuarioAfter != "undefined") {
							if (usuarioIQBFVO.codMensaje == '00'){
								buscarUsuarioInputService.buscarUsuarioAfter(usuarioIQBFVO);
							}else{
								showMessageErrorBuscarUsuarioInput(usuarioIQBFVO.mensaje);
							}
						}
					},
					error: function() {
						if (typeof buscarUsuarioInputService.idDivError != "undefined" && typeof buscarUsuarioInputService.idEtiquetaError != "undefined" && typeof buscarUsuarioInputService.errorMessage != "undefined") {
							showMessageErrorBuscarUsuarioInput(buscarUsuarioInputService.errorMessage.errorGenerico);
						}
					}
				});
			}, 500);
		}
		else {
			if (typeof buscarUsuarioInputService.idDivError != "undefined" && typeof buscarUsuarioInputService.idEtiquetaError != "undefined" && typeof buscarUsuarioInputService.errorMessage != "undefined") {
				showMessageErrorBuscarUsuarioInput(buscarUsuarioInputService.errorMessage.cantidadMinimaNumeroRegistro);
			}
		}
	}
}

function showMessageErrorBuscarUsuarioInput(errorMessage) {
	setHtmlElement(buscarUsuarioInputService.idEtiquetaError, errorMessage);
	showElement(buscarUsuarioInputService.idDivError);
}