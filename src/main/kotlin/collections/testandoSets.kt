package collections

fun main() {
    val conjuntoQuadrupedes = setOf<String>("Jacaré", "Sapo", "Rato", "Cavalo")
    val conjuntoMamiferos = setOf<String>("Coelho", "Baleia", "Gato", "Golfinho", "Cavalo")
    val conjuntoAnimaisMarinhos = mutableSetOf<String>("Tubarão", "Arraia", "Golfinho", "Baleia")

    // Métodos inline não precisam do . e nem dos parênteses para serem chamados
    val conjuntoMamiferosTerrestres = conjuntoMamiferos subtract conjuntoAnimaisMarinhos
    println(conjuntoMamiferosTerrestres)

    val conjuntoQuadrupedesMamiferos = conjuntoMamiferos intersect conjuntoQuadrupedes
    println(conjuntoQuadrupedesMamiferos)

    val conjuntoAnimais = conjuntoQuadrupedes union conjuntoMamiferos union conjuntoAnimaisMarinhos
    println(conjuntoAnimais.sorted())
}