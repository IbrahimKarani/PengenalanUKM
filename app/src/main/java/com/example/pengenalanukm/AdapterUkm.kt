package com.example.pengenalanukm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_ukm.view.*

class AdapterUkm(private val itemFac: List<DataUkm>,
                 private val clickListener: (DataUkm) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_ukm, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(itemFac[position], clickListener)
    }

    override fun getItemCount() = itemFac.size

    class PartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data : DataUkm, clickListener: (DataUkm) -> Unit){
            itemView.image_fak.setImageResource(data.imgFac)
            itemView.image_fak.contentDescription = data.nameFac
            itemView.tv_list_fac.text = data.nameFac
            itemView.setOnClickListener { clickListener(data) }
        }
    }
}