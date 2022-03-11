package collections

fun main() {
    testandoRanges()
}

private fun testandoRanges() {
    val intervaloNumerico: IntRange = 1..10
    val alfabeto: CharRange = 'a'..'z'
    val imparesAteVinte = 1..20 step 2
    val paresAteDezSemContarODez = 0.until(10) step 2
    val contagemRegressiva: IntProgression = 10 downTo 0

    for(numero in intervaloNumerico) {
        print("$numero ")
    }
    println()

    for(letra in alfabeto) {
        print("$letra ")
    }
    println()

    imparesAteVinte.forEach {
        print("$it ")
    }
    println()

    paresAteDezSemContarODez.forEach { par ->
        print("$par ")
    }
    println()

    contagemRegressiva.forEach {
        print("$it ")
    }
    println()

    println(verificaSeNumeroEstaDentroDoIntervalo(4, 23..120))
    println(verificaSeNumeroEstaDentroDoIntervalo(4, 20 downTo 0))

}

fun verificaSeNumeroEstaDentroDoIntervalo(numero: Int, intervalo: IntProgression): Boolean {
    return numero in intervalo
}