package com.ifound.ui.helpers.stringHelpers

fun String.capitalizeFirstLetter(): String {
    if (this.isEmpty()) {
        return this
    }
    return this.substring(0, 1).uppercase() + this.substring(1)
}


fun String.capitalizeAllFirstLetter(): String {
    if (this.isEmpty()) {
        return this
    }
    return this.split(" ").joinToString(" ") { it.substring(0, 1).uppercase() + it.substring(1) }
}

