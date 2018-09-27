package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable

/**
 * Created by deimi on 2/8/2018.
 */

data class Usuario(var estatus: String = "",
                   var codigo: String = "",
                   var Nombre: String = "",
                   var Sede: String = "",
                   var carrera: String = "",
                   var institution: String = "",
                   var Telefono: String = "",
                   var Celular: String = "",
                   var Email: String = "",
                   var Sexo: String = "",
                   var EsPreparatoria: String = "0",
                   var EsCentroUniversitario: String = "1",
                   var EsDependencia:String = "0",
                   var EscuelaId: String = "0",
                   var Edad:String = "0",
                   var Grado: String = "",
                   var Grupo: String = "",
                   var Turno: String = "") : Serializable