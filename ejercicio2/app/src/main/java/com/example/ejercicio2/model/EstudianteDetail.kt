package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class EstudianteDetail(
    @SerializedName("id")
    var id: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("dateOfBirth")
    var birth: String?,
    @SerializedName("house")
    var house: String?,
    @SerializedName("ancestry")
    var ancestry: String?,
    @SerializedName("patronus")
    var patronus: String?,
    @SerializedName("eyeColour")
    var eyeColour: String?,
    @SerializedName("hairColour")
    var hairColour: String?

)
