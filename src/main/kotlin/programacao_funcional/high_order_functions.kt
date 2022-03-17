package programacao_funcional

fun main() {
    // Exemplo 1
    soma(12, 8) { resultado ->
        println("A soma de a e b é: $resultado")
    }

    // Exemplo 2
    soma(5, 10, resultado = (::println))

    // Exemplo 3
    soma(3, 7) {
        println("O resultado $it " + if(it % 2 ==0) "é par" else "é ímpar")
    }

    // Exemplo 1 com receiver
    somaComReceiver(12, 8) {
        println("A soma de a e b é: $this")
    }

    // Exemplo 2 com receiver
    somaComReceiver(5, 10, resultado = (::println))

    somaComReceiver(3, 7) {
        println("O resultado $this " + if(this % 2 ==0) "é par" else "é ímpar")
    }
}

private fun soma(a: Int, b:Int, resultado: (Int) -> Unit) {
    println("A função soma foi iniciada")
    resultado(a+b)
    println("A função soma foi finalizada")
}

private fun somaComReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("A função soma foi iniciada")
    var total = a + b
    total.resultado()
    println("A função soma foi finalizada")
}