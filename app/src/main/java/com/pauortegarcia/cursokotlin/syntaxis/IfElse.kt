package com.pauortegarcia.cursokotlin.syntaxis


fun main(){
    ifbasico("Joel")
}

fun ifbasico(name:String){

    if(name == "Pau"){
        println("Hola Pau")
    }else if(name=="Joel"){
        println("Hola Joel")
    }else{
        println("Hola $name")
    }
}