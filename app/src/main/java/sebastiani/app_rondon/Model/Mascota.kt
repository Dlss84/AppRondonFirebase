package sebastiani.app_rondon.Model

data class Mascota(
    var mascotaid: String?=null,
    var nommascota: String?= null,
    var edmascota: String?=null,
    var colmascota: String?=null,
    var duemascota: String?=null
){
    constructor():this("","","","",""){

    }
}
