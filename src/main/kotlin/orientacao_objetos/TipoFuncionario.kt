package orientacao_objetos

enum class TipoFuncionario {
    COMUM,
    DIRETOR,
    GERENTE,
}

enum class TipoFuncionarioComplexo(val descricao: String) {
    COMUM("Comum"),
    DIRETOR("Diretor"),
    GERENTE("Gerente"),
}