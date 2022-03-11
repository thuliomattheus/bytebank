package collections

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    usandoBigDecimal()
}

private fun usandoBigDecimal() {
    val salarios: Array<BigDecimal> = arrayOf(BigDecimal.valueOf(5600), BigDecimal.valueOf(8700.50), BigDecimal.valueOf(2560))

    println("Lista de salários: ${salarios.contentToString()}")
    println("Soma dos salários: ${salarios.sumOf {it}}")
    println("Soma dos salários usando reduce: ${somarArrayDeBigDecimalComReduce(salarios)}")
    println("Criar extension function de array de BigDecimal: ${salarios.sum()}")

    val salariosUsandoFuncaoCriadaPorNos = bigDecimalArrayOf(5600.0, 8700.5, 2560.0, 4800.0, 10000.0, 3750.0)

    println("Lista de salários usando nossa função: ${salariosUsandoFuncaoCriadaPorNos.contentToString()}")
    calcularMediaDosNMaioresSalarios(3, salarios = salariosUsandoFuncaoCriadaPorNos)
}

private fun bigDecimalArrayOf(vararg valores: Double): Array<BigDecimal> {
    return Array(valores.size) {
        BigDecimal.valueOf(valores[it])
    }
}

private fun somarArrayDeBigDecimalComReduce(valores: Array<BigDecimal>): BigDecimal {
    return valores.reduce { acumulador, valorAtual ->
        (acumulador + valorAtual).setScale(2, RoundingMode.UP)
    }
}

private fun Array<BigDecimal>.sum(): BigDecimal {
    return somarArrayDeBigDecimalComReduce(this)
}

private fun List<BigDecimal>.average(): BigDecimal {
    if(this.isEmpty()) return BigDecimal.ZERO

    return (this.reduce { acumulador, valorAtual ->
        (acumulador + valorAtual)
    }) / this.size.toBigDecimal()
}

private fun calcularMediaDosNMaioresSalarios(n: Int, salarios: Array<BigDecimal>) {
    val mediaDosNMaioresSalarios = salarios.sorted()
        .takeLast(n)
        .average()

    val mediaDosNMenoresSalarios = salarios.sorted()
        .take(n)
        .average()

    println("A média dos $n maiores salários é $mediaDosNMaioresSalarios")
    println("A média dos $n menores salários é $mediaDosNMenoresSalarios")
}