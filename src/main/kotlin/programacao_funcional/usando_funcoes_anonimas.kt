package programacao_funcional

fun main() {
    val funcaoInutil: () -> Unit = fun () { println("Não retorna nada") }
    println(funcaoInutil())

    val funcaoInutilSemDeclararOTipo = fun () { println("Aqui também não retorna nada") }
    println(funcaoInutilSemDeclararOTipo())

    val mil: () -> Int = fun () : Int { return 1000 }
    println(mil())

    val dobro: (param: Int) -> Int = fun (numero) : Int { return 2 * numero }
    println("O dobro de 5 é ${dobro(5)}")
}