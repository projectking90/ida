/**
 * DataTable Setting
 */
function setDataTable(table_id){
	var dt = $(table_id).DataTable({
		"columnDefs" : [
			{"searchable" : false, "orderable" : false, "targets" : 0}
		]
		,"order": [[4, "asc"]]
	});
	
	dt.on( 'order.dt search.dt', function () {
		dt.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			cell.innerHTML = i+1;
		} );
	} ).draw();
}