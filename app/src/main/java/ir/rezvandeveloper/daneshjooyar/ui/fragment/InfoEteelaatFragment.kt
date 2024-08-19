package ir.amozeshgam.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatInfo
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentInfoEteelaatBinding

class InfoEteelaatFragment(
    private val data: ArrayList<DataEteelaatInfo>
) : Fragment() {

    private lateinit var binding: FragmentInfoEteelaatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInfoEteelaatBinding.inflate(inflater)
        initInfo()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

    }

    private fun initInfo() {
        //binding = FragmentInfoEteelaatBinding.inflate(this.layoutInflater)

        binding.tvEteelaatAUp.text = data[0].name
        binding.tvEteelaatADown.text = data[0].count
        binding.ivEteelaatA.setImageDrawable(data[0].img)

        binding.tvEteelaatBUp.text = data[1].name
        binding.tvEteelaatBDown.text = data[1].count
        binding.ivEteelaatB.setImageDrawable(data[1].img)

        binding.tvEteelaatCUp.text = data[2].name
        binding.tvEteelaatCDown.text = data[2].count
        binding.ivEteelaatC.setImageDrawable(data[2].img)

        binding.tvEteelaatDUp.text = data[3].name
        binding.tvEteelaatDDown.text = data[3].count
        binding.ivEteelaatD.setImageDrawable(data[3].img)
    }
}