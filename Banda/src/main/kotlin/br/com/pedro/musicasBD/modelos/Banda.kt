package br.com.pedro.musicasBD.modelos

class Banda(
    val nome: String = "Nome da banda",
    val descricao: String = "Descrição da banda",
    val id: Int = 0,
) {
    override fun toString(): String {
        return "$nome ($id)"
    }
}