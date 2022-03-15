package programacao_funcional

fun main() {
    val funcaoInutil: () -> Unit = {
        println("Não retorna nada")
    }
    println(funcaoInutil())

    val funcaoInutilSemDeclararOTipo = {
        println("Aqui também não retorna nada")
    }
    println(funcaoInutilSemDeclararOTipo())

    val mil: () -> Int = {1000}
    println(mil())

    val dobro: (param: Int) -> Int = {
        2 * it
    }
    println("O dobro de 5 é ${dobro(5)}")
}