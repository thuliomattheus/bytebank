package programacao_funcional

fun main() {
    val palavraNula: String? = null
    val palavraNaoNula: String? = "not null"

    palavraNula.let {
        println(it?.substring(0) ?: "a variável palavraNula é nula")
    }

    palavraNaoNula.let {
        println(it?.substring(0) ?: "a variável palavraNaoNula é nula")
    }

    palavraNula?.let {
        println(it.substring(0))
    }

    palavraNaoNula?.let {
        println(it.substring(0))
    }

    palavraNula.let(::funcaoQuePodeSerChamadaNoLetSemRetorno)
    println(palavraNaoNula?.let(::funcaoQuePodeSerChamadaNoLetComRetorno))

    val numeroInteiro = 238
    numeroInteiro.let(::funcaoQuePodeSerChamadaNoLetAPartirDeUmNumeroInteiro)

    listOf<Int?>().let(::funcaoQuePodeSerChamadaNoLetAPartirDeUmaListaDeNumerosQuePodeSerNula)

    funcaoQueRecebeOutraFuncao { 2 }

    // SEM USAR O LET
    val usuario = Usuario("Thúlio", 27)
    println("O nome do usuário é ${usuario.nome} e essa pessoa tem ${usuario.idade} anos")

    // USANDO O LET
    val teste = Usuario("Thúlio", 27)
        . let {
            "O nome do usuário é ${usuario.nome} e essa pessoa tem ${usuario.idade} anos"
        }
        . let(::println)
}

private data class Usuario(val nome: String, val idade: Int)

fun funcaoQuePodeSerChamadaNoLetSemRetorno(palavraQuePodeSerNula: String?) {
    println("funcaoQuePodeSerChamadaNoLetSemRetorno executada")
    println("O argumento passado foi $palavraQuePodeSerNula")
}
fun funcaoQuePodeSerChamadaNoLetComRetorno(palavra: String): Int = 89
fun funcaoQuePodeSerChamadaNoLetAPartirDeUmNumeroInteiro(numeroQuePodeSerNulo: Int?) {
    println("funcaoQuePodeSerChamadaNoLetAPartirDeUmNumeroInteiro executada")
    println("O argumento passado foi ${numeroQuePodeSerNulo ?: "null"}")
}
fun funcaoQuePodeSerChamadaNoLetAPartirDeUmaListaDeNumerosQuePodeSerNula(numeros: List<Number?>) {
    println("funcaoQuePodeSerChamadaNoLetAPartirDeUmaListaDeNumerosQuePodeSerNula executada")
    println("O argumento passado foi $numeros")
}

fun funcaoQueRecebeOutraFuncao(funcaoPassada: () -> Int) {
    println("O valor passado foi ${funcaoPassada()}")
}