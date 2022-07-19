package sebastiani.app_rondon.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registrar_mascota.*
import sebastiani.app_rondon.Model.Citas
import sebastiani.app_rondon.R

class RegistrarCitas : AppCompatActivity() {

    private lateinit var etNombreMascota: EditText
    private lateinit var etDueno: EditText
    private lateinit var etFecha: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var btnSave: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_citas)

        etNombreMascota = findViewById(R.id.etmascota)
        etDueno = findViewById(R.id.etedueno)
        etFecha = findViewById(R.id.etfecha)
        etDescripcion = findViewById(R.id.etdescripcion)
        btnSave = findViewById(R.id.btn_add)

        dbRef = FirebaseDatabase.getInstance().getReference("Citas")

        btn_add.setOnClickListener{
            saveMascotaData()
        }
    }
    private fun saveMascotaData(){
        val nommascota = etNombreMascota.text.toString()
        val dueno = etDueno.text.toString()
        val fecha = etFecha.text.toString()
        val descripcion = etDescripcion.text.toString()

        if(nommascota.isEmpty()){
            etNombreMascota.error = "Ingrese nombre de su mascota"
        }
        if(dueno.isEmpty()){
            etDueno.error = "Ingrese nombre del dueño"
        }
        if(fecha.isEmpty()){
            etFecha.error = "Ingrese la fechaa"
        }
        if(descripcion.isEmpty()){
            etDescripcion.error = "Ingrese nota u observacion"
        }

        val citaid = dbRef.push().key!!

        val cita = Citas(citaid, nommascota, dueno,fecha, descripcion)

        dbRef.child(citaid).setValue(cita).addOnCompleteListener{
            Toast.makeText(this,"Cita registrada exitosamente", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{ err ->
            Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
        }
    }
}