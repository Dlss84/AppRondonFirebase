package sebastiani.app_rondon.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import sebastiani.app_rondon.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    lateinit var binding : ActivityResetPasswordBinding
    lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            val email=binding.etUserReset.text.toString()
            val userRegister = binding.etUserReset

            if (email.isEmpty()) {
                userRegister.error = "El correo electrónico no puede estar vacío"
                userRegister.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                userRegister.error = "Email inválido"
                userRegister.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {

                if (it.isSuccessful){
                    Toast.makeText(this, "Se ha enviado un correo electrónico de restablecimiento de contraseña", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}