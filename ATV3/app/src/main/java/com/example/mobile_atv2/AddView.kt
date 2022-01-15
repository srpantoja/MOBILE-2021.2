package com.example.mobile_atv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_view)
    }

    private lateinit var database : DatabaseReference

    fun addFood(view: View){
        val intent = Intent(this, Main::class.java)
        val addName : EditText = findViewById(R.id.nameadd)
        val addDesc : EditText = findViewById(R.id.descriptionadd)
        val addPrice : EditText = findViewById(R.id.priceadd)

        var name = addName.text.toString()
        var desc = addDesc.text.toString()
        var price = addPrice.text.toString()

        database = FirebaseDatabase.getInstance().getReference("pigfood")
        val newPigFood : DatabaseReference = database.push()
        val idPigFood = newPigFood.key
        val _food : PigFood = PigFood(idPigFood, name, price, desc)
        database.child(idPigFood.toString()).setValue(_food).addOnSuccessListener {
            addName.text.clear()
            addDesc.text.clear()
            addPrice.text.clear()
            Toast.makeText(this,"success", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()
        }
        Main.count++
        startActivity(intent)
        finish()
    }

}