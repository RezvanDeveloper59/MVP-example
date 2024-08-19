package ir.rezvandeveloper.daneshjooyar.presenter

import ir.rezvandeveloper.daneshjooyar.ext.BaseLifecycle
import ir.rezvandeveloper.daneshjooyar.model.ModelDarbareMaFragment
import ir.rezvandeveloper.daneshjooyar.view.ViewDarbareMaFragment

class PresenterDarbareMaFragment(
    private val viewDarbareMaFragment: ViewDarbareMaFragment,
    private val modelDarbareMaFragment: ModelDarbareMaFragment
) : BaseLifecycle {

    override fun onCreate() {
        setDataHeader()
        setDataVizhegiha()
        onClickInstagram()
        onClickYouTube()
    }

    ////////////////////////////////////////////////////////////////////////////////

    private fun setDataHeader() {

        viewDarbareMaFragment.initDataHeader(modelDarbareMaFragment.datadDarbareMaHeader())

    }

    private fun setDataVizhegiha() {

        viewDarbareMaFragment.initDataVizhegiha(modelDarbareMaFragment.datadDarbareMaVizhegiha())

    }

    private fun onClickInstagram(){
        viewDarbareMaFragment.openPageInInstagram()
    }

    private fun onClickYouTube(){
        viewDarbareMaFragment.openPageInYouTube()
    }
}