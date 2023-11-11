//package com.mincho.myapplication
//дефиниция на пакети и вмъкване на библиотеки

//import kotlin.text.*

//функции

fun sum (a:Int, b:Int):Int{
    return a+b
}

fun sumVer2 (a:Int, b:Int) = a+b

fun printSum(a:Int, b:Int){
    println("printSum = ${a+b}")
}
//класове, за дефиниране на класове се използва ключовата дума class

open class Shape

class Rectangle (var l:Double,var h:Double ):Shape(){
    var p = (l+h)*2
    var s = l*h
}

data class Poin (val a:Int, val b:Int)

//условни оператори
fun maxOf(a:Int, b:Int):Int{
    if (a > b)
        return a
    else
        return b
}

fun maxOfVer2 (a:Int, b:Int) = if (a>b) a else b

fun typeCheck(obj:Any): String =
    when (obj) {
        is Int -> "Integer"
        is Double -> "Double"
        is String -> "String"
        else -> "Unknown"
    }


//Aнонимната функция.
//Има функции които не се нуждаят от име а се идентифицират по техните входове и изходи.
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}
//

//Lambda expression

// with type annotation in lambda expression
val sum1 = { a: Int, b: Int -> a + b }

// without type annotation in lambda expression
val sum2:(Int,Int)-> Int = { a , b -> a + b}

val lambda4 : String.(Int) -> String = { this + it }

//High-order functions
//Функции, които могат приемат друга функция като аргумент.
//
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}



fun main(){ //входна функция
    //дефиниция на променлива само за четене - val
    val a:Int = 10
    val b = 25
    val c: Int
    println(" a= $a, b= $b, c= ")
    c= 23
    println(" a= $a, b= $b, c= $c")

    //дефинициа на променлива
    var x = 5
    x+= 1

    println(" x = $x")

    //Null safety
//    val country: String = null
    //Тази дефиниция е невъзможна в Kotlin. За да използвате нулева стойност, трябва да дефинирате нулев тип.
    // Това става :
    val country: String? = null

    //fun
    println("fun")
    val s1 = sum(4,6)
    val s2 = sumVer2(5,7)
    println ("sum = $s1, sum as body function = $s2")
    printSum(10,10)
    //class

    println("class")
    val aRect = Rectangle(3.0,5.0)
    println("p = ${aRect.p}, s = ${aRect.s}")

    //условни оператори
    println("conditional expression")

    val m1 = maxOf(3456,3479)
    val m2 = maxOfVer2(687877,56787)
    println("m1 = $m1 , m2 = $m2")

    //when
    println(" 2 is ${typeCheck(2)}, 5.6 is ${typeCheck(5.6)}" +
            "\n mincho is ${typeCheck("mincho")} , / is ${typeCheck('/')}")

    //for
    val items = listOf("apple","banana","water mellon", "peach", "pear")

    println("for loop")
    for (item in items) {
        print("$item ")
    }

    println()
    for (index in items.indices){
        print("${items[index]} ")
    }

    println()

    //while loop
    println("while loop")
    var index = 0

    while (index < items.size){
        print("${items[index]} ")
        index++
    }
    println()


    println("lambda function")

    val stringLength: Int = stringLengthFunc("Android")

    println("Android - $stringLength")

    val result1 = sum1(2,3)
    val result2 = sum2(3,4)
    println("The sum of two numbers is: $result1")
    println("The sum of two numbers is: $result2")

    // directly print the return value of lambda
    // without storing in a variable.
    println(sum1(5,7))

    val result = "Geeks".lambda4(50)
    println(result)


    //използване на lambda

    println("use lambda")
    items
        .filter { it.startsWith("p") }
        .sortedBy { it }
        .map {it.uppercase()}
        .forEach{ println(it)}


    println("high order function")
    println("Android - ${stringMapper("Android", { input ->
        input.length +1 
    })}")


}



