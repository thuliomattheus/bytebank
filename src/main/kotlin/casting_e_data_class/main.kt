package casting_e_data_class

fun main() {

    var usuario = object {
        private val nome: String = "fulaninho"
        val idade: Int = 27

        fun descricao(): String {
            return "meu nome é $nome e tenho $idade anos"
        }
    }

    println(usuario.descricao())
    testaCasting()
}