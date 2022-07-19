package sebastiani.app_rondon.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import sebastiani.app_rondon.Model.Mascota
import sebastiani.app_rondon.R

class MascotaAdapter( val mCtx : Context, val layoutResid: Int, val masList: List<Mascota>): ArrayAdapter<Mascota>(mCtx, layoutResid, masList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(layoutResid, null)

        val tvmascota : TextView = view.findViewById(R.id.tv_mascota)
        val tvedad : TextView = view.findViewById(R.id.tv_edad)
        val tvcolor : TextView = view.findViewById(R.id.tv_color)
        val tvdueno : TextView = view.findViewById(R.id.tv_dueno)

        val mascota = masList[position]

        tvmascota.text = mascota.nommascota
        tvedad.text = mascota.edmascota
        tvcolor.text = mascota.colmascota
        tvdueno.text = mascota.duemascota

        return view

    }
}