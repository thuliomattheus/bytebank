package orientacao_objetos

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: String,
) : Funcionario(nome, cpf, salario),
    Autenticavel
{

    private var plr: Double = 0.0

    override fun autentica(senha: String) {
        if(senha == this.senha) println("Seja bem-vindo(a)")
        else println("Senha incorreta")
    }

    override fun bonificacao(): Double {
        return 0.3 * super.salario + this.plr
    }
}