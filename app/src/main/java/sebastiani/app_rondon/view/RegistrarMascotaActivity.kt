package sebastiani.app_rondon.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registrar_mascota.*
import sebastiani.app_rondon.Model.Mascota
import sebastiani.app_rondon.R

class RegistrarMascotaActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etColor: EditText
    private lateinit var etDueno: EditText
    private lateinit var btnSave: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_mascota)

        etNombre = findViewById(R.id.etnombre)
        etEdad = findViewById(R.id.etedad)
        etColor = findViewById(R.id.etcolor)
        etDueno = findViewById(R.id.etdueño)
        btnSave = findViewById(R.id.btn_add)

        dbRef = FirebaseDatabase.getInstance().getReference("Mascotas")

        btn_add.setOnClickListener{
            saveMascotaData()
        }
    }

    private fun saveMascotaData(){
        val nommascota = etNombre.text.toString()
        val edmascota = etEdad.text.toString()
        val colmascota = etColor.text.toString()
        val duemascota = etDueno.text.toString()

        if(nommascota.isEmpty()){
            etNombre.error = "Ingrese nombre de su mascota"
        }
        if(edmascota.isEmpty()){
            etEdad.error = "Ingrese edad de su mascota"
        }
        if(colmascota.isEmpty()){
            etColor.error = "Ingrese color de pelaje de mascota"
        }
        if(duemascota.isEmpty()){
            etDueno.error = "Ingrese dueño de mascota"
        }

        val mascotaid = dbRef.push().key!!

        val mascota = Mascota(mascotaid, nommascota, edmascota,colmascota, duemascota)

        dbRef.child(mascotaid).setValue(mascota).addOnCompleteListener{
            Toast.makeText(this,"Mascota registrada exitosamente", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{ err ->
            Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
        }
    }

}