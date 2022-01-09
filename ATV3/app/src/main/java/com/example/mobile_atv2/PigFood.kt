package com.example.mobile_atv2

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class PigFood(
    var id: Int? = 0,
    var name: String? = "",
    var price: String? = "",
    var description: String? = ""
) : Serializable{
}
