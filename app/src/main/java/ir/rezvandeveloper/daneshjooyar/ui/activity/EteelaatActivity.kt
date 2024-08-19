package ir.rezvandeveloper.daneshjooyar.ui.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import ir.rezvandeveloper.daneshjooyar.R
import ir.rezvandeveloper.daneshjooyar.ext.extClass
import ir.rezvandeveloper.daneshjooyar.model.ModelEteelaatActivity
import ir.rezvandeveloper.daneshjooyar.presenter.PresenterEteelaatActivity
import ir.rezvandeveloper.daneshjooyar.view.ViewEteelaatActivity

class EteelaatActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterEteelaatActivity

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewEteelaatActivity(this, supportFragmentManager)
        setContentView(view.binding.root)

        presenter = PresenterEteelaatActivity(view, ModelEteelaatActivity(this), this)
        presenter.onCreate()

        view.binding.toolbarEteelaat.ivBack.setOnClickListener {
            finish()
        }

        view.binding.toolbarEteelaat.ivSupport.setOnClickListener {
            extClass.dialogSupport(this)
        }

        // در اینجا متغیر videoView را مقدار دهی میکنیم
        videoView = view.binding.videoView

        // این تابع برای مقدار دهی و راه اندازی videoView میباشد
        initVideoView()

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
            //videoView.start()
        } catch (e: Exception) {
            Log.e("Error", e.message ?: "Error")
        }

        // این شنونده زمانی که videoView آماده اجرا شده باشد، صدا زده میشود
        videoView.setOnPreparedListener {

            it.setOnVideoSizeChangedListener { _, _, _ ->
                mediaController.setAnchorView(videoView)
            }
        }
    }

    // با استفاده از این تابع موقعیت ویدیو را در هنگام چرخش صفحه در Bundle ذخیره میکنیم
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("position", videoView.currentPosition)

    }

    // در این متد، موقعیت ذخیره شده را بازیابی کرده و در videoView قرار میدهیم
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        videoView.seekTo(savedInstanceState.getInt("position", 0))
    }
}