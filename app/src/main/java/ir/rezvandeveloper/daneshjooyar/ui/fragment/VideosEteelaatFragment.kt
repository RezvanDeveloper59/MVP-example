package ir.amozeshgam.tablayout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezvandeveloper.daneshjooyar.adapter.RecyclerAlmentorAdapter
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatAmoozeshAlmentor
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentVideosEteelaatBinding
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData
import ir.rezvandeveloper.daneshjooyarv.dp.dao.PishraftDao

class VideosEteelaatFragment(
    private val context: Context,
    private val data: ArrayList<DataEteelaatAmoozeshAlmentor>,
    private val onBindData: OnBindData
) : Fragment() {

    private lateinit var binding: FragmentVideosEteelaatBinding

    private lateinit var adapterAlmentor: RecyclerAlmentorAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideosEteelaatBinding.inflate(inflater)
        initRecyclerAlmentor(data, onBindData)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun initRecyclerAlmentor(
        data: ArrayList<DataEteelaatAmoozeshAlmentor>,
        onBindData: OnBindData
    ) {

        binding.rvAlmentor.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapterAlmentor = RecyclerAlmentorAdapter(data, onBindData, context)
        binding.rvAlmentor.adapter = adapterAlmentor
        //binding.rvAlmentor.background = context.resources.getDrawable(R.drawable.btn_background)
        //h.itemView.setBackgroundColor(Color.GREEN)
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "getSeeAllOneVideo: 1")

        val db = DBHelper(context)
        val pishraftDao = PishraftDao(db)
        val listAllMentor: List<Pishraft> = pishraftDao.findAll()

        if (listAllMentor.isEmpty()) {

            pishraftDao.save(Pishraft(0, "test", 0))
            pishraftDao.save(Pishraft(1, "test", 0))
            pishraftDao.save(Pishraft(2, "test", 0))
            pishraftDao.save(Pishraft(3, "test", 0))
            pishraftDao.save(Pishraft(4, "test", 0))

        }

        if (listAllMentor[0].darsad_pishraft > 95)
            if (listAllMentor[1].darsad_pishraft > 95)
                if (listAllMentor[2].darsad_pishraft > 95)
                    if (listAllMentor[3].darsad_pishraft > 95)
                        if (listAllMentor[4].darsad_pishraft > 95)
                            binding.ivTabrikAlmentor.visibility = View.VISIBLE

    }
}