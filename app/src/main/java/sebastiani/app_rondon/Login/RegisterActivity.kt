package sebastiani.app_rondon.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import sebastiani.app_rondon.Model.Usuario
import sebastiani.app_rondon.databinding.ActivityRegisterBinding
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityRegisterBinding
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvLoginHere02.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegistrar.setOnClickListener {
            val email = binding.etCorreo.text.toString()
            val pass = binding.etPassword.text.toString()
            val pass_conf = binding.etPasswordConfirm.text.toString()
            val name = binding.etNombre.text.toString()
            val lastname = binding.etApellido.text.toString()
            val n_documento = binding.etDNI.text.toString()
            val phone = binding.etTelefono.text.toString()
            val direction = binding.etDireccion.text.toString()

            val passwordRegex = Pattern.compile(
                "^" +
                        "(?=.*[-@#$%^&+=])" +     // Al menos 1 carácter especial
                        ".{7,}" +                // Al menos 4 caracteres
                        "$"
            )
            //VALIDACIÓN NOMBRE
            if (name.isEmpty()) {
                binding.etNombre.error = "Nombres requerido"
                binding.etNombre.requestFocus()
                return@setOnClickListener
            }
            //VALIDACIÓN APELLIDO
            if (lastname.isEmpty()) {
                binding.etApellido.error = "Apellidos requerido"
                binding.etApellido.requestFocus()
                return@setOnClickListener
            }
            //VALIDACIÓN EMAIL
            if (email.isEmpty()) {
                binding.etCorreo.error = "Correo electrónico requerido"
                binding.etCorreo.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN EMAIL NO COINCIDE
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etCorreo.error = "Correo Inválido"
                binding.etCorreo.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN PASSWORD
            if (pass.isEmpty() || !passwordRegex.matcher(pass_conf).matches()) {
                binding.etPassword.error = "La Contraseña debe de tener algun carácter especial"
                binding.etPassword.requestFocus()
                //Toast.makeText(this,"La Contraseña es Débil", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            //VALIDACIÓN PASSWORD
            if (pass_conf.isEmpty()) {
                binding.etPasswordConfirm.error = "Repita su Password"
                binding.etPasswordConfirm.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN PASSWORD Y PASSWORD CONFIRM IGUALES
            if (pass != pass_conf) {
                Toast.makeText(this, "Las Contraseñas no Coinciden", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //VALIDACIÓN PASSWORD LONGITUD
            /*
            if (pass.length < 10) {
                binding.etPassword.error = "El Password debe tener mínimo 10 Caracteres"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }*/
            //VALIDACIÓN Nª DOCUMENTO
            if (n_documento.isEmpty()) {
                binding.etDNI.error = "Nª Documento requerido"
                binding.etDNI.requestFocus()
                return@setOnClickListener
            }
            //VALIDACIÓN Nª DOCUMENTO LONGITUD
            if (n_documento.length < 8) {
                binding.etDNI.error = "El Nª Documento debe tener mínimo 8 Caracteres"
                binding.etDNI.requestFocus()
                return@setOnClickListener
            }
            //VALIDACIÓN Nª TELEFONO
            if (n_documento.isEmpty()) {
                binding.etTelefono.error = "Nª Documento requerido"
                binding.etTelefono.requestFocus()
                return@setOnClickListener
            }
            //VALIDACIÓN Nª TELEFONO LONGITUD

            if (n_documento.length < 9) {
                binding.etTelefono.error = "El Nª de teléfono debe tener mínimo 9 Caracteres"
                binding.etTelefono.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN Nª DIRECCION
            if (n_documento.isEmpty()) {
                binding.etDireccion.error = "Direción requerida"
                binding.etDireccion.requestFocus()
                return@setOnClickListener
            }


            RegisterFirebase(email, pass)

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = Usuario(name, lastname, email, pass, n_documento, phone, direction)
            database.child(name).setValue(User).addOnSuccessListener {

                limpiar_campos()

                Toast.makeText(this, "Registro Realizado", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun RegisterFirebase(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }


    private fun limpiar_campos() {

        binding.etNombre.text.clear()
        binding.etApellido.text.clear()
        binding.etCorreo.text.clear()
        binding.etPassword.text?.clear()
        binding.etPasswordConfirm.text?.clear()
        binding.etDNI.text?.clear()
        binding.etTelefono.text?.clear()
        binding.etDireccion.text.clear()
    }

}