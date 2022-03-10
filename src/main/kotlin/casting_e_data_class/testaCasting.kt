package casting_e_data_class

fun testaCasting() {

    var numero: Any = 34.0

    testaCondicoes(numero)

    // Realizando o casting pra String
    //numero as Double

    testaCondicoes(numero)
}

private fun testaCondicoes(numero: Any) {
    println(numero.javaClass)
    if(numero is Any) {
        println("$numero herda da classe Any")
    }
    if(numero is Number) {
        println("$numero é um número")
    }
    if(numero is Double) {
        println("$numero é um número decimal")
    }
    println()
}