package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable

data class Incidente (var local : Boolean = false,
                      var lat : Double = 0.0,
                      var lon : Double = 0.0,
                      var metropolitan: Boolean = false,
                      var city:String = "",
                      var location_description:String = "",
                      var num_victims: Int = 1,
                      var type:String = "",
                      var description:String = "",
                      var escapeMethod:String = "",
                      var suspects:ArrayList<Atracante> = ArrayList()) : Serializable