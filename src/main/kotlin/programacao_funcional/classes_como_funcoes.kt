package programacao_funcional

fun main() {
    testandoChamadaDeClasseSemParametroESemRetornoComoFuncao()
    testandoChamadaDeClasseSemParametroMasComRetornoComoFuncao()
    testandoChamadaDeClasseComParametroMasSemRetornoComoFuncao()
    testandoChamadaDeClasseComParametroEComRetornoComoFuncao()
}

private class ClasseSemParametroESemRetorno: () -> Unit {
    override fun invoke() {
        println("A classe sem parâmetro e sem retorno foi chamada")
    }
}

private class ClasseSemParametroEComRetorno: () -> ClasseSemParametroEComRetorno {
    override fun invoke(): ClasseSemParametroEComRetorno {
        println("A classe sem parâmetro e com retorno foi chamada")
        return this
    }
}

private class ClasseComParametroESemRetorno(): (String) -> Unit {
    override fun invoke(palavra: String) {
        println("A classe com parâmetro e sem retorno foi chamada")
        println("O parâmetro informado foi: $palavra")
    }
}

private class ClasseComParametroEComRetorno(): (String) -> ClasseComParametroEComRetorno {
    override fun invoke(palavra: String): ClasseComParametroEComRetorno {
        println("A classe com parâmetro e com retorno foi chamada")
        println("O parâmetro informado foi: $palavra")
        return this
    }
}

private fun testandoChamadaDeClasseSemParametroESemRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseSemParametroESemRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada()}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()(): ${classeComoFuncaoDeclaradaDeFormaErrada()()}")
    println("----------\n")

    println("----------")
    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseSemParametroESemRetorno()
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta()}")
    println("----------\n")
}

private fun testandoChamadaDeClasseSemParametroMasComRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseSemParametroEComRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada()}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()(): ${classeComoFuncaoDeclaradaDeFormaErrada()()}")
    println("----------\n")

    println("----------")
    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseSemParametroEComRetorno()
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta()}")
    println("----------\n")
}

private fun testandoChamadaDeClasseComParametroMasSemRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseComParametroESemRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada()}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()(): ${classeComoFuncaoDeclaradaDeFormaErrada()("Caso 1")}")
    println("----------\n")

    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseComParametroESemRetorno()
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta("Caso 2")}")
    println("----------\n")
}

private fun testandoChamadaDeClasseComParametroEComRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseComParametroEComRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada()}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()(): ${classeComoFuncaoDeclaradaDeFormaErrada()("Primeiro teste")}")
    println("----------\n")

    println("----------")
    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseComParametroEComRetorno()
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta("Segundo teste")}")
    println("----------\n")
}