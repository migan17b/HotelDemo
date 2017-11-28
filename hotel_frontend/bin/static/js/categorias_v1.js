
function initElementsCategorias(){
	addEventElement("btnMail", "click", clickBtnMail);
	addEventElement("btnSearch", "click", clickBtnSearch);
	
}




function clickBtnMail() {
    $('#modalMail').modal();
}

function clickBtnSearch() {
setTimeout(function() {
	var nombreSearch = getUpperCaseValueInputText("txtSearch");
	
	var categoriaBody ={	
					"nombre": nombreSearch
				};
	$.ajax({
		url: "http://localhost:5092/frontendhotel/categoria/searchcategorias" ,
		type: "POST",
		dataType: "json",
		contentType: "application/json",
		cache: false,
		data:JSON.stringify(categoriaBody) ,
		
		success: function(result) {
			var documentoList = result;
			if (documentoList != null && documentoList.length > 0) {
				
				for (var i = 0; i < documentoList.length; i++) {
					var documento = documentoList[i];
					 	console.log(documento);
					};
	
			}
			
		},
		error: function() {
			
		}
	});
}, 500);

}