package casting_e_data_class

fun main() {
    val dataClass = DataClassExemplo("chelsea", 1905)

    // Realizando uma inicialização por referência
    val dataClassIgual = dataClass

    // Realizando uma inicialização por cópia
    val dataClassCopiada = dataClass.copy()

    // Realizando uma inicialização por cópia e alterando algum valor
    val dataClassCopiadaComAlteracao = dataClass.copy(numero=32)

    // Extraindo valores da dataclass e salvando em algumas variáveis
    var (minhaPalavra, outraVariavel) = dataClass

    println(dataClass)
    println(dataClassIgual)
    println(dataClassCopiada)
    println(dataClassCopiadaComAlteracao)
    println(minhaPalavra)
    println(outraVariavel)
    println()

    println("Os valores de dataClass e dataClassIgual são iguais: ${dataClass == dataClassIgual}")
    println("Os valores de dataClassIgual e dataClassCopiada são iguais: ${dataClassIgual == dataClassCopiada}")
    println("Os valores de dataClassCopiada e dataClass são iguais: ${dataClassCopiada == dataClass}")
    println("As referências de dataClass e dataClassIgual são iguais: ${dataClass === dataClassIgual}")
    println("As referências de dataClassIgual e dataClassCopiada são diferentes: ${dataClassIgual === dataClassCopiada}")
    println("As referências de dataClassCopiada e dataClass são diferentes: ${dataClassCopiada === dataClass}")
}