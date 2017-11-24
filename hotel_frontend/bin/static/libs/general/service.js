/*
 * Archivo que nos permite definir los metodos reutilizables - Interfaces.
 */


function BuscarUsuarioInputService(dataParametros, buscarUsuarioInputBeforeMethod, buscarUsuarioInputAfterMethod) {
	
	if (typeof dataParametros != "undefined") {
		this.idNumeroRuc = dataParametros.idNumeroRuc;
		this.idRazonSocial= dataParametros.idRazonSocial;
		this.idDivLoading = dataParametros.idDivLoading;
		this.idDivError = dataParametros.idDivError;
		this.idEtiquetaError = dataParametros.idEtiquetaError;
		this.idDivScreenBlock = dataParametros.idDivScreenBlock;
		
		this.errorMessage = dataParametros.errorMessage;

		
	}
	if (typeof buscarUsuarioInputBeforeMethod != "undefined") {
		this.buscarUsuarioBefore = buscarUsuarioInputBeforeMethod;
	}
	if (typeof buscarUsuarioInputAfterMethod != "undefined") {
		this.buscarUsuarioAfter = buscarUsuarioInputAfterMethod;
	}
}

