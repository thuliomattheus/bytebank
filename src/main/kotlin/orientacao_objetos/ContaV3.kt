package orientacao_objetos

abstract class ContaV3(val titular: String) {

    val numero: UInt = (Math.random() * 100000000).toUInt()
    var saldo: Double = 0.0
        protected set

    constructor(nome: String, sobrenome: String): this("$nome $sobrenome") {}

    override fun toString(): String {
        return "basic.Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }

    fun depositar(valorDeposito:Double) : Double {
        if(valorDeposito > 0) saldo += valorDeposito
        else println("O valor depositado é inválido. Valor inserido: $valorDeposito")
        return saldo
    }

    abstract fun sacar(valorSaque:Double) : Double

    fun transferirPara(contaDestino: ContaV3, valorTransferencia:Double) : Boolean {
        if(valorTransferencia > 0 && saldo >= valorTransferencia) {
            this.sacar(valorTransferencia)
            contaDestino.depositar(valorTransferencia)
            return true
        }

        return false
    }
}