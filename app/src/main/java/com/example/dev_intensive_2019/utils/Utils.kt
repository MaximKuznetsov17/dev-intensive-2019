package com.example.dev_intensive_2019.utils

object Utils {
    fun parseFullName (fullName:String?):Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)?.trim()
        var lastName = parts?.getOrNull(1)?.trim()
        if (firstName?.length == 0) {
            firstName = null
        }
        if (lastName?.length == 0) {
            lastName = null
        }
        return firstName to lastName
    }
}