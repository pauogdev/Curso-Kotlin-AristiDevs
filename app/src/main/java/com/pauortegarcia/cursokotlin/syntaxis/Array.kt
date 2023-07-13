package com.pauortegarcia.cursokotlin.syntaxis

fun main (){
    var weekDays =  arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")


    for (position in weekDays.indices){
        println(weekDays[position])
    }

    for (weekday in weekDays){
        println("Ahora es $weekday")
    }


}