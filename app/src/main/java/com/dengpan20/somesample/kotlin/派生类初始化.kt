package com.dengpan20.somesample.kotlin

/**

 * Author: Paddy
 * Date: 2019/10/11 14:25
 * Description:
 *
 */

//open class Base(val name: String) {
//
//    init { println("Initializing Base") }
//
//    open val size: Int =
//        name.length.also { println("Initializing size in Base: $it") }
//}
//
//class Derived(
//    name: String,
//    val lastName: String
//) : Base(name.capitalize().also { println("Argument for Base: $it") }) {
//
//    init { println("Initializing Derived") }
//
//    override val size: Int =
//        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
//}

interface Base {
    val message: String
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(message) }
}

class Derived(b: Base) : Base by b {
    // 在 b 的 `print` 实现中不会访问到这个属性
    override val message = "Message of Derived"
}

fun main(args: Array<String>){
//    val  derived = Derived("firstName","lastName")
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    println(derived.message)
}