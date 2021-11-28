package com.example.mobile_atv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_view)
    }

    fun addFood(view: View){
        val intent = Intent(this, Main::class.java)
        val addName : EditText = findViewById(R.id.nameadd)
        val addDesc : EditText = findViewById(R.id.descriptionadd)
        val addPrice : EditText = findViewById(R.id.priceadd)

        var name = addName.text.toString()
        var desc = addDesc.text.toString()
        var price = addPrice.text.toString()

        Main.pigFood.add(PigFood(Main.count, name, desc, price))
        Main.count++
        startActivity(intent)
        finish()
    }

}