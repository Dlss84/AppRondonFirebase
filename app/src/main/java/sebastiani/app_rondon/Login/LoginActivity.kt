package sebastiani.app_rondon.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import sebastiani.app_rondon.MenuPrincipalActivity
import sebastiani.app_rondon.R
import sebastiani.app_rondon.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        //Redireccionar a ResetPasswordActivity
        binding.tvForgotPass.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }


        //Redireccionar a RegisterActivity
        binding.tvRegister02.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {

            val correo = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            //VALIDACIÓN EMAIL
            if (correo.isEmpty()) {
                binding.etEmail.error = "Correo electrónico requerido"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN EMAIL NO COINCIDE
            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                binding.etEmail.error = "Correo Inválido"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            //VALIDACIÓN PASSWORD
            if (password.isEmpty()) {
                binding.etPassword.error = "Correo electrónico requerido"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }
            LoginFIrebas(correo, password)
        }
    }

    private fun LoginFIrebas(correo: String, password: String) {
        auth.signInWithEmailAndPassword(correo, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Bienvenido $correo", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MenuPrincipalActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}