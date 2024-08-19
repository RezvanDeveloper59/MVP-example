package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ir.rezvandeveloper.daneshjooyar.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginOk.setOnClickListener {

            val phoneNumber = binding.etInputUsername.text?.trim().toString()

            if (isValidPhoneNumber(phoneNumber) && isMobileAhmadi(phoneNumber)) {
                val intent = Intent(this, LoginCodeActivity::class.java)
                startActivity(intent)
                finish()
                //binding.tvCheckMobile.visibility = View.GONE
            } else {
                binding.tvCheckMobile.visibility = View.VISIBLE
            }
        }
    }

    // chatGPT
    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // الگوی منظم برای شماره موبایل (برای مثال: 09123456789)
        val regex = Regex("^09\\d{9}\$") // تغییر دهید به الگوی مورد نظر شما
        return regex.matches(phoneNumber)
    }

    fun isMobileAhmadi(mobile: String): Boolean {
        if (mobile.equals("09059214470"))
            return true
        return false
    }
}