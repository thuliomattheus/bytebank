package exceptions_e_null_safety

class ExemploExcecao: RuntimeException() {
    override val message: String?
        get() = "Exemplo de exceção: ${super.message}"
}

private class OutroExemploExcecao(mensagem: String): RuntimeException(mensagem)

