fun main() {
    testandoListas()
    testandoMapas()
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
    estados["RN"] = "Natal"

    println(estados["RN"])
}