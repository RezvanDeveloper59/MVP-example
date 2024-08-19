package ir.rezvandeveloper.daneshjooyar.view

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezvandeveloper.daneshjooyar.adapter.RecyclerHeaderHomeAdapter
import ir.rezvandeveloper.daneshjooyar.adapter.RecyclerHomeAdapter
import ir.rezvandeveloper.daneshjooyar.data.DataHeaderRecyclerView
import ir.rezvandeveloper.daneshjooyar.data.DataHomeRecyclerView
import ir.rezvandeveloper.daneshjooyar.databinding.FragmentHomeBinding
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData

class ViewHomeActivity(
    private val context: Context
) {

    //val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    val binding = FragmentHomeBinding.inflate(LayoutInflater.from(context))

    private lateinit var adapterHeader: RecyclerHeaderHomeAdapter
    private lateinit var adapterHome: RecyclerHomeAdapter

    fun initRecyclerHeader(data: ArrayList<DataHeaderRecyclerView>, onBindData: OnBindData) {

        binding.rvHeader.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, true)

        adapterHeader = RecyclerHeaderHomeAdapter(data, onBindData)
        binding.rvHeader.adapter = adapterHeader
    }

    fun initRecyclerHome(data: ArrayList<DataHomeRecyclerView>, onBindData: OnBindData) {

        binding.rvHome.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapterHome = RecyclerHomeAdapter(data, onBindData)
        binding.rvHome.adapter = adapterHome
    }
}

