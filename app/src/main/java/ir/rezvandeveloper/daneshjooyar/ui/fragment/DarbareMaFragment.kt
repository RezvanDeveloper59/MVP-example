package ir.rezvandeveloper.daneshjooyar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentDarbareMaBinding
import ir.rezvandeveloper.daneshjooyar.model.ModelDarbareMaFragment
import ir.rezvandeveloper.daneshjooyar.model.ModelHomeActivity
import ir.rezvandeveloper.daneshjooyar.presenter.PresenterDarbareMaFragment
import ir.rezvandeveloper.daneshjooyar.presenter.PresenterHomeActivity
import ir.rezvandeveloper.daneshjooyar.view.ViewDarbareMaFragment
import ir.rezvandeveloper.daneshjooyar.view.ViewHomeActivity

class DarbareMaFragment(private val context: Context) : Fragment() {

    //private lateinit var binding: FragmentDarbareMaBinding
    private lateinit var presenter: PresenterDarbareMaFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = ViewDarbareMaFragment(context)

        presenter = PresenterDarbareMaFragment(view, ModelDarbareMaFragment(context))
        presenter.onCreate()

        return view.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}