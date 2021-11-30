package com.example.tp2ihm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.bo.Course
import com.example.tp2ihm.databinding.ItemCourseBinding
import com.example.tp2ihm.metier.dto.CourseDTO
import com.example.tp2ihm.viewModels.ListeCourseViewModel

class CourseAdapter(
    private val listeCourseViewModel: ListeCourseViewModel) :
        RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private var listeCourseDTO: MutableList<CourseDTO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder
    {
        val itemCourseBinding = ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return CourseViewHolder(itemCourseBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(listeCourseDTO[position])

    }

    override fun getItemCount(): Int = listeCourseDTO.size

    fun updateCourses(listeCourseDTO: MutableList<CourseDTO>){
        this.listeCourseDTO = listeCourseDTO
        notifyDataSetChanged()
    }

    // ViewHolder :
    inner class CourseViewHolder(private val itemCourseBinding: ItemCourseBinding) :
        RecyclerView.ViewHolder(itemCourseBinding.root)
    {
        fun bind(courseDTO: CourseDTO)
        {
            itemCourseBinding.course = courseDTO
            itemCourseBinding.viewModel = listeCourseViewModel
            itemCourseBinding.executePendingBindings()
        }
    }
}