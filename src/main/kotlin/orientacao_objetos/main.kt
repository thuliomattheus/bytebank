package orientacao_objetos

fun main() {

//    testaContas()
//    testaFuncionarios()
}

fun testaContas() {
    val contaCorrente: ContaCorrente = ContaCorrente("Hazard")
    val contaNormal: ContaV3 = ContaPoupanca("Thúlio")

    println(contaNormal.depositar(100.0))
    println(contaCorrente.depositar(100.0))

    println(contaNormal.sacar(10.0))
    println(contaCorrente.sacar(10.0))
}
