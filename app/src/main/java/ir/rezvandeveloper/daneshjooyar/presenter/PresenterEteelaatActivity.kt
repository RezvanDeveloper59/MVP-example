package ir.rezvandeveloper.daneshjooyar.presenter

import android.content.Context
import android.content.Intent
import ir.rezvandeveloper.daneshjooyar.ui.activity.VideoAlmentorActivity
import ir.rezvandeveloper.daneshjooyar.ext.BaseLifecycle
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData
import ir.rezvandeveloper.daneshjooyar.model.ModelEteelaatActivity
import ir.rezvandeveloper.daneshjooyar.view.ViewEteelaatActivity

class PresenterEteelaatActivity(
    private val viewEteelaatActivity: ViewEteelaatActivity,
    private val modelEteelaatActivity: ModelEteelaatActivity,
    val context: Context
) : BaseLifecycle {

    override fun onCreate() {
        setDataInfo()
        //setDataInitAlmentorRecycler()
    }

    ////////////////////////////////////////////////////////////////////////////////

    private fun setDataInfo() {

            viewEteelaatActivity.initInfo(
                modelEteelaatActivity.dataInfo(),
                modelEteelaatActivity.dataAmoozeshAlmentor(),
                object : OnBindData {
                    override fun getDataAlmentor(id: Int, sarFasl: String) {
                        val intent = Intent(context, VideoAlmentorActivity::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("name", sarFasl)
                        context.startActivity(intent)
                    }
                }
            )

    }
}