package ir.rezvandeveloper.daneshjooyar.view

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import ir.amozeshgam.tablayout.InfoEteelaatFragment
import ir.amozeshgam.tablayout.VideosEteelaatFragment
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatAmoozeshAlmentor
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatInfo
import ir.rezvandeveloper.daneshjooyar.databinding.ActivityEteelaatBinding
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData

class ViewEteelaatActivity(
    private val context: Context,
    private val fragmentManager: FragmentManager
) {

    val binding =
        ActivityEteelaatBinding.inflate(LayoutInflater.from(context))

    fun initInfo(
        data: ArrayList<DataEteelaatInfo>,
        dataAlmentor: ArrayList<DataEteelaatAmoozeshAlmentor>,
        onBindData: OnBindData
    ) {

        fragmentManager.beginTransaction().replace(R.id.frameLayout, InfoEteelaatFragment(data))
            .commit()

        //binding.tabLayoutEteelaat.setScrollPosition(1, 0f, false)

        // در اینجا listener مربوط به انتخاب آیتم های tabLayout را به view خود اضافه میکنیم
        binding.tabLayoutEteelaat.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {

            // این متد، زمانی که یکی از آیتم های tabLayout انتخاب شود، اجرا میشود
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // اینجا بر اساس انتخاب کاربر، فرگمنت ها را به replaceFragment میفرستیم
                when (tab?.position) {
                    0 -> replaceFragment(
                        VideosEteelaatFragment(
                            context,
                            dataAlmentor,
                            onBindData
                        )
                    )

                    1 -> replaceFragment(InfoEteelaatFragment(data))
                }
            }

            // این متد، زمانی که یکی از آیتم های tabLayout از حالت انتخاب خارج شود، اجرا میشود
            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            // این متد، زمانی که یکی از آیتم های tabLayout مجددا انتخاب شود، اجرا میشود
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

    }

    // این متد مسئول جایگزین کردن فرگمنت ها بر اساس انتخاب کاربر میباشد
    private fun replaceFragment(fragment: Fragment) {
        // کد مربوط به جایگزینی فرگمنت ها
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    /*fun init(dataAlmentor: ArrayList<DataEteelaatAmoozeshAlmentor>, onBindData: OnBindData) {
        replaceFragment(
            VideosEteelaatFragment(context, dataAlmentor, onBindData)
        )
    }*/
}