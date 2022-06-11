$(document).ready(function() {
	$('#myTable').DataTable({

		lengthMenu: [
			[5, 7],
			[5, 7],
		],
		"language": {
			"oPaginate": {
				"sFirst": "Primero",
				"sLast": "último",
				"sNext": "Siguiente",
				"sPrevious": "Anterior"
			},
			"infoEmpty": "Mostrando registros del 0 al 0, (Total de 0 registros)",
			"zeroRecords": "Ningun resultado para la palabra buscada",
			"lengthMenu": "Visualizando _MENU_ registros",
			"info": "Visualizando registros del _START_ al _END_, (Total de _TOTAL_ registros)",
			"sSearch": "Buscar por Nombre:",
			"infoFiltered": "(filtrado de un total de _MAX_ registros)",

		}
	});
});

function LimpiarCampos() {
	window.location = '/menu/estudiantes/Consolidado/listar';
}

window.setTimeout(function() {
	$(".alert").fadeTo(1000, 0).slideDown(1000, function() {
		$(this).remove();
	});
}, 2000);



