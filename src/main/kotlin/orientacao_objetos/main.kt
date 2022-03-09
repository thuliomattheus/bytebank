package orientacao_objetos

fun main() {
    val funcionario = Funcionario("Thúlio", "123", 5.0)

    println(funcionario)
    println(funcionario.nome)
    println(funcionario.cpf)
    println(funcionario.salario)
    println(funcionario.tipo)
    println(funcionario.bonificacao())
}