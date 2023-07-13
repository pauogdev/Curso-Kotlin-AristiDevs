package com.pauortegarcia.cursokotlin.syntaxis

fun main(){
    var name:String? = null

    if(name == "Aris"){
        println(name?.get(3) ?: "Es nulo")
    }
}