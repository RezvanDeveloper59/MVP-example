package ir.rezvandeveloper.daneshjooyar.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ir.rezvandeveloper.daneshjooyar.data.DataEteelaatAmoozeshAlmentor
import ir.rezvandeveloper.daneshjooyar.databinding.RecyclerAlmentorItemBinding
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyar.ext.OnBindData
import ir.rezvandeveloper.daneshjooyarv.dp.dao.PishraftDao

class RecyclerAlmentorAdapter(
    private val dataAlmentorRecyclerViews: ArrayList<DataEteelaatAmoozeshAlmentor>,
    private val onBindData: OnBindData,
    private val c: Context
) : RecyclerView.Adapter<RecyclerAlmentorAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(
        private val binding: RecyclerAlmentorItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: DataEteelaatAmoozeshAlmentor) {

            binding.tvAlmentorRecycleView.text = data.name
            binding.ivAlmentorRV.setImageDrawable(data.img)
            binding.root.setOnClickListener {
                onBindData.getDataAlmentor(data.id, data.name)
            }
            //binding.tvAlmentorRecycleView.setBackgroundResource(R.drawable.btn_background)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            RecyclerAlmentorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = dataAlmentorRecyclerViews.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.setData(dataAlmentorRecyclerViews[position])

        val db = DBHelper(c)
        val pisraft = PishraftDao(db)
        val listAll: List<Pishraft> = pisraft.findAll()

        if (position == 0) {
            if (listAll[0].darsad_pishraft > 95) {
                holder.itemView.setBackgroundColor(Color.GREEN)
            }
        } else if (position == 1) {
            if (listAll[1].darsad_pishraft > 95) {
                holder.itemView.setBackgroundColor(Color.GREEN)
            }
        } else if (position == 2) {
            if (listAll[2].darsad_pishraft > 95) {
                holder.itemView.setBackgroundColor(Color.GREEN)
            }
        } else if (position == 3) {
            if (listAll[3].darsad_pishraft > 95) {
                holder.itemView.setBackgroundColor(Color.GREEN)
            }
        } else if (position == 4) {
            if (listAll[4].darsad_pishraft > 95) {
                holder.itemView.setBackgroundColor(Color.GREEN)
            }
        }
    }


}

