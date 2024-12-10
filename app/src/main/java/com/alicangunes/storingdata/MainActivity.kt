package com.alicangunes.storingdata

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alicangunes.storingdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPref : SharedPreferences
    var ageFromPref : Int? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences -XML - Key-Value

        sharedPref = getSharedPreferences("com.alicangunes.storingdata", MODE_PRIVATE)

        ageFromPref= sharedPref.getInt("age", -1)

        if (ageFromPref == 1) {
            binding.textView.text = "Your age: "
        } else {
            binding.textView.text = "Your age: ${ageFromPref}"
        }

    }

    @SuppressLint("SetTextI18n")
    fun save(view : View) {

        val myAge = binding.editText.text.toString().toIntOrNull()

        if (myAge != null) {
            binding.textView.text = "Your age: ${myAge}"
            sharedPref.edit().putInt("age", myAge).apply()
        }
    }

    @SuppressLint("SetTextI18n")
    fun delete(view : View) {
        ageFromPref = sharedPref.getInt("age", -1)

        if (ageFromPref != -1) {
            sharedPref.edit().remove("age").apply()
            binding.textView.text = "Your age: "
        }

    }

}