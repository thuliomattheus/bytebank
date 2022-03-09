package orientacao_objetos

fun testaFuncionarios() {
    val funcionarioComum = Funcionario("Barkley", "123", 5.0)
    val gerente = Gerente("Kanté", "456", 10.0, senha = "petit")
    val diretor = Diretor("Drogba", "789", 20.0, "king")

    // Overloading
    val funcionarioInicializadoComoDiretor: Funcionario = Diretor("Hazard", "0", 100.0, "prince")
    // Nesse caso apenas os atributos mais genéricos estão disponíveis
    //println(funcionarioInicializadoComoDiretor.senha)

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

    var calculadoraBonificacao = CalculadoraBonificacao()
    calculadoraBonificacao.registra(funcionarioComum)
    calculadoraBonificacao.registra(gerente)
    calculadoraBonificacao.registra(diretor)

    println("total de bonificação da empresa ${calculadoraBonificacao.total}")
}