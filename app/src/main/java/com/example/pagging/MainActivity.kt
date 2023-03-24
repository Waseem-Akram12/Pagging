package com.example.pagging

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagging.pagging.view1pagging
import com.example.pagging.viewmodels.viewmodelapi

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val viewmodelapi :viewmodelapi by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : view1pagging
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView2)

        adapter = view1pagging(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        viewmodelapi.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })



    }


}