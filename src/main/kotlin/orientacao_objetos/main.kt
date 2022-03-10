package orientacao_objetos

fun main() {

    /*
    var usuario = object {
        private val nome: String = "fulaninho"
        val idade: Int = 27

        fun descricao(): String {
            return "meu nome é $nome e tenho $idade anos"
        }
    }
     */

//    println(usuario.descricao())
//    testaContas()
//    testaFuncionarios()
    testaCasting()
}

fun testaContas() {
    val contaCorrente: ContaCorrente = ContaCorrente("Hazard")
    val contaNormal: ContaV3 = ContaPoupanca("Thúlio")

    println(contaNormal.depositar(100.0))
    println(contaCorrente.depositar(100.0))

    println(contaNormal.sacar(10.0))
    println(contaCorrente.sacar(10.0))
}
