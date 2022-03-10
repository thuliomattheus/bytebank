package exceptions_e_null_safety

fun main() {

    // Bloco comum de try-expression
    testandoTryCatchBlock()

    // Bloco de try-expression que possui retorno
    testandoTryCatchBlockComRetorno()

    // Try catch como expressão
    println(testandoTryCatchExpression("353"))
    println(testandoTryCatchExpression("AEIOU"))

    testandoIfElseExpression(43)
    testandoIfElseExpression(98)

    testandoLancamentoExcecoes()
}
