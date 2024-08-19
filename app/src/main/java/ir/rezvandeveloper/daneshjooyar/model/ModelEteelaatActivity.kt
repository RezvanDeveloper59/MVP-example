package ir.rezvandeveloper.daneshjooyar.model

import android.content.Context
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.adapter.RecyclerAlmentorAdapter
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatInfo
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatAmoozeshAlmentor
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyarv.dp.dao.PishraftDao

class ModelEteelaatActivity(val context: Context) {

    fun dataInfo(): ArrayList<DataEteelaatInfo> {
        return arrayListOf(
            DataEteelaatInfo(
                "57,703 نفر",
                "تعداد دانشجو",
                context.resources.getDrawable(R.drawable.eteelaat_a)
            ),
            DataEteelaatInfo(
                "4.5 از 5",
                "امتیاز دانشجویان",
                context.resources.getDrawable(R.drawable.eteelaat_b)
            ),
            DataEteelaatInfo(
                "26 عدد",
                "تعداد دوره ها",
                context.resources.getDrawable(R.drawable.eteelaat_c)
            ),
            DataEteelaatInfo(
                "26 ساعت",
                "ساعت آموزش",
                context.resources.getDrawable(R.drawable.eteelaat_d)
            )
        )
    }

    fun dataAmoozeshAlmentor(): ArrayList<DataEteelaatAmoozeshAlmentor> {
        return arrayListOf(
            DataEteelaatAmoozeshAlmentor(
                1,
                "المنتور چیست ؟ چرا باید از آن استفاده کنبم ؟",
                context.resources.getDrawable(R.drawable.amoozesh_almentor)
            ),
            DataEteelaatAmoozeshAlmentor(
                2,
                "نصب و راه اندازی المنتور",
                context.resources.getDrawable(R.drawable.amoozesh_almentor)
            ),
            DataEteelaatAmoozeshAlmentor(
                3,
                "افزایش محدوده حافظه PHP در وردپرس",
                context.resources.getDrawable(R.drawable.amoozesh_almentor)
            ),
            DataEteelaatAmoozeshAlmentor(
                4,
                "بررسی کامل المنتور رایگان و قابلیت های آن",
                context.resources.getDrawable(R.drawable.amoozesh_almentor)
            ),
            DataEteelaatAmoozeshAlmentor(
                5,
                "نکات حیات در استفاده از افزونه های غیر رایگان",
                context.resources.getDrawable(R.drawable.amoozesh_almentor)
            )
        )
    }

}