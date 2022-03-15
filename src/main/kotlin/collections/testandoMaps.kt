package collections

fun main() {
    val chelsea = mutableMapOf(
        Pair(1, "Cech"),
        Pair(2, "Ivanovic"),
        3 to "Ashley Cole",
        4 to "Fàbregas",
        5 to "Essien",
        6 to "Ricardo Carvalho",
        7 to "Kanté",
        8 to "Lampard",
        9 to "Hasselbaink",
        10 to "Hazard",
        11 to "Drogba",
    )

    chelsea[26]?.let {
        println("Captain, Leader, Legend: $it")
    }

    chelsea[11]?.let {
        println("The King: $it")
    }

    adicionarJogador(chelsea, "Terry", 26)
    listarJogadores(chelsea)
    adicionarJogador(chelsea, "Ronaldo", 99)
    removerJogador(chelsea, 99)
    listarJogadores(chelsea)

    val timeFake = mutableMapOf<Int, String?>(1 to null)
    println(buscarJogadorQuePodeSerNull(timeFake, 1))
    //println(buscarJogadorQuePodeSerNull(timeFake, 2))

    println(chelsea.getOrElse(100) { "tem esse jogador não" })
    println(chelsea.getOrDefault(100, "tem esse jogador não" ))

    println(filtrarMelhoresJogadores(chelsea, setOf(1, 4, 7, 8, 10, 11, 26)))

    removerJogadorPorNome(chelsea,"Terry")
    removerJogadorPorNome(chelsea,"Henry")
    listarJogadores(chelsea)

    val jogadoresLiverpool = listOf<String>(
        "Alisson",
        "Alexander-Arnold",
        "Van Dijk",
        "Gerrard",
        "Robertson",
        "Xabi Alonso",
        "Coutinho",
        "Wijnaldum",
        "Suarez",
        "Salah",
        "Torres"
    )
    val liverpool = testarAssociate(jogadoresLiverpool)
    listarJogadores(liverpool)

    val bonsJogadoresDoLiverpool = testarAssociateWith(jogadoresLiverpool, listOf(2, 3, 4, 6, 9, 10, 11))
    println(bonsJogadoresDoLiverpool.filter {it.value}.map { it.key }.joinToString())

    println(testarGroupBy(chelsea.values.toList()).toSortedMap())
}

private fun filtrarMelhoresJogadores(time: MutableMap<Int, String>, melhoresPorNumeracao: Set<Int>): String {
    return time
        .filter {
            it.key in melhoresPorNumeracao
        }
        .map {
            it.value
        }
        .joinToString()
}

private fun listarJogadores(time: Map<Int, String>) {
    for(jogador in time) {
        println("${jogador.key} - ${jogador.value}")
    }
    println()
}

private fun adicionarJogador(time: MutableMap<Int, String>, nomeJogador: String, numeracao: Int) {
    time.putIfAbsent(numeracao, nomeJogador)
}

private fun removerJogador(time: MutableMap<Int, String>, numeracao: Int) {
    time.remove(numeracao)
}

private fun removerJogadorPorNome(time: MutableMap<Int, String>, nome: String) {
    time.values.remove(nome)
}

/**
 * Se o valor dessa chave for null, o retorno é null
 * Se a chave não existir no map, uma NoSuchElementException será lançada
 */
private fun buscarJogadorQuePodeSerNull(timeQuePodeTerJogadoresNulos: MutableMap<Int, String?>, numeracao: Int): String? {
    return timeQuePodeTerJogadoresNulos.getValue(numeracao)
}

private fun testarAssociate(jogadores: List<String>): Map<Int, String> {
    var contador = 1

    return jogadores.associate {
        Pair(contador++, it)
    }
}

private fun testarAssociateBy(jogadores: List<String>): Map<Int, String> {
    var contador = 1
    return jogadores.associateBy { contador++ }
}

private fun testarAssociateWith(jogadores: List<String>, jogadoresBonsPorNumeracao: List<Int>): Map<String, Boolean> {
    var contador = 1
    return jogadores.associateWith {
        contador++ in jogadoresBonsPorNumeracao
    }
}

private fun testarGroupBy(jogadores: List<String>): Map<Int, List<String>> {
    return jogadores.groupBy {
        it.length
    }
}