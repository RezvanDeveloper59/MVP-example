package ir.rezvandeveloper.daneshjooyar.presenter

import android.content.Context
import android.content.Intent
import ir.rezvandeveloper.daneshjooyar.ui.activity.EteelaatActivity
import ir.rezvandeveloper.daneshjooyar.ext.BaseLifecycle
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData
import ir.rezvandeveloper.daneshjooyar.model.ModelHomeActivity
import ir.rezvandeveloper.daneshjooyar.view.ViewHomeActivity

class PresenterHomeActivity(
    private val viewHomeActivity: ViewHomeActivity,
    private val modelHomeActivity: ModelHomeActivity,
    private val context: Context?
) : BaseLifecycle {

    override fun onCreate() {
        setDataInitRecycler()
    }

    ////////////////////////////////////////////////////////////////////////////////

    init {
        viewHomeActivity.initRecyclerHome(
            modelHomeActivity.dataHomeRV1(),
            object : OnBindData {
                override fun getDataHome(entity: Int) {
                    onClick(entity)
                }
            }
        )
    }

    private fun setDataInitRecycler() {
        viewHomeActivity.initRecyclerHeader(
            modelHomeActivity.dataHeaderHome(),
            object : OnBindData {
                override fun getData(entity: Int) {
                    onClick(entity)
                }
            }
        )
    }

    private fun onClick(entity: Int) {

        when (entity) {
            1 -> {
                viewHomeActivity.initRecyclerHome(
                    modelHomeActivity.dataHomeRV1(),
                    object : OnBindData {
                        override fun getDataHome(entity: Int) {
                            startActivity()
                        }
                    }
                )
            }
            2 -> {
                viewHomeActivity.initRecyclerHome(
                    modelHomeActivity.dataHomeRV2(),
                    object : OnBindData {
                        override fun getDataHome(entity: Int) {
                            startActivity()
                        }
                    }
                )
            }
            3 -> {
                viewHomeActivity.initRecyclerHome(
                    modelHomeActivity.dataHomeRV3(),
                    object : OnBindData {
                        override fun getDataHome(entity: Int) {
                            startActivity()
                        }
                    }
                )
            }
            4 -> {
                viewHomeActivity.initRecyclerHome(
                    modelHomeActivity.dataHomeRV4(),
                    object : OnBindData {
                        override fun getDataHome(entity: Int) {
                            startActivity()
                        }
                    }
                )
            }
            5 -> {
                viewHomeActivity.initRecyclerHome(
                    modelHomeActivity.dataHomeRV5(),
                    object : OnBindData {
                        override fun getDataHome(entity: Int) {
                            startActivity()
                        }
                    }
                )
            }
        }
    }

    private fun startActivity() {
        val intent = Intent(context, EteelaatActivity::class.java)
        context?.startActivity(intent)
    }
}