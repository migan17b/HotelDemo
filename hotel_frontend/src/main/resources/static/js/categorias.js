
function initElementsCategorias(){
	initTable();
	addEventElement("btnMail", "click", clickBtnMail);
	addEventElement("btnSearch", "click", clickBtnSearch);
	
}

function initTable(){
	

	
	
	$('#tblCategorias').DataTable( {
      
        responsive: true,
        bPaginate: false,
        bLengthChange: false,
        bFilter: false,
        bSort: false,
        bInfo: false,
        bAutoWidth: false,
        columns: [
        	 { data: "id" },
            { data: "nombre" },
            { data: "precio" },
            { data: "acciones" }
        ]
    } );
}


function clickBtnMail() {
    $('#modalMail').modal();
}

function clickBtnSearch() {
setTimeout(function() {
	var nombreSearch = getUpperCaseValueInputText("txtSearch");
	var dataTableCategoria = $("#tblCategorias").DataTable();
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
					 	var dataRow = {
								"id": documento.id,
								"nombre": documento.nombre,
								"precio":documento.precio,
								"acciones": ""
						};
					 	dataTableCategoria.row.add(dataRow).draw();
					};
	
			}
			
			
			
		},
		error: function() {
			
		}
	});
}, 500);

}

$(document).ready(function() {
    
} );