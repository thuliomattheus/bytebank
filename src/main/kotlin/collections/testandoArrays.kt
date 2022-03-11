package collections

import java.math.BigDecimal

fun main() {
    val stringArray: Array<String> = arrayOf("Testando", "criação", "de", "array")
    val arrayDeArrays: Array<Array<String>> = arrayOf(
        arrayOf("Teste", "com", "múltiplos", "arrays")
    )
    val idades = declarandoArrays()
    percorrendoArrays(idades)
    usandoFuncoesComunsDeArrays()
}

private fun declarandoArrays(): IntArray {

    var idades = IntArray(4)

    // Primeira forma de declarar um array
    idades[0] = 25
    idades[1] = 19
    idades[2] = 33
    idades[3] = 20

    // Segunda forma de declarar um array
    idades = intArrayOf(25, 19, 33, 20)

    return idades
}

private fun percorrendoArrays(idades: IntArray) {
    var maiorIdade = idades[0]
    var menorIdade = idades[0]

    // Primeira forma de percorrer todos os elementos do array
    for(idade in idades) {
        maiorIdade = if(idade > maiorIdade) idade else maiorIdade
    }

    println(maiorIdade)

    // Segunda forma de percorrer todos os elementos do array
    idades.forEach {
        menorIdade = if(it < menorIdade) it else menorIdade
    }

    println(menorIdade)

    val salarios: DoubleArray = doubleArrayOf(1000.0, 5000.0, 3400.0, 2800.0)

    // Primeira forma de percorrer todos os índices do array
    for(indice in salarios.indices) {
        salarios[indice] = salarios[indice] * 1.1
    }

    println(salarios.contentToString())

    // Segunda forma de percorrer todos os índices do array
    // Terceira forma de percorrer todos os elementos do array
    salarios.forEachIndexed { indice, salario ->
        salarios[indice] = salario * 1.1
    }

    println(salarios.contentToString())
}

private fun usandoFuncoesComunsDeArrays() {
    var idades: IntArray = intArrayOf(12, 18, 23, 43, 30)

    println("A maior idade é ${idades.maxOrNull() ?: "nenhuma"}")
    println("A menor idade é ${idades.minOrNull() ?: "nenhuma"}")
    println("A idade média é ${idades.average()}")
    println("Todas as idades são maiores que 20 anos? ${idades.all { it > 20} }")
    println("Alguma idade é igual a 18 anos? ${idades.any { it == 18} }")
    println("Lista de idades abaixo de 27: ${idades.filter { it < 27} }")
    println("Primeira idade ímpar: ${idades.find {it % 2 == 1} }")

    idades.sort()
    println("Idades ordenadas: ${idades.contentToString()}")
}