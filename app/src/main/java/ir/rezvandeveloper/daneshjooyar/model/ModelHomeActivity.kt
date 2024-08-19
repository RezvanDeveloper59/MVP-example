package ir.rezvandeveloper.daneshjooyar.model

import android.content.Context
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.data.DataHeaderRecyclerView
import ir.rezvandeveloper.daneshjooyar.data.DataHomeRecyclerView

class ModelHomeActivity(private val activity: Context) {

    fun dataHeaderHome(): ArrayList<DataHeaderRecyclerView> {
        return arrayListOf(
            DataHeaderRecyclerView(
                1,
                "طراحی سایت",
                activity.resources.getDrawable(R.drawable.baseline_app_shortcut_24)
            ),
            DataHeaderRecyclerView(
                2,
                "برنامه نویسی موبایل",
                activity.resources.getDrawable(R.drawable.baseline_android_24)
            ),
            DataHeaderRecyclerView(
                3,
                "هوش مصنوعی",
                activity.resources.getDrawable(R.drawable.baseline_assistant_24)
            ),
            DataHeaderRecyclerView(
                4,
                "طراحی نرم افزار ویندوز",
                activity.resources.getDrawable(R.drawable.baseline_archive_24)
            ),
            DataHeaderRecyclerView(
                5,
                "بازی سازی",
                activity.resources.getDrawable(R.drawable.baseline_airplay_24)
            ),
        )
    }

    fun dataHomeRV1(): ArrayList<DataHomeRecyclerView> {
        return arrayListOf(
            DataHomeRecyclerView(
                1,
                "آموزش راه اندازی کسب و کار اینترنتی ( رایگان و کاربردی )",
                activity.resources.getDrawable(R.drawable.home_rv_a)
            ),
            DataHomeRecyclerView(
                1,
                "آموزش راه اندازی کسب و کار اینترنتی ( رایگان و کاربردی )",
                activity.resources.getDrawable(R.drawable.home_rv_a)
            ),
            DataHomeRecyclerView(
                1,
                "آموزش راه اندازی کسب و کار اینترنتی ( رایگان و کاربردی )",
                activity.resources.getDrawable(R.drawable.home_rv_a)
            ),
            DataHomeRecyclerView(
                1,
                "آموزش راه اندازی کسب و کار اینترنتی ( رایگان و کاربردی )",
                activity.resources.getDrawable(R.drawable.home_rv_a)
            )
        )
    }

    fun dataHomeRV2(): ArrayList<DataHomeRecyclerView> {
        return arrayListOf(
            DataHomeRecyclerView(
                1,
                "دوره مستر تدوینگر آموزش پریمیر با بیش از 20 پروژه عملی ویژه بازار کار",
                activity.resources.getDrawable(R.drawable.home_rv_b)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مستر تدوینگر آموزش پریمیر با بیش از 20 پروژه عملی ویژه بازار کار",
                activity.resources.getDrawable(R.drawable.home_rv_b)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مستر تدوینگر آموزش پریمیر با بیش از 20 پروژه عملی ویژه بازار کار",
                activity.resources.getDrawable(R.drawable.home_rv_b)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مستر تدوینگر آموزش پریمیر با بیش از 20 پروژه عملی ویژه بازار کار",
                activity.resources.getDrawable(R.drawable.home_rv_b)
            )
        )
    }
    fun dataHomeRV3(): ArrayList<DataHomeRecyclerView> {
        return arrayListOf(
            DataHomeRecyclerView(
                1,
                "دوره مسترکدر پایتون ، 45 ساعت آموزش پایتون جامع در کاربردی ترین دوره فارسی",
                activity.resources.getDrawable(R.drawable.home_rv_c)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مسترکدر پایتون ، 45 ساعت آموزش پایتون جامع در کاربردی ترین دوره فارسی",
                activity.resources.getDrawable(R.drawable.home_rv_c)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مسترکدر پایتون ، 45 ساعت آموزش پایتون جامع در کاربردی ترین دوره فارسی",
                activity.resources.getDrawable(R.drawable.home_rv_c)
            ),
            DataHomeRecyclerView(
                1,
                "دوره مسترکدر پایتون ، 45 ساعت آموزش پایتون جامع در کاربردی ترین دوره فارسی",
                activity.resources.getDrawable(R.drawable.home_rv_c)
            )
        )
    }
    fun dataHomeRV4(): ArrayList<DataHomeRecyclerView> {
        return arrayListOf(
            DataHomeRecyclerView(
                1,
                "دوره جامع طراحی سایت با PHP ( مقدماتی تا پیشرفته )",
                activity.resources.getDrawable(R.drawable.home_rv_d)
            ),
            DataHomeRecyclerView(
                1,
                "دوره جامع طراحی سایت با PHP ( مقدماتی تا پیشرفته )",
                activity.resources.getDrawable(R.drawable.home_rv_d)
            ),
            DataHomeRecyclerView(
                1,
                "دوره جامع طراحی سایت با PHP ( مقدماتی تا پیشرفته )",
                activity.resources.getDrawable(R.drawable.home_rv_d)
            ),
            DataHomeRecyclerView(
                1,
                "دوره جامع طراحی سایت با PHP ( مقدماتی تا پیشرفته )",
                activity.resources.getDrawable(R.drawable.home_rv_d)
            )
        )
    }
    fun dataHomeRV5(): ArrayList<DataHomeRecyclerView> {
        return arrayListOf(
            DataHomeRecyclerView(
                1,
                "دوره طلایی آموزش بازی سازی با یونیتی ، عملی و پروژه محور",
                activity.resources.getDrawable(R.drawable.home_rv_e)
            ),
            DataHomeRecyclerView(
                1,
                "دوره طلایی آموزش بازی سازی با یونیتی ، عملی و پروژه محور",
                activity.resources.getDrawable(R.drawable.home_rv_e)
            ),
            DataHomeRecyclerView(
                1,
                "دوره طلایی آموزش بازی سازی با یونیتی ، عملی و پروژه محور",
                activity.resources.getDrawable(R.drawable.home_rv_e)
            ),
            DataHomeRecyclerView(
                1,
                "دوره طلایی آموزش بازی سازی با یونیتی ، عملی و پروژه محور",
                activity.resources.getDrawable(R.drawable.home_rv_e)
            )
        )
    }
}