function GScript(src) {
    document.write('<' + 'script src="' + src + '"' +' type="text/javascript"><' + '/script>');
}
function GBrowserIsCompatible() {
    return true;
}
function GApiInit() {
    if (GApiInit.called) return;
    GApiInit.called = true;
    window.GAddMessages && GAddMessages({
        160: '\x3cH1\x3eError del servidor\x3c/H1\x3eError temporal del servidor. No se pudo completar tu solicitud. \x3cp\x3ePor favor, vuélvelo a intentar dentro de un minuto aproximadamente.\x3c/p\x3e',
        1415: '.',
        1416: ',',
        1547: 'mi',
        1616: 'km',
        4100: 'm',
        4101: 'pies',
        10018: 'Cargando...',
        10021: 'Aumentar',
        10022: 'Reducir',
        10024: 'Arrastra para ampliar o reducir',
        10029: 'Volver al último resultado',
        10049: 'Mapa',
        10050: 'Satélite',
        10093: 'Términos de uso',
        10111: 'Mapa',
        10112: 'Sat.',
        10116: 'Híbrido',
        10117: 'Híb.',
        10120: 'Lo lamentamos, pero no disponemos de mapas de esta región con este nivel de zoom.\x3cp\x3ePrueba a reducir el zoom para tener una perspectiva más amplia.\x3c/p\x3e',
        10121: 'Lo lamentamos, pero no disponemos de imágenes de esta región con este nivel de zoom.\x3cp\x3ePrueba a reducir el zoom para tener una perspectiva más amplia.\x3c/p\x3e',
        10507: 'Vista panorámica a la izquierda',
        10508: 'Vista panorámica a la derecha',
        10509: 'Vista panorámica hacia arriba',
        10510: 'Vista panorámica hacia abajo',
        10511: 'Mostrar callejero',
        10512: 'Mostrar imágenes por satélite',
        10513: 'Mostrar imágenes con nombres de calle',
        10806: 'Haz clic para visualizar esta zona en Google Maps',
        10807: 'Tráfico',
        10808: 'Mostrar tráfico',
        10809: 'Ocultar tráfico',
        12150: '%1$s en %2$s',
        12151: '%1$s en %2$s a la altura de %3$s',
        12152: '%1$s en %2$s entre %3$s y %4$s',
        10985: 'Ampliar',
        10986: 'Reducir',
        11047: 'Centrar el mapa aquí',
        11089: '\x3ca href\x3d\x22javascript:void(0);\x22\x3eAcercar\x3c/a\x3e para ver el tráfico de esta zona',
        11259: 'Pantalla completa',
        11751: 'Mostrar callejero con relieve',
        11752: 'Estilo:',
        11757: 'Cambiar estilo del mapa',
        11758: 'Relieve',
        11759: 'Terr.',
        11794: 'Superponer callejero',
        11303: 'Ayuda de Street View',
        11274: 'Para usar Street View necesitas Adobe Flash Player, versión %1$d o posterior.',
        11382: 'Consigue la última versión de Flash Player.',
        11314: 'Disculpa las molestias. Street View no está disponible en este momento debido a que el sistema experimenta una gran demanda.\x3cbr\x3eInténtalo de nuevo más tarde.',
        1559: 'N',
        1560: 'S',
        1561: 'O',
        1562: 'E',
        1608: 'NO',
        1591: 'NE',
        1605: 'SO',
        1606: 'SE',
        11907: 'Esta imagen ya no está disponible',
        10041: 'Ayuda',
        12471: 'Ubicación actual',
        12492: 'Earth',
        12823: 'Google ha deshabilitado el uso del API de Google Maps para esta aplicación. Para obtener más información, consulta las Condiciones del servicio: %1$s.',
        12822: 'http://code.google.com/apis/maps/terms.html',
        12915: 'Mejorar el mapa',
        12916: 'Google, Europa Technologies',
        13171: 'Híbrido 3D',
        0: ''
    });
}
var GLoad;
(function() {
    GLoad = function(apiCallback) {
        var callee = arguments.callee;
        GApiInit();
        var opts = {
            export_legacy_names:true,
            tile_override:[{
                maptype:0,
                min_zoom:"7",
                max_zoom:"7",
                rect:[{
                    lo:{
                        lat_e7:330000000,
                        lng_e7:1246050000
                    },
                    hi:{
                        lat_e7:386200000,
                        lng_e7:1293600000
                    }
                },{
                lo:{
                    lat_e7:366500000,
                    lng_e7:1297000000
                },
                hi:{
                    lat_e7:386200000,
                    lng_e7:1314843700
                }
            }],
        uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26"]
        },{
        maptype:0,
        min_zoom:"8",
        max_zoom:"8",
        rect:[{
            lo:{
                lat_e7:330000000,
                lng_e7:1246050000
            },
            hi:{
                lat_e7:386200000,
                lng_e7:1279600000
            }
        },{
        lo:{
            lat_e7:345000000,
            lng_e7:1279600000
        },
        hi:{
            lat_e7:386200000,
            lng_e7:1286700000
        }
    },{
    lo:{
        lat_e7:354690000,
        lng_e7:1286700000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26"]
},{
    maptype:0,
    min_zoom:"9",
    max_zoom:"9",
    rect:[{
        lo:{
            lat_e7:330000000,
            lng_e7:1246050000
        },
        hi:{
            lat_e7:386200000,
            lng_e7:1279600000
        }
    },{
    lo:{
        lat_e7:340000000,
        lng_e7:1279600000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1286700000
    }
},{
    lo:{
        lat_e7:348900000,
        lng_e7:1286700000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1302000000
    }
},{
    lo:{
        lat_e7:368300000,
        lng_e7:1302000000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26"]
},{
    maptype:0,
    min_zoom:"10",
    max_zoom:"19",
    rect:[{
        lo:{
            lat_e7:329890840,
            lng_e7:1246055600
        },
        hi:{
            lat_e7:386930130,
            lng_e7:1284960940
        }
    },{
    lo:{
        lat_e7:344646740,
        lng_e7:1284960940
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1288476560
    }
},{
    lo:{
        lat_e7:350277470,
        lng_e7:1288476560
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1310531620
    }
},{
    lo:{
        lat_e7:370277730,
        lng_e7:1310531620
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1.17\x26hl=es\x26src=api\x26"]
},{
    maptype:3,
    min_zoom:"7",
    max_zoom:"7",
    rect:[{
        lo:{
            lat_e7:330000000,
            lng_e7:1246050000
        },
        hi:{
            lat_e7:386200000,
            lng_e7:1293600000
        }
    },{
    lo:{
        lat_e7:366500000,
        lng_e7:1297000000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26"]
},{
    maptype:3,
    min_zoom:"8",
    max_zoom:"8",
    rect:[{
        lo:{
            lat_e7:330000000,
            lng_e7:1246050000
        },
        hi:{
            lat_e7:386200000,
            lng_e7:1279600000
        }
    },{
    lo:{
        lat_e7:345000000,
        lng_e7:1279600000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1286700000
    }
},{
    lo:{
        lat_e7:354690000,
        lng_e7:1286700000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26"]
},{
    maptype:3,
    min_zoom:"9",
    max_zoom:"9",
    rect:[{
        lo:{
            lat_e7:330000000,
            lng_e7:1246050000
        },
        hi:{
            lat_e7:386200000,
            lng_e7:1279600000
        }
    },{
    lo:{
        lat_e7:340000000,
        lng_e7:1279600000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1286700000
    }
},{
    lo:{
        lat_e7:348900000,
        lng_e7:1286700000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1302000000
    }
},{
    lo:{
        lat_e7:368300000,
        lng_e7:1302000000
    },
    hi:{
        lat_e7:386200000,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26"]
},{
    maptype:3,
    min_zoom:"10",
    rect:[{
        lo:{
            lat_e7:329890840,
            lng_e7:1246055600
        },
        hi:{
            lat_e7:386930130,
            lng_e7:1284960940
        }
    },{
    lo:{
        lat_e7:344646740,
        lng_e7:1284960940
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1288476560
    }
},{
    lo:{
        lat_e7:350277470,
        lng_e7:1288476560
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1310531620
    }
},{
    lo:{
        lat_e7:370277730,
        lng_e7:1310531620
    },
    hi:{
        lat_e7:386930130,
        lng_e7:1314843700
    }
}],
uris:["http://mt0.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt1.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt2.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26","http://mt3.gmaptiles.co.kr/mt/v=kr1p.17\x26hl=es\x26src=api\x26"]
}],
jsmain:"http://maps.gstatic.com/intl/es_ALL/mapfiles/400d/maps2.api/main.js",
bcp47_language_code:"es",
obliques_urls:["http://khm0.googleapis.com/kh?v=65\x26src=app\x26","http://khm1.googleapis.com/kh?v=65\x26src=app\x26"],
token:"3557517872",
jsmodule_base_url:"http://maps.gstatic.com/intl/es_ALL/mapfiles/400d/maps2.api",
generic_tile_urls:["http://mt0.googleapis.com/vt?hl=es\x26src=api\x26","http://mt1.googleapis.com/vt?hl=es\x26src=api\x26"],
ignore_auth:false,
sv_host:"http://cbk0.google.com"
};

apiCallback(["http://mt0.googleapis.com/vt/lyrs\x3dm@196000000\x26hl\x3des\x26src\x3dapi\x26","http://mt1.googleapis.com/vt/lyrs\x3dm@196000000\x26hl\x3des\x26src\x3dapi\x26"], ["http://khm0.googleapis.com/kh/v\x3d121\x26src\x3dapp\x26","http://khm1.googleapis.com/kh/v\x3d121\x26src\x3dapp\x26"], ["http://mt0.googleapis.com/vt/lyrs\x3dh@196000000\x26hl\x3des\x26src\x3dapi\x26","http://mt1.googleapis.com/vt/lyrs\x3dh@196000000\x26hl\x3des\x26src\x3dapi\x26"],""  ,""  ,""  ,true,"google.maps.",opts,["http://mt0.googleapis.com/vt/lyrs\x3dt@129,r@196000000\x26hl\x3des\x26src\x3dapi\x26","http://mt1.googleapis.com/vt/lyrs\x3dt@129,r@196000000\x26hl\x3des\x26src\x3dapi\x26"]);
if (!callee.called) {
    callee.called = true;
}
}
})();
function GUnload() {
    if (window.GUnloadApi) {
        GUnloadApi();
    }
}
var _mIsRtl = false;
var _mHost = "http://maps.google.com";
var _mUri = "/maps";
var _mDomain = "google.com";
var _mStaticPath = "http://maps.gstatic.com/intl/es_ALL/mapfiles/";
var _mJavascriptVersion = G_API_VERSION = "400d";
var _mTermsUrl = "http://www.google.com/intl/es_ALL/help/terms_maps.html";
var _mLocalSearchUrl = "http://www.google.com/uds/solutions/localsearch/gmlocalsearch.js";
var _mHL = "es";
var _mGL = "";
var _mTrafficEnableApi = true;
var _mTrafficTileServerUrls = ["http://mt0.google.com/mapstt","http://mt1.google.com/mapstt","http://mt2.google.com/mapstt","http://mt3.google.com/mapstt"];
var _mCityblockLatestFlashUrl = "http://maps.google.com/local_url?dq=&amp;q=http://www.adobe.com/shockwave/download/download.cgi%3FP1_Prod_Version%3DShockwaveFlash&amp;s=ANYYN7lCgR1J0Lu7tVcPbijNF_TKW5wcqQ";
var _mCityblockFrogLogUsage = false;
var _mCityblockInfowindowLogUsage = false;
var _mCityblockUseSsl = false;
var _mSatelliteToken = "fzwq1BtIu22OvJHtu3YUyPljUXqJchkNVK3Hlw";
var _mMapCopy = "Datos de mapa \x26#169;2012";
var _mSatelliteCopy = "Imágenes \x26#169;2012";
var _mGoogleCopy = "\x26#169;2012 Google";
var _mPreferMetric = false;
var _mDirectionsEnableApi = true;
var _mLayersTileBaseUrls = ['http://mt0.google.com/mapslt','http://mt1.google.com/mapslt','http://mt2.google.com/mapslt','http://mt3.google.com/mapslt'];
var _mLayersFeaturesBaseUrl = "http://mt0.google.com/vt/ft";
function GLoadMapsScript() {
    if (!GLoadMapsScript.called && GBrowserIsCompatible()) {
        GLoadMapsScript.called = true;
        GScript("http://maps.gstatic.com/intl/es_ALL/mapfiles/400d/maps2.api/main.js");
    }
}(function() {
    if (!window.google) window.google = {};
        
    if (!window.google.maps) window.google.maps = {};
        
    var ns = window.google.maps;
    ns.BrowserIsCompatible = GBrowserIsCompatible;
    ns.Unload = GUnload;
})();

function getRoute(from, to) {
                            var gdir=new GDirections();
                            gdir.load("from: "+from+" to: "+to,
                            { "locale": "es", "travelMode" : G_TRAVEL_MODE_DRIVING });
                            var drivingDistanceKilometers = gdir.getDistance().meters / 1000;
                            return drivingDistanceKilometers;
                        }
                        
GLoadMapsScript();