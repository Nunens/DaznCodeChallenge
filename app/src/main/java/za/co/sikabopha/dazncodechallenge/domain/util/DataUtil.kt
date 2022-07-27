package za.co.sikabopha.dazncodechallenge.domain.util

import java.text.SimpleDateFormat

fun formatToDate(date: String): String {
    val pattern: String = "yyyy-MM-dd"
    val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(pattern)
    var formattedDate: String = simpleDateFormat.format(date)
    println(formattedDate)
    return formattedDate
}

fun formatToTime(date: String): String {
    val pattern: String = "HH:mm"
    val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(pattern)
    var formattedDate: String = simpleDateFormat.format(date)
    println(formattedDate)
    return formattedDate
}
