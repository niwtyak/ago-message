fun minutesEnding(timeInMinutes: Int): String {
    return when (timeInMinutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}

fun hoursEnding(timeInHours: Int): String {
    return when (timeInHours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

fun agoToText(timeInSeconds: Int): String {
    val timeToText = when (timeInSeconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${timeInSeconds / 60} ${minutesEnding(timeInSeconds / 60)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${timeInSeconds / (60 * 60)} ${hoursEnding(timeInSeconds / (60 * 60))} назад"
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "сегодня"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "вчера"
        else -> "давно"
    }
    return "был(а) $timeToText"
}


fun main() {
    println(agoToText(30))
    println(agoToText(11*60))
    println(agoToText(33*60))
    println(agoToText(41*60))
    println(agoToText(1+60*60))
    println(agoToText(15*60*60))
    println(agoToText(24*60*60))
    println(agoToText(24*60*60+1))
    println(agoToText(15*60+2*60*60*24))
    println(agoToText(10*60*60*60))
}