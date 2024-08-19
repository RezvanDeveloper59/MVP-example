package ir.rezvandeveloper.daneshjooyar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentMadarekBinding
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyarv.dp.dao.PishraftDao

class MadarekFragment(private val context: Context) : Fragment() {

    private lateinit var binding: FragmentMadarekBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMadarekBinding.inflate(inflater)
        checkMadrak()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkMadrak() {
        val db = DBHelper(context)
        val pishraftDao = PishraftDao(db)
        val listAllMentor:List<Pishraft> = pishraftDao.findAll()

        if (listAllMentor.isEmpty()) {

            pishraftDao.save(Pishraft(0, "test", 0))
            pishraftDao.save(Pishraft(1, "test", 0))
            pishraftDao.save(Pishraft(2, "test", 0))
            pishraftDao.save(Pishraft(3, "test", 0))
            pishraftDao.save(Pishraft(4, "test", 0))

        }

        if (listAllMentor[0].darsad_pishraft > 2)
            if (listAllMentor[1].darsad_pishraft > 2)
                if (listAllMentor[2].darsad_pishraft > 2)
                    if (listAllMentor[3].darsad_pishraft > 2)
                        if (listAllMentor[4].darsad_pishraft > 2){
                            binding.ivCheckMadrak.setImageDrawable(context.resources.getDrawable(R.drawable.etmame_dore_almentor))
                        }else {
                            binding.ivCheckMadrak.setImageDrawable(context.resources.getDrawable(R.drawable.no_madrak))
                        }
    }
}