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
import sebastiani.app_rondon.Adapter.CitaAdapter
import sebastiani.app_rondon.Model.Citas
import sebastiani.app_rondon.R


class CitasFragment : Fragment() {

    private lateinit var btnMascota: FloatingActionButton
    private lateinit var listCita: ListView
    private lateinit var ref: DatabaseReference
    private lateinit var citalist: MutableList<Citas>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_citas, container, false)
        ref= FirebaseDatabase.getInstance().getReference("Citas")
        btnMascota = view.findViewById(R.id.btn_mascota)
        listCita = view.findViewById(R.id.lv_data1)
        val appContext = context!!.applicationContext

        btnMascota.setOnClickListener{
            val intent = Intent(this@CitasFragment.requireContext(), RegistrarCitas::class.java)
            startActivity(intent)
        }
        citalist = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    citalist.clear()
                    for(h in snapshot.children){
                        val c = h.getValue(Citas::class.java)
                        if(c != null){
                            citalist.add(c)
                        }
                    }
                    val adapter = CitaAdapter(appContext, R.layout.item_cita, citalist)
                    listCita.adapter= adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return view
    }

}