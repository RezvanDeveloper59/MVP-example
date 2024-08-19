package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ir.rezvandeveloper.daneshjooyar.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // در بخش زیر، نوار وضعیت یا statusBar را مخفی میکنیم
        // این if به جهت بررسی نسخه api گوشی کاربر میباشد
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            // https://stackoverflow.com/questions/66075399/how-do-i-hide-the-status-bar-in-my-android-11-app
            window.decorView.windowInsetsController!!.hide(
                android.view.WindowInsets.Type.statusBars()
            )

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {

            // اگر api گوشی 28 یا بالاتر بود ازین کد ها استفاده میشود
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            val attrib = window.attributes
            attrib.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES

        } else {

            // چنانچه api پایین تر از نسخه 30 بود از این کد استفاده خواهد شد
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        if (isInternetNetwork()) {
            Handler(Looper.getMainLooper()).postDelayed({

                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)

                finish()

            }, 1000)

        } else {

            val dialog = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.no_connect_internet_dialog, null)
            dialog.setView(view)
            view.findViewById<Button>(R.id.btn_wifi).setOnClickListener {

                // of chatGPT
                val intent = Intent(WifiManager.ACTION_PICK_WIFI_NETWORK)
                recreate()
                startActivity(intent)

            }

            view.findViewById<Button>(R.id.btn_data).setOnClickListener {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {

                    // of chatGPT
                    val intent = Intent(Settings.ACTION_DATA_USAGE_SETTINGS)
                    recreate()
                    startActivity(intent)

                } else {

                    val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(intent)

                }
            }

            dialog.setOnCancelListener {
                recreate()
            }

            dialog.create()
            dialog.show()
        }

    }

    private fun isInternetNetwork(): Boolean {
        var result = false

        var connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            val netInfo = connectivityManager.activeNetworkInfo
            result = when (netInfo?.type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }
        }
        return result
    }
}