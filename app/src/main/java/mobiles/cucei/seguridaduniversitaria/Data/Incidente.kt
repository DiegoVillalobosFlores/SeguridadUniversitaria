package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable
import java.util.*

data class Incidente (var EsInterno : Boolean = false,
                      var Latitude : Double = 0.0,
                      var Longitude : Double = 0.0,
                      var Esinterno: String = "1",
                      var EnZonaMetropilitana: String = "0",
                      var Municipio:String = "",
                      var location_description:String = "",
                      var NumeroAgraviados: Int = 1,
                      var type:String = "",
                      var Descripcion:String = "",
                      var MedioHuida:String = "",
                      var escapeDetails:String = "",
                      var detained:Int = 0,
                      var Fecha:String = "",
                      var Robo:String = "0",
                      var QueRoban:String = "0",
                      var DelitosSexuales:String = "0",
                      var Lesiones:String = "0",
                      var Extorsion: String = "0",
                      var AlcoholDrogas: String = "0",
                      var TentativaPrivacionLibertad:String = "0",
                      var Other:String = "0",
                      val Incidente:String = "1",
                      var NumeroAgresores:String = "1",
                      var NumeroDetenidos:String = "0"): Serializable