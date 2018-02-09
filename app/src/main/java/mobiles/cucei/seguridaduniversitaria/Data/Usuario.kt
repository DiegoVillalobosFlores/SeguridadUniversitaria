package mobiles.cucei.seguridaduniversitaria.Data

import java.io.Serializable

/**
 * Created by deimi on 2/8/2018.
 */

data class Usuario(val estatus: String,val codigo: String, val name: String, val centro: String, val carrera: String) : Serializable