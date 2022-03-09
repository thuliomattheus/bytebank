class ContaV2(private val titular: String) {

    private val numero: UInt = (Math.random() * 100000000).toUInt()
    var saldo: Double = 0.0
        private set

    init {
        println("Esse código é executado antes de todo o resto. É correspondente ao bloco static do java")
    }

    constructor(nome: String, sobrenome: String): this("$nome $sobrenome") {}

    override fun toString(): String {
        return "Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }

    fun main(args: Array<String>) {
        val contaDeThulio = ContaV2("Thúlio")
        val contaDeThulioMattheus = ContaV2("Thúlio", "Mattheus")
        contaDeThulio.depositar(0.0)
        contaDeThulio.depositar(-10.0)
        contaDeThulio.depositar(30.0)
        contaDeThulio.depositar(10.0)
        contaDeThulio.depositar(0.5)
        contaDeThulio.sacar(-10.0)
        contaDeThulio.sacar(10.0)
        contaDeThulio.transferirPara(contaDestino=contaDeThulioMattheus, 20.0)

        println("$contaDeThulio")
        println("$contaDeThulioMattheus")
    }

    private fun depositar(valorDeposito:Double) : Double {
        if(valorDeposito > 0) saldo += valorDeposito
        else println("O valor depositado é inválido. Valor inserido: $valorDeposito")
        return saldo
    }

    private fun sacar(valorSaque:Double) : Double {
        if(valorSaque in 0.0..saldo) saldo -= valorSaque
        else println("O valor sacado precisa ser positivo e menor que o saldo atual. " +
                "Valor inserido: $valorSaque | Saldo Atual: $saldo")
        return saldo
    }

    private fun transferirPara(contaDestino:ContaV2, valorTransferencia:Double) : Boolean {
        if(valorTransferencia > 0 && saldo >= valorTransferencia) {
            this.sacar(valorTransferencia)
            contaDestino.depositar(valorTransferencia)
            return true
        }

        return false
    }
}