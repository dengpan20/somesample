package com.dengpan20.somesample.kotlin

/**

 * Author: Paddy
 * Date: 2019/10/11 10:43
 * Description:
 *
 */
class 循环 {
//    fun main(args: Array<String>) {
//        var items = listOf("lihui", "fanfan", "wangbign", "xiaolong")
//        for (item in items) {
//            println(item)
//        }
//    }

    fun subString(obj:Any):String = when(obj){
        1 -> "isNum"
        "hello" -> "isHello"
        is Long -> "isLong"
        is Int -> "isInt"
        is String -> "isString"
        else -> "other"
    }
}
fun main(args:Array<String>){
    var items = listOf("lihui","fanfan","wangbign","xiaolong")
    for (item in items){
        println(item)
    }

    for (index in items.indices){
        println("item at ${index} is ${items[index]}")
    }
    var index =0
    while (index<items.size){
        println(items[index])
        index++
    }
    var ins = 循环()
    println(ins.subString("hello"))
    println(ins.subString(1.23))
    println(ins.subString(1))
    println(ins.subString(5))
    println(ins.subString(54545454545))

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.contains("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}