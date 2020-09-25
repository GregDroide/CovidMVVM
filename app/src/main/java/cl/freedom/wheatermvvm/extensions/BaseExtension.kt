package cl.freedom.wheatermvvm.extensions

fun Boolean?.isNullOrFalse(): Boolean {
    return ((this == null).or(this == false))
}

fun Boolean?.orFalse(): Boolean {
    return !this.isNullOrFalse()
}

fun Boolean?.isTrue(): Boolean {
    return this == true
}

fun <T> T?.orElse(otherValue: T): T {
    return this ?: otherValue
}

fun String?.orNull(): String? {
    return if(!this.isNullOrEmpty()) this else null
}