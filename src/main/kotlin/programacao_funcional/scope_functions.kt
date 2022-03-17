package programacao_funcional

import java.lang.System.Logger

data class Fruta(var nome: String, var cor: String)

fun main() {
    val frutas = mutableListOf(
        Fruta("Maçã", "Vermelho"),
        Fruta("Uva", "Roxo"),
        Fruta("Morango", "Vermelho"),
        Fruta("Abacaxi", "Amarelo"),
    )

    // testandoOLet(frutas)
    // testandoOWith(frutas)
    // testandoORun(frutas)
    // testandoOApply(frutas)
    // testandoOAlso(frutas)
}

private fun testandoOLet(frutas: List<Fruta>) {

    // O valor da variável que invoca o let não é modificado por referência, apenas dentro do seu escopo
    // Ela sempre é lida como val
    frutas
        .let {
            // O código abaixo não compila, portanto, só podemos usar o valor no let, mas não modificá-lo
            /*
            println(it)
            it = listOf()
            println(it)
            println(it[0])
            it[0] = Fruta("Melancia", "Vermelho")
            println(it[0])
             */
        }
}

private fun testandoORun(frutas: List<Fruta>) {

    val textoExplicativo = run {
        "Funciona mesmo se não houver nenhum argumento"
    }

    run {
        println(textoExplicativo)
    }

    frutas
        .run {
            println("\tthis: $this")
            println("\tthis.first(): ${this.first()}")
            println("\tfirst(): ${first()}")
            println("\tthis.size: ${this.size}")
            println("\tsize: $size")
        }

    // O valor da variável que invoca o run não é modificado por referência, apenas dentro do seu escopo
    frutas
        .run {
            // O código abaixo não compila, portanto, só podemos usar o valor no let, mas não modificá-lo
            /*
            println(this)
            this = listOf()
            println(this)
            println(this[0])
            this[0] = Fruta("Melancia", "Vermelho")
            println(this[0])
             */
        }
}

private fun testandoOApply(frutas: List<Fruta>) {
    println("frutas: $frutas")
    val oApplySempreRetornaOReceiver = frutas.first().apply{
        println("Receiver antes de ser modificado: $this")
        nome = "Blueberry"
        cor = "Azul"
    }
    println("Receiver depois de ser modificado: $oApplySempreRetornaOReceiver")
    println("frutas: $frutas")
}

private fun testandoOAlso(frutas: List<Fruta>) {
    println("O Also deve ser usado para operações que não afetam a lógica envolvida")
    println("Ou seja, é mais usado para printar log ou coisas que podem ser removidas sem quebrar nada")

    frutas
        .also {
            println("Entrou aqui")
        }
        .also {
            var x = 100
            println("Essa variável só serve pra ser logada e nada mais: $x")
        }
        .also {
            println("O also retorna o receiver, mas não é possível modificar o valor do receiver")
        }
}

private fun testandoOWith(frutas: MutableList<Fruta>) {

    // O with consegue alterar o valor do receiver por referência
    println(frutas)
    with(frutas) {
        this[0] = Fruta("Banana", "Amarelo")
        this[1].cor = "Verde"
    }
    println(frutas)

    println("with sem retorno:")
    with(frutas) {
        println("\tfrutas: $frutas")
        println("\tthis: $this")
        println("\tsize: $size")
        println("\tfirst: ${first()}")
        println("\tfirst.nome: ${first().nome}")
    }

    val withComRetorno = with(frutas.first()) {
        "\tfrutas: $frutas\n" +
        "\tthis: $this\n" +
        "\tnome: $nome"
    }

    println("withComRetorno:\n$withComRetorno")
}