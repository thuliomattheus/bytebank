package programacao_funcional

fun main() {
    val funcaoInutil = ::funcaoQueNaoFazNadaNaoRecebeParametroENaoTemRetorno
    println(funcaoInutil())

    val funcaoInutilSemDeclararOTipo = ::funcaoQueNaoFazNadaNaoRecebeParametroENaoTemRetorno
    println(funcaoInutilSemDeclararOTipo())

    val mil = ::funcaoQueNaoFazNadaNaoRecebeParametroERetornaMil
    println(mil())

    val dobro: (param: Int) -> Int = ::funcaoQueRecebeParametroERetornaODobroDoValorRecebido
    println("O dobro de 5 é ${dobro(5)}")
}

private fun funcaoQueNaoFazNadaNaoRecebeParametroENaoTemRetorno() {}

private fun funcaoQueNaoFazNadaNaoRecebeParametroERetornaMil() = 1000

private fun funcaoQueRecebeParametroERetornaODobroDoValorRecebido(numero: Int) = 2 * numero