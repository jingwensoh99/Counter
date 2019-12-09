package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declaration of View Model
    private lateinit var viewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialising View Model
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //Add oobserver
        viewModel.counter.observe(this, Observer<Int>{
            if(viewModel.counter.value == 10) endGame()
        })
        //Increment & decrement
        btnPlus.setOnClickListener({
            viewModel.increment()
            textViewCounter.text = viewModel.counter.value.toString()
        })

        btnMinus.setOnClickListener({
            viewModel.decrement()
            textViewCounter.text = viewModel.counter.value.toString()
        })
    }

    private fun endGame(){
        Toast.makeText(applicationContext, "Counter has reached 10!", Toast.LENGTH_LONG).show()
    }


}
