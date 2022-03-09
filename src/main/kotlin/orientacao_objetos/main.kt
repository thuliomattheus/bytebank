package orientacao_objetos

fun main() {
    val funcionarioComum = Funcionario("Barkley", "123", 5.0)
    val gerente = Gerente("Kanté", "456", 10.0, senha = "petit")
    val diretor = Diretor("Drogba", "789", 20.0, "king")

    println(funcionarioComum.nome)
    println(funcionarioComum.cpf)
    println(funcionarioComum.salario)
    println("${funcionarioComum.bonificacao()} \n")

    println(gerente.nome)
    println(gerente.cpf)
    println(gerente.salario)
    println(gerente.bonificacao())
    println(gerente.senha)
    gerente.autentica(gerente.senha)
    gerente.autentica(gerente.senha + "1")

    println(diretor.nome)
    println(diretor.cpf)
    println(diretor.salario)
    println(diretor.bonificacao())
    println(diretor.senha)
    diretor.autentica(diretor.senha)
    diretor.autentica(diretor.senha + "1")
}