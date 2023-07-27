package com.example.lab1
data class ItemData(val originalPos: Int, val originalValue: Any, val type: String, val info: String?)

fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null) {
        return null
    }

    val result = mutableListOf<ItemData>()

    for ((index, value) in inputList.withIndex()) {
        if (value != null) {
            val originalPos = index + 1
            val originalValue = value
            val type = when (value) {
                is Int -> "entero"
                is String -> "cadena"
                is Boolean -> "booleano"
                else -> "null"
            }
            val info = when (value) {
                is Int -> {
                    when {
                        value % 10 == 0 -> "M10"
                        value % 5 == 0 -> "M5"
                        value % 2 == 0 -> "M2"
                        else -> null
                    }
                }
                is String -> "L${value.length}"
                is Boolean -> if (value) "Verdadero" else "Falso"
                else -> null
            }

            val itemData = ItemData(originalPos, originalValue, type, info)
            result.add(itemData)
        }
    }

    return if (result.isEmpty()) null else result
}

fun main() {
    // Example usage:
    val inputList = listOf(null, null, 5, "Hola", true, null)
    val outputList = processList(inputList)

    outputList?.forEach { item ->
        println("originalPos=${item.originalPos}, originalValue=${item.originalValue}, type=${item.type}, info=${item.info}")
    }
}
