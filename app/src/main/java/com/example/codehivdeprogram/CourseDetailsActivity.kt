package com.example.codehivdeprogram

import CourseAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        var rvCourses= findViewById<RecyclerView>(R.id.rvCourses)
        var courseList= listOf(
            Course("MBT01",
                "Mobile Development",
                "Introduction to Android",
                "John"),

            Course("NPT05",
                "Backend Development",
                "Introduction to python",
                "James"),

            Course("NTP031",
                "Frontend Development",
                "Introduction to JavaScript",
                "Purity"),
        )


        var courseAdapter= CourseAdapter(courseList)
        rvCourses.layoutManager= LinearLayoutManager(baseContext)
        rvCourses.adapter= courseAdapter
    }
}