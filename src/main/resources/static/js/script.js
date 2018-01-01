var map;
var oa = 31.653966;
var ob = -8.024443;
var da = 31.65371;
var db = -8.02249;
var busStop = '../img/bus-stop.png';
var bus = '../img/school-bus.png';
$(document).ready(function() {
	// Initiation
	map = new GMaps({
		el : '#map',
		lat : 31.653966,
		lng : -8.024443
	});

	// Menu contextuel pour ajouter un marqueur ou centrer la carte
	map.setContextMenu({
		control : 'map',
		options : [ {
			title : 'Ajouter un point de ramassage',
			name : 'add_marker',
			action : function(e) {
				this.addMarker({
					lat : e.latLng.lat(),
					lng : e.latLng.lng(),
					title : 'Nouvelle point de ramassage'
				});
			}
		}, {
			title : 'Centrer ici',
			name : 'center_here',
			action : function(e) {
				this.setCenter(e.latLng.lat(), e.latLng.lng());
			}
		} ]
	});

	// Ajout d'un marqueur
	map.addMarker({
		lat : da,
		lng : db,
		icon : {
			size : new google.maps.Size(32, 32),
			url : busStop
		},
		click : function(e) {
			if (console.log)
				console.log(e);
			alert('EMSI :D');
		},
		mouseover : function(e) {
			if (console.log)
				console.log(e);
		}
	});

	map.addMarker({
		lat : 31.653966,
		lng : -8.024443,
		icon : {
			size : new google.maps.Size(32, 32),
			url : bus
		}
	});

	// Tracer un chemin entre deux points
	map.drawRoute({
		origin : [ oa, ob ],
		destination : [ da, db ],
		travelMode : 'driving',
		strokeColor : '#131540',
		strokeOpacity : 0.6,
		strokeWeight : 6
	});

});