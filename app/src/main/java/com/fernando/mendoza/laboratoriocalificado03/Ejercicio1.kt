package com.fernando.mendoza.laboratoriocalificado03

import TeacherViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewmodel
import androidx.recyclerview.widget.LinearLayoutManager
import com.fernando.mendoza.laboratoriocalificado03.databinding.ActivityEjercicio01Binding
import com.fernando.mendoza.laboratoriocalificado03.ui.TeacherAdapter


class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding
    private val viewModel: TeacherViewModel by viewmodel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.teachers.observe(this, { teachers ->
            binding.recyclerView.adapter = TeacherAdapter(this, teachers)
        })

        viewModel.fetchTeachers()
    }
}
