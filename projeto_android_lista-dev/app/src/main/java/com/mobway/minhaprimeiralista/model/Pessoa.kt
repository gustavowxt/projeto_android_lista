package com.mobway.minhaprimeiralista.model

import androidx.annotation.DrawableRes
import java.io.Serializable

class Pessoa(

    val nome: String,
    val idade: Int,
    @DrawableRes
    val photo: Int,

) : Serializable