package orientacao_objetos

open class Funcionario(
    val nome: String,
    val cpf: String,
    var salario: Double,
) {

    // Primeira maneira de retornar a bonificação
    open fun bonificacao(): Double {
        return salario * 0.1
    }

    // Segunda maneira de retornar a mesma bonificação
    open fun bonificacao2(): Double = salario * 0.1

    // Terceira maneira de retornar a mesma bonificação
    open fun bonificacao3() = salario * 0.1

    // Quarta maneira de retornar a mesma bonificação
    open val bonificacao4: Double
        get() {
            return salario * 0.1
        }

    // Quinta maneira de retornar a mesma bonificação
    open val bonificacao5: Double get() = salario * 0.1

    // Sexta maneira de retornar a mesma bonificação
    open val bonificacao6 get() = salario * 0.1
}