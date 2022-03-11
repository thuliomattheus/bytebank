package collections

import java.math.BigDecimal

fun main() {
    usandoBigDecimal()
}

private fun usandoBigDecimal() {
    var salarios: Array<BigDecimal> = arrayOf(BigDecimal.valueOf(5600), BigDecimal.valueOf(8700.50), BigDecimal.valueOf(2560))
    var salariosUsandoFuncaoCriadaPorNos: Array<BigDecimal> = bigDecimalArrayOf(BigDecimal.valueOf(5600), BigDecimal.valueOf(8700.50), BigDecimal.valueOf(2560))

    println("Lista de salários: ${salarios.contentToString()}")
    println("Lista de salários usando nossa função: ${salariosUsandoFuncaoCriadaPorNos.contentToString()}")
    println("Soma dos salários: ${salarios.sumOf {it}}")
    println("Soma dos salários usando reduce: ${somarArrayDeBigDecimalComReduce(salarios)}")
    println("Criar extension function de array de BigDecimal: ${salarios.sum()}")
}

private fun bigDecimalArrayOf(vararg valores: BigDecimal): Array<BigDecimal> {
    return Array(valores.size) {
        valores[it]
    }
}

private fun somarArrayDeBigDecimalComReduce(valores: Array<BigDecimal>): BigDecimal {
    return valores.reduce { acumulador, valorAtual ->
        acumulador + valorAtual
    }
}

private fun Array<BigDecimal>.sum(): BigDecimal {
    return somarArrayDeBigDecimalComReduce(this)
}