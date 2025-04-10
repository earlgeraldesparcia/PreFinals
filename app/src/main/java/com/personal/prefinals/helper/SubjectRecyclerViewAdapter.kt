package com.personal.prefinals.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.personal.prefinals.R
import com.personal.prefinals.data.Subject

class SubjectRecyclerViewAdapter (
    private val listOfSubjects: List<Subject>,
    private val onClick: (Subject) -> Unit
): RecyclerView.Adapter<SubjectRecyclerViewAdapter.ItemViewHolder>()  {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectName = view.findViewById<TextView>(R.id.SIRVtv_subjectName)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectRecyclerViewAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subject_item_recycler_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = listOfSubjects.size

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = listOfSubjects[position]

        holder.subjectName.setText(item.subjectName)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
}