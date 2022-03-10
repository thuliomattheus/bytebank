package exceptions_e_null_safety

fun testandoTryCatchBlock() {
    try {
        var stringNumerica = "1000000000000000000"
        var numeroPequeno: Int = 32
        numeroPequeno *= stringNumerica.toInt()
        println(numeroPequeno)
        println(3/0)
        println("teste" as Int)
    } catch (exception: ClassCastException) {
        println("É assim que captura exception no kotlin")
    } catch(exception: ArithmeticException) {
        println("Outro tipo de exception capturada")
    } catch(exception: Exception) {
        println("Lançamento de exceção mais genérica")
        exception.printStackTrace()
    } finally {
        println("O finally é assim")
    }
}

fun testandoTryCatchBlockComRetorno() {
    println(
        try {
            12309/0
        } catch(exc: ArithmeticException) {
            exc.printStackTrace()
            "O retorno do bloco try-catch é este"
        }
    )
}

fun testandoTryCatchExpression(palavra: String): Int {
    return try { palavra.toInt() } catch (exc: NumberFormatException) { -1 }
}
