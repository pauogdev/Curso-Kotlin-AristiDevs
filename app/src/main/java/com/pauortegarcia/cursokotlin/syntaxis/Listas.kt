package com.pauortegarcia.cursokotlin.syntaxis

fun main(){

    inmutableList()
    mutableList()
}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    /** println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first()) */

    val example = readOnly.filter { it.contains("a") }
    //println(example)

    //readOnly.forEach{weekday -> println(weekday)}
}

fun mutableList(){
    var weekDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays)
    weekDays.add(0, "NuevoDia")
    weekDays.remove("NuevoDia")
    println(weekDays)



}