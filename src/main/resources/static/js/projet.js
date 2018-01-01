var map = null;
var geocoder = null;

function load() {
    var mapdiv = document.getElementById("map_canvas");
    var mapMakerMapType = new google.maps.ImageMapType({
        getTileUrl: function(coord, zoom) {
            return 'http://mt' + Math.ceil(Math.random() * 3) + ".google.com/vt?lyrs=mapmaker|map_type:m" + "&x=" + coord.x + "&y=" + coord.y + "&z=" + zoom;
        },
        tileSize: new google.maps.Size(256, 256),
        isPng: true,
        maxZoom: 20,
        name: "Map Maker Normal"
    });
    map = new google.maps.Map(mapdiv, {
        zoom: 13,
        center: new google.maps.LatLng(48.8514211, 2.2920236),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    map.overlayMapTypes.insertAt(0, mapMakerMapType);
    geocoder = new google.maps.Geocoder();
}

var marker = null;

function addrToGpsCoordinates(address) {
    geocoder.geocode({
        'address': address
    }, function(data) {
        handleResponse(data);
    });
}

function handleResponse(response, pos, intent) {
    if (marker != null) marker.setMap(null);
    if (response.length == 0) {
        alert(lang.noresult);
        return;
    }
    var address = response[0].formatted_address;
    if (pos == null) pos = response[0].geometry.location;
    marker = new google.maps.Marker({
        position: pos,
        map: map,
        title: 'Address'
    });
    map.panTo(pos);
    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map, marker);
    });
    document.getElementById('address').value = address;
    document.getElementById('lat').value = arr(pos.lat());
    document.getElementById('lon').value = arr(pos.lng());
}


function btnAddr2Gps() {
    var addr = document.getElementById('address').value;
    addrToGpsCoordinates(addr);
}


function mapClickEvent(event) {
    var pos = event.latLng;
    document.getElementById('lat').value = arr(pos.lat());
    document.getElementById('lon').value = arr(pos.lng());
    btnGps2Addr();
}

function arr(nb) {
    return Math.round(nb * 1000000) / 1000000;
}
load();