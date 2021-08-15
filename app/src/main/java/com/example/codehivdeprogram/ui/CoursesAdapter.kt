package com.example.codehivdeprogram.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.ui.Course

class CoursesAdapter (var courseList: List<Course>): RecyclerView.Adapter<CoursesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_list_item, parent, false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentCourse = courseList.get(position)
        holder.tvCourseName.text = currentCourse.courseName
        holder.tvDescription.text = currentCourse.description
        holder.tvInstructor.text = currentCourse.instructor
        holder.tvcode.text = currentCourse.courseCode
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}

class CoursesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvInstructor)
    var tvcode = itemView.findViewById<TextView>(R.id.tvCode)
}
