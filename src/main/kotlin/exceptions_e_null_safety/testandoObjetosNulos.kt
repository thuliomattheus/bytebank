package exceptions_e_null_safety

fun main() {
    val numeroQuePodeSerNulo: Int? = null

    testandoObjetosNulos(numeroQuePodeSerNulo)
    testandoFuncaoLet(numeroQuePodeSerNulo)
    //testandoOperadorExclamacao(numeroQuePodeSerNulo)
    testandoElvisOperator("teste")
    //testandoElvisOperator(null)
    testandoSafeCast()
}

fun testandoObjetosNulos(numeroQuePodeSerNulo: Int?) {
    println("Exemplo com todos os atributos usando o safe call")
    println(numeroQuePodeSerNulo?.toShort())
    println(numeroQuePodeSerNulo?.toShort()?.toString())
    println(numeroQuePodeSerNulo?.toShort()?.toString()?.substring(1))

}

fun testandoFuncaoLet(numeroQuePodeSerNulo: Int?) {
    println("Exemplo com todos os atributos usando o safe call dentro da função let sem safe call")
    numeroQuePodeSerNulo.let {
        println(it?.toShort())
        println(it?.toShort()?.toString())
        println(it?.toShort()?.toString()?.substring(1))
    }

    println("Exemplo com todos os atributos sem safe call dentro da função let com safe call")
    println("Nada será executado dada que a variável é interpretada como nula")
    numeroQuePodeSerNulo?.let {
        println(it.toShort())
        println(it.toShort().toString())
        println(it.toShort().toString().substring(1))
    }

    println("Exemplo com todos os atributos sem safe call dentro da função let sem safe call, usando array function")
    numeroQuePodeSerNulo.let { numeroNulo: Int? ->
        println(numeroNulo?.toShort())
        println(numeroNulo?.toShort().toString())
        println(numeroNulo?.toShort().toString().substring(1))
    }

    println("Exemplo com todos os atributos sem safe call dentro da função let com safe call, usando array function")
    println("Nada será executado dada que a variável é interpretada como nula")
    numeroQuePodeSerNulo?.let { numeroNulo: Int ->
        println(numeroNulo.toShort())
        println(numeroNulo.toShort().toString())
        println(numeroNulo.toShort().toString().substring(1))
    }
}

fun testandoOperadorExclamacao(numeroQuePodeSerNulo: Int?) {
    println("Exemplo com o operador !!")
    // Se a variável for null, vai dar NullPointerException
    println(numeroQuePodeSerNulo!!.toShort())
}

fun testandoElvisOperator(palavraQuePodeSerNula: String?) {

    val assertionUsandoIfExpressionEMetodoInterno: String = if(palavraQuePodeSerNula != null) palavraQuePodeSerNula else "a variável é nula"
    val assertionUsandoElvisOperatorEMetodoInterno: String = palavraQuePodeSerNula ?: "a variável é nula"
    val assertionUsandoIfExpression: String = if(palavraQuePodeSerNula != null) palavraQuePodeSerNula.substring(1) else "a variável é nula"
    val assertionUsandoElvisOperator: String = palavraQuePodeSerNula?.substring(1) ?: "a variável é nula"
    val lancandoExcecaoComElvisOperator: String = palavraQuePodeSerNula ?: throw RuntimeException("Deu ruim")

    println("assertionUsandoIfExpressionEMetodoInterno: $assertionUsandoIfExpressionEMetodoInterno")
    println("assertionUsandoElvisOperatorEMetodoInterno: $assertionUsandoElvisOperatorEMetodoInterno")
    println("assertionUsandoIfExpression: $assertionUsandoIfExpression")
    println("assertionUsandoElvisOperator: $assertionUsandoElvisOperator")
    println("lancandoExcecaoComElvisOperator: $lancandoExcecaoComElvisOperator")
}

fun testandoSafeCast() {
    val numeroInteiro = 5
    println("numeroInteiro: $numeroInteiro")

    val esseCastPodeSerFeito: Double? = numeroInteiro as? Double
    println("esseCastPodeSerFeito: $esseCastPodeSerFeito")

    val esseCastNaoPodeSerFeito: Double = numeroInteiro as Double
    println("esseCastNaoPodeSerFeito: $esseCastNaoPodeSerFeito")
}