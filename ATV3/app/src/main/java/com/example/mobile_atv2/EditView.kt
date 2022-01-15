package com.example.mobile_atv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditView : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private var pigFoodAux : PigFood = Main.pigFoodItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_view)

        renderItem()
    }

    fun renderItem(){
         var editname : EditText = findViewById(R.id.name)
         var editdesc : EditText = findViewById(R.id.description)
         var editprice : EditText = findViewById(R.id.price)

        editname.setText(pigFoodAux.name)
        editdesc.setText(pigFoodAux.description)
        editprice.setText(pigFoodAux.price)
    }

    fun deletePigFood(view: View){
        val intent = Intent(this, Main::class.java)
        database = FirebaseDatabase.getInstance().getReference("pigfood")

        var pigFoodAux : PigFood = Main.pigFoodItem
        var editname : EditText = findViewById(R.id.name)
        var editdesc : EditText = findViewById(R.id.description)
        var editprice : EditText = findViewById(R.id.price)
        var name = editname.text.toString()
        var desc = editdesc.text.toString()
        var price = editprice.text.toString()

        println("========= REMOVE TEST ===========")
        //Main.pigFood[pigFoodAux.id!!] =
        database.child(pigFoodAux.id.toString()).removeValue()
        startActivity(intent)
        finish()
    }

    fun editPigFood(view: View){
        val intent = Intent(this, Main::class.java)
        database = FirebaseDatabase.getInstance().getReference("pigfood")

        var pigFoodAux : PigFood = Main.pigFoodItem
        var editname : EditText = findViewById(R.id.name)
        var editdesc : EditText = findViewById(R.id.description)
        var editprice : EditText = findViewById(R.id.price)
        var name = editname.text.toString()
        var desc = editdesc.text.toString()
        var price = editprice.text.toString()

        //Main.pigFood[pigFoodAux.id!!] =
        database.child(pigFoodAux.id.toString()).setValue(PigFood(pigFoodAux.id, name, price, desc))
        startActivity(intent)
        finish()

    }

}