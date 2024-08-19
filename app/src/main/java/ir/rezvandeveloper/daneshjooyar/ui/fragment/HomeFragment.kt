package ir.rezvandeveloper.daneshjooyar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentHomeBinding
import ir.rezvandeveloper.daneshjooyar.model.ModelHomeActivity
import ir.rezvandeveloper.daneshjooyar.presenter.PresenterHomeActivity
import ir.rezvandeveloper.daneshjooyar.view.ViewHomeActivity

class HomeFragment(private val context: Context) : Fragment() {

    //private lateinit var binding: FragmentHomeBinding
    private lateinit var presenter: PresenterHomeActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //binding = FragmentHomeBinding.inflate(inflater)
        val view = ViewHomeActivity(context)

        presenter = PresenterHomeActivity(view, ModelHomeActivity(context), context)
        presenter.onCreate()

        return view.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}