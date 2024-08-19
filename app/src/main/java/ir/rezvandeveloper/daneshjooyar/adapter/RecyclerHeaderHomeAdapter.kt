package ir.rezvandeveloper.daneshjooyar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ir.rezvandeveloper.daneshjooyar.data.DataHeaderRecyclerView
import ir.rezvandeveloper.daneshjooyar.databinding.RecyclerHeaderHomeItemBinding
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData

class RecyclerHeaderHomeAdapter(
    private val dataHeaderRecyclerViews: ArrayList<DataHeaderRecyclerView>,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<RecyclerHeaderHomeAdapter.HeaderViewHolder>() {

    inner class HeaderViewHolder(
        private val binding: RecyclerHeaderHomeItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: DataHeaderRecyclerView) {

            binding.tvHeaderRecyclerViewHome.text = data.name
            binding.ivHeader.setImageDrawable(data.img)
            binding.root.setOnClickListener{
                onBindData.getData(data.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HeaderViewHolder(
            RecyclerHeaderHomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = dataHeaderRecyclerViews.size

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.setData(dataHeaderRecyclerViews[position])
    }
}

