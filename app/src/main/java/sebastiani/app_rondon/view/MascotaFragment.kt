package sebastiani.app_rondon.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import sebastiani.app_rondon.Adapter.MascotaAdapter
import sebastiani.app_rondon.Model.Mascota
import sebastiani.app_rondon.R

class MascotaFragment : Fragment() {

    /*private lateinit var btnMascota:FloatingActionButton
    private lateinit var listMascota:ListView
    private lateinit var ref: DatabaseReference
    private lateinit var mascotalist: MutableList<Mascota>
    */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mascota, container, false)

        return view
    }
        /*ref= FirebaseDatabase.getInstance().getReference("Mascotas")
        btnMascota = view.findViewById(R.id.btn_mascota)
        listMascota = view.findViewById(R.id.lv_data)
        val appContext = context!!.applicationContext

        btnMascota.setOnClickListener{
            val intent = Intent(this@MascotaFragment.requireContext(), RegistrarMascotaActivity::class.java)
            startActivity(intent)
        }


        mascotalist = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    mascotalist.clear()
                    for(h in snapshot.children){
                        val mas = h.getValue(Mascota::class.java)
                        if(mas != null){
                            mascotalist.add(mas)
                        }
                    }
                    val adapter = MascotaAdapter(appContext, R.layout.item_mascota, mascotalist)
                    listMascota.adapter= adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        */





    /*
    * redireccionar las opciones del menu
validar campos
solo especialidades - OK
boton de cerrar sesion
    * */

}