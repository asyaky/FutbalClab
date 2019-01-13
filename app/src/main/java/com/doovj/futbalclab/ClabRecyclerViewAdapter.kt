package com.doovj.futbalclab

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class ClabRecyclerViewAdapter(private val clabs: MutableList<Clab>, private val listener: (Clab) -> Unit)
    : RecyclerView.Adapter<ClabRecyclerViewAdapter.ClabViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ClabViewHolder(FutbalClabUI().createView(AnkoContext.create(p0.context, p0)))

    override fun onBindViewHolder(p0: ClabViewHolder, p1: Int) {
        p0.bindItem(clabs[p1], listener)
    }

    override fun getItemCount(): Int = clabs.size

    class ClabViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvNem : TextView
        var ivImej : ImageView
        // var tvDeskripsion : TextView

        init {
            tvNem = view.findViewById(R.id.nameId)
            ivImej = view.findViewById(R.id.imageId)
            // tvDeskripsion = view.findViewById(FutbalClabUI.descriptionId)
        }

        fun bindItem(clabs: Clab, listener: (Clab) -> Unit) {
            tvNem.text = clabs.namaklab
            // tvDeskripsion.text = clabs.deskripsiklab
            Glide.with(itemView.context).load(clabs.gambarklab).into(ivImej)
            itemView.setOnClickListener {
                listener(clabs)
            }
        }
    }
}