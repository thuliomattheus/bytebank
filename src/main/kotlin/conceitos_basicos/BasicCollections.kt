package conceitos_basicos

fun main() {
    testandoListas()
    testandoMapas()
    testandoConjuntos()
    convertendoListaEmMapa()
    convertendoListaEmSet()
}

fun testandoListas() {
    val planetas: List<String> = listOf("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter",
        "Saturno", "Urânio", "Netuno"
    )
    val numeros: List<Number> = listOf(1, 2.34, 0.8912, -128, 111111111)
    val coisas = listOf<Any>("palavra", "texto grandão e contínuo...", 8000, -2323, "987954", listOf(6))

    var jogadores: ArrayList<String> = arrayListOf("Hazard", "Drogba")
    jogadores.add("Lampard")
}

fun testandoMapas() {
    val estados :HashMap<String, String> = hashMapOf()
    estados["RN"] = "Rio Grande do Norte"
    estados["CE"] = "Ceará"
    estados["RJ"] = "Rio de Janeiro"

    for(estado in estados) {
        println("${estado.key}: ${estado.value}")
    }
}

fun testandoConjuntos() {
    var conjuntoA: HashSet<Int> = hashSetOf(2, 1, 12, 43)
    println("${conjuntoA.sortedDescending()}")

    conjuntoA.add(1)
    conjuntoA.add(13)
    conjuntoA.add(12)

    for(elemento in conjuntoA.sorted()) {
        println(elemento)
    }
}

fun convertendoListaEmMapa() {
    val planetas: List<String> = listOf("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter",
        "Saturno", "Urânio", "Netuno"
    )

    var planetasComoMapa:Map<String, String>

    planetasComoMapa =
        planetas.map {
            p -> p to p.substring(0)
        }
        .toMap()

    // OU

    planetasComoMapa =
        planetas.associateWith {
            p -> p.substring(0)
        }

    // OU

    planetasComoMapa =
        planetas.associate {
                p -> p to p.substring(0, 1)
        }

    // OU

    planetasComoMapa =
        planetas.associateBy (
            { it }, { it.uppercase() }
        )

    println(planetasComoMapa)
}

fun convertendoListaEmSet() {
    val planetas: List<String> = listOf("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter",
        "Saturno", "Urânio", "Netuno", "Netuno"
    )

    println(planetas
        .filter {
                p -> p.startsWith("M") || p.endsWith("O", true)
        }
        .map {
            p -> p.uppercase()
        }
        .sorted()
        .toSet()
    )
}