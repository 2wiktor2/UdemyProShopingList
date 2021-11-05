package com.wiktor.udemyproshopinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.wiktor.udemyproshopinglist.R

class MainActivity : AppCompatActivity() {



    private var count = 0

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.i("qwertyu", it.toString())
            if(count == 0){
                count++
                val item = it[0]
                viewModel.changeEnabledState(item)
            }
        }
    }
}