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
}

private fun soma(a: Int, b:Int, resultado: (Int) -> Unit) {
    println("A função soma foi iniciada")
    resultado(a+b)
    println("A função soma foi finalizada")
}