package sebastiani.app_rondon.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import sebastiani.app_rondon.Model.Citas
import sebastiani.app_rondon.R

class CitaAdapter ( val mCtx : Context, val layoutResid: Int, val citList: List<Citas>): ArrayAdapter<Citas>(mCtx, layoutResid, citList) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

            val view : View = layoutInflater.inflate(layoutResid, null)

            val tvmascota : TextView = view.findViewById(R.id.tv_mascota)
            val tvdueno : TextView = view.findViewById(R.id.tv_dueno)
            val tvfecha : TextView = view.findViewById(R.id.tv_fecha)
            val tvdescripcion : TextView = view.findViewById(R.id.tv_descripcion)

            val cita = citList[position]

            tvmascota.text = cita.nommascota
            tvdueno.text = cita.dueno
            tvfecha.text = cita.fecha
            tvdescripcion.text = cita.descripcion

            return view

        }
}