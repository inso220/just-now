package ru.netology

fun main () {
    val time = "был(а) в сети " + agoToText(661)
    println(time)
}

fun agoToText (seconds: Int): String { // функция определения сколько времени прошло с последнего визита собеседника
    var absenceTime = when (seconds) {
        in 0..60 -> "только что"
        in 61..60*60 -> (seconds / 60).toString() + minuteVariants(seconds) + " назад"
        in 60*60+1..24*60*60 -> (seconds / (60*60)).toString() + hoursVariants(seconds) + " назад"
        in 24*60*60+1..48*60*60 -> "вчера"
        in 48*60*60+1..72*60*60 -> "позавчера"
        else -> "давно"
    }
    return absenceTime
}

fun minuteVariants (seconds: Int): String { // функция для подбора окончания у минут
    val minute = seconds / 60
    var minutes = when (minute % 10) {
        1 -> if (minute % 100 !=11) " минуту" else " минут"
        in 2..4 -> " минуты"
        else -> " минут"
    }
    return minutes
}

fun hoursVariants (seconds: Int): String { // функция для подбора окончания у часов
    val hour = seconds / (60 * 60)
    var hours = when (hour % 10) {
        1 -> if (hour % 100 != 11) " час" else " часов"
        in 2..4 -> " часа"
        else -> " часов"
    }
    return hours
}