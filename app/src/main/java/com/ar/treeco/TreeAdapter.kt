package com.ar.treeco

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class TreeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TAG = "HistoryAdapter"
    val PAYLOAD_SELECTED_INDICATOR = "PAYLOAD_SELECTED_INDICATOR"

    var runHistoryList: ArrayList<ArTree> = ArrayList()
    private var selectedPos = RecyclerView.NO_POSITION

    private var onItemClickListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ar_tree_preview, parent, false)
        return TreePreviewHolder(view)
    }

    override fun getItemCount(): Int {
        return runHistoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val historyPreviewHolder = holder as TreePreviewHolder
        val aTree = runHistoryList[position]
        // Show image + Tree name

        holder.textView?.text = aTree.name
        Picasso.get().load(aTree.image).placeholder(R.drawable.ic_ar).fit().into(holder.image)

        updateSelectedIndicator(historyPreviewHolder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        val historyPreviewHolder = holder as TreePreviewHolder

        holder.itemView.isSelected = selectedPos == position

        if (!payloads.isEmpty()) {
            val pay = payloads[0]
            if (pay is String && pay.equals(PAYLOAD_SELECTED_INDICATOR)) {
                updateSelectedIndicator(historyPreviewHolder)
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }

    }

    private fun updateSelectedIndicator(historyPreviewHolder: TreePreviewHolder) {
        historyPreviewHolder.rootView?.isSelected = historyPreviewHolder.itemView.isSelected
    }


    inner class TreePreviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            updateViewSelectedState(adapterPosition)
            onItemClickListener?.onItemClick(v, adapterPosition)
        }

        var textView: TextView? = null
        var image: ImageView? = null
        var rootView: ConstraintLayout? = null

        init {
            textView = itemView.findViewById(R.id.textView)
            image = itemView.findViewById(R.id.imageView)
            rootView = itemView.findViewById(R.id.root)

            itemView.setOnClickListener(this)
        }

    }

    fun updateList(newHistoryList: List<ArTree>) {
        runHistoryList.clear()
        runHistoryList.addAll(newHistoryList)
        notifyDataSetChanged()
    }

    fun updateViewSelectedState(position: Int = RecyclerView.NO_POSITION) {
        val prevSelected = selectedPos
        selectedPos = position

        notifyItemChanged(prevSelected, PAYLOAD_SELECTED_INDICATOR)
        notifyItemChanged(selectedPos, PAYLOAD_SELECTED_INDICATOR)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

}