package com.example.tp2ihm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2ihm.databinding.ItemCourseBinding
import com.example.tp2ihm.metier.dto.CourseDTO
import com.example.tp2ihm.viewModels.ListeCourseViewModel

class CourseListAdapter(private val listeCourseViewModel: ListeCourseViewModel):
ListAdapter<CourseDTO, CourseListAdapter.CourseViewHolder>(CourseDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemCourseBinding = ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CourseViewHolder(itemCourseBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) =
        holder.bind(getItem(position))

    // ViewHolder :
    inner class CourseViewHolder(private val itemCourseBinding: ItemCourseBinding) :
        RecyclerView.ViewHolder(itemCourseBinding.root) {
        fun bind(courseDTO: CourseDTO) {
            itemCourseBinding.course = courseDTO
            itemCourseBinding.viewModel = listeCourseViewModel
            itemCourseBinding.executePendingBindings()
        }
    }
}