package com.example.tp2ihm.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tp2ihm.metier.dto.CourseDTO

class CourseDiffCallback : DiffUtil.ItemCallback<CourseDTO>() {
    override fun areItemsTheSame(oldItem: CourseDTO, newItem: CourseDTO): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: CourseDTO, newItem: CourseDTO): Boolean {
        return oldItem == newItem
    }
}