package com.example.dev_intensive_2019.extensions

import com.example.dev_intensive_2019.TimeUnits
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy") :String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {
    this.time += when(units) {
        TimeUnits.DAY -> value * DAY
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.SECOND -> value * SECOND
    }
    return this
}