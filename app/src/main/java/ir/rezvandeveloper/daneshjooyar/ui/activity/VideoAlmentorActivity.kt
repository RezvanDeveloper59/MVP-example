package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.databinding.ActivityVideoAlmentorBinding
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyarv.dp.dao.PishraftDao

class VideoAlmentorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoAlmentorBinding
    private lateinit var videoView: VideoView
    private var pishraft = 0
    private var position = 0
    private var currentPosition = 0
    private var id: Int = 0
    private lateinit var sarFasl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoAlmentorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra("id", 1)
        sarFasl = intent.getStringExtra("name").toString()

        binding.tvSarfastVideoAlmentor.text = sarFasl

        // در اینجا متغیر videoView را مقدار دهی میکنیم
        videoView = binding.videoViewAlmentor

        // این تابع برای مقدار دهی و راه اندازی videoView میباشد
        initVideoView()

        val db = DBHelper(this)
        val pishraftDao = PishraftDao(db)
        val l: List<Pishraft> = pishraftDao.findByColumn("id", "1")
        if (l.isEmpty()) {
            pishraftDao.save(Pishraft(0, "test", 0))
            pishraftDao.save(Pishraft(1, "test", 0))
            pishraftDao.save(Pishraft(2, "test", 0))
            pishraftDao.save(Pishraft(3, "test", 0))
            pishraftDao.save(Pishraft(4, "test", 0))
        }
    }

    private fun initVideoView() {

        // اینجا میتوانیم آدرس ویدیو در پوشه raw و یا آدرس اینترنتی ویدیو را وارد کنیم
        val uri = Uri.parse("android.resource://$packageName/${R.raw.test_video}")

        // در اینجا یک کنترل کننده ویدیو برای videoView ایجاد میکنیم
        val mediaController = MediaController(this)

        // در این بخش videoView خود را start میکنیم
        // برای جلوگیری از خطاهای احتمالی از try استفاده شده است
        try {
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(uri)
            videoView.start()
        } catch (e: Exception) {
            Log.e("Error", e.message ?: "Error")
        }

        // این شنونده زمانی که videoView آماده اجرا شده باشد، صدا زده میشود
        videoView.setOnPreparedListener {


            it.setOnVideoSizeChangedListener { _, _, _ ->
                mediaController.setAnchorView(videoView)

                val db = DBHelper(this)
                val pishraftDao = PishraftDao(db)

                //https://stackoverflow.com/questions/55570990/kotlin-call-a-function-every-second
                val mainHandler = Handler(Looper.getMainLooper())

                val darsadeDuration = videoView.duration / 1000 / 100f

                mainHandler.post(object : Runnable {
                    override fun run() {
                        binding.progressBar.max = videoView.duration / 1000
                        binding.progressBar.progress = videoView.currentPosition / 1000
                        if (videoView.isPlaying) {
                            pishraft = pishraft + 1
                            val darsadePishraft = Math.round(pishraft / darsadeDuration)
                            binding.tvDarsadPishraft.text = darsadePishraft.toString() + "/100%"

                            currentPosition = videoView.currentPosition

                            pishraftDao.edit(id.toString(), Pishraft(id, sarFasl, darsadePishraft))
                        }
                        mainHandler.postDelayed(this, 1000)
                    }
                })
            }

        }
    }

    // زمانیکه کاربر صفحه را بچرخاند این متد اجرا می شود
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position", currentPosition)
    }

    // وقتی گوشی چرخید این متد اجرا می شود
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        position = savedInstanceState.getInt("position")
        videoView.seekTo(position)
        Log.i("TAG", "onRestoreInstanceState: " + position)
    }
}