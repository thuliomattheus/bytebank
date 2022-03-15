package collections

data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Long,
    val editora: String? = null
): Comparable<Livro> {

    override fun compareTo(other: Livro): Int {
        return this.titulo.compareTo(other.titulo)
    }
}

fun main() {
    val minhaListaDeLivros = declarandoListaMutavel()
    minhaListaDeLivros.adicionandoLivro()
    minhaListaDeLivros.listandoLivros()
    minhaListaDeLivros.listandoLivrosComAOrdenacaoDefinidaNaClasseLivro()
    minhaListaDeLivros.listandoLivrosOrdenados()
    minhaListaDeLivros.listandoLivrosOrdenados(false)
    minhaListaDeLivros.filter { it.editora != null }.listandoLivros()

    val titulos: List<String> = minhaListaDeLivros.map { it.titulo }
    println(titulos)

    val minhaListaDeLivrosComNulos = declarandoListaMutavelComNulos()
    minhaListaDeLivrosComNulos.filterNotNull().listandoLivros()

    minhaListaDeLivros.agrupandoLivrosPorEditora()
}

fun declarandoListaMutavel(): MutableList<Livro> {
    return mutableListOf(
        Livro(titulo = "Grande Sertão: Veredas", autor = "João Guimarães Rosa", anoPublicacao = 1956),
        Livro(titulo = "Minha vida de menina", autor = "Helena Morley", anoPublicacao = 1942, editora = "Editora A"),
        Livro(titulo = "Memórias Póstumas de Brás Cubas", autor = "Machado de Assis", anoPublicacao = 1881),
        Livro(titulo = "Iracema", autor = "José de Alencar", anoPublicacao = 1865, editora = "Editora B"),
    )
}

fun declarandoListaMutavelComNulos(): MutableList<Livro?> {
    val listaMutavelComNulos: MutableList<Livro?> = mutableListOf(null, null, null)

    for(livro in declarandoListaMutavel()) {
        listaMutavelComNulos.add(livro)
    }

    return listaMutavelComNulos
}

fun MutableList<Livro>.adicionandoLivro() {
    this.add(
        Livro(titulo = "Sagarana", autor = "João Guimarães Rosa", anoPublicacao = 1946)
    )
}

fun List<Livro>.listandoLivros() {
    // Primeira opção
    /*
    this.forEach {
        println("Título: ${it.titulo}, Autor: ${it.autor}, Ano de publicação: ${it.anoPublicacao}")
    }
     */

    // Segunda opção
    val textoFormatado = this.joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }

    println(" #### Lista de Livros #### \n$textoFormatado")
}

fun MutableList<Livro>.listandoLivrosComAOrdenacaoDefinidaNaClasseLivro() {
    this.sorted().listandoLivros()
}

fun MutableList<Livro>.listandoLivrosOrdenados(ordenacaoCrescente: Boolean = true) {
    if(ordenacaoCrescente) this.sortedBy { it.titulo }.listandoLivros()
    else this.sortedByDescending { it.titulo }.listandoLivros()
}

fun MutableList<Livro>.agrupandoLivrosPorEditora() {
    this
        .groupBy { it.editora ?: "Editora desconhecida" }
        .forEach { (editora, livros) ->
            println("$editora -> ${livros.joinToString { it.titulo }}")
        }
}