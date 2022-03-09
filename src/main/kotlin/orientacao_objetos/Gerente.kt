package orientacao_objetos

class Gerente : Funcionario,
    Autenticavel
{

    var senha: String = ""
        private set

    constructor(
        nome: String,
        cpf: String,
        salario: Double,
        senha: String
    ) : super(nome, cpf, salario) {
        this.senha = senha
    }

    override fun autentica(senha: String) {
        if(senha == this.senha) println("Seja bem-vindo(a)")
        else println("Senha incorreta")
    }

    override fun bonificacao(): Double {
        return 0.2 * super.salario
    }
}