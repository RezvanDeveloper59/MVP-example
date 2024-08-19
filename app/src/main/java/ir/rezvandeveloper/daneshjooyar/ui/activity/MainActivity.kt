package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ir.rezvandeveloper.daneshjooyar.DarbareMaFragment
import ir.rezvandeveloper.daneshjooyar.HomeFragment
import ir.rezvandeveloper.daneshjooyar.MadarekFragment
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.databinding.ActivityMainBinding
import ir.rezvandeveloper.daneshjooyar.ext.extClass

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val view = ViewHomeActivity(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarHome.ivBack.setOnClickListener {
            finish()
        }

        binding.toolbarHome.ivSupport.setOnClickListener {
            extClass.dialogSupport(this)
        }

        /*val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHost.findNavController())*/

        //binding.bottomNav.menu.getItem(0).isChecked = true

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, HomeFragment(this))
            .commit()

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> {
                    replaceFragment(HomeFragment(this))
                    true
                }

                R.id.about_ma_menu -> {
                    replaceFragment(DarbareMaFragment(this))
                    true
                }

                R.id.madarek_menu -> {
                    replaceFragment(MadarekFragment(this))
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}