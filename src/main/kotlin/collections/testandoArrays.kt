package collections

fun main() {
    val stringArray: Array<String> = arrayOf("Testando", "criação", "de", "array")
    val arrayDeArrays: Array<Array<String>> = arrayOf(
        arrayOf("Teste", "com", "múltiplos", "arrays")
    )
    val idades = declarandoArrays()
    percorrendoArrays(idades)
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