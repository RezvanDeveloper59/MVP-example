package ir.rezvandeveloper.daneshjooyar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ir.rezvandeveloper.daneshjooyar.data.DataHomeRecyclerView
import ir.rezvandeveloper.daneshjooyar.databinding.RecyclerHomeItemBinding
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData

class RecyclerHomeAdapter(
    private val dataHomeRecyclerViews: ArrayList<DataHomeRecyclerView>,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<RecyclerHomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(
        private val binding: RecyclerHomeItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: DataHomeRecyclerView) {

            binding.tvHomeRecyclerView.text = data.name
            binding.ivHomeRV.setImageDrawable(data.img)
            binding.root.setOnClickListener{
                onBindData.getDataHome(data.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            RecyclerHomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = dataHomeRecyclerViews.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.setData(dataHomeRecyclerViews[position])
    }



}

