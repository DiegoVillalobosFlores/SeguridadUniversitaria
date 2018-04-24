package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable

data class Atracante (var cara:String = "",
                      var edad:String = "",
                      var estatura:String = "",
                      var senas:String = "",
                      var boca:String = "",
                      var tez:String = "",
                      var cabelloTipo:String = "",
                      var cabelloColor:String = "",
                      var ojosTipo:String = "",
                      var ojosColor:String = "",
                      var gorra:String = "",
                      var ropa:String = "",
                      var cicatrices:String = "",
                      var tatuajes:String = "",
                      var piercing: String = "",
                      var detenido:Boolean = false,
                      var observaciones:String = "") : Serializable