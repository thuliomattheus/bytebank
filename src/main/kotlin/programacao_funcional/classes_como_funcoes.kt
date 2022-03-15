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
    val palavra = "atributo único da classe"
    override fun invoke(): ClasseSemParametroEComRetorno {
        println("A classe sem parâmetro e com retorno foi chamada")
        return this
    }
}

private class ClasseComParametroESemRetorno(palavra: String): (String) -> Unit {
    override fun invoke(palavra: String) {
        println("A classe com parâmetro e sem retorno foi chamada")
        println("O parâmetro informado foi: $palavra")
    }
}

private class ClasseComParametroEComRetorno(val palavra: String): (String) -> ClasseComParametroEComRetorno {
    override fun invoke(palavra: String): ClasseComParametroEComRetorno {
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
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()().palavra: ${classeComoFuncaoDeclaradaDeFormaErrada()().palavra}")
    println("----------\n")

    println("----------")
    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseSemParametroEComRetorno()
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta()}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta().palavra: ${classeComoFuncaoDeclaradaDeFormaCerta().palavra}")
    println("----------\n")
}

private fun testandoChamadaDeClasseComParametroMasSemRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseComParametroESemRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada("Caso 1")}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada("Caso 2")("Caso 3")}")
    println("----------\n")

    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseComParametroESemRetorno("Caso 4")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta("Caso 5")}")
    println("----------\n")
}

private fun testandoChamadaDeClasseComParametroEComRetornoComoFuncao() {
    val classeComoFuncaoDeclaradaDeFormaErrada = ::ClasseComParametroEComRetorno
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada: $classeComoFuncaoDeclaradaDeFormaErrada")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada(): ${classeComoFuncaoDeclaradaDeFormaErrada("Primeiro teste")}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()(): ${classeComoFuncaoDeclaradaDeFormaErrada("Segundo teste")("Terceiro teste")}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaErrada()().palavra: ${classeComoFuncaoDeclaradaDeFormaErrada("Quarto teste")("Quinto teste").palavra}")
    println("----------\n")

    println("----------")
    val classeComoFuncaoDeclaradaDeFormaCerta = ClasseComParametroEComRetorno("Sexto Teste")
    println("classeComoFuncaoDeclaradaDeFormaCerta: $classeComoFuncaoDeclaradaDeFormaCerta")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta(): ${classeComoFuncaoDeclaradaDeFormaCerta("Sétimo Teste")}")
    println("----------")
    println("classeComoFuncaoDeclaradaDeFormaCerta().palavra: ${classeComoFuncaoDeclaradaDeFormaCerta("Oitavo Teste").palavra}")
    println("----------\n")
}