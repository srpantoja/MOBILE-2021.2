
package com.example.mobile_atv2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main.*


class Main : AppCompatActivity(), PlaceAdapter.ClickItem {

    private lateinit var mPlaceAdapter : PlaceAdapter

    companion object{
        var pigFood = ArrayList<PigFood>()
        val PIGFOOD = "PIGFOOD"
        var count = 0
        var pigFoodItem = PigFood(0, "", "", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
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
        val mDisplayedPlacesData: MutableList<PigFood> = ArrayList()
        mDisplayedPlacesData.addAll(pigFood)
        mPlaceAdapter = PlaceAdapter(this, this)
        mPlaceAdapter.submiteList(mDisplayedPlacesData)
        listPigFood.apply{
            layoutManager = LinearLayoutManager(this@Main)
            adapter = mPlaceAdapter
        }
    }

    override fun clickItem(item: PigFood) {
        editPigFood(item)
    }
}