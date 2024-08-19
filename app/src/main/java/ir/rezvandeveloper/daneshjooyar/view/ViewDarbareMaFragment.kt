package ir.rezvandeveloper.daneshjooyar.view

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import ir.rezvandeveloper.daneshjooyar.data.DataDarbareMaVizhegiha
import ir.rezvandeveloper.daneshjooyar.data.DataHeaderDarbareMa
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentDarbareMaBinding


class ViewDarbareMaFragment(
    private val context: Context
)  {

    //val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    val binding = FragmentDarbareMaBinding.inflate(LayoutInflater.from(context))

    fun initDataHeader(data: ArrayList<DataHeaderDarbareMa>) {

        binding.ivDarbareMaB.setImageDrawable(data[0].img)
        binding.tvDarbareMaBUp.text = data[0].name
        binding.tvDarbareMaBDown.text = data[0].name

        binding.ivDarbareMaA.setImageDrawable(data[1].img)
        binding.tvDarbareMaAUp.text = data[1].name
        binding.tvDarbareMaADown.text = data[1].name

        binding.ivDarbareMaD.setImageDrawable(data[2].img)
        binding.tvDarbareMaDUp.text = data[2].name
        binding.tvDarbareMaDDown.text = data[2].name

        binding.ivDarbareMaC.setImageDrawable(data[3].img)
        binding.tvDarbareMaCUp.text = data[3].name
        binding.tvDarbareMaCDown.text = data[3].name

    }

    fun initDataVizhegiha(data: ArrayList<DataDarbareMaVizhegiha>) {

        binding.ivDarbareMaModaresineMojarab.setImageDrawable(data[0].img)
        binding.tvDarbareMaModaresineMojarab.text = data[0].name

        binding.ivDarbareMaMadrakeDoZabane.setImageDrawable(data[1].img)
        binding.tvDarbareMaMadrakeDoZabane.text = data[1].name

        binding.ivDarbareMaKheyrieAmoozeshi.setImageDrawable(data[2].img)
        binding.tvDarbareMaKheyrieAmoozeshi.text = data[2].name

        binding.ivDarbareMaTakhasosMehvar.setImageDrawable(data[3].img)
        binding.tvDarbareMaTakhasosMehvar.text = data[3].name

    }

    fun openPageInInstagram() {

        binding.btnInstagram.setOnClickListener {
            val address = "https://www.instagram.com/Lrn.ir/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            intent.setPackage("com.instagram.android")

            // ممکن است هیچ نرم افزاری برای انجام کار مدنظر پیدا نشود
            // پس دلیل استفاده از try و catch نیز همین است تا برنامه متوقف نشود
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                val webpage: Uri = Uri.parse("https://www.instagram.com/Lrn.ir/")
                val intentWeb = Intent(Intent.ACTION_VIEW, webpage)

                // ممکن است هیچ نرم افزاری برای انجام کار مدنظر پیدا نشود
                // پس دلیل استفاده از try و catch نیز همین است تا برنامه متوقف نشود
                try {
                    context.startActivity(intentWeb)
                } catch (e: ActivityNotFoundException) {
                    Log.i("TAG", "openPageInInstagram: " + "no instagram page")
                }
            }
        }
    }

    fun openPageInYouTube() {
        binding.btnYouTube.setOnClickListener {

            //https://stackoverflow.com/questions/16510860/open-youtube-channel-calling-youtube-app-android
            val youtubeURL = "https://www.youtube.com/channel/UC3CgN2MN18jGoUjiPuIlHrw"
            var youtubeIntent: Intent?

            try {
                youtubeIntent = Intent(Intent.ACTION_VIEW)
                youtubeIntent.setPackage("com.google.android.youtube")
                youtubeIntent.setData(Uri.parse(youtubeURL))
                context.startActivity(youtubeIntent)
            } catch (e: ActivityNotFoundException) {
                youtubeIntent = Intent(Intent.ACTION_VIEW)
                youtubeIntent.setData(Uri.parse(youtubeURL))
                context.startActivity(youtubeIntent)
            }
        }
    }
}



