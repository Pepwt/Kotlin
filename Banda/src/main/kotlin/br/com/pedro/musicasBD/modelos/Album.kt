package br.com.pedro.musicasBD.modelos

class Album(
    val titulo: String = "Título do álbum",
    val banda: Banda = Banda(),
    val id: Int = 0
) {
    override fun toString(): String {
        return "$titulo ($id) - $banda"
    }
}