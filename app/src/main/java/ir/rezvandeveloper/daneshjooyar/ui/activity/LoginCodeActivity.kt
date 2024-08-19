package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.rezvandeveloper.daneshjooyar.databinding.ActivityLoginCodeBinding

class LoginCodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llVirayeshShomare.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLoginPassword.setOnClickListener{
            val password = binding.etPassword.text?.trim().toString()
            if (password.equals("12345")){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else
                Toast.makeText(this, "رمز اشتباه است .", Toast.LENGTH_SHORT).show()
        }
    }
}