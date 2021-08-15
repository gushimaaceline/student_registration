package com.example.codehivdeprogram.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehivdeprogram.R
import com.example.codehivdeprogram.databinding.ActivityCourseDetailsBinding
import com.example.codehivdeprogram.databinding.ActivityMainBinding

class CourseDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCourseDetailsBinding
    val courseViewModel:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)



    }
}

//        displayCourses()
//        fun displayCourses(){
//            var rvCourses= findViewById<RecyclerView>(R.id.rvCourses)
//            var courseList= listOf(
//                Course("MBT01",
//                    "Mobile Development",
//                    "Introduction to Android",
//                    "John"),
//
//                Course("NPT05",
//                    "Backend Development",
//                    "Introduction to python",
//                    "James"),
//
//                Course("NTP031",
//                    "Frontend Development",
//                    "Introduction to JavaScript",
//                    "Purity"),
//            )
//
//            var courseAdapter= CourseAdapter(courseList)
//            rvCourses.layoutManager= LinearLayoutManager(baseContext)
//            rvCourses.adapter= courseAdapter
//
//        }

