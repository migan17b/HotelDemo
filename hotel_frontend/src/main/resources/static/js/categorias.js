
function initElementsCategorias(){
	initTable();
	addEventElement("btnMail", "click", clickBtnMail);
	addEventElement("btnSearch", "click", clickBtnSearch);
	addEventElement("btnSearchResponsive", "click", clickBtnSearchResponsive);
	
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
	var search = getUpperCaseValueInputText("txtSearch");
	buscarCategorias(search);
}

function clickBtnSearchResponsive() {
	var search = getUpperCaseValueInputText("txtSearchResponsive");
	buscarCategorias(search);
}

function buscarCategorias(nombreSearch){
	
	setTimeout(function() {
		
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
				dataTableCategoria.clear()
				if (documentoList != null && documentoList.length > 0) {
					
					for (var i = 0; i < documentoList.length; i++) {
						var documento = documentoList[i];
						 	console.log(documento);
						 	var dataRow = {
									"id": documento.id,
									"nombre": documento.nombre,
									"precio":documento.precio,
									"acciones": " <a href=\"../categoria/categoriaform?id="+ documento.id+"\"  ><button type=\"button\" class=\"btn  btn-primary btn-sd\"><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i></button></a>"
										+ "<a href=\"../categoria/removecategoria?id="+ documento.id+"\" ><button type=\"button\" class=\"btn btn-danger\"><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></button></a> "
									          
						 	
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