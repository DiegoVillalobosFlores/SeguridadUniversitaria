package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable

/**
 * Created by deimi on 2/8/2018.
 */

data class Usuario(var estatus: String = "",
                   var codigo: String = "",
                   var name: String = "",
                   var centro: String = "",
                   var carrera: String = "",
                   var institution: String = "",
                   var telCasa: String = "",
                   var telCel: String = "",
                   var email: String = "",
                   var gender: String = "") : Serializable