package sebastiani.app_rondon.Model

data class Citas(
    var citaid: String?=null,
    var nommascota: String? = null,
    var dueno: String? = null,
    var fecha: String? = null,
    var descripcion: String? = null
){
    constructor():this("","","","",""){

    }
}
