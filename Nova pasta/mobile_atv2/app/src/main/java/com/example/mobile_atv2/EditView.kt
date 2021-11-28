package com.example.mobile_atv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EditView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_view)
        renderItem()
    }

    fun renderItem(){
         var pigFoodAux : PigFood = Main.pigFoodItem
         var editname : EditText = findViewById(R.id.name)
         var editdesc : EditText = findViewById(R.id.description)
         var editprice : EditText = findViewById(R.id.price)

        editname.setText(pigFoodAux.name)
        editdesc.setText(pigFoodAux.description)
        editprice.setText(pigFoodAux.price)
    }

    fun editPigFood(view: View){
        val intent = Intent(this, Main::class.java)
        var pigFoodAux : PigFood = Main.pigFoodItem
        var editname : EditText = findViewById(R.id.name)
        var editdesc : EditText = findViewById(R.id.description)
        var editprice : EditText = findViewById(R.id.price)
        var name = editname.text.toString()
        var desc = editdesc.text.toString()
        var price = editprice.text.toString()

        Main.pigFood[pigFoodAux.id] = PigFood(pigFoodAux.id, name, desc, price)

        startActivity(intent)
        finish()

    }

}