fun main(args: Array<String>) {
    println(ContaV2("thulio"))
    declaracaoDeVariaveis()
    estruturaCondicionalIfElse(1)
    estruturaCondicionalWhen(2)
    estruturaRepeticaoFor()
    estruturaRepeticaoWhile()
}

fun declaracaoDeVariaveis() {
    val constante: String = "f"
    val constanteSemTipoDefinido = "f"
    var variavel: Int = 4
    var variavelSemTipoDefinido = 4
    val names = listOf("Eden", "Didier", "John", "Petr", "Frank")
    val numbers = listOf(3, 4, 5.90, -129)
    val rangeNumbers = (0..13).toList()

    variavel = 45
    variavel += 34.0.toInt()

    println("variavel = $variavel")
    println("constante = $constante")
}

fun estruturaCondicionalIfElse(variavel: Int) {
    if (variavel == 0) {
        println("a variável é igual a zero")
    } else if (variavel > 0) {
        println("a variável é positiva")
    } else {
        println("a variável é negativa")
    }

    if(variavel in 0..100) {
        println("A variável faz parte da primeira centena")
    }
}

fun estruturaCondicionalWhen(variavel: Int) {
    when {
        variavel == 0 -> {
            println("a variável é igual a zero")
        }
        variavel > 0 -> println("a variável é positiva")
        else -> {
            println("a variável é negativa")
        }
    }
}

fun estruturaRepeticaoFor() {
    for (i in 1..10) {
        if (i < 10) print("$i, ")
        else print("$i\n")
    }

    for (i in 10 downTo 1) {
        if (i > 1) print("$i, ")
        else println(i)
    }

    for (i in 10 downTo 1 step 2) {
        if (i > 2) print("$i, ")
        else println(i)
    }

    for (i in 1 until 10 step 3) {
        if (i==1) continue
        if (i==7) break
        println("$i, ")
    }

    a_loop_label@ for (i in 1..10) {
        println("i: $i")
        another_loop_label@ for (j in 1..5) {
            if(j==3) break@a_loop_label
            println("j: $j")
        }
    }

    val names = listOf(
        "Cech", "Ivanovic", "Ashley Cole", "Fabregas", "Essien", "Ricardo Carvalho", "Kante",
        "Lampard", "Hasselbaink", "Hazard", "Drogba"
    )
    for(name in names) {
        println(name)
    }

    for((index, value) in names.withIndex()){
        println("${index+1}: $value")
    }
}

fun estruturaRepeticaoWhile() {
    while(true) {
        println("ta bom")
        break
    }

    var contador = 0
    while(contador < 5){
        println("rode 5 vezes")
        contador++
    }

    do {
        println("rode só uma vez")
    } while(false)
}