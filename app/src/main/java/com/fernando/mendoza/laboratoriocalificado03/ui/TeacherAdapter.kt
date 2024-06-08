package com.fernando.mendoza.laboratoriocalificado03.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fernando.mendoza.laboratoriocalificado03.R
import com.fernando.mendoza.laboratoriocalificado03.model.Teacher

class TeacherAdapter(private val context: Context, private val teachers: List<Teacher>) :
    RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.teacher_photo)
        val name: TextView = itemView.findViewById(R.id.teacher_name)
        val lastName: TextView = itemView.findViewById(R.id.teacher_last_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.name.text = teacher.name
        holder.lastName.text = teacher.lastname
        Glide.with(context).load(teacher.photo).into(holder.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phone}"))
            context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${teacher.email}")
            }
            context.startActivity(intent)
            true
        }
    }

    override fun getItemCount(): Int = teachers.size
}
