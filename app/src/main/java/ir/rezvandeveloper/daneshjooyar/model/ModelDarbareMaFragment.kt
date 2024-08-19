package ir.rezvandeveloper.daneshjooyar.model

import android.content.Context
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.data.DataDarbareMaVizhegiha
import ir.rezvandeveloper.daneshjooyar.data.DataHeaderDarbareMa

class ModelDarbareMaFragment(private val context: Context) {

    fun datadDarbareMaHeader():ArrayList<DataHeaderDarbareMa>{
        return arrayListOf(
            DataHeaderDarbareMa(
            "+400,000","تعداد کاربران",context.resources.getDrawable(R.drawable.darbare_ma_a)),
            DataHeaderDarbareMa(
                "+25,000","بازدید روزانه",context.resources.getDrawable(R.drawable.darbare_ma_b)),
            DataHeaderDarbareMa(
                "+500","تعداد مدرسین",context.resources.getDrawable(R.drawable.darbare_ma_c)),
            DataHeaderDarbareMa(
                "+2,000","تعداد دوذه ها",context.resources.getDrawable(R.drawable.darbare_ma_d)
        ))
    }

    fun datadDarbareMaVizhegiha():ArrayList<DataDarbareMaVizhegiha>{
        return arrayListOf(
            DataDarbareMaVizhegiha(
            "مدرک دو زبانه",context.resources.getDrawable(R.drawable.madrake_do_zabane)),
            DataDarbareMaVizhegiha(
                "مدرسین مجرب",context.resources.getDrawable(R.drawable.modaresine_mojarab)),
            DataDarbareMaVizhegiha(
                "دوره های تخصص محور",context.resources.getDrawable(R.drawable.dorehaye_takhasosi_mehvar)),
            DataDarbareMaVizhegiha(
                "خیریه آموزشی",context.resources.getDrawable(R.drawable.kheyriye_amozeshi)),
        )
    }
}