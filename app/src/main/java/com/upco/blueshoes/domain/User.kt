package com.upco.blueshoes.domain

data class User(
    val name: String,
    val image: Int,
    val status: Boolean = false
)