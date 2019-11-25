package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.add
import com.example.dev_intensive_2019.extensions.format
import com.example.dev_intensive_2019.modules.*
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user1 = User("1")
        val user2 = User("2")
        val user3 = User("3")
        println("$user1, $user2, $user3")
        user1.printMe()
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Cena")
        val user1 = User.makeUser("John")
        val user2 = user.copy(lastVisit = Date(), lastName = "Dick")
        val user3 = user2.copy(lastName = "Wick", lastVisit = Date())
        println("""
            ${user.lastVisit?.format("hh.mm")}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
        }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Kuznetsov Maxim")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url message", type = "image")
        when (imgMessage ) {
            is TextMessage -> println("It is text message")
            is ImageMessage -> println("It is image message")
        }
    }

    @Test
    fun test_date_add() {
        var date = Date().add(2, TimeUnits.SECOND)
        println(date)
        date = Date().add(-4, TimeUnits.DAY)
        println(date)
    }
}
