
package com.example.mobile_atv2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.main.*


class Main : AppCompatActivity(), PlaceAdapter.ClickItem {

    private lateinit var mPlaceAdapter : PlaceAdapter

    private lateinit var database : DatabaseReference
    private lateinit var pigFood : ArrayList<PigFood>
    companion object{
        val PIGFOOD = "PIGFOOD"
        var count = 1
        var pigFoodItem = PigFood(1, "", "", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        pigFood = arrayListOf<PigFood>()
        showPigFood()
    }

     fun addPigFood(view: View){
        val intent = Intent(this, AddView::class.java)
        startActivity(intent)
    }

    fun editPigFood(editpigfood : PigFood){
        val intent = Intent(this, EditView::class.java)
        pigFoodItem = editpigfood
        startActivity(intent)
    }

    private fun showPigFood(){
        database = FirebaseDatabase.getInstance().getReference("pigfood")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(pigfoodSnapshot in snapshot.children){
                        var value = pigfoodSnapshot.getValue(PigFood::class.java)
                        println("VALUEEEE" + value.toString())
                        pigFood.add(value!!)
                    }
                    val mDisplayedPlacesData: MutableList<PigFood> = ArrayList()
                    mDisplayedPlacesData.addAll(pigFood)
                    print("SUPER TEST")
                    mPlaceAdapter = PlaceAdapter(this@Main, this@Main)
                    mPlaceAdapter.submiteList(mDisplayedPlacesData)
                    listPigFood.apply{
                        layoutManager = LinearLayoutManager(this@Main)
                        adapter = mPlaceAdapter
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun clickItem(item: PigFood) {
        editPigFood(item)
    }
}