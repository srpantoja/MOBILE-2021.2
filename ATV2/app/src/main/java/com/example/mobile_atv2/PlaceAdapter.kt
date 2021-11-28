package com.example.mobile_atv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.places_row.view.*

class PlaceAdapter(private val mContext: Context, var clickItem: ClickItem): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface ClickItem{
        fun clickItem(item: PigFood){

        }
    }

    private var mItemsData: List<PigFood> = ArrayList()

    fun submiteList(list: List<PigFood>){
        mItemsData = list
    }

    private class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(place: PigFood){
            itemView.title.text = place.name
            itemView.desc.text = place.description
            itemView.price.text = place.price
        }
        val cardView = itemView.cardViewOnClick

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return PlacesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.places_row, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(holder){
            is PlacesViewHolder ->{
                holder.bind(mItemsData[position])
                val pigFood : PigFood = mItemsData[position]
                holder.cardView.setOnClickListener{
                    clickItem.clickItem(pigFood)
                }

            }
            else -> return;
        }
    }

    override fun getItemCount(): Int = mItemsData.size


}