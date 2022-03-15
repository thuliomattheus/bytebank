package programacao_funcional

import kotlin.math.pow

fun main() {
    val funcaoInutil: () -> Unit = { println("Não retorna nada") }
    println(funcaoInutil())

    val funcaoInutilSemDeclararOTipo = { println("Aqui também não retorna nada") }
    println(funcaoInutilSemDeclararOTipo())

    val mil: () -> Int = {1000}
    println(mil())

    val dobro: (Int) -> Int = { 2 * it }
    println("O dobro de 5 é ${dobro(5)}")

    val metade: (numero: Int) -> Int = { n -> n/2 }
    println("A metade de 100 é ${metade(100)}")

    val soma: (Int, Int) -> Int = { a, b -> a + b }
    println("A soma de 23 e 9 é ${soma(23, 9)}")

    val multiplicacao = { x: Int, y: Int -> x * y }
    println("A multiplicação de 15 e 4 é ${multiplicacao(15, 4)}")

    val quadradoDoSegundo = { _: Double, t: Double -> t.pow(2).toInt() }
    println("O quadrado de 100 é ${quadradoDoSegundo(78.0, 100.0)}")

    // Sem esse return@minhaLambdaFunction, o retorno sempre seria o dobro(it)
    val maiorEntreODobroOuDez: (Int) -> Int = minhaLambdaFunction@{
        if(it < 5) {
            return@minhaLambdaFunction 10
        }

        return@minhaLambdaFunction dobro(it)
    }
    println("O maior entre o dobro ou dez do número 4 é ${maiorEntreODobroOuDez(4)}")
    println("O maior entre o dobro ou dez do número 9 é ${maiorEntreODobroOuDez(9)}")
}