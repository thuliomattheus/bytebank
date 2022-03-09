package conceitos_basicos

class Conta() {

    constructor(titular:String = "valor padrão") : this() {
        this.titular = titular
    }

    private val numero: UInt = (Math.random() * 100000000).toUInt()
    private var titular = ""
        private get
        private set
    var saldo: Double = 0.0
        private set(valor) {
            if(valor > 0) {
                field = valor
            }
        }
        get() {
            return field
        }

    override fun toString(): String {
        return "basic.Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }

    fun main() {
        val contaSemTitular = Conta()
        val contaDeThulio = Conta("Thúlio")
        contaDeThulio.depositar(0.0)
        contaDeThulio.depositar(-10.0)
        contaDeThulio.depositar(30.0)
        contaDeThulio.depositar(10.0)
        contaDeThulio.depositar(0.5)
        contaDeThulio.sacar(-10.0)
        contaDeThulio.sacar(10.0)
        contaDeThulio.transferirPara(contaDestino=contaSemTitular, 2.0)

        println("$contaSemTitular")
        println("$contaDeThulio")
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

    private fun transferirPara(contaDestino: Conta, valorTransferencia:Double) : Boolean {
        if(valorTransferencia > 0 && saldo >= valorTransferencia) {
            this.sacar(valorTransferencia)
            contaDestino.depositar(valorTransferencia)
            return true
        }

        return false
    }
}