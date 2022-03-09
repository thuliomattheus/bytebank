package orientacao_objetos

class ContaPoupanca(titular: String) : ContaV3(titular) {

    override fun sacar(valorSaque: Double): Double {
        if(valorSaque in 0.0..saldo) super.saldo -= valorSaque
        else println("O valor sacado precisa ser positivo e menor que o saldo atual. " +
                "Valor inserido: $valorSaque | Saldo Atual: $saldo")
        return saldo
    }
}