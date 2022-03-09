package orientacao_objetos

class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
    val tipo: TipoFuncionario = TipoFuncionario.COMUM
) {
    fun bonificacao(): Double {
        return when(tipo) {
            TipoFuncionario.COMUM -> salario * 0.1
            TipoFuncionario.GERENTE -> salario * 0.2
            TipoFuncionario.DIRETOR -> salario * 0.3
            else -> 0.0
        }
    }
}